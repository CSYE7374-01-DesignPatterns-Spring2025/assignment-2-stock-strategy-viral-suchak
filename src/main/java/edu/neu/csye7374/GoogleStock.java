package edu.neu.csye7374;

public class GoogleStock extends StockAPI{

    public GoogleStock(double price, PricingStrategy strategy) {

        super("Google", price, "Software Engineering Company", strategy);
    }

    public GoogleStock(double price) {
        super("Google", price, "Software Engineering Company");
    }

//    @Override
//    public int getMetric() {
//        double mean = this.prevPrices.stream().mapToDouble(i -> i).sum() / this.prevPrices.size();
//        double dev = 0.0;
//        for(double num : this.prevPrices) {
//            dev += mean - num/3;
//        }
//        dev = dev / this.prevPrices.size();
//        return dev > 0.0 ? 1 : -1;
//    }
//
@Override
public String toString(){
    return "Stock [name: " + this.getName() + ", price: " + this.getPrice() + ", description: " + this.getDescription() + ", Metric: " + this.getMetric() + "]";
}

}
