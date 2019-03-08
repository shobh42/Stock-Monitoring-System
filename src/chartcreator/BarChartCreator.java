package chartcreator;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.awt.Color;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.renderer.category.BarRenderer;
/**
 *
 * @author Shobhit
 */
public class BarChartCreator extends ChartCreator {

    @Override
    public JFreeChart getChart() {
        return ChartFactory.createBarChart(chartTitle, categoryAxisLabel, valueAxisLabel, dataset);
    }
    
    public void setPlotColor(CategoryPlot plot){
        plot.setRangeZeroBaselinePaint(Color.BLUE);
        BarRenderer barRenderer = (BarRenderer)plot.getRenderer();
        barRenderer.setSeriesPaint(0, Color.BLUE);
    }
 }
    

