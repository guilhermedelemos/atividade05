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
public interface Portfolio {

    public BigDecimal getAvgPrice(Stock stock);

    public void buy(Stock stock);

    public void sell(Stock stock, int i);
}
