package pl.grzegorz.client.messages;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
class MessageService {

    private final String url;
    private final RestTemplate restTemplate;

    public MessageService(RestTemplate restTemplate, @Value("${rest-template.message-service.host}") String address) {
        this.restTemplate = restTemplate;
        this.url = "http://" + address + ":8282/messages";
    }

    String getMessageFromMessageService() {
        return restTemplate.getForObject(url, String.class);
    }
}