package com.caelum.net.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class MinecraftStatusService {

    private final String MINECRAFT_SERVER_URL = "https://api.mcsrvstat.us/2/";

    private final RestTemplate restTemplate;

    @Autowired
    public MinecraftStatusService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public MinecraftServerStatus getServerStatus(String serverAddress) {
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
