package it.euris.academy.cinema.data.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import it.euris.academy.cinema.data.archetype.Dto;
import it.euris.academy.cinema.data.archetype.Model;
import it.euris.academy.cinema.data.dto.CinemaDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "cinema")
@Entity
public class Cinema implements Model{
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_cinema")
  private Long id;
  
  @Column(name = "name_cinema")
  private String name;
  
  @OneToMany(mappedBy = "cinema")
  @Builder.Default
  private List<Hall> halls= new ArrayList<Hall>();
  
  public Cinema(String cinemaId) {
    if (cinemaId != null) {
        this.id = Long.parseLong(cinemaId);
    }
}
  
  @Override
  public CinemaDto toDto() {
    return CinemaDto.builder()
        .idCinema(id==null?null:id.toString())
        .nameCinema(name)
        .build();
  }

}
