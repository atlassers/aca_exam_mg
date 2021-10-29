package it.euris.academy.cinema.data.dto;

import java.time.Instant;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnore;
import it.euris.academy.cinema.data.archetype.Dto;
import it.euris.academy.cinema.data.model.Hall;
import it.euris.academy.cinema.data.model.Movie;
import it.euris.academy.cinema.data.model.Projection;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProjectionDto implements Dto {

  private String idProjection;
  private String timeProjection;
  private String moneyEarnedProjection;
  private String movieProjection;
  private String hallProjection;  
  private List<TicketDto> ticketsProjection;

  @Override
  public Projection toModel() {
    return Projection.builder().id(idProjection == null ? null : Long.parseLong(idProjection))
        .moneyEarned(moneyEarnedProjection== null ? null :Double.parseDouble(moneyEarnedProjection))
        .time(Instant.parse(timeProjection)).movie(new Movie(movieProjection))
        .hall(new Hall(hallProjection)).build();
  }

}
