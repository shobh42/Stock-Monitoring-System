package decorator;
import subject.Subject;
import subject.Stock;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
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
public class CurrentPriceDecorator extends FrameDecorator{

    @Override
    public void decorate(JPanel panel) {
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 4;
        c.ipady = 2;
        nameLabel.setText("Current Price");
        panel.add(nameLabel, c);
        
        c.gridx = 1;
        c.gridy = 4;
        panel.add(valueLabel, c);
    }

    @Override
    public void update(Subject subject) {
        Stock stock = (Stock) subject;
        valueLabel.setText(Integer.toString(stock.getCurrentPrice()));
    }
}
