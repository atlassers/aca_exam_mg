package it.euris.academy.cinema.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import it.euris.academy.cinema.data.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
