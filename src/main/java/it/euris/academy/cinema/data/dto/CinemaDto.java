package it.euris.academy.cinema.data.dto;

import java.util.List;
import java.util.stream.Collectors;
import com.fasterxml.jackson.annotation.JsonIgnore;
import it.euris.academy.cinema.data.archetype.Dto;
import it.euris.academy.cinema.data.archetype.Model;
import it.euris.academy.cinema.data.model.Cinema;
import it.euris.academy.cinema.data.model.Hall;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class CinemaDto implements Dto {

  private String idCinema;
  private String nameCinema;
  @JsonIgnore
  private List<HallDto> hallsCinema;
  
  @Override
  public Cinema toModel() {
    Cinema cinema= Cinema.builder()
        .id(idCinema==null?null:Long.parseLong(idCinema))
        .name(nameCinema)
        .build();
    
    if (this.getHallsCinema() != null) {
      cinema.getHalls().addAll(
          this.getHallsCinema().stream().map(HallDto::toModel).collect(Collectors.toList()));
    }
    return cinema;
  }

}
