package com.caelum.net.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class MinecraftStatusService {

    private final RestTemplate restTemplate;

    @Autowired
    public MinecraftStatusService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public MinecraftServerStatus getServerStatus(String serverAddress) {
        String MINECRAFT_SERVER_URL = "https://api.mcsrvstat.us/2/";
        String url = MINECRAFT_SERVER_URL + serverAddress;
        try {
            MinecraftServerStatus response = restTemplate.getForObject(url, MinecraftServerStatus.class);
            return response;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
