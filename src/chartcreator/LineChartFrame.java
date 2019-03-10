package chartcreator;

import subject.Subject;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Shobhit
 */
public class LineChartFrame extends ChartFrame{
    
    public LineChartFrame(String title){
        super(new LineChartCreator(), title);
    }
}
