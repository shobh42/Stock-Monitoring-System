package util;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import subject.Stock;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author Shobhit
 */
public class CSVReader {
    public Map<String , Stock> readFile(String fileName){
        Map<String , Stock> stocksInfo = new TreeMap<>();
        String csvFile = "C:\\Users\\Shobhit\\Desktop\\Misc\\Projects\\Fall 16 - cs5700\\Stock Monitoring System\\Companies.csv";
        BufferedReader bufferReader = null;
        String line = "";
        String cvsSplitBy = ",";
        try {
            bufferReader = new BufferedReader(new FileReader(csvFile));
            while ((line = bufferReader.readLine()) != null) {
                String[] stock = line.split(cvsSplitBy);
                stocksInfo.put(stock[0],new Stock(stock[0], stock[1]));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bufferReader != null) {
                try {
                    bufferReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } 
        
        return stocksInfo;
    }
}
