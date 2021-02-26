package com.car2.car2.controller;

import com.car2.car2.model.Car;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class HomeController {
    @Value("${spring.application.name}")
    private String appName;

    static final String CARS = "cars";
    static final String APP_NAME = "appName";

    @GetMapping(value = "/home")
    public String getHome(Model model) throws IOException {

        List<List<String>> carsInfo = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("E:/Techmaster/namtien97.github.io/car2/src/main/resources/static/csv/cars.csv"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                carsInfo.add(Arrays.asList(values));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < carsInfo.size(); i++) {
            String idStr = carsInfo.get(i).get(0);
            int idInt = Integer.parseInt(idStr);
            String priceStr = carsInfo.get(i).get(3);
            int priceInt = Integer.parseInt(priceStr);
            cars.add(new Car(idInt, carsInfo.get(i).get(1), carsInfo.get(i).get(2), priceInt));
        }

        model.addAttribute(CARS, cars);
        model.addAttribute(APP_NAME, appName);
        return "home";
    }
}
