package com.example.demo.controller;


import com.example.demo.model.Car;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @Value("${spring.application.name}")
    private String appName;

    static final String APP_NAME = "appName";
    static final String CARS = "cars";

    @GetMapping(value = "/home")
    public String getHome(Model model) {
        Car[] carCollection = {
                new Car(1, "xe ford", "ford", 700),
                new Car(2, "xe ford", "ford", 700),
                new Car(3, "xe ford", "ford", 700)
        };

        model.addAttribute(CARS, carCollection);
        model.addAttribute(APP_NAME, appName);
        return "home";
    }
}
