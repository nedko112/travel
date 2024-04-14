package tu.sofia.travel.service;

import org.springframework.stereotype.Service;
import tu.sofia.travel.exception.NotEnoughAmountException;
import tu.sofia.travel.exception.ConsumerNotFoundException;
import tu.sofia.travel.model.entity.Consumer;
import tu.sofia.travel.repository.ConsumerRepository;

import java.util.Optional;

@Service
public class ConsumerServiceImpl
        implements ConsumerService {

    private final ConsumerRepository consumerRepository;

    public ConsumerServiceImpl(ConsumerRepository consumerRepository) {
        this.consumerRepository = consumerRepository;
    }

    @Override
    public Consumer getById(final Long id) {
        return this.consumerRepository.findById(id)
                                      .orElseThrow(ConsumerNotFoundException::new);
    }

    @Override
    public Consumer updateAmount(
            final Long id,
            final Double ticketPrice
    ) {
        return Optional.of(this.getById(id))
                .filter(consumer -> consumer.getAmount()
                        > ticketPrice)
                .map(consumer -> this.consumerRepository.save(consumer.setAmount(
                        consumer.getAmount() - ticketPrice)))
                .orElseThrow(NotEnoughAmountException::new);
    }
}