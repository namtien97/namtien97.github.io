package com.moneyconverter.demo;

import com.moneyconverter.demo.service.MoneyConverter;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class DemoApplicationTests {

    @Autowired
    private MoneyConverter moneyConverter;

    @Test
    void contextLoads() {
        moneyConverter.loadExchangeRateFromJSON();
        assertEquals(true,true);
    }

}
