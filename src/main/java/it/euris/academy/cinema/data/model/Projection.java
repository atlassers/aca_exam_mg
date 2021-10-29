package it.euris.academy.cinema.data.model;

import java.time.Instant;
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
import it.euris.academy.cinema.data.dto.ProjectionDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "projection")
@Entity
public class Projection implements Model {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_projection")
  private Long id;

  @Column(name = "time_projection")
  private Instant time;
  
  @Column(name = "money_earned_projection")
  private Double moneyEarned;

  @ManyToOne
  @JoinColumn(name = "movie_id", nullable = false)
  private Movie movie;

  @ManyToOne
  @JoinColumn(name = "hall_id", nullable = false)
  private Hall hall;


  @OneToMany(mappedBy = "projection") // FetchType.Eager?
  private List<Ticket> tickets;

  public Projection(String projectionId) {
    if (projectionId != null) {
      this.id = Long.parseLong(projectionId);
    }
  }

  @Override
  public ProjectionDto toDto() {
    return ProjectionDto.builder().idProjection(id == null ? null : id.toString())
        .moneyEarnedProjection(moneyEarned == null ? null : moneyEarned.toString())
        .movieProjection(movie.getId().toString()).timeProjection(time.toString())
        .hallProjection(hall.getId().toString()).build();
  }



}
