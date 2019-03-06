
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Shobhit
 */
public class AvailableStock {
    //To maintain the order of the stocks, we have user tree map
    private Map<String, Stock> stocks = new TreeMap<String, Stock>();
    
    public AvailableStock(){
        stocks = new CSVReader().readFile(null);
    }
    
    public Map<String, Stock> getAvailableStock(){
        return stocks;
    }
}
