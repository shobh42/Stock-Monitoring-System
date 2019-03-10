package decorator;
import subject.Subject;
import subject.Stock;
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
        super.decorate(panel, 4, 0, 2, "Current Price");
    }

    @Override
    public void update(Subject subject) {
        Stock stock = (Stock) subject;
        valueLabel.setText(Integer.toString(stock.getCurrentPrice()));
    }
}
