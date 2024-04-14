package tu.sofia.travel.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import tu.sofia.travel.exception.UserNotAuthenticatedException;
import tu.sofia.travel.model.entity.Destination;
import tu.sofia.travel.model.entity.Price;
import tu.sofia.travel.model.entity.Ticket;
import tu.sofia.travel.model.payload.TicketRequest;
import tu.sofia.travel.repository.TicketRepository;

import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;

@ExtendWith(MockitoExtension.class)
class TicketServiceImplTest {

    @Mock
    private DestinationService destinationService;

    @Mock
    private ConsumerService consumerService;

    @Mock
    private PriceService priceService;

    @Mock
    private TicketRepository ticketRepository;

    @InjectMocks
    private TicketServiceImpl ticketService;

    private Destination destination;

    private Price price;

    @BeforeEach
    void setUp() {
        this.destination = new Destination(
                "Sofia",
                "Varna"
        );

        this.price = new Price(
                50.0,
                this.destination
        );
    }

    @Test
    void testCreate_withDayRushHourAndNoDiscount_expectNoModifiedFinalPrice() {
        this.mockCommonData();

        var result = this.ticketService.create(
                new TicketRequest(
                        this.destination.getDestination(),
                        this.destination.getDeparture(),
                        LocalTime.of(
                                7,
                                30
                        ),
                        LocalTime.of(
                                8,
                                30
                        ),
                        false,
                        false,
                        false
                ),
                1L
        );

        assertEquals(
                50.0,
                result
        );
    }

    @Test
    void testCreate_withDayRushHourAndHasKidDiscount_expectNoModifiedFinalPrice() {
        this.mockCommonData();

        var result = this.ticketService.create(
                new TicketRequest(
                        this.destination.getDestination(),
                        this.destination.getDeparture(),
                        LocalTime.of(
                                7,
                                30
                        ),
                        LocalTime.of(
                                8,
                                30
                        ),
                        true,
                        false,
                        false
                ),
                1L
        );

        assertEquals(
                25.0,
                result
        );
    }

    @Test
    void testCreate_withDayRushHourAndHasFamilyDiscount_expectNoModifiedFinalPrice() {
        this.mockCommonData();

        var result = this.ticketService.create(
                new TicketRequest(
                        this.destination.getDestination(),
                        this.destination.getDeparture(),
                        LocalTime.of(
                                7,
                                30
                        ),
                        LocalTime.of(
                                8,
                                30
                        ),
                        false,
                        true,
                        false
                ),
                1L
        );

        assertEquals(
                45.0,
                result
        );
    }

    @Test
    void testCreate_withDayRushHourAndHasAdultCard_expectNoModifiedFinalPrice() {
        this.mockCommonData();

        var result = this.ticketService.create(
                new TicketRequest(
                        this.destination.getDestination(),
                        this.destination.getDeparture(),
                        LocalTime.of(
                                7,
                                30
                        ),
                        LocalTime.of(
                                8,
                                30
                        ),
                        false,
                        false,
                        true
                ),
                1L
        );

        assertEquals(
                33.0,
                result
        );
    }

    @Test
    void testCreate_withNightRushHourAndNoDiscount_expectNoModifiedFinalPrice() {
        this.mockCommonData();

        var result = this.ticketService.create(
                new TicketRequest(
                        this.destination.getDestination(),
                        this.destination.getDeparture(),
                        LocalTime.of(
                                16,
                                30
                        ),
                        LocalTime.of(
                                18,
                                30
                        ),
                        false,
                        false,
                        false
                ),
                1L
        );

        assertEquals(
                50.0,
                result
        );
    }

    @Test
    void testCreate_withNightRushHourAndHasKidDiscount_expectNoModifiedFinalPrice() {
        this.mockCommonData();

        var result = this.ticketService.create(
                new TicketRequest(
                        this.destination.getDestination(),
                        this.destination.getDeparture(),
                        LocalTime.of(
                                16,
                                30
                        ),
                        LocalTime.of(
                                18,
                                30
                        ),
                        true,
                        false,
                        false
                ),
                1L
        );

        assertEquals(
                25.0,
                result
        );
    }

