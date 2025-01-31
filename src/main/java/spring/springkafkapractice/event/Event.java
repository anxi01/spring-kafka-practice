package spring.springkafkapractice.event;

import java.util.Map;
import java.util.UUID;

public class Event {
  private String eventId;
  private Map<String, Object> data;

  public Event(Map<String, Object> data) {
    this.eventId = UUID.randomUUID().toString();
    this.data = data;
  }

  public String getEventId() {
    return eventId;
  }

  public void setEventId(String eventId) {
    this.eventId = eventId;
  }

  public Map<String, Object> getData() {
    return data;
  }

  public void setData(Map<String, Object> data) {
    this.data = data;
  }

  @Override
  public String toString() {
    return "Event{" +
        "eventId='" + eventId + '\'' +
        ", data=" + data +
        '}';
  }
}
