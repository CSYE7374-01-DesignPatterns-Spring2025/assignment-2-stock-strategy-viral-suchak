package edu.neu.csye7374;

public class BullMarketStrategy implements PricingStrategy{

    @Override
    public double calculateNewPrice(double currentPrice) {
        return currentPrice * 1.10; // Increase price by 10%
    }
}
