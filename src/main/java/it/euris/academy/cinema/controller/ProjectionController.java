package it.euris.academy.cinema.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import it.euris.academy.cinema.data.dto.ProjectionDto;
import it.euris.academy.cinema.service.ProjectionService;

@RestController
@RequestMapping("/projections")
public class ProjectionController {
  @Autowired
  ProjectionService projectionService;

  @GetMapping("/v6")
  public List<ProjectionDto> getAll() {
      return projectionService.getAll();
  }

  @GetMapping("/v6/{id}")
  public ProjectionDto getById(@PathVariable("id") Long id) {
      return projectionService.getById(id);
  }

  @DeleteMapping("/v6/{id}")
  public Boolean delete(@PathVariable("id") Long id) {
      return projectionService.delete(id);
  }

  @PostMapping("/v6")
  public ProjectionDto insert(@RequestBody ProjectionDto dto) {
      return projectionService.add(dto);
  }

  @PutMapping("/v6")
  public ProjectionDto update(@RequestBody ProjectionDto dto) {
      return projectionService.update(dto);
  }

}
