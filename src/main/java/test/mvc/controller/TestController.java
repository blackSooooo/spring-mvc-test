package test.mvc.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;


import java.util.List;

@RestController
public class TestController {
    private final WebClient webClient = WebClient.builder()
            .baseUrl("http://localhost:7777")
            .build();

    @GetMapping("/api")
    public List test() {

        return webClient.get().uri("/test")
                .retrieve()
                .bodyToMono(List.class)
                .block();
    }
}
