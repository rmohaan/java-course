package org.mohaan;

import java.util.HashMap;

public class StockFetcher {
    public static StockInfo getPrice(String ticker) {
        var map = new HashMap<String, Double>();
        map.put("AAPL", 102.78d);
        map.put("MSFT", 109.23d);
        map.put("INTC", 98.00d);
        map.put("FRSH", 10.22d);
        return new StockInfo(ticker, map.get(ticker));
    }
}
