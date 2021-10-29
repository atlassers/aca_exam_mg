package it.euris.academy.cinema.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import it.euris.academy.cinema.data.model.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long> {

}
