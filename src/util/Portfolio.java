package util;


import stock.monitoring.system.AvailableStock;
import subject.Stock;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Shobhit
 */
public class Portfolio {
    
    private HashMap<String, Stock> symbolsToStock;
    private AvailableStock availableStock;
    
    public Portfolio(AvailableStock availableStock){
        this.availableStock = availableStock;
        symbolsToStock = new HashMap<String, Stock>();
    }
    
    public void Add(String symbol){
        Map<String, Stock> stocks = availableStock.getAvailableStock();
        Stock stock = stocks.get(symbol);
        symbolsToStock.put(symbol, stock);
    }
    
    public void Remove(String symbol){
        symbolsToStock.remove(symbol);
    }
    
    public Set<String> getSymbols(){
        return symbolsToStock.keySet();
    }
    
    public Stock getStock(String symbol){
        return symbolsToStock.get(symbol);
    }
}

