package tu.sofia.travel.web;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import tu.sofia.travel.model.payload.TicketRequest;
import tu.sofia.travel.service.TicketService;

@RestController
public class TicketController {

    private final TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @PostMapping("ticket")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Double create(
            @RequestBody final TicketRequest ticketRequest,
            @RequestHeader(required = false) final Long userId
    ) {
        return this.ticketService.create(
                ticketRequest,
                userId
        );
    }
}
