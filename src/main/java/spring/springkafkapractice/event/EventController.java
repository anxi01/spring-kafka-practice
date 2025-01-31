package spring.springkafkapractice.event;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EventController {

  private final EventService eventService;

  public EventController(EventService eventService) {
    this.eventService = eventService;
  }

  @GetMapping("/event")
  public String sendMyEvent() {
    eventService.sendMessage();
    return "ok";
  }
}
