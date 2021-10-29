package it.euris.academy.cinema.data.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import it.euris.academy.cinema.data.archetype.Model;
import it.euris.academy.cinema.data.dto.HallDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "hall")
@Entity
public class Hall implements Model{

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_hall")
  private Long id;
  
  @Column(name = "name_hall")
  private String name;
  
  @Column(name = "capacity_hall")
  private Integer capacity;
  
  @OneToMany(mappedBy = "hall")
  @Builder.Default
  private List<Projection> projections = new ArrayList<Projection>() ;
  
  @ManyToOne
  @JoinColumn(name = "cinema_id", nullable = false)
  private Cinema cinema;

  public Hall(String hallId) {
      if (hallId != null) {
          this.id = Long.parseLong(hallId);
      }
  }

  @Override
  public HallDto toDto() {
    return HallDto.builder().idHall(id==null?null:id.toString()).nameHall(name).capacityHall(capacity.toString()).build();
  }
  
}