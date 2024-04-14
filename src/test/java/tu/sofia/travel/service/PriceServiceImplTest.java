package tu.sofia.travel.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import tu.sofia.travel.exception.PriceNotFoundException;
import tu.sofia.travel.model.entity.Price;
import tu.sofia.travel.repository.PriceRepository;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;

@ExtendWith(MockitoExtension.class)
class PriceServiceImplTest {

    @Mock
    private PriceRepository priceRepository;

    @InjectMocks
    private PriceServiceImpl priceService;

    @Test
    void testGetPriceByDepartureData_withCorrectData_expectCorrectResponse() {
        doReturn(Optional.of(new Price())).when(this.priceRepository)
                                          .findByDestination_DepartureAndDestination_Destination(
                                                  any(),
                                                  any()
                                          );

        assertNotNull(this.priceService.getPriceByDepartureData(
                any(),
                any()
        ));
    }

    @Test
    void testGetPriceByDepartureData_withNotPresentPrice_expectPriceNotFoundException() {
        doReturn(Optional.empty()).when(this.priceRepository)
                                  .findByDestination_DepartureAndDestination_Destination(
                                          any(),
                                          any()
                                  );

        assertThrows(
                PriceNotFoundException.class,
                () -> this.priceService.getPriceByDepartureData(
                        any(),
                        any()
                )
        );
    }
}