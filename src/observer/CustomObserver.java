package observer;


import util.Portfolio;
import chartcreator.BarChartFrame;
import chartcreator.LineChartFrame;
import chartcreator.ChartFrame;
import subject.Subject;
import subject.Stock;
import decorator.OpeningPriceDecorator;
import decorator.StatusDecorator;
import decorator.TenDayVolumeDecorator;
import decorator.VolumePriceDecorator;
import decorator.FrameDecorator;
import decorator.BidPriceDecorator;
import decorator.CurrentPriceDecorator;
import decorator.AskPriceDecorator;
import decorator.ClosingPriceDecorator;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

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
    
    /**
     * Creates new form CustomObserver
     */
    public CustomObserver(Portfolio portfolio) {
        super(portfolio);
        decorators = new ArrayList<FrameDecorator>();
        valuesPanel.removeAll();
        valuesPanel.setSize(250, 250);
        valuesPanel.setLayout(new GridBagLayout());
        AddCheckBoxToPanel();
    }

    private void doneButtonActionPerformed(java.awt.event.ActionEvent evt) {                                           
        String selectedItem = availableStockComboBox.getSelectedItem().toString();
        // If the subject is changed, frame should be removed from the observer and frame should subscribe to new stock.
        String symbol = selectedItem.split(",")[0];
        decorators = new ArrayList<FrameDecorator>();
        
        //Remove all the prevoius decorators
               
        Stock stock = portfolio.getStock(symbol);
        stock.addObserver(this);
        FrameDecorator decorator = null;
        if(currentPriceCheckBox.isSelected()){
            decorator = new CurrentPriceDecorator();
            decorators.add(decorator);
        }
        
        if(openingPriceCheckBox.isSelected()){
            decorator = new OpeningPriceDecorator();
            decorators.add(decorator);
        }
        
        if(closingPriceCheckBox.isSelected()){
            decorator = new ClosingPriceDecorator();
            decorators.add(decorator);
        }
        
        if(askPriceCheckBox.isSelected()){
            decorator = new AskPriceDecorator();
            decorators.add(decorator);
        }
        
        if(statusCheckBox.isSelected()){
            decorator = new StatusDecorator();
            decorators.add(decorator);
        }

        if(bidPriceCheckBox.isSelected()){
            decorator = new BidPriceDecorator();
            decorators.add(decorator);
        }
        
        if(volumeCheckBox.isSelected()){
            decorator = new VolumePriceDecorator();
            decorators.add(decorator);
        }
        
        if(tenDayVolumeCheckBox.isSelected()){
            decorator = new TenDayVolumeDecorator();
            decorators.add(decorator);
        }
        
        if(lineChartCheckBox.isSelected()){
            ChartFrame chartFrame = new LineChartFrame();
            Thread thread = new Thread(chartFrame);
            thread.start();
            stock.addObserver(chartFrame);
        }
        
        if(barChartCheckBox.isSelected()){
            ChartFrame chartFrame = new BarChartFrame();
            Thread thread = new Thread(chartFrame);
            thread.start();
            stock.addObserver(chartFrame);
        }
        
        decoratePanel();
        valuesPanel.repaint();
        valuesPanel.revalidate();
    }                                          
    
    @Override
    public void update(Subject stock) {
        for(FrameDecorator decorator: decorators){
            decorator.update(stock);
        }
    }

    private void AddCheckBoxToPanel() {
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 0;
        c.ipadx = 30;
        c.ipady = 2;
        currentPriceCheckBox = new JCheckBox("Current Price");
        valuesPanel.add(currentPriceCheckBox, c);
        
        
        c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 1;
        c.gridy = 0;
        c.ipadx = 30;
        c.ipady = 2;
        openingPriceCheckBox = new JCheckBox("Opening Price");
        valuesPanel.add(openingPriceCheckBox, c);
        
        c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 2;
        c.gridy = 0;
        c.ipadx = 20;
        c.ipady = 2;
        closingPriceCheckBox = new JCheckBox("Closing Price");
        valuesPanel.add(closingPriceCheckBox, c);
        
        c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 1;
        c.ipadx = 30;
        c.ipady = 2;
        bidPriceCheckBox = new JCheckBox("Bid Price");
        valuesPanel.add(bidPriceCheckBox, c);
        
        c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 1;
        c.gridy = 1;
        c.ipadx = 30;
        c.ipady = 2;
        statusCheckBox = new JCheckBox("Status");
        valuesPanel.add(statusCheckBox, c);
        
        c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 2;
        c.gridy = 1;
        c.ipadx = 20;
        c.ipady = 2;
        askPriceCheckBox = new JCheckBox("Ask Price");
        valuesPanel.add(askPriceCheckBox, c);
        
        c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 2;
        c.ipadx = 30;
        c.ipady = 2;
        volumeCheckBox = new JCheckBox("Current Volume");
        valuesPanel.add(volumeCheckBox, c);
        
        c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 1;
        c.gridy = 2;
        c.ipadx = 30;
        c.ipady = 2;
        tenDayVolumeCheckBox = new JCheckBox("Ten Day Volume");
        valuesPanel.add(tenDayVolumeCheckBox, c);
        
        c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 2;
        c.gridy = 2;
        c.ipadx = 20;
        c.ipady = 2;
        lineChartCheckBox = new JCheckBox("Line Chart");
        valuesPanel.add(lineChartCheckBox, c);
        
        c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 3;
        c.ipadx = 30;
        c.ipady = 2;
        barChartCheckBox = new JCheckBox("Bar Chart");
        valuesPanel.add(barChartCheckBox, c);
        
        c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 5;
        c.gridx = 1;
        c.gridy = 3;
        c.ipadx = 30;
        c.ipady = 2;
        doneButton = new JButton("Done");
        valuesPanel.add(doneButton, c);
        doneButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                doneButtonActionPerformed(e);
            }
        } );


        valuesPanel.repaint();
        valuesPanel.revalidate();
    }

    private void decoratePanel() {
        for(FrameDecorator decorator: decorators){
            decorator.decorate(valuesPanel);
        }
    }
}