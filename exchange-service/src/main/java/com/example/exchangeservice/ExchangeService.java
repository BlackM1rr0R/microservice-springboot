package com.example.exchangeservice;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Service
public class ExchangeService {
    private static final String API_KEY = "865a993b0560f2f28fc5ab3a";
    private static final String API_URL = "https://v6.exchangerate-api.com/v6/" + API_KEY + "/latest/";

    public Map<String, Double> getExchangeRates(String baseCurrency) {
        RestTemplate restTemplate = new RestTemplate();
        String url = API_URL + baseCurrency;

        ExchangeDataResponse response = restTemplate.getForObject(url, ExchangeDataResponse.class);

        if (response == null || response.getConversion_rates() == null) {
            throw new RuntimeException("Döviz kurları alınamadı!");
        }

        return response.getConversion_rates();
    }
}
