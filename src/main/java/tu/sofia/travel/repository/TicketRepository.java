package tu.sofia.travel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tu.sofia.travel.model.entity.Ticket;

public interface TicketRepository
        extends JpaRepository<Ticket, Long> {}
