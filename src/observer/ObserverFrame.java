package observer;


import util.Portfolio;
import subject.Subject;
import subject.Stock;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Shobhit
 */
public class ObserverFrame extends javax.swing.JFrame implements Observer{

    protected Portfolio portfolio;
    protected Subject previousSubject;
    /**
     * Creates new form ObserverFrame
     */
    public ObserverFrame(Portfolio portfolio) {
        initComponents();
        this.portfolio = portfolio;
        addAvailableStocksInComboBox();
        setResizable(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        availableStockComboBox = new javax.swing.JComboBox();
        valuesPanel = new javax.swing.JPanel();
        currentPriceLabel = new javax.swing.JLabel();
        currentPriceValueLabel = new javax.swing.JLabel();
        openingPriceLabel = new javax.swing.JLabel();
        closingPriceLabel = new javax.swing.JLabel();
        askPriceLabel = new javax.swing.JLabel();
        bidPriceLabel = new javax.swing.JLabel();
        volumePriceLabel = new javax.swing.JLabel();
        tenDayVolumeLabel = new javax.swing.JLabel();
        openingPriceValueLabel = new javax.swing.JLabel();
        closingPriceValueLabel = new javax.swing.JLabel();
        askPriceValueLabel = new javax.swing.JLabel();
        bidPriceValueLabel = new javax.swing.JLabel();
        volumePriceValueLabel = new javax.swing.JLabel();
        tenDayVolumeValueLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Observer");

        availableStockComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                availableStockComboBoxItemStateChanged(evt);
            }
        });

        currentPriceLabel.setText("Current Price :");

        currentPriceValueLabel.setText("Current Price Value");

        openingPriceLabel.setText("Opening Price :");

        closingPriceLabel.setText("Closing Price :");

        askPriceLabel.setText("Ask Price :");

        bidPriceLabel.setText("Bid Price :");

        volumePriceLabel.setText("Volume :");

        tenDayVolumeLabel.setText("Ten Day Volume :");

        openingPriceValueLabel.setText("Opening Price Value");

        closingPriceValueLabel.setText("Closing Price Value");

        askPriceValueLabel.setText("Ask Price");

        bidPriceValueLabel.setText("Bid Price Value");

        volumePriceValueLabel.setText("Volume Price Value");

        tenDayVolumeValueLabel.setText("Ten Day Volume Value");

        javax.swing.GroupLayout valuesPanelLayout = new javax.swing.GroupLayout(valuesPanel);
        valuesPanel.setLayout(valuesPanelLayout);
        valuesPanelLayout.setHorizontalGroup(
            valuesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(valuesPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(valuesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(valuesPanelLayout.createSequentialGroup()
                        .addComponent(closingPriceLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(closingPriceValueLabel))
                    .addGroup(valuesPanelLayout.createSequentialGroup()
                        .addComponent(askPriceLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(askPriceValueLabel))
                    .addGroup(valuesPanelLayout.createSequentialGroup()
                        .addComponent(bidPriceLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bidPriceValueLabel))
                    .addGroup(valuesPanelLayout.createSequentialGroup()
                        .addComponent(volumePriceLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(volumePriceValueLabel))
                    .addGroup(valuesPanelLayout.createSequentialGroup()
                        .addComponent(tenDayVolumeLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tenDayVolumeValueLabel))
                    .addGroup(valuesPanelLayout.createSequentialGroup()
                        .addGroup(valuesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(currentPriceLabel)
                            .addComponent(openingPriceLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(valuesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(openingPriceValueLabel)
                            .addComponent(currentPriceValueLabel))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        valuesPanelLayout.setVerticalGroup(
            valuesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(valuesPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(valuesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(currentPriceLabel)
                    .addComponent(currentPriceValueLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(valuesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(openingPriceLabel)
                    .addComponent(openingPriceValueLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(valuesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(closingPriceLabel)
                    .addComponent(closingPriceValueLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(valuesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(askPriceLabel)
                    .addComponent(askPriceValueLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(valuesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bidPriceLabel)
                    .addComponent(bidPriceValueLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(valuesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(volumePriceLabel)
                    .addComponent(volumePriceValueLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(valuesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tenDayVolumeLabel)
                    .addComponent(tenDayVolumeValueLabel))
                .addContainerGap(102, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(valuesPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(availableStockComboBox, 0, 388, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(availableStockComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(valuesPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void availableStockComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_availableStockComboBoxItemStateChanged
        String selectedItem = availableStockComboBox.getSelectedItem().toString();
        // If the subject is changed, frame should be removed from the observer and frame should subscribe to new stock.
        if(previousSubject != null){
            previousSubject.removeObserver(this);
        }
        
        String symbol = selectedItem.split(",")[0];
        Stock stock = portfolio.getStock(symbol);
        stock.addObserver(this);
        previousSubject = stock;
    }//GEN-LAST:event_availableStockComboBoxItemStateChanged

    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel askPriceLabel;
    private javax.swing.JLabel askPriceValueLabel;
    protected javax.swing.JComboBox availableStockComboBox;
    private javax.swing.JLabel bidPriceLabel;
    private javax.swing.JLabel bidPriceValueLabel;
    private javax.swing.JLabel closingPriceLabel;
    private javax.swing.JLabel closingPriceValueLabel;
    private javax.swing.JLabel currentPriceLabel;
    private javax.swing.JLabel currentPriceValueLabel;
    private javax.swing.JLabel openingPriceLabel;
    private javax.swing.JLabel openingPriceValueLabel;
    private javax.swing.JLabel tenDayVolumeLabel;
    private javax.swing.JLabel tenDayVolumeValueLabel;
    protected javax.swing.JPanel valuesPanel;
    private javax.swing.JLabel volumePriceLabel;
    private javax.swing.JLabel volumePriceValueLabel;
    // End of variables declaration//GEN-END:variables

    @Override
    public void update(Subject subject) {
        Stock stock = (Stock)subject;
        currentPriceValueLabel.setText(Integer.toString(stock.getCurrentPrice()));
        openingPriceValueLabel.setText(Integer.toString(stock.getOpeningPrice()));
        closingPriceValueLabel.setText(Integer.toString(stock.getClosingPrice()));
        bidPriceValueLabel.setText(Integer.toString(stock.getBidPrice()));
        askPriceValueLabel.setText(Integer.toString(stock.getAskPrice()));
        volumePriceValueLabel.setText(Integer.toString(stock.getCurrentVolume()));
        tenDayVolumeValueLabel.setText(Integer.toString(stock.getTenDayVolume()));
    }

    private void addAvailableStocksInComboBox() {
        Set<String> symbols = portfolio.getSymbols();
        for(String symbol : symbols){
            Stock stock = portfolio.getStock(symbol);
            availableStockComboBox.addItem(symbol + ", " + stock.getCompanyName());
        }
    }
}