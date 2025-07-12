package org.mohaan;

public class StockInfo {
    private String ticker;
    private Double price;
    
    public StockInfo(String ticker, Double price) {
        this.ticker = ticker;
        this.price = price;
    }

    public String getTicker() {
        return ticker;
    }

    public void setTicker(String ticker) {
        this.ticker = ticker;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return this.ticker + " " + this.price;
    }
}
