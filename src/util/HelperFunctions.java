package util;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Shobhit
 */
public class HelperFunctions {
    public static String padRight(String s, int n) {
        return String.format("%1$-" + n + "s", s);
    }
}
