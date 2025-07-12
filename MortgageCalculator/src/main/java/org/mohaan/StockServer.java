package org.mohaan;

import rx.Observable;
import rx.Subscriber;

import java.util.List;

public class StockServer {
    public static Observable<StockInfo> getFeed(List<String> symbols) {
        return Observable.create(subscriber -> process(subscriber, symbols));
    }

    private static void process(Subscriber<? super StockInfo> subscriber, List<String> symbols) {
        System.out.println("processing the request...");

        while(true) {
            symbols.stream()
                    .map(StockFetcher::getPrice)
                    .forEach(subscriber::onNext);
        }
    }
}
