package it.euris.academy.cinema.service;

import java.util.List;
import it.euris.academy.cinema.data.dto.HallDto;

public interface HallService {
  public HallDto getById(Long id);

  public List<HallDto> getAll();

  public HallDto add(HallDto dto);

  public HallDto update(HallDto dto);

  public Boolean delete(Long id);
}
