package pl.grzegorz.messageservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/messages")
class MessageController {

    @GetMapping
    String getMessage() {
        return "Message from the Message Service";
    }
}
