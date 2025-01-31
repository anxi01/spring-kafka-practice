package spring.springkafkapractice.sender;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class KafkaProducer {

  // Group ID
  public static final String TOPIC_NAME = "anxi";

  private final ObjectMapper objectMapper;

  /**
   * KafkaTemplate을 <String, String>으로 설정한 이유:
   * - Kafka로 메시지를 보낼 때 Jackson 라이브러리를 사용하여 JSON 문자열(String)로 변환하기 위해서이다.
   * - send() 메서드의 파라미터는 다양한 타입(Object)을 받을 수 있지만,
   *   KafkaTemplate을 통해 전송할 때는 JSON 문자열로 변환하여 전송한다.
   *
   * 객체를 직접 직렬화하여 보내는 대신, JSON 문자열로 변환하는 것이 더 안전하다.
   * - 특정 클래스에 종속되지 않으며, 다양한 언어(Java, Python 등)에서 쉽게 파싱할 수 있다.
   * - Kafka의 기본 직렬화 방식보다 JSON이 범용적으로 사용되며, 데이터 호환성이 높다.
   */
  private final KafkaTemplate<String, String> kafkaTemplate;

  public KafkaProducer(ObjectMapper objectMapper, KafkaTemplate<String, String> kafkaTemplate) {
    this.objectMapper = objectMapper;
    this.kafkaTemplate = kafkaTemplate;
  }

  public void send(String topic, Object data) {
    try {
      // Json으로 직렬화해서 전송
      kafkaTemplate.send(topic, objectMapper.writeValueAsString(data));
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }
}
