/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.swing.JFrame;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author Shobhit
 */
public abstract class ChartCreator {
    protected String chartTitle = "Current Price";
    protected String categoryAxisLabel = null;
    protected String valueAxisLabel = null;
    protected CategoryDataset dataset;
    
    public JFreeChart createChart(List<Integer> points){
        
        dataset = createDataset(points);
        JFreeChart chart = getChart();
        chart.setBackgroundPaint(Color.WHITE);
    
        final CategoryPlot plot = (CategoryPlot) chart.getPlot();
        plot.setBackgroundPaint(Color.WHITE);
       
        ValueAxis yAxis = plot.getRangeAxis();
        if(points.size()<=10){
            yAxis.setRange(Collections.min(points)-20,Collections.max(points)+5);
        }else{
            yAxis.setRange(Collections.min(points.subList(points.size()-10, points.size()))-20,Collections.max(points.subList(points.size()-10, points.size()))+5);
        }
        
        setPlotColor(plot);
        plot.getDomainAxis();
        plot.setOutlineVisible(false);
        plot.setRangeGridlinePaint(Color.white);
        plot.setDomainGridlinePaint(Color.BLUE);
        plot.getRangeAxis().setVisible(true);
        plot.getDomainAxis().setAxisLineVisible(true);
        plot.getDomainAxis().setTickMarksVisible(false);
        plot.getDomainAxis().setTickLabelsVisible(false);
        return chart;
        //return chartPanel;
    }
    
    public abstract JFreeChart getChart();
    
    public abstract void setPlotColor(CategoryPlot plot);
    
    public DefaultCategoryDataset createDataset(List<Integer> points){
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        String series1 = "";
        if(points.size()<=10){
            for(int i= 0  ;i<points.size();i++){
                int number = points.get(i);
                dataset.addValue(number, series1, ""+i);
            }
        }else{
            for(int i= points.size()-10  ;i<points.size();i++){
                int number = points.get(i);
                dataset.addValue(number, series1, ""+i);
        } 
    }
       
    return dataset;
        
    }
   
}
