/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ummsm.ocp.streams;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import static java.util.stream.Collectors.toList;

/**
 *
 * @author LENOVO
 */
public class DebuggingStreams {
    
    public static void main(String[] args) {
        List<Dish> list = DishFactory.getDishList();
        
        System.out.println(list);
        System.out.println("");
        
        Predicate<Dish> p = d -> { 
            System.out.println("Filtering: " + d.getName());
            return d.getCalories() < 300;
        };
        
        list = list.stream()
                .filter( p )
                .limit(3)
                .collect(toList());
        
        System.out.println("");
        System.out.println(list);
    }
    
}
