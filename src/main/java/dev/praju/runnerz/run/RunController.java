package dev.praju.runnerz.run;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import jakarta.validation.Valid;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/runs")
public class RunController {

  private final RunRepository runRepository;

  // DI in the constructor
  public RunController(RunRepository runRepository) {
    this.runRepository = runRepository;
  }

  @GetMapping("")
  public List<Run> getAllRuns() {
    return runRepository.getAllRuns();
  }

  @GetMapping("/{id}")
  public Run getRun(@PathVariable int id) {
    Optional<Run> run = runRepository.findById(id);
    if (run.isEmpty()) {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Run not found.");
    }
    return run.get();
  }

  @PostMapping("")
  @ResponseStatus(HttpStatus.CREATED)
  public Run addRun(@Valid @RequestBody Run run) {
    runRepository.addRun(run);
    return run;
  }

  @PutMapping("/{id}")
  public Run updateRun(@Valid @RequestBody Run run, @PathVariable int id) {
    Optional<Run> runToUpdate = runRepository.findById(id);
    if (runToUpdate.isEmpty()) {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Run not found.");
    }
    runRepository.updateRun(run, id);
    return run;
  }

  @DeleteMapping("/{id}")
  public Run deleteRun(@PathVariable int id) {
    Optional<Run> runToDelete = runRepository.findById(id);
    if (runToDelete.isEmpty()) {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Run not found.");
    }
    runRepository.deleteRun(id);
    return runToDelete.get();
  }

}
