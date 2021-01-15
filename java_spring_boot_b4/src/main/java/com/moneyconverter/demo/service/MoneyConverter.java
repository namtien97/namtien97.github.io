package com.moneyconverter.demo.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import com.moneyconverter.demo.model.CurrencyRate;
import com.moneyconverter.demo.model.ExchangeRate;
import com.moneyconverter.demo.request.ConverterRequest;
import com.moneyconverter.demo.response.ConverterResult;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.*;
import java.util.*;

@Service
public class MoneyConverter {

    private HashMap<String, CurrencyRate> mapCurrencyRates;
    private JsonNode masterNode;

    public MoneyConverter(){
        loadExchangeRateFromJSON();
        loadCurrencyCodeFromCSV();
    }

    public HashMap<String, CurrencyRate> getMapCurrencyRates(){
        return mapCurrencyRates;
    }

    public List<CurrencyRate> getSortedCurrencyCode(){
        ArrayList<CurrencyRate> listCurrency = new ArrayList<>(mapCurrencyRates.values());
        Collections.sort(listCurrency,Comparator.comparing(CurrencyRate::getName));
        return listCurrency;
    }

    /* doc json*/
    public void loadExchangeRateFromJSON() {
        try {
            File file = ResourceUtils.getFile("classpath:static/exchange_rate.json");
            FileReader reader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(reader);
            ObjectMapper objectMapper = new ObjectMapper();
            masterNode = objectMapper.readTree(bufferedReader);
        } catch (FileNotFoundException e) {
            System.out.println(e);
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    /*doc csv*/
    public void loadCurrencyCodeFromCSV(){
        mapCurrencyRates = new HashMap<>();
        try {
            File file = ResourceUtils.getFile("classpath:static/currency.csv");
            CsvMapper mapper = new CsvMapper();
            CsvSchema schema =  CsvSchema.emptySchema().withHeader();
            ObjectReader oReader = mapper.readerFor(CurrencyRate.class).with(schema);
            Reader reader = new FileReader(file);
            MappingIterator<CurrencyRate> mi = oReader.readValues(reader);

            while (mi.hasNext()){
                CurrencyRate currencyRate = mi.next();
                String currencyCode = currencyRate.getCode();

                if(mapCurrencyRates.get(currencyCode)==null){
                    float rate = getExchangeRate (currencyCode);
                    if(rate >0.0f){
                        currencyRate.setRate(rate);
                        mapCurrencyRates.put(currencyCode,currencyRate);
                    }
                }

            }
        } catch (FileNotFoundException e) {
            System.out.println(e);
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    /*luu vao model ExchangeRate*/
    public List<ExchangeRate> parseExchangeRate(){
        if(masterNode == null) return Collections.emptyList();
        Iterator<Map.Entry<String,JsonNode>> iter = masterNode.fields();

        ArrayList<ExchangeRate> exchangeRates = new ArrayList<>();

        while (iter.hasNext()){
            var node = iter.next();
            exchangeRates.add(new ExchangeRate(node.getKey(),(float) node.getValue().doubleValue()));
        }
        return exchangeRates;
    }

    /*lay exchangerate ra*/
    public float getExchangeRate(String currencyCode) {
        if(masterNode==null){
            return 0;
        }
        JsonNode currencyNode = masterNode.get(currencyCode);

        if(currencyNode != null){
            return currencyNode.floatValue();
        }else {
            return 0.0f;
        }
    }

    public ConverterResult calculateAmount(ConverterRequest request) {
        float resultConvert = request.getAmount()*getExchangeRate(request.getToCurrency())
                /getExchangeRate(request.getFromCurrency());
        return new ConverterResult(resultConvert);
    }
}
