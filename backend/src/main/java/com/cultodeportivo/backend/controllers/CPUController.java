package com.cultodeportivo.backend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class CPUController {

    @GetMapping("/cpu")
    public String stressCpu() {
        long endTime = System.currentTimeMillis() + 10000; // 10 segundos de carga
        while (System.currentTimeMillis() < endTime) {
            Math.pow(Math.random(), Math.random());
        }
        return "CPU stress completed!";
    }
}
