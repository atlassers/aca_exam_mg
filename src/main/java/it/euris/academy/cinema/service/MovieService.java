package it.euris.academy.cinema.service;

import java.util.List;
import it.euris.academy.cinema.data.dto.MovieDto;

public interface MovieService {

  public MovieDto getById(Long id);

  public List<MovieDto> getAll();

  public MovieDto add(MovieDto dto);

  public MovieDto update(MovieDto dto);

  public Boolean delete(Long id);
}
