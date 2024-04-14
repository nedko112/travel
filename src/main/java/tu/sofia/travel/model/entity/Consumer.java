package tu.sofia.travel.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class Consumer
        extends BaseEntity {

    private String username;

    private String password;

    private Double amount;

    @OneToMany
    private List<Ticket> tickets;

    public Consumer() { }

    public Consumer(
            String username,
            String password,
            Double amount,
            List<Ticket> tickets
    ) {
        this.username = username;
        this.password = password;
        this.amount = amount;
        this.tickets = tickets;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(final String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(final String password) {
        this.password = password;
    }

    public Double getAmount() {
        return this.amount;
    }

    public Consumer setAmount(final Double amount) {
        this.amount = amount;

        return this;
    }

    public List<Ticket> getTickets() {
        return this.tickets;
    }

    public void setTickets(final List<Ticket> tickets) {
        this.tickets = tickets;
    }
}