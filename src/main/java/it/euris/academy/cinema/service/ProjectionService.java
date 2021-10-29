package it.euris.academy.cinema.service;

import java.util.List;
import it.euris.academy.cinema.data.dto.ProjectionDto;

public interface ProjectionService {

  public ProjectionDto getById(Long id);

  public List<ProjectionDto> getAll();

  public ProjectionDto add(ProjectionDto dto);

  public ProjectionDto update(ProjectionDto dto);

  public Boolean delete(Long id);
}
