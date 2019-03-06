
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
public class CurrentPriceDecorator extends PanelDecorator {

    public CurrentPriceDecorator(DecoratedPanel panel){
        super(panel);
    }
    
    @Override
    public DecoratedPanel decoratePanel() {
        panel = panel.decoratePanel();
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.VERTICAL;

        JLabel label = new JLabel("Button 1");
        label.setPreferredSize(new Dimension(100, 100));
        c.weightx = 0;
        c.fill = GridBagConstraints.VERTICAL;
        c.gridx = 0;
        c.gridy = 0;
        panel.add(label, c);
        return panel;
    }
}
