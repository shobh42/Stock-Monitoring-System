/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.sun.javafx.scene.control.skin.VirtualFlow;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.chart.Chart;
import javax.swing.JFrame;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;

/**
 *
 * @author Shobhit
 */
public class ChartFrame implements Observer, Runnable{
    
    private JFrame chartJFrame;
    private ChartCreator chartCreator;
    private List<Integer> points;
    
    public ChartFrame(ChartCreator chartCreator){
        chartJFrame = new ChartJFrame();
        this.chartCreator = chartCreator;
        points = new ArrayList<Integer>();
    }
    
    public void showChart(){
        
        if(points.size() == 0) return;
        
        JFreeChart chart = chartCreator.createChart(points);
        ChartPanel chartPanel = new ChartPanel(chart);
        chartJFrame.setVisible(true);
        chartJFrame.add(chartPanel);
    }

    @Override
    public void update(Subject stock) {
        Stock s = (Stock)stock;
        int currentPrice = s.getCurrentPrice();
        points.add(currentPrice);
    }

    @Override
    public void run() {
        while(true){
            try {
                showChart();
                Thread.sleep(2000);
            } catch (InterruptedException ex) {
                Logger.getLogger(ChartFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }
} 