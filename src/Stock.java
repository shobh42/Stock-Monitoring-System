/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/**
 *
 * @author Shobhit
 */
public class Stock implements Subject {
    private String symbol;
    private String companyName;
    private int openingPrice;
    private int closingPrice;
    private int bidPrice;
    private int currentPrice;
    private int askPrice;
    private int currentVolume;
    private int tenDayVolume;
    private ArrayList<Observer> observers;
    
    public Stock(String symbol, String companyName){
        this.symbol = symbol;
        this.companyName = companyName;
        observers = new ArrayList<>();
    }

    public String getSymbol() {
        return symbol;
    }

    public String getCompanyName() {
        return companyName;
    }
    
    public int getOpeningPrice() {
        return openingPrice;
    }

    public int getClosingPrice() {
        return closingPrice;
    }

    public int getBidPrice() {
        return bidPrice;
    }

    public int getCurrentPrice() {
        return currentPrice;
    }

    public int getAskPrice() {
        return askPrice;
    }

    public int getCurrentVolume() {
        return currentVolume;
    }

    public int getTenDayVolume() {
        return tenDayVolume;
    }
    
     public void updateStock(TickerMessage message){
        openingPrice = message.getOpeningPrice();
        closingPrice = message.getPreviousClosingPrice();
        bidPrice = message.getBidPrice();
        currentPrice = message.getCurrentPrice();
        askPrice = message.getAskPrice();
        currentVolume = message.getCurrentVolume();
        tenDayVolume = message.getAverageVolume();
        notifyAllObserver();
    }

    @Override
    public void addObserver(Observer observerToAdd) {
        observers.add(observerToAdd);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyAllObserver() {
        for(Observer observer : observers){
            observer.update(this);
        } 
        
        //System.out.println(this);
    }

    @Override
    public String toString(){
        return symbol + " " + companyName + " " +currentPrice + " " + 
                openingPrice + " " + closingPrice + " " + bidPrice + " " + 
                askPrice + " " + currentVolume + " " + tenDayVolume; 
    }
}
