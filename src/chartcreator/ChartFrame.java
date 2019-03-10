package chartcreator;


import DatasetValues.AskPriceDatasetValue;
import DatasetValues.BidPriceDatasetValue;
import DatasetValues.ClosingPriceDatasetValue;
import DatasetValues.CurrentPriceDatasetValue;
import DatasetValues.DatasetValue;
import DatasetValues.OpeningPriceDatasetValue;
import DatasetValues.TenDayVolumeDatasetValue;
import DatasetValues.VolumePriceDatasetValue;
import observer.Observer;
import subject.Subject;
import subject.Stock;
import java.awt.BorderLayout;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Shobhit
 */
public class ChartFrame extends javax.swing.JFrame implements Runnable, Observer {

    private ChartCreator chartCreator;
    private DatasetValue currentDataset;
    private final Map<Integer, DatasetValue> datasetMapping;
    private int numberOfPoints = 10;
    
    public ChartFrame(ChartCreator chartCreator, String title){
        initComponents();
        this.chartCreator = chartCreator;
        datasetMapping = initailizeDatesetMapping();
        chartJPanel.setLayout(new BorderLayout());
        setVisible(true);
        setTitle(title);
    }

//    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        chartJPanel = new javax.swing.JPanel();
        priceOptionComboBox = new javax.swing.JComboBox();
        numberOfPointsTextField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        showButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        chartJPanel.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout chartJPanelLayout = new javax.swing.GroupLayout(chartJPanel);
        chartJPanel.setLayout(chartJPanelLayout);
        chartJPanelLayout.setHorizontalGroup(
            chartJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        chartJPanelLayout.setVerticalGroup(
            chartJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 268, Short.MAX_VALUE)
        );

        priceOptionComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Current Price","Opening Price", "Closing Price", "Ask Price", "Bid Price", "Volume Price", "Ten Day Volume"}));

        numberOfPointsTextField.setText("10");

        jLabel1.setText("Number of update");

        jLabel2.setText("Currently showing");

        showButton.setText("Show");
        showButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(chartJPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(numberOfPointsTextField))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(priceOptionComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(showButton, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(priceOptionComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(numberOfPointsTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)))
                    .addComponent(showButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chartJPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void showButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showButtonActionPerformed
        int index = priceOptionComboBox.getSelectedIndex();
        currentDataset = datasetMapping.get(index);
        try {  
            numberOfPoints = (int) Double.parseDouble(numberOfPointsTextField.getText());  
        } catch(NumberFormatException e){  
            JOptionPane.showMessageDialog(this, "Please enter a valid number.");  
        }  
    }//GEN-LAST:event_showButtonActionPerformed

    public void showChart(){
        if(currentDataset.getValues().size() == 0){
            return;
        }
        JFreeChart chart = chartCreator.createChart(currentDataset, numberOfPoints);
        ChartPanel chartPanel = new ChartPanel(chart);
        chartJPanel.removeAll();
        chartJPanel.updateUI();
        chartJPanel.add(BorderLayout.CENTER, chartPanel); 
        chartJPanel.repaint();
        //PanelUpdater.repaintPanel(chartJPanel);
    }

    @Override
    public void update(Subject subject) {
        Stock stock = (Stock)subject;
        datasetMapping.get(0).add(stock.getCurrentPrice());
        datasetMapping.get(1).add(stock.getOpeningPrice());
        datasetMapping.get(2).add(stock.getClosingPrice());
        datasetMapping.get(3).add(stock.getAskPrice());
        datasetMapping.get(4).add(stock.getBidPrice());
        datasetMapping.get(5).add(stock.getCurrentVolume());
        datasetMapping.get(6).add(stock.getTenDayVolume());
    }

    @Override
    public void run() {
        while(true){
            try {
                showChart();
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(ChartFrame.class.getName()).log(Level.SEVERE, null, ex);
            } 
        }
    }
    
    
    private Map<Integer, DatasetValue> initailizeDatesetMapping() {
        Map<Integer, DatasetValue> datasetMapping = new HashMap<>();
        datasetMapping.put(0, new CurrentPriceDatasetValue());
        datasetMapping.put(1, new OpeningPriceDatasetValue());
        datasetMapping.put(2, new ClosingPriceDatasetValue());
        datasetMapping.put(3, new AskPriceDatasetValue());
        datasetMapping.put(4, new BidPriceDatasetValue());
        datasetMapping.put(5, new VolumePriceDatasetValue());
        datasetMapping.put(6, new TenDayVolumeDatasetValue());
        currentDataset = datasetMapping.get(0);
        
        return datasetMapping;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel chartJPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField numberOfPointsTextField;
    private javax.swing.JComboBox priceOptionComboBox;
    private javax.swing.JButton showButton;
    // End of variables declaration//GEN-END:variables

}
