package edu.neu.csye7374;

import java.util.ArrayList;
import java.util.List;

public class StockAPI implements Tradable{

    private String name;
    private double price;
    private String description;
    protected List<Double> prevPrices = new ArrayList<>();
    private PricingStrategy pricingStrategy;

    public StockAPI(){
        super();
    }

    public StockAPI(String name, double price, String description) {
        this.name = name;
        this.price = price;
        this.description = description;
    }

    public StockAPI(String name, double price, String description, PricingStrategy strategy) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.pricingStrategy = strategy;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }


    public void setPricingStrategy(PricingStrategy strategy) {
        this.pricingStrategy = strategy;
    }

    public PricingStrategy getPricingStrategy() {
        return pricingStrategy;
    }

    public void applyStrategy() {
        if (pricingStrategy != null) {
            this.price = pricingStrategy.calculateNewPrice(this.price);
        }
    }

    @Override
    public void setBid(double bid) {
        this.price = bid;
    }

    @Override
    public int getMetric() {
        return price > 100 ? 1 : -1;
    }


    @Override
    public String toString(){
        return "Stock [name: " + this.getName() + ", price: " + this.getPrice() + ", description: " + this.getDescription() + ", Metric: " + this.getMetric() + "]";
    }

//    @Override
//    public String toString() {
//        return "Stock [name: " + name + ", price: " + price + ", description: " + description + ", strategy: " + pricingStrategy.getClass().getSimpleName() + "]";
//    }
}
