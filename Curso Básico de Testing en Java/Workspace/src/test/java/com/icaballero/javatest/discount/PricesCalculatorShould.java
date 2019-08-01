package com.icaballero.javatest.discount;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class PricesCalculatorShould {


    @Test
    public void total_zero_when_there_are_prices() {

        PricesCalculator calculator = new PricesCalculator();

        assertThat(calculator.getTotal(), is(0.0));


    }


    @Test
    public void total_is_the_sum_of_prices() {

        PricesCalculator calculator = new PricesCalculator();

        calculator.addPrices(10.2);
        calculator.addPrices(15.5);

        assertThat(calculator.getTotal(), is(25.7));


    }


    @Test
    public void apply_discount_to_prices() {

        PricesCalculator calculator = new PricesCalculator();

        calculator.addPrices(100);
        calculator.addPrices(100);

        calculator.setDiscount(25);

        assertThat(calculator.getTotal(), is(150.0));


    }



}