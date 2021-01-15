package com.moneyconverter.demo.response;

public class ConverterResult {
    private float amountResult;

    public ConverterResult(float amountResult) {
        this.amountResult = amountResult;
    }

    public float getAmountResult() {
        return amountResult;
    }

    public void setAmountResult(float amountResult) {
        this.amountResult = amountResult;
    }
}
