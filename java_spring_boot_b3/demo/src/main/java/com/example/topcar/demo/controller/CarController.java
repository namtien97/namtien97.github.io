package com.example.topcar.demo.controller;

import com.example.topcar.demo.model.Car;
import com.example.topcar.demo.repository.CarDao;
import com.example.topcar.demo.request.DeleteRequest;
import com.example.topcar.demo.request.SearchRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/car")
public class CarController {
    @Autowired
    private CarDao carDao;

    @GetMapping
    public String listAll(Model model){
        model.addAttribute("cars",carDao.getAll());
        return "allcars";
    }

    @GetMapping(value = "/{id}")
    public String getByID(@PathVariable("id") int id, Model model){
        Optional<Car> car = carDao.get(id);
        if(car.isPresent()){
            model.addAttribute("car",car.get());
        }
        return "car";
    }

    @GetMapping("/add")
    public String add(Model model){
        model.addAttribute("car", new Car());
        return "form";
    }

    @PostMapping("/save")
    public String save(Car car, BindingResult result){
        if(result.hasErrors()){
            return "form";
        }
        if(car.getId()>0){
            carDao.update(car);
        }else {
            carDao.add(car);
        }
        return "redirect:/car";
    }

    @GetMapping(value = "/edit/{id}")
    public String editBookId(@PathVariable("id") int id, Model model){
        Optional<Car> car = carDao.get(id);
        if(car.isPresent()){
            model.addAttribute("car",car.get());
        }
        return "form";
    }

    @PostMapping(value = "/delete")
    public String deleteByID(@ModelAttribute DeleteRequest request, BindingResult result){
        if(!result.hasErrors()){
            carDao.deleteByID(request.getId());
        }
        return "redirect:/car";
    }

    @GetMapping("/search")
    public String searchForm(Model model){
        model.addAttribute("searchrequest", new SearchRequest());
        return "search";
    }

    @PostMapping("/search")
    public String searchByKeyword(@ModelAttribute SearchRequest request,BindingResult bindingResult,Model model){
        if(!bindingResult.hasFieldErrors()){
            model.addAttribute("cars", carDao.searchByKeyword(request.getKeyword()));
        }
        return "allcars";
    }
}