    @Test
    void testCreate_withNightRushHourAndHasFamilyCardDiscount_expectNoModifiedFinalPrice() {
        this.mockCommonData();

        var result = this.ticketService.create(
                new TicketRequest(
                        this.destination.getDestination(),
                        this.destination.getDeparture(),
                        LocalTime.of(
                                16,
                                30
                        ),
                        LocalTime.of(
                                18,
                                30
                        ),
                        false,
                        true,
                        false
                ),
                1L
        );

        assertEquals(
                45.0,
                result
        );
    }

    @Test
    void testCreate_withNightRushHourAndHasAdultCardDiscount_expectNoModifiedFinalPrice() {
        this.mockCommonData();

        var result = this.ticketService.create(
                new TicketRequest(
                        this.destination.getDestination(),
                        this.destination.getDeparture(),
                        LocalTime.of(
                                16,
                                30
                        ),
                        LocalTime.of(
                                18,
                                30
                        ),
                        false,
                        false,
                        true
                ),
                1L
        );

        assertEquals(
                33.0,
                result
        );
    }

    @Test
    void testCreate_withNormalHoursAndNoDiscount_expectNoModifiedFinalPrice() {
        this.mockCommonData();

        var result = this.ticketService.create(
                new TicketRequest(
                        this.destination.getDestination(),
                        this.destination.getDeparture(),
                        LocalTime.of(
                                14,
                                30
                        ),
                        LocalTime.of(
                                16,
                                15
                        ),
                        false,
                        false,
                        false
                ),
                1L
        );

        assertEquals(
                47.5,
                result
        );
    }

    @Test
    void testCreate_withNormalHoursAndHasKidDiscount_expectNoModifiedFinalPrice() {
        this.mockCommonData();

        var result = this.ticketService.create(
                new TicketRequest(
                        this.destination.getDestination(),
                        this.destination.getDeparture(),
                        LocalTime.of(
                                14,
                                30
                        ),
                        LocalTime.of(
                                16,
                                15
                        ),
                        true,
                        false,
                        false
                ),
                1L
        );

        assertEquals(
                23.75,
                result
        );
    }

    @Test
    void testCreate_withNormalHoursAndHasFamilyCardDiscount_expectNoModifiedFinalPrice() {
        this.mockCommonData();

        var result = this.ticketService.create(
                new TicketRequest(
                        this.destination.getDestination(),
                        this.destination.getDeparture(),
                        LocalTime.of(
                                14,
                                30
                        ),
                        LocalTime.of(
                                16,
                                15
                        ),
                        false,
                        true,
                        false
                ),
                1L
        );

        assertEquals(
                42.75,
                result
        );
    }

    @Test
    void testCreate_withNormalHoursAndHasAdultCardDiscount_expectNoModifiedFinalPrice() {
        this.mockCommonData();

        var result = this.ticketService.create(
                new TicketRequest(
                        this.destination.getDestination(),
                        this.destination.getDeparture(),
                        LocalTime.of(
                                14,
                                30
                        ),
                        LocalTime.of(
                                16,
                                15
                        ),
                        false,
                        false,
                        true
                ),
                1L
        );

        assertEquals(
                31.349999999999998,
                result
        );
    }

    @Test
    void testCreate_withNotPresentUserId_expectUserNotAuthenticatedException() {
        assertThrows(
                UserNotAuthenticatedException.class,
                () -> this.ticketService.create(
                        new TicketRequest(
                                this.destination.getDestination(),
                                this.destination.getDeparture(),
                                LocalTime.of(
                                        14,
                                        30
                                ),
                                LocalTime.of(
                                        16,
                                        15
                                ),
                                false,
                                false,
                                true
                        ),
                        null
                )
        );
    }

    private void mockCommonData() {
        doReturn(this.price).when(this.priceService)
                            .getPriceByDepartureData(
                                    any(),
                                    any()
                            );
        doReturn(this.destination).when(this.destinationService)
                                  .get(
                                          any(),
                                          any()
                                  );
        doReturn(new Ticket()).when(this.ticketRepository)
                              .save(any());
    }
}