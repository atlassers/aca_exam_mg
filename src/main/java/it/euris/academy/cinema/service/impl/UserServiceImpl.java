package it.euris.academy.cinema.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import it.euris.academy.cinema.data.dto.UserDto;
import it.euris.academy.cinema.data.model.User;
import it.euris.academy.cinema.exception.IdMustBeNullException;
import it.euris.academy.cinema.exception.IdMustNotBeNullException;
import it.euris.academy.cinema.repository.UserRepository;
import it.euris.academy.cinema.service.UserService;

@Service
public class UserServiceImpl implements UserService {

  @Autowired
  private UserRepository userRepository;
  
  @Override
  public UserDto getById(Long id) {
    return userRepository.findById(id).orElse(new User()).toDto();
  }

  @Override
  public List<UserDto> getAll() {
    return userRepository.findAll()
        .stream().map(curProduct -> curProduct.toDto())
        .collect(Collectors.toList());
  }

  @Override
  public UserDto add(UserDto userDto) {
    if (userDto.getIdUser() != null) {
      throw new IdMustBeNullException();
    }
    return userRepository.save(userDto.toModel()).toDto();
  }

  @Override
  public UserDto update(UserDto userDto) {
    if (userDto.getIdUser() != null) {
      throw new IdMustNotBeNullException();
    }
    return userRepository.save(userDto.toModel()).toDto();
  }

  @Override
  public Boolean delete(Long id) {
    userRepository.deleteById(id);
    return userRepository.findById(id).isEmpty();
  }

}
