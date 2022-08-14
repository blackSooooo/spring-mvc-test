package test.mvc.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;


import java.util.List;

@RestController
public class TestController {
    private final WebClient webClient = WebClient.builder()
            .baseUrl("http://localhost:7777")
            .build();

    private static final Logger logger = LoggerFactory.getLogger(TestController.class);

    @GetMapping("/api")
    public List test() {
        logger.info("TEST");
        return webClient.get().uri("/test")
                .retrieve()
                .bodyToMono(List.class)
                .block();
    }
}
