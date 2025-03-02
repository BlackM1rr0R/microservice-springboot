package com.example.userservice;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final WebClient.Builder webClientBuilder;
    private final UserService userService;

    @GetMapping("/user")
    public String getUserWithProducts() {
        String products = webClientBuilder.build()
                .get()
                .uri("http://product-service/products")
                .retrieve()
                .bodyToMono(String.class)
                .block();
        return "User Service | Products: " + products;
    }

    @GetMapping("/user/{userId}")
    public String getUserWithUserId(@PathVariable Long userId) {
        String products = webClientBuilder.build()
                .get()
                .uri("http://product-service/products")
                .retrieve()
                .bodyToMono(String.class)
                .block();
        User user =userService.getUserById(userId);
        return "User: " + user + " | Gelen Productlar: " + products;
    }
}
