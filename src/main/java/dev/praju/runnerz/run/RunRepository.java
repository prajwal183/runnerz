package dev.praju.runnerz.run;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import org.springframework.stereotype.Repository;
import jakarta.annotation.PostConstruct;

@Repository
public class RunRepository {
  // intialize the runs list
  private List<Run> runs = new ArrayList<Run>();

  List<Run> getAllRuns() {
    return runs;
  }

  Optional<Run> findById(int id) {
    return runs.stream().filter((i) -> i.id() == id).findFirst();
  }

  void addRun(Run run) {
    runs.add(run);
  }

  void updateRun(Run run, Integer id) {
    Optional<Run> runToUpdate = findById(id);
    if (runToUpdate.isPresent()) {
      runs.set(runs.indexOf(runToUpdate.get()), run);
    }
  }

  void deleteRun(Integer id) {
    Optional<Run> runToDelete = findById(id);
    if (runToDelete.isPresent()) {
      runs.remove(runToDelete.get());
    }
  }

  // method which will be called after the object is created
  @PostConstruct
  public void init() {
    runs.add(
        new Run(1, "Run 1", LocalDateTime.now(), LocalDateTime.now().plus(1, ChronoUnit.HOURS), 100, Location.OUTDOOR));
    runs.add(
        new Run(2, "Run 2", LocalDateTime.now(), LocalDateTime.now().plus(2, ChronoUnit.HOURS), 50, Location.OUTDOOR));
  }

}
