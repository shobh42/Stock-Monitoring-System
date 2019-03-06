/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.awt.Color;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;

/**
 *
 * @author Shobhit
 */
public class LineChartCreator extends ChartCreator {

    @Override
    public JFreeChart getChart() {
        //return ChartFactory.createLineChart(chartTitle,  categoryAxisLabel, valueAxisLabel,dataset);
        return ChartFactory.createLineChart(chartTitle, categoryAxisLabel, valueAxisLabel, dataset);
    }
    
    @Override
    public void setPlotColor(CategoryPlot plot){
         plot.setRangeZeroBaselinePaint(Color.RED);
    }
}
