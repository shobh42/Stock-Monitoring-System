package decorator;
import subject.Subject;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import subject.Stock;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Shobhit
 */
public class StatusDecorator extends FrameDecorator {
    private int previousPrice;
    private Icon upIcon ;
    private Icon downIcon;
            
    public StatusDecorator(){
        previousPrice = -1;
        upIcon = new ImageIcon("upIcon.jpg");
        downIcon = new ImageIcon("downIcon.jpg");
    }
    
    @Override
    public void decorate(JPanel panel) {
        super.decorate(panel, 8, 0, 2, "Status");
    }

    @Override
    public void update(Subject subject) {
        Stock stock = (Stock) subject;
        int currentPrice = stock.getCurrentPrice();
        Icon icon = upIcon;
        icon = currentPrice > previousPrice ? upIcon : downIcon;
        valueLabel.setIcon(icon);
        previousPrice = currentPrice;
    }
}
