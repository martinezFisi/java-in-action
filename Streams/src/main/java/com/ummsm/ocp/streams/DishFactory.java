/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ummsm.ocp.streams;

import java.util.Arrays;
import java.util.List;

/**
 *
 * @author LENOVO
 */
public class DishFactory {

    private DishFactory() {
    }
    
    public static List<Dish> getDishList(){
        return Arrays.asList( new Dish("KFC", 220),
                              new Dish("Pizza", 150),
                              new Dish("Donnuts", 170),
                              new Dish("Chocoton", 300),
                              new Dish("Hot Dog", 250));
    }
    
}
