package spring.springkafkapractice.event;

import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Service;
import spring.springkafkapractice.sender.KafkaProducer;

@Service
public class EventService {

  private final KafkaProducer kafkaProducer;

  public EventService(KafkaProducer kafkaProducer) {
    this.kafkaProducer = kafkaProducer;
  }

  public void sendMessage() {
    Map<String, Object> data = new HashMap<>();
    data.put("width", 1024);
    data.put("height", 768);

    kafkaProducer.send(KafkaProducer.TOPIC_NAME, new Event(data));
  }
}
