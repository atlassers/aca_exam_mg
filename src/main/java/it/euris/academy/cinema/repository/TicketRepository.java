package it.euris.academy.cinema.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import it.euris.academy.cinema.data.model.Ticket;

public interface TicketRepository extends JpaRepository<Ticket, Long> {

}
