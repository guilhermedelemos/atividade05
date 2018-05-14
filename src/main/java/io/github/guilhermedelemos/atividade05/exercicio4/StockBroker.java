/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.guilhermedelemos.atividade05.exercicio4;

import java.math.BigDecimal;

/**
 *
 * @author guilherme
 */
public class StockBroker {

    private final static BigDecimal LIMIT = new BigDecimal("0.10");

    private final MarketWatcher market;

    public StockBroker(MarketWatcher market) {
        this.market = market;
    }

    /**
     * Extraído do exercício
     *
     * @param portfolio
     * @param stock
     */
    public void perform(Portfolio portfolio, Stock stock) {
        Stock liveStock = market.getQuote(stock.getSymbol());
        BigDecimal avgPrice = portfolio.getAvgPrice(stock);
        BigDecimal priceGained = liveStock.getPrice().subtract(avgPrice);
        BigDecimal percentGain = priceGained.divide(avgPrice);
        if (percentGain.compareTo(LIMIT) > 0) {
            portfolio.sell(stock, 10);
        } else if (percentGain.compareTo(LIMIT) < 0) {
            portfolio.buy(stock);
        }
    }
}
