package it.euris.academy.cinema.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import it.euris.academy.cinema.repository.CinemaRepository;
import it.euris.academy.cinema.service.CinemaService;

public class CinemaServiceImpl implements CinemaService {

  @Autowired
  private CinemaRepository cinemaRepository;
}
