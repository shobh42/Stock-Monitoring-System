/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import decorator.AskPriceDecorator;
import decorator.BidPriceDecorator;
import decorator.ClosingPriceDecorator;
import decorator.CurrentPriceDecorator;
import decorator.FrameDecorator;
import decorator.OpeningPriceDecorator;
import decorator.StatusDecorator;
import decorator.TenDayVolumeDecorator;
import decorator.VolumePriceDecorator;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JCheckBox;

/**
 *
 * @author Shobhit
 */
public class DecoratorFactory {
    
    public static List<FrameDecorator> createDecorator(List<JCheckBox> checkBox) {
        
        List<FrameDecorator> decorator = new ArrayList<FrameDecorator>();
        for(JCheckBox box: checkBox){
            if(box.getText() == "Current Price" && box.isSelected()){
                decorator.add(new CurrentPriceDecorator());
            }
        
            if(box.getText() == "Opening Price" && box.isSelected()){
                decorator.add(new OpeningPriceDecorator());
            }
            
            if(box.getText() == "Closing Price" && box.isSelected()){
                decorator.add(new ClosingPriceDecorator());
            }
            
            if(box.getText() == "Ask Price" && box.isSelected()){
                decorator.add(new AskPriceDecorator());
            }
            
            if(box.getText() == "Status" && box.isSelected()){
                decorator.add(new StatusDecorator());
            }
            
            if(box.getText() == "Bid Price" && box.isSelected()){
                decorator.add(new BidPriceDecorator());
            }
            
            if(box.getText() == "Volume Price" && box.isSelected()){
                decorator.add(new VolumePriceDecorator());
            }
            
            if(box.getText() == "Ten Day Volume" && box.isSelected()){
                decorator.add(new TenDayVolumeDecorator());
            }
        }
        
        return decorator;
    }
}
