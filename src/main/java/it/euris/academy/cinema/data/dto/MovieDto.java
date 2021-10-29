package it.euris.academy.cinema.data.dto;

import java.util.List;
import java.util.stream.Collectors;
import it.euris.academy.cinema.data.archetype.Dto;
import it.euris.academy.cinema.data.model.Movie;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class MovieDto implements Dto {

  private String idMovie;
  private String nameMovie;
  private List<ProjectionDto> projectionsMovie;
  @Override
  public Movie toModel() {
  
    Movie entity = Movie.builder().id(idMovie==null?null:Long.parseLong(idMovie)).name(nameMovie).build();
    return entity;
  }
  


}
