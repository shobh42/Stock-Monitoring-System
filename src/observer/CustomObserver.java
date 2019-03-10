package observer;
import util.Portfolio;
import chartcreator.BarChartFrame;
import chartcreator.LineChartFrame;
import chartcreator.ChartFrame;
import subject.Subject;
import subject.Stock;
import decorator.FrameDecorator;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import util.DecoratorFactory;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Shobhit
 */
public class CustomObserver extends ObserverFrame{
    
    private JCheckBox currentPriceCheckBox;
    private JCheckBox openingPriceCheckBox;
    private JCheckBox closingPriceCheckBox;
    private JCheckBox askPriceCheckBox;
    private JCheckBox statusCheckBox;
    private JCheckBox bidPriceCheckBox;
    private JCheckBox volumeCheckBox;
    private JCheckBox tenDayVolumeCheckBox;
    private JCheckBox lineChartCheckBox;
    private JCheckBox barChartCheckBox;
    private JButton doneButton;
    private List<FrameDecorator> decorators;
    private List<JCheckBox> checkBox;
    
    /**
     * Creates new form CustomObserver
     */
    public CustomObserver(Portfolio portfolio) {
        super(portfolio);
        decorators = new ArrayList<FrameDecorator>();
        checkBox = new ArrayList<JCheckBox>();
        updatePanel();
        AddCheckBoxToPanel();
        setTitle("Custom Observer");
    }
    
    private void updatePanel() {
        stocksUpdatePanel.removeAll();
        stocksUpdatePanel.setSize(250, 250);
        stocksUpdatePanel.setLayout(new GridBagLayout());
    }
    
    private void doneButtonActionPerformed(java.awt.event.ActionEvent evt) {                                           
        String selectedItem = availableStockComboBox.getSelectedItem().toString();
        String symbol = selectedItem.split(",")[0];
        
        //Remove all the previous decorators so that the frame will show only current decorators
        removePreviousDecorator();
        decorators = new ArrayList<FrameDecorator>();
        Stock stock = portfolio.getStock(symbol);
        stock.addObserver(this);
        currentSubject = stock;
        decorators = DecoratorFactory.createDecorator(checkBox);
        
        if(lineChartCheckBox.isSelected()){
            Stock currentStock = (Stock) currentSubject;
            ChartFrame chartFrame = new LineChartFrame(currentStock.getCompanyName());
            Thread thread = new Thread(chartFrame);
            thread.start();
            stock.addObserver(chartFrame);
        }
        
        if(barChartCheckBox.isSelected()){
            Stock currentStock = (Stock) currentSubject;
            ChartFrame chartFrame = new BarChartFrame(currentStock.getCompanyName());
            Thread thread = new Thread(chartFrame);
            thread.start();
            stock.addObserver(chartFrame);
        }
        
        decoratePanel();
        stocksUpdatePanel.repaint();
    }                                          
    
    @Override
    public void update(Subject stock) {
        for(FrameDecorator decorator: decorators){
            decorator.update(stock);
        }
        
        stocksUpdatePanel.repaint();
        stocksUpdatePanel.revalidate();
    }

    private void AddCheckBoxToPanel() {
        GridBagConstraints c = new GridBagConstraints();

        addCheckBoxToPanel(c, 0, 0, 30, 2);
        currentPriceCheckBox = new JCheckBox("Current Price");
        stocksUpdatePanel.add(currentPriceCheckBox, c);
        checkBox.add(currentPriceCheckBox);
        
        addCheckBoxToPanel(c, 1, 0, 30, 2);
        openingPriceCheckBox = new JCheckBox("Opening Price");
        stocksUpdatePanel.add(openingPriceCheckBox, c);
        checkBox.add(openingPriceCheckBox);
                
        addCheckBoxToPanel(c, 2, 0, 20, 2);
        closingPriceCheckBox = new JCheckBox("Closing Price");
        stocksUpdatePanel.add(closingPriceCheckBox, c);
        checkBox.add(closingPriceCheckBox);
        
        addCheckBoxToPanel(c, 0, 1, 30, 2);
        bidPriceCheckBox = new JCheckBox("Bid Price");
        stocksUpdatePanel.add(bidPriceCheckBox, c);
        checkBox.add(bidPriceCheckBox);

        addCheckBoxToPanel(c, 1, 1, 30, 2);
        statusCheckBox = new JCheckBox("Status");
        stocksUpdatePanel.add(statusCheckBox, c);
        checkBox.add(statusCheckBox);
        
        addCheckBoxToPanel(c, 2, 1, 20, 2);
        askPriceCheckBox = new JCheckBox("Ask Price");
        stocksUpdatePanel.add(askPriceCheckBox, c);
        checkBox.add(askPriceCheckBox);
        
        addCheckBoxToPanel(c, 0, 2, 30, 2);
        volumeCheckBox = new JCheckBox("Current Volume");
        stocksUpdatePanel.add(volumeCheckBox, c);
        checkBox.add(volumeCheckBox);
        
        addCheckBoxToPanel(c, 1, 2, 30, 2);
        tenDayVolumeCheckBox = new JCheckBox("Ten Day Volume");
        stocksUpdatePanel.add(tenDayVolumeCheckBox, c);
        checkBox.add(tenDayVolumeCheckBox);

        addCheckBoxToPanel(c, 2, 2, 20, 2);
        lineChartCheckBox = new JCheckBox("Line Chart");
        stocksUpdatePanel.add(lineChartCheckBox, c);

        addCheckBoxToPanel(c, 0, 3, 30, 2);
        barChartCheckBox = new JCheckBox("Bar Chart");
        stocksUpdatePanel.add(barChartCheckBox, c);
        
        addCheckBoxToPanel(c, 1, 3, 30, 2);
        doneButton = new JButton("Done");
        stocksUpdatePanel.add(doneButton, c);
        doneButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                doneButtonActionPerformed(e);
            }
        } );

        stocksUpdatePanel.repaint();
    }

    private void addCheckBoxToPanel(GridBagConstraints c, int row, int col, 
            int distanceX, int distanceY){
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = row;
        c.gridy = col;
        c.ipadx = distanceX;
        c.ipady = distanceY;
    }
    
    private void decoratePanel() {
        for(FrameDecorator decorator: decorators){
            decorator.decorate(stocksUpdatePanel);
        }
    }

    private void removePreviousDecorator() {
        for(FrameDecorator decorator: decorators){
            decorator.removeLabel(stocksUpdatePanel);
            stocksUpdatePanel.repaint();
        }    
    }
}