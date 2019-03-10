package decorator;
import subject.Subject;
import observer.Observer;
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
public abstract class FrameDecorator implements Observer{
    protected final JLabel valueLabel = new JLabel("");
    protected final JLabel nameLabel = new JLabel();
    protected final GridBagConstraints c = new GridBagConstraints();
    
    
    public abstract void decorate(JPanel panel);
    
    protected void decorate(JPanel panel, int row, int col, int distanceY, String labelName){
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = col;
        c.gridy = row;
        c.ipady = distanceY;
        nameLabel.setText(labelName);
        panel.add(nameLabel, c);
        
        c.gridx = col + 1;
        c.gridy = row;
        c.ipady = distanceY;
        panel.add(valueLabel, c);
    }
    
    @Override
    public abstract void update(Subject stock);
    
    public void removeLabel(JPanel panel){
        panel.remove(valueLabel);
        panel.remove(nameLabel);
    }
}
