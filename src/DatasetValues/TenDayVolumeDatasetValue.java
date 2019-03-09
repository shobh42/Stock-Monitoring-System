/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DatasetValues;

import java.util.ArrayList;

/**
 *
 * @author Shobhit
 */
public class TenDayVolumeDatasetValue extends DatasetValue {

    public TenDayVolumeDatasetValue(){
        values = new ArrayList<Integer>();
    }
    
    @Override
    public String toString(){
        return "Ten Day Volumne";
    }
}
