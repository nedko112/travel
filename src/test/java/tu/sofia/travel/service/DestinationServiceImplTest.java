package tu.sofia.travel.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import tu.sofia.travel.exception.DestinationNotFoundException;
import tu.sofia.travel.model.entity.Destination;
import tu.sofia.travel.repository.DestinationRepository;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;

@ExtendWith(MockitoExtension.class)
class DestinationServiceImplTest {

    @Mock
    private DestinationRepository destinationRepository;

    @InjectMocks
    private DestinationServiceImpl destinationService;

    private Destination destination;

    @BeforeEach
    void setUp() {
        this.destination = new Destination(
                "Sofia",
                "Varna"
        );
    }

    @Test
    void testGet_withExistingDestinations_expectCorrectResponse() {
        doReturn(Optional.of(destination)).when(this.destinationRepository)
                                          .findDestinationByDepartureAndDestination(
                                                  any(),
                                                  any()
                                          );
        var dest = this.destinationService.get(
                any(),
                any()
        );

        assertEquals(
                dest,
                destination
        );
    }

    @Test
    void testGet_withNonExistingDestination_expectDestinationNotFoundException() {
        doReturn(Optional.empty()).when(this.destinationRepository)
                                  .findDestinationByDepartureAndDestination(
                                          any(),
                                          any()
                                  );

        assertThrows(
                DestinationNotFoundException.class,
                () -> this.destinationService.get(
                        any(),
                        any()
                )
        );
    }
}