
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
public class StatusDecorator extends PanelDecorator {

    public StatusDecorator(DecoratedPanel panel){
        super(panel);
    }
    
    @Override
    public DecoratedPanel decoratePanel() {
        panel.add((new JLabel("Status : ")));
        panel.add((new JLabel("")));
        return panel;
    }
}