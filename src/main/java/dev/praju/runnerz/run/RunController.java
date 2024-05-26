package dev.praju.runnerz.run;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RunController {

  @GetMapping("/")
  public String getRun() {
    return "Jai Shree Ram";
  }
}
