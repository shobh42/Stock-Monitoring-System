/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.awt.Color;
import java.util.Collections;
import java.util.List;
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
        
        dataset = DataSetCreator.createDataset(points);
        JFreeChart chart = getChart();
        chart.setBackgroundPaint(Color.WHITE);
    
        CategoryPlot plot = (CategoryPlot) chart.getPlot();
        plot.setBackgroundPaint(Color.WHITE);
       
        ValueAxis yAxis = plot.getRangeAxis();
        if(points.size()<=10){
            int minRange = Collections.min(points)-20;
            int maxRange = Collections.max(points)+5;
            yAxis.setRange(minRange, maxRange);
        }else{
            int minRange = Collections.min(points.subList(points.size()-10, points.size()))-20;
            int maxRange = Collections.max(points.subList(points.size()-10, points.size()))+5;
            yAxis.setRange(minRange, maxRange);
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
    }
    
    public abstract JFreeChart getChart();
    
    public abstract void setPlotColor(CategoryPlot plot);
}
