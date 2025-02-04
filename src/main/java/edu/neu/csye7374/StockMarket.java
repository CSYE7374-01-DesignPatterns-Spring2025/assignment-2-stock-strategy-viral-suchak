package edu.neu.csye7374;

import java.util.ArrayList;
import java.util.List;

public class StockMarket {
    private static StockMarket instance;

    private List<StockAPI> stocks = new ArrayList<>();

    private StockMarket(){
        instance = null;
    }

    public static StockMarket getInstance(){
        if(instance == null){
            instance = new StockMarket();
        }
        return instance;
    }

    public StockAPI getStockItem(String name, double price, String description){
        return new StockAPI(name, price, description);
    }

    public void add(StockAPI stock){
        stocks.add(stock);
    }

    public void remove(StockAPI s){
        boolean removed = this.stocks.remove(s);

        if(!removed) {
            System.out.println("Stock not found");
        }
    }

    public void displayStocks(){
        for(StockAPI s : this.stocks){
            System.out.println(s.toString());
        }
    }

    public void updatePrice(StockAPI s, double price){
        if(this.stocks.contains(s)){
            s.setPrice(price);
            return;
        }
        System.out.println("Stock not found");
    }

    public static void demo(){
        System.out.println("");

        GoogleStock googleStock = new GoogleStock(80);
        MetaStock metaStock = new MetaStock(110);

        StockMarket.getInstance().add(googleStock);
        StockMarket.getInstance().add(metaStock);

        googleStock.setBid(10);

        googleStock.setBid(40);

        googleStock.setBid(50);

        googleStock.setBid(60);

        googleStock.setBid(70);

        googleStock.setBid(75);

        googleStock.getMetric();

        /*Meta Stocks*/
        metaStock.setBid(80);

        metaStock.setBid(90);

        metaStock.setBid(100);

        metaStock.setBid(110);

        metaStock.setBid(120);

        metaStock.setBid(130);

        metaStock.getMetric();

        StockMarket.getInstance().displayStocks();


        /* Lazy and Eager Factory Pattern */

        StockAPI googleStock1 = MetaStockFactoryLazy.getInstance().getObject(80.00);
        StockAPI metaStock1 = GoogleStockFactoryEager.getInstance().getObject(90.00);

        StockMarket.getInstance().add(googleStock1);
        StockMarket.getInstance().add(metaStock1);

        googleStock1.setBid(15);

        googleStock1.setBid(30);

        googleStock1.setBid(45);

        googleStock1.setBid(60);

        googleStock1.setBid(75);

        googleStock1.setBid(90);

        googleStock1.setBid(105);

        metaStock1.setBid(85);

        metaStock1.setBid(95);

        metaStock1.setBid(105);

        metaStock1.setBid(115);

        metaStock1.setBid(125);

        metaStock1.setBid(135);

        metaStock1.getMetric();
        StockMarket.getInstance().displayStocks();

        /*  Factory Pattern */
        StockAPI googleStock2 = new GoogleStockFactory().getObject(80.00);
        StockAPI metaStock2 = new MetaStockFactory().getObject(90.00);

        StockMarket.getInstance().add(googleStock2);
        StockMarket.getInstance().add(metaStock2);

        googleStock2.setBid(15);

        googleStock2.setBid(30);

        googleStock2.setBid(45);

        googleStock2.setBid(60);

        googleStock2.setBid(75);

        googleStock2.setBid(90);

        googleStock2.setBid(105);

        metaStock2.setBid(85);

        metaStock2.setBid(95);

        metaStock2.setBid(105);

        metaStock2.setBid(115);

        metaStock2.setBid(125);

        metaStock2.setBid(135);

        metaStock2.getMetric();
        StockMarket.getInstance().displayStocks();


        /***** Strategy Pattern ******/

        PricingStrategy bullMarket = new BullMarketStrategy();
        PricingStrategy bearMarket = new BearMarketStrategy();

        GoogleStock googleStockStrategy = new GoogleStock(80, bullMarket);
        MetaStock metaStockStrategy = new MetaStock(110, bearMarket);

        googleStockStrategy.applyStrategy();
        metaStockStrategy.applyStrategy();

        System.out.println("\nAfter applying market strategies:");
        System.out.println("\nBullish...");
        System.out.println(googleStockStrategy);
        System.out.println("\nBearish...");
        System.out.println(metaStockStrategy);

    }
}
