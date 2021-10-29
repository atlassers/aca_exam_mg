package it.euris.academy.cinema.service;

import java.util.List;
import it.euris.academy.cinema.data.dto.TicketDto;

public interface TicketService {

  public TicketDto getById(Long id);

  public List<TicketDto> getAll();

  public TicketDto add(TicketDto dto);

  public TicketDto update(TicketDto dto);

  public Boolean delete(Long id);
}
