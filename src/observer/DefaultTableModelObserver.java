package observer;

import java.util.HashMap;
import java.util.Map;
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
public class DefaultTableModelObserver extends DefaultTableModel implements Observer {

    private Icon upIcon;
    private Icon downIcon;
    private Icon idleIcon;
    private Map<String, Integer> stockRowMapping;

    public DefaultTableModelObserver() {
        upIcon = new ImageIcon("upIcon.jpg");
        downIcon = new ImageIcon("downIcon.jpg");
        idleIcon = new ImageIcon("idleIcon.jpg");
        stockRowMapping = new HashMap<>();
    }

    @Override
    public void update(Subject stock) {
        Stock s = (Stock) stock;
        int rowNumber = stockRowMapping.get(s.getSymbol());
        String previousPrice = getValueAt(rowNumber, 1).toString();
        Icon icon = idleIcon;
        if (previousPrice != "") {
            int previousPriceValue = Integer.parseInt(previousPrice);
            int currentPrice = s.getCurrentPrice();
            icon = previousPriceValue == currentPrice ? idleIcon : 
                    currentPrice > previousPriceValue ? upIcon : downIcon;
        }
        
        setValueAt(s.getCurrentPrice(), rowNumber, 1);
        setValueAt(s.getOpeningPrice(), rowNumber, 2);
        setValueAt(s.getClosingPrice(), rowNumber, 3);
        setValueAt(s.getAskPrice(), rowNumber, 4);
        setValueAt(icon, rowNumber, 5);
        setValueAt(s.getBidPrice(), rowNumber, 6);
        setValueAt(s.getCurrentVolume(), rowNumber, 7);
        setValueAt(s.getTenDayVolume(), rowNumber, 8);
        this.fireTableDataChanged();
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return columnIndex == 5 ? ImageIcon.class : String.class;
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        return false;//This causes all cells to be not editable
    }

    public void addToMapping(String stockName, int row) {
        stockRowMapping.put(stockName, row);
    }
}
