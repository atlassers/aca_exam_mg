package it.euris.academy.cinema.data.model;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import it.euris.academy.cinema.data.archetype.Model;
import it.euris.academy.cinema.data.dto.UserDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user")
@Entity
public class User implements Model {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_user")
  private Long id;

  @Column(name = "name_user")
  private String name;

  @OneToMany(mappedBy = "user") // FetchType.Eager?
  private List<Ticket> tickets;

  public User(String userId) {
    if (userId != null) {
      this.id = Long.parseLong(userId);
    }
  }

  @Override
  public UserDto toDto() {
    return UserDto.builder().idUser(id == null ? null : id.toString()).nameUser(name).build();
  }



}
