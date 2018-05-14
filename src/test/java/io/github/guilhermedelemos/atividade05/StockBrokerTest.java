/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.guilhermedelemos.atividade05;

import io.github.guilhermedelemos.atividade05.exercicio4.StockBroker;
import io.github.guilhermedelemos.atividade05.exercicio4.Portfolio;
import io.github.guilhermedelemos.atividade05.exercicio4.MarketWatcher;
import io.github.guilhermedelemos.atividade05.exercicio4.Stock;
import java.math.BigDecimal;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 *
 * @author guilherme
 */
public class StockBrokerTest {

    public StockBrokerTest() {
    }

    @Test
    public void venderAcoesTest() {
        // MOCK PORTFOLIO - PREÇO
        Stock stock = new Stock("GOLL4", "Gol", new BigDecimal(10));

        Portfolio pMock = mock(Portfolio.class);
        when(pMock.getAvgPrice(stock)).thenReturn(new BigDecimal(10));

        // MOCK MARKET WATCHER
        Stock mwStock = new Stock("GOLL4", "Gol", new BigDecimal(20));

        MarketWatcher mwMock = mock(MarketWatcher.class);
        when(mwMock.getQuote("GOLL4")).thenReturn(mwStock);

        // PERFORM
        StockBroker broker = new StockBroker(mwMock);
        broker.perform(pMock, stock);
    }
    
    @Test
    public void comprarAcoesTest() throws Exception {
        // MOCK PORTFOLIO - PREÇO
        Stock stock = new Stock("GOLL4", "Gol", new BigDecimal(10));
     
        Portfolio pMock = mock(Portfolio.class);
        when(pMock.getAvgPrice(stock)).thenReturn(new BigDecimal(10));

        // MOCK MARKET WATCHER
        Stock mwStock = new Stock("GOLL4", "Gol", new BigDecimal(5));
        
        MarketWatcher mwMock = mock(MarketWatcher.class);
        when(mwMock.getQuote("GOLL4")).thenReturn(mwStock);

        // PERFORM
        StockBroker broker = new StockBroker(mwMock);
        broker.perform(pMock, stock);
    }
    
    @Test(expected = Exception.class)
    public void semInternetAcoesTest() throws Exception {
        // MOCK PORTFOLIO - PREÇO
        Stock stock = new Stock("GOLL4", "Gol", new BigDecimal(10));
        Portfolio pMock = mock(Portfolio.class);
        when(pMock.getAvgPrice(stock)).thenReturn(new BigDecimal(10));

        // MOCK MARKET WATCHER
        Stock mwStock = new Stock("GOLL4", "Gol", new BigDecimal(5));
        MarketWatcher mwMock = mock(MarketWatcher.class);
        when(mwMock.getQuote("GOLL4")).thenThrow(new Exception("Sem acesso a internet."));

        // PERFORM
        StockBroker broker = new StockBroker(mwMock);
        broker.perform(pMock, stock);
    }
    
}
