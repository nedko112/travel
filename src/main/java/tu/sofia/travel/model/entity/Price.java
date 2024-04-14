package tu.sofia.travel.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;

@Entity
public class Price
        extends BaseEntity {

    private Double price;

    @ManyToOne
    private Destination destination;

    public Price() {
    }

    public Price(
            Double price,
            Destination destination
    ) {
        this.price = price;
        this.destination = destination;
    }

    public Destination getDestination() {
        return destination;
    }

    public void setDestination(Destination destination) {
        this.destination = destination;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}