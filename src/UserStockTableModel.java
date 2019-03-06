/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.HashMap;
import java.util.Map;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Shobhit
 */
public class UserStockTableModel extends DefaultTableModel {
    private Map <String, Integer> rowMapping ;
    private int row = 0;
    private final  String[] columns = new String[] {
                "Stock", "Current","Status" ,"Bid", "Ask","Previous","Volume"
    };  
   
    public UserStockTableModel(){
        setColumnIdentifiers(columns);
        rowMapping = new HashMap<>(); 
    }
    
    public void updateRow(String symbol,int currentPrice,Icon status,int bidPrice,
            int askPice,int previousPrice ,int volume){
        addRow(new Object[]{symbol,currentPrice,status,bidPrice,
            askPice,previousPrice,volume}); 
        rowMapping.put(symbol, row++);
    }
    
    public int getRow(String symbol){
        return rowMapping.get(symbol);
    }
    
      @Override
            public Class<?> getColumnClass(int columnIndex) {
                return columnIndex == 2 ? ImageIcon.class : String.class;
            }
             public boolean isCellEditable(int row, int column){
                return false;//This causes all cells to be not editable
            }
        };


