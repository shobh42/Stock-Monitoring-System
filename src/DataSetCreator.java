
import java.util.List;
import org.jfree.data.category.DefaultCategoryDataset;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Shobhit
 */
public class DataSetCreator {
    
    public DefaultCategoryDataset createDataset(List<Integer> points){
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        String series1 = "";
        if(points.size()<=10){
            for(int i= 0  ;i<points.size();i++){
                int number = points.get(i);
                dataset.addValue(number, series1, ""+i);
            }
        }else{
            for(int i= points.size()-10  ;i<points.size();i++){
                int number = points.get(i);
                dataset.addValue(number, series1, " "+i);
            }
        } 
        
        return dataset;
    }
}
