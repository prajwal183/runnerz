package dev.praju.runnerz.run;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;

// this is immutable and cannot use the setters but it comes with getters
public record Run(
    Integer id,
    @NotEmpty
    String title,
    LocalDateTime startedOn,
    LocalDateTime completedOn,
    @Positive
    Integer miles,
    Location location) {

  public Run {
    if (startedOn.isAfter(completedOn)) {
      throw new IllegalArgumentException("startedOn cannot be after completedOn");
    }
  }

}
