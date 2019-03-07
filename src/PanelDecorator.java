
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
public class PanelDecorator extends DecoratedPanel{
    
    protected DecoratedPanel panel;
    protected Subject subject;
    protected JLabel valueLabel;
    
    public PanelDecorator(DecoratedPanel panel, Subject subject){
        this.panel = panel;
        this.subject = subject;
        valueLabel = new JLabel("");
    }
    
    public DecoratedPanel decoratePanel(){
        return panel.decoratePanel();
    }
}
