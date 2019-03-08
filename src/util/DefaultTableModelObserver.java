package util;


import observer.Observer;
import subject.Subject;
import subject.Stock;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Shobhit
 */
public class DefaultTableModelObserver extends DefaultTableModel implements Observer{

    private Icon upIcon ;
    private Icon downIcon;
    
    public DefaultTableModelObserver(){
        upIcon = new ImageIcon("upIcon.jpg");
        downIcon = new ImageIcon("downIcon.jpg");
    }
    
    @Override
    public void update(Subject stock) {
        Stock s = (Stock) stock;
        for(int i = 0; i < getRowCount(); i++){
            String currentRowSymbol = getValueAt(i, 0).toString();
            if(s.getSymbol().equalsIgnoreCase(currentRowSymbol)){
                String previousPrice = getValueAt(i, 1).toString();
                Icon icon = upIcon;
                if(previousPrice != ""){
                    icon = Integer.parseInt(previousPrice) < s.getCurrentPrice() ?
                        upIcon : downIcon;
                }
                
                setValueAt(s.getCurrentPrice(), i, 1);
                setValueAt(s.getOpeningPrice(), i, 2);
                setValueAt(s.getClosingPrice(), i, 3);
                setValueAt(s.getAskPrice(), i, 4);
                setValueAt(icon, i, 5);
                setValueAt(s.getBidPrice(), i, 6);
                setValueAt(s.getCurrentVolume(), i, 7);
                setValueAt(s.getTenDayVolume(), i, 8);
                this.fireTableDataChanged();
                break;
            }
        }
    }
    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return columnIndex == 5 ? ImageIcon.class : String.class;
    }
    
    @Override
    public boolean isCellEditable(int row, int column){
        return false;//This causes all cells to be not editable
    }
}
