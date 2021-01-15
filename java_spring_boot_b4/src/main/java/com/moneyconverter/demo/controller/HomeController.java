package com.moneyconverter.demo.controller;

import com.moneyconverter.demo.model.CurrencyRate;
import com.moneyconverter.demo.request.ConverterRequest;
import com.moneyconverter.demo.response.ConverterResult;
import com.moneyconverter.demo.service.MoneyConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/money")
public class HomeController {

    @Autowired
    private MoneyConverter moneyConverter;



    @GetMapping
    public String getConverterForm(Model model){
        model.addAttribute("converterRequest", new ConverterRequest());
        List<CurrencyRate> currencies = moneyConverter.getSortedCurrencyCode();
        model.addAttribute("currencies",currencies);
        model.addAttribute("converterResult", null);
        return "home";
    }

    @PostMapping()
    public String handleConverterForm(@ModelAttribute ConverterRequest request, BindingResult bindingResult, Model model){
        if(!bindingResult.hasErrors()){
            ConverterResult converterResult = moneyConverter.calculateAmount(request);
            model.addAttribute("converterRequest",request);
            model.addAttribute("converterResult", converterResult);
            List<CurrencyRate> currencies = moneyConverter.getSortedCurrencyCode();
            model.addAttribute("currencies",currencies);
        }
        return "home";
    }
}
