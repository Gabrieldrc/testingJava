package com.gdrc.testingJava.discounts;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PriceCalculatorShould {
    private PriceCalculator calculator;
    @Before
    public void setup() {
        calculator = new PriceCalculator();
    }
    @Test
    public void return_total_zero_when_there_ar_no_prices() {
        assertEquals(0, calculator.getTotal(),  0);
    }

    @Test
    public void return_total_is_the_sum_of_price() {
        calculator.addPrice(10.0);
        calculator.addPrice(15.5);

        assertEquals(calculator.getTotal(), 25.5, 25.5);
    }

    @Test
    public void apply_discount_to_prices() {
        calculator.addPrice(12.2);
        calculator.addPrice(17.5);

        calculator.setDiscount(25);

        assertEquals(calculator.getTotal(), 25.5, (29.7 * 0.75));
    }
}