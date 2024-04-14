package tu.sofia.travel.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;

import java.time.LocalTime;

@Entity
public class Ticket
        extends BaseEntity {

    private Double discount;

    private LocalTime createdOn;

    private LocalTime departureFrom;

    private LocalTime arriveAt;

    @ManyToOne
    private Destination destination;

    public Ticket() { }

    public Ticket(
            Double discount,
            LocalTime createdOn,
            LocalTime departureFrom,
            LocalTime arriveAt,
            Destination destination
    ) {
        this.discount = discount;
        this.createdOn = createdOn;
        this.departureFrom = departureFrom;
        this.arriveAt = arriveAt;
        this.destination = destination;
    }
    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public LocalTime getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(LocalTime createdOn) {
        this.createdOn = createdOn;
    }

    public LocalTime getDepartureFrom() {
        return departureFrom;
    }

    public void setDepartureFrom(LocalTime departureFrom) {
        this.departureFrom = departureFrom;
    }

    public LocalTime getArriveAt() {
        return arriveAt;
    }

    public void setArriveAt(LocalTime arriveAt) {
        this.arriveAt = arriveAt;
    }

    public Destination getDestination() {
        return destination;
    }

    public void setDestination(Destination destination) {
        this.destination = destination;
    }
}