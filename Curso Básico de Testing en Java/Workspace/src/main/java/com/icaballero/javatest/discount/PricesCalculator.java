package com.icaballero.javatest.discount;

import java.util.ArrayList;
import java.util.List;

public class PricesCalculator {

    private List<Double> prices = new ArrayList<>();
    private double discount = 0;

    public double getTotal() {

        double result = 0;

        for (Double price : prices) {
            result +=price;

        }

        return result * ((100 - discount) / 100);
    }

    public void addPrices(double price) {
        prices.add(price);
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }
}
