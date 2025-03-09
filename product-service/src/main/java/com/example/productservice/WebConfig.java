package com.example.productservice;



import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")  // Tüm endpointler için geçerli
                .allowedOrigins("http://localhost:63342")  // Frontend'in URL'si
                .allowedMethods("GET", "POST", "PUT", "DELETE")  // İzin verilen HTTP yöntemleri
                .allowedHeaders("*")  // Tüm başlıkları kabul et
                .allowCredentials(true);  // Kimlik doğrulama bilgileri (cookies, HTTP auth) izin verir
    }
}

