package com.caelum.net.controllers;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ErrorsController implements ErrorController {
    @RequestMapping("/error")
    public String handleError (HttpServletRequest request) {
        Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");

        return switch (statusCode) {
            case 404 -> "errors/404";
            case 500 -> "errors/500";
            case null, default -> "errors/error";
        };
    }

    public String getErrorPath () {
        return "/error";
    }
}
