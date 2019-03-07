
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
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
public class CustomObserverOne extends ObserverFrame{
    
    public CustomObserverOne(Portfolio portfolio){
        super(portfolio);
        valuesPanel.removeAll();
        valuesPanel.setSize(250, 250);
        valuesPanel.setLayout(new GridBagLayout());
        //valuesPanel.setBackground(Color.WHITE);
        
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 0;
        c.ipadx = 30;
        c.ipady = 2;
        valuesPanel.add(new JCheckBox("Current Price"), c);
        
        c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 1;
        c.gridy = 0;
        c.ipadx = 30;
        c.ipady = 2;
        valuesPanel.add(new JCheckBox("Opening Price"), c);
        
        c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 2;
        c.gridy = 0;
        c.ipadx = 20;
        c.ipady = 2;
        valuesPanel.add(new JCheckBox("Closing Price"), c);
        
        c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 1;
        c.ipadx = 30;
        c.ipady = 2;
        valuesPanel.add(new JCheckBox("Bid Price"), c);
        
        c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 1;
        c.gridy = 1;
        c.ipadx = 30;
        c.ipady = 2;
        valuesPanel.add(new JCheckBox("Status"), c);
        
        c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 2;
        c.gridy = 1;
        c.ipadx = 20;
        c.ipady = 2;
        valuesPanel.add(new JCheckBox("Ask Price"), c);
        
        c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 2;
        c.ipadx = 30;
        c.ipady = 2;
        valuesPanel.add(new JCheckBox("Current Volume"), c);
        
        c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 1;
        c.gridy = 2;
        c.ipadx = 30;
        c.ipady = 2;
        valuesPanel.add(new JCheckBox("Ten Day Volume"), c);
        
        c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 2;
        c.gridy = 2;
        c.ipadx = 20;
        c.ipady = 2;
        valuesPanel.add(new JCheckBox("Line Chart"), c);
        
        c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 3;
        c.ipadx = 30;
        c.ipady = 2;
        valuesPanel.add(new JCheckBox("Bar Chart"), c);
        
        c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 5;
        c.gridx = 1;
        c.gridy = 3;
        c.ipadx = 30;
        c.ipady = 2;
        valuesPanel.add(new JButton("Done"), c);
        
        c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 4;
        c.ipady = 2;
        valuesPanel.add(new JLabel("Current Price"), c);
        
        c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 1;
        c.gridy = 4;
        c.ipady = 2;
        valuesPanel.add(new JLabel("Current Price Value"), c);
        
        c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 5;
        c.ipady = 2;
        valuesPanel.add(new JLabel("Opening Price"), c);
        
        c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 1;
        c.gridy = 5;
        c.ipady = 2;
        valuesPanel.add(new JLabel("Opening Price Value"), c);
        
        c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 6;
        c.ipady = 2;
        valuesPanel.add(new JLabel("Closing Price"), c);
        
        c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 1;
        c.gridy = 6;
        c.ipady = 2;
        valuesPanel.add(new JLabel("Closing Price Value"), c);
        
        c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 7;
        c.ipady = 2;
        valuesPanel.add(new JLabel("Ask Price"), c);
        
        c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 1;
        c.gridy = 7;
        c.ipady = 2;
        valuesPanel.add(new JLabel("Ask Price Value"), c);
        
        c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 8;
        c.ipady = 2;
        valuesPanel.add(new JLabel("Status"), c);
        
        c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 1;
        c.gridy = 8;
        c.ipady = 2;
        valuesPanel.add(new JLabel("Status Value"), c);
        
        c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 9;
        c.ipady = 2;
        valuesPanel.add(new JLabel("Bid Price"), c);
        
        c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 1;
        c.gridy = 9;
        c.ipady = 2;
        valuesPanel.add(new JLabel("Bid Price Value"), c);
        
        c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 10;
        c.ipady = 2;
        valuesPanel.add(new JLabel("Volume Price"), c);
        
        c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 1;
        c.gridy = 10;
        c.ipady = 2;
        valuesPanel.add(new JLabel("Volume Price Value"), c);
        
        c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 11;
        c.ipady = 2;
        valuesPanel.add(new JLabel("Ten Day Volume"), c);
        
        c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 1;
        c.gridy = 11;
        c.ipady = 2;
        valuesPanel.add(new JLabel("Ten Day Volume Value"), c);
        
        valuesPanel.repaint();
        valuesPanel.revalidate();
    }
}