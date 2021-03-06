package it.euris.academy.cinema.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import it.euris.academy.cinema.data.dto.MovieDto;
import it.euris.academy.cinema.data.model.Movie;
import it.euris.academy.cinema.exception.IdMustBeNullException;
import it.euris.academy.cinema.exception.IdMustNotBeNullException;
import it.euris.academy.cinema.repository.MovieRepository;
import it.euris.academy.cinema.service.MovieService;

@Service
public class MovieServiceImpl implements MovieService{
  
  @Autowired
  private MovieRepository movieRepository;
  
  @Override
  public MovieDto getById(Long id) {
    return movieRepository.findById(id).orElse(new Movie()).toDto();
  }

  @Override
  public List<MovieDto> getAll() {
    return movieRepository.findAll()
        .stream().map(curProduct -> curProduct.toDto())
        .collect(Collectors.toList());
  }

  @Override
  public MovieDto add(MovieDto movieDto) {
    if (movieDto.getIdMovie() != null) {
      throw new IdMustBeNullException();
    }
    return movieRepository.save(movieDto.toModel()).toDto();
  }

  @Override
  public MovieDto update(MovieDto movieDto) {
    if (movieDto.getIdMovie() != null) {
      throw new IdMustNotBeNullException();
    }
    return movieRepository.save(movieDto.toModel()).toDto();
  }

  @Override
  public Boolean delete(Long id) {
    movieRepository.deleteById(id);
    return movieRepository.findById(id).isEmpty();
  }


}
