package tu.sofia.travel.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import tu.sofia.travel.exception.ConsumerNotFoundException;
import tu.sofia.travel.exception.NotEnoughAmountException;
import tu.sofia.travel.exception.UserNotAuthenticatedException;
import tu.sofia.travel.model.entity.Consumer;
import tu.sofia.travel.repository.ConsumerRepository;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class ConsumerServiceImplTest {

    private Consumer consumer;

    @Mock
    private ConsumerRepository consumerRepository;

    @InjectMocks
    private ConsumerServiceImpl consumerService;

    @BeforeEach
    void setUp() {
        this.consumer = new Consumer(
                "TEST_USERNAME",
                "TEST_PASS",
                120.0,
                null
        );
    }

    @Test
    void testGetById_withExistingConsumer_expectSuccess() {
        doReturn(Optional.of(consumer)).when(this.consumerRepository)
                                       .findById(any());

        var consumer = this.consumerService.getById(1L);

        assertEquals(
                this.consumer,
                consumer
        );
        verify(this.consumerRepository).findById(1L);
    }

    @Test
    void testGetById_withNotExistingConsumer_expectConsumerNotFoundException() {
        doReturn(Optional.empty()).when(this.consumerRepository)
                                  .findById(any());

        assertThrows(
                ConsumerNotFoundException.class,
                () -> this.consumerService.getById(any())
        );
    }

    @Test
    void testUpdateAmount_withCorrectData_expectCorrectResponse() {
        doReturn(Optional.of(consumer)).when(this.consumerRepository)
                                       .findById(any());
        doReturn(consumer).when(this.consumerRepository)
                          .save(any());

        assertNotNull(this.consumerService.updateAmount(
                1L,
                50.0
        ));
    }

    @Test
    void testUpdateAmount_withNotEnoughAmount_expectNotEnoughAmountException() {
        doReturn(Optional.of(consumer)).when(this.consumerRepository)
                                       .findById(any());

        assertThrows(
                NotEnoughAmountException.class,
                () -> this.consumerService.updateAmount(
                        1L,
                        2718287.0
                )
        );
    }

    @Test
    void testUpdateAmount_withNotPresentUserId_expectConsumerNotFoundException() {
        doReturn(Optional.empty()).when(this.consumerRepository)
                                  .findById(any());

        assertThrows(
                ConsumerNotFoundException.class,
                () -> this.consumerService.updateAmount(
                        null,
                        any()
                )
        );
    }
}