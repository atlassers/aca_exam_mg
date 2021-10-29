package it.euris.academy.cinema.data.dto;

import java.util.List;
import java.util.stream.Collectors;
import com.fasterxml.jackson.annotation.JsonIgnore;
import it.euris.academy.cinema.data.archetype.Dto;
import it.euris.academy.cinema.data.model.Hall;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class HallDto implements Dto {

  private String idHall;
  private String nameHall;
  private String capacityHall;
  @JsonIgnore
  private List<ProjectionDto> projectionsHall;
  
  @Override
  public Hall toModel() {
    Hall hall = Hall.builder()
        .id(idHall==null?null:Long.parseLong(idHall))
        .name(nameHall)
        .capacity(Integer.parseInt(capacityHall))
        .build();
    
    if (this.getProjectionsHall() != null) {
      hall.getProjections().addAll(
          this.getProjectionsHall().stream().map(ProjectionDto::toModel).collect(Collectors.toList()));
    }
    return hall;
  }

}
