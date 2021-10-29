package it.euris.academy.cinema.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import it.euris.academy.cinema.data.model.Projection;

public interface ProjectionRepository extends JpaRepository<Projection, Long> {

}
