package it.euris.academy.cinema.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import it.euris.academy.cinema.data.model.Projection;

public interface ProjectionRepository extends JpaRepository<Projection, Long> {
  @Query(value = "SELECT sum(cp.money_earned_projection) as earn\r\n"
      + "FROM cinema.projection as cp\r\n"
      + "JOIN cinema.hall as ch on cp.hall_id = ch.id_hall\r\n"
      + "where cp.hall_id =:hallId and ch.cinema_id=:cinemaId ",nativeQuery = true)
  Double moneyEarned(@Param("hallId") Long hallId,@Param("cinemaId") Long cinemaId);
}
