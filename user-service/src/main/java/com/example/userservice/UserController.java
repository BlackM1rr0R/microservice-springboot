package com.example.userservice;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@RestController
@RequestMapping("/users")

public class UserController {

    private final WebClient.Builder webClientBuilder;
    private final UserService userService;

    public UserController(WebClient.Builder webClientBuilder, UserService userService) {
        this.webClientBuilder = webClientBuilder;
        this.userService = userService;
    }

    @PostMapping("/adduser")
    public User addUser(@RequestBody User user) {
        return userService.addUser(user);
    }

    @GetMapping
    public String getUserWithProducts() {
        String products = webClientBuilder.build()
                .get()
                .uri("http://product-service/products")
                .retrieve()
                .bodyToMono(String.class)
                .block();
        return "User Service | Products: " + products;
    }

    @GetMapping("/user/{userId}/products")
    public UserWithProductsDTO getUserWithProducts(@PathVariable Long userId) {

        User user = userService.getUserById(userId);

        List<Product> products = webClientBuilder.build()
                .get()
                .uri("http://product-service/products/" + userId)
                .retrieve()
                .bodyToFlux(Product.class)
                .collectList()
                .block();

        return new UserWithProductsDTO(user, products);
    }


}
