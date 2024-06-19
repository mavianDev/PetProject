package com.caelum.net.controllers;

import com.caelum.net.services.MinecraftServerStatus;
import com.caelum.net.services.MinecraftStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class MinecraftController {
    private final MinecraftStatusService minecraftStatusService;

    @Autowired
    public MinecraftController(MinecraftStatusService minecraftStatusService) {
        this.minecraftStatusService = minecraftStatusService;
    }

    @GetMapping("/minecraft/status/{localhost:25565}")
    public String getMinecraftServerStatus(@PathVariable String serverAddress, Model model) {
        MinecraftServerStatus serverStatus = minecraftStatusService.getServerStatus(serverAddress);

        if (serverStatus != null) {
            model.addAttribute("serverAddress", serverAddress);
            model.addAttribute("online", serverStatus.isOnline());
            model.addAttribute("playersOnline", serverStatus.getPlayersOnline());
            model.addAttribute("version", serverStatus.getVersion());
            return "minecraftStatus";
        } else {
            return "error"; // Создайте шаблон ошибки, если требуется
        }
    }
}
