package tu.sofia.travel.service;

import org.springframework.stereotype.Service;
import tu.sofia.travel.exception.UserNotAuthenticatedException;
import tu.sofia.travel.model.entity.Ticket;
import tu.sofia.travel.model.payload.TicketRequest;
import tu.sofia.travel.repository.TicketRepository;

import java.time.LocalTime;
import java.util.Objects;

@Service
public class TicketServiceImpl
        implements TicketService {

    private final DestinationService destinationService;

    private final ConsumerService consumerService;

    private final PriceService priceService;

    private final TicketRepository ticketRepository;


    public TicketServiceImpl(
            DestinationService destinationService,
            ConsumerService consumerService,
            PriceService priceService,
            TicketRepository ticketRepository
    ) {
        this.destinationService = destinationService;
        this.consumerService = consumerService;
        this.priceService = priceService;
        this.ticketRepository = ticketRepository;
    }

    @Override
    public Double create(
            final TicketRequest ticketRequest,
            final Long userId
    ) {
        if (Objects.nonNull(userId)) {
            return this.performCreation(
                    ticketRequest,
                    userId
            );
        } else {
            throw new UserNotAuthenticatedException();
        }
    }

    private Double performCreation(
            final TicketRequest ticketRequest,
            final Long userId
    ) {
        var price = this.priceService.getPriceByDepartureData(
                ticketRequest.departure(),
                ticketRequest.destination()
        );

        var ticketFinalPrice = this.calculatePrice(
                price.getPrice(),
                ticketRequest
        );

        this.ticketRepository.save(this.create(
                ticketRequest,
                ticketFinalPrice,
                userId
        ));

        return ticketFinalPrice;
    }

    private Ticket create(
            final TicketRequest ticketRequest,
            final Double ticketFinalPrice,
            final Long userId
    ) {
        this.consumerService.updateAmount(
                userId,
                ticketFinalPrice
        );

        return new Ticket(
                ticketFinalPrice,
                LocalTime.now(),
                ticketRequest.departureFrom(),
                ticketRequest.arriveAt(),
                this.destinationService.get(
                        ticketRequest.departure(),
                        ticketRequest.destination()
                )

        );
    }

    private Double calculatePrice(
            Double price,
            final TicketRequest ticketRequest
    ) {
        var departureFrom = ticketRequest.departureFrom();
        var arriveAt = ticketRequest.arriveAt();

        if (!(
                (
                        departureFrom.isAfter(LocalTime.of(
                                7,
                                29
                        )) && arriveAt.isBefore(LocalTime.of(
                                9,
                                31
                        ))
                ) || (
                        departureFrom.isAfter((
                                                      LocalTime.of(
                                                              16,
                                                              29
                                                      )
                                              ))
                                && arriveAt.isBefore(LocalTime.of(
                                19,
                                31
                        ))
                )
        )) {
            price -= price * 0.05;
        }

        if (ticketRequest.hasAdultCard()) {
            return price - price * 0.34;
        } else if (ticketRequest.hasFamilyCard()) {
            return price - price * 0.1;
        } else if (ticketRequest.hasKid()) {
            return price - price * 0.5;
        }

        return price;
    }
}