package decorator;
import subject.Subject;
import javax.swing.Icon;
import javax.swing.ImageIcon;
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
public class StatusDecorator extends FrameDecorator {
    private int previousPrice;
    private Icon upIcon ;
    private Icon downIcon;
    JLabel test = new JLabel("Value");
    
    public StatusDecorator(){
        previousPrice = -1;
        upIcon = new ImageIcon("upIcon.jpg");
        downIcon = new ImageIcon("downIcon.jpg");
    }
    
    @Override
    public void decorate(JPanel panel) {
        super.decorate(panel, 8, 0, 2, "Status");
//        test = new JLabel("");
//
//        panel.add(test, c);
    }

    @Override
    public void update(Subject subject) {
//        Stock stock = (Stock) subject;
//        String prev = test.getText();
//        int currentPrice = stock.getCurrentPrice();
//        valueLabel.removeAll();
//        //currentPrice = previousPrice + 1;
//        Icon icon = (ImageIcon) upIcon;
//        if(prev != ""){
//            if(Integer.parseInt(prev) <= currentPrice){
//                valueLabel.setIcon(new ImageIcon("upIcon.jpg"));
//                try {
//                Thread.sleep(2000);
//            } catch (InterruptedException ex) {
//                Logger.getLogger(StatusDecorator.class.getName()).log(Level.SEVERE, null, ex);
//            }
//                
//            }else {
//                valueLabel.setIcon(new ImageIcon("downIcon.jpg"));
//                try {
//                Thread.sleep(2000);
//            } catch (InterruptedException ex) {
//                Logger.getLogger(StatusDecorator.class.getName()).log(Level.SEVERE, null, ex);
//               }
//            }
//        }
//        test.setText(Integer.toString(stock.getCurrentPrice()));
//        
//      
////        while(true){
////            valueLabel.setIcon(new ImageIcon("upIcon.jpg"));
////            try {
////                Thread.sleep(2000);
////            } catch (InterruptedException ex) {
////                Logger.getLogger(StatusDecorator.class.getName()).log(Level.SEVERE, null, ex);
////            }
////            valueLabel.setIcon(new ImageIcon("downIcon.jpg"));
////            try {
////                Thread.sleep(2000);
////            } catch (InterruptedException ex) {
////                Logger.getLogger(StatusDecorator.class.getName()).log(Level.SEVERE, null, ex);
////            }
////            
////        }
//        
////        valueLabel.updateUI();
////        valueLabel.repaint();
////        valueLabel.revalidate();
////        valueLabel.invalidate();
//        previousPrice = currentPrice;
//    }
    }
}