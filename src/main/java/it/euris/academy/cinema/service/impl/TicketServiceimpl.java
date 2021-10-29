package it.euris.academy.cinema.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import it.euris.academy.cinema.data.dto.TicketDto;
import it.euris.academy.cinema.data.model.Ticket;
import it.euris.academy.cinema.exception.IdMustBeNullException;
import it.euris.academy.cinema.exception.IdMustNotBeNullException;
import it.euris.academy.cinema.repository.TicketRepository;
import it.euris.academy.cinema.service.TicketService;


@Service
public class TicketServiceimpl implements TicketService {

  @Autowired
  private TicketRepository ticketRepository;
  
  @Override
  public TicketDto getById(Long id) {
    return ticketRepository.findById(id).orElse(new Ticket()).toDto();
  }

  @Override
  public List<TicketDto> getAll() {
    return ticketRepository.findAll()
        .stream().map(curProduct -> curProduct.toDto())
        .collect(Collectors.toList());
  }

  @Override
  public TicketDto add(TicketDto ticketDto) {
    if (ticketDto.getIdTicket() != null) {
      throw new IdMustBeNullException();
    }
    return ticketRepository.save(ticketDto.toModel()).toDto();
  }

  @Override
  public TicketDto update(TicketDto ticketDto) {
    if (ticketDto.getIdTicket() != null) {
      throw new IdMustNotBeNullException();
    }
    return ticketRepository.save(ticketDto.toModel()).toDto();
  }

  @Override
  public Boolean delete(Long id) {
    ticketRepository.deleteById(id);
    return ticketRepository.findById(id).isEmpty();
  }

}
