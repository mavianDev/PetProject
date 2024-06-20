package com.caelum.net.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class MinecraftController {
    public String getMinecraftServerStatus(@PathVariable String serverAddress, Model model) {
        String serverIP = "hypixel.net";
        boolean online = true;
        int playersOnline = 10;
        String version = "1.20";

        // Передача данных в модель
        model.addAttribute("serverAddress", serverIP);
        model.addAttribute("online", online);
        model.addAttribute("playersOnline", playersOnline);
        model.addAttribute("version", version);

        return "minecraftStatus";
    }
}
