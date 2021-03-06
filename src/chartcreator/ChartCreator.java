package chartcreator;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import DatasetValues.DatasetValue;
import util.DataSetCreator;
import java.awt.Color;
import java.util.Collections;
import java.util.List;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.data.category.CategoryDataset;

/**
 *
 * @author Shobhit
 */
public abstract class ChartCreator {
    protected String chartTitle;
    protected String categoryAxisLabel = null;
    protected String valueAxisLabel = null;
    protected CategoryDataset dataset;
    private DataSetCreator datasetCreator = new DataSetCreator();
    
    public JFreeChart createChart(DatasetValue currentDataset, int numOfPoints){
        List<Integer> points = currentDataset.getValues();
        chartTitle = currentDataset.toString();
        dataset = datasetCreator.createDataset(points, numOfPoints);
        JFreeChart chart = getChart();
        chart.setBackgroundPaint(Color.WHITE);
    
        CategoryPlot plot = (CategoryPlot) chart.getPlot();
        plot.setBackgroundPaint(Color.WHITE);
       
        ValueAxis yAxis = plot.getRangeAxis();
        if(points.size()<= numOfPoints){
            int minRange = Collections.min(points)-20;
            int maxRange = Collections.max(points)+5;
            yAxis.setRange(minRange, maxRange);
        }else{
            int minRange = Collections.min(points.subList(points.size()-numOfPoints, points.size()))-20;
            int maxRange = Collections.max(points.subList(points.size()-numOfPoints, points.size()))+5;
            yAxis.setRange(minRange, maxRange);
        }
        
        setPlotColor(plot);
        updatePlotSetting(plot);
        return chart;
    }
    
    public abstract JFreeChart getChart();
    
    public abstract void setPlotColor(CategoryPlot plot);

    private void updatePlotSetting(CategoryPlot plot) {
        plot.getDomainAxis();
        plot.setOutlineVisible(false);
        plot.setRangeGridlinePaint(Color.white);
        plot.setDomainGridlinePaint(Color.BLUE);
        plot.getRangeAxis().setVisible(true);
        plot.getDomainAxis().setAxisLineVisible(true);
        plot.getDomainAxis().setTickMarksVisible(false);
        plot.getDomainAxis().setTickLabelsVisible(false);
    }
}
