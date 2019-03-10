/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DatasetValues;

import java.util.List;

/**
 *
 * @author Shobhit
 */
public abstract class DatasetValue {
    
    protected List<Integer> values;
    
    public void add(Integer value){
        values.add(value);
    }
    
    public List<Integer> getValues(){
        return values;
    }
}
