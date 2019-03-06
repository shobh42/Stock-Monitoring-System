
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
public class PanelDecorator extends JPanel{
    
    protected DecoratedPanel panel;
    
    public PanelDecorator(DecoratedPanel panel){
        this.panel = panel;
    }
    
    public DecoratedPanel decoratePanel(){
        return panel.decoratePanel();
    }
}
