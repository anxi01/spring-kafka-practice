package spring.springkafkapractice.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import spring.springkafkapractice.sender.KafkaProducer;

@Component
public class KafkaConsumer {

  // RabbitMQ -> @RabbitListener

  /**
   * topics: 지정된 TopicName으로 메시지가 전송되면 eventHandler()에서 처리할 수 있다.
   * autoStartup: 애플리케이션 실행 시 해당 KafkaListener를 자동으로 시작할지 여부를 결정하는 옵션 (기본값: true)
   * @param event 수신된 Kafka 메시지
   */
  @KafkaListener(topics = KafkaProducer.TOPIC_NAME, groupId = "anxi", autoStartup = "true")
  public void eventHandler(Object event) {
    System.out.println("get data: " + event);
  }
}
