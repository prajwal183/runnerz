package dev.praju.runnerz.run;

import java.time.LocalDateTime;
// this is immutable and cannot use the setters but it comes with getters
public record Run(
    Integer id,
    String title,
    LocalDateTime startedOn,
    LocalDateTime completedOn,
    Integer miles,
    Location location) {

}
