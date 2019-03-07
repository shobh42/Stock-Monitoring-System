
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
public class BidPriceDecorator extends PanelDecorator {

    public BidPriceDecorator(DecoratedPanel panel, Subject subject){
        super(panel, subject);
    }
    
    @Override
    public DecoratedPanel decoratePanel() {
        panel = panel.decoratePanel();
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.VERTICAL;

        JLabel label = new JLabel("Button 2");
        label.setPreferredSize(new Dimension(100, 100));
        c.weightx = 0;
        c.fill = GridBagConstraints.VERTICAL;
        c.gridx = 0;
        c.gridy = 0;
        panel.add(label, c);
        return panel;
    }
}
