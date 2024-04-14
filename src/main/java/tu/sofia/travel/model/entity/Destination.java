package tu.sofia.travel.model.entity;

import jakarta.persistence.Entity;

@Entity
public class Destination
        extends BaseEntity {

    private String departure;

    private String destination;

    public Destination() {
    }

    public Destination(
            String departure,
            String destination
    ) {
        this.departure = departure;
        this.destination = destination;
    }

    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }
}
