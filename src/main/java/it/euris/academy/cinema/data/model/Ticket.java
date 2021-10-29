package it.euris.academy.cinema.data.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import it.euris.academy.cinema.data.archetype.Model;
import it.euris.academy.cinema.data.dto.TicketDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "ticket")
@Entity
public class Ticket implements Model {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_ticket")
  private Long id;

  @Column(name = "seat_ticket")
  private String seat;

  @ManyToOne
  @JoinColumn(name = "projection_id", nullable = false)
  private Projection projection;

  @ManyToOne
  @JoinColumn(name = "user_id", nullable = false)
  private User user;

  @Override
  public TicketDto toDto() {
    return TicketDto.builder().idTicket(id == null ? null : id.toString()).seatTicket(seat)
        .projectionTicket(projection.getId().toString()).userTicket(user.getId().toString())
        .build();
  }



}
