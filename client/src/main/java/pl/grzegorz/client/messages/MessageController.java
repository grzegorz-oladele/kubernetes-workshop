package pl.grzegorz.client.messages;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/messages")
@RequiredArgsConstructor
class MessageController {

    private final MessageService messageService;

    @GetMapping("/get")
    String getMessageFromMessageService() {
        return messageService.getMessageFromMessageService();
    }
}
