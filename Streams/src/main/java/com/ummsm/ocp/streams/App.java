/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ummsm.ocp.streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import static java.util.stream.Collectors.toList;

/**
 *
 * @author LENOVO
 */
public class App {
    
    public static void main(String[] args) {
        
        List<Dish> list = DishFactory.getDishList();
        
        List<String> names = 
                list.stream()
                .filter( d -> d.getCalories() < 200 )
                .sorted( Comparator.comparing(Dish::getCalories).reversed() )
                .map( Dish::getName )
                .collect(toList());
        
        System.out.println(names);
    }
    
}


class Dish{
    String name;
    double calories;

    public Dish(String name, double calories) {
        this.name = name;
        this.calories = calories;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCalories() {
        return calories;
    }

    public void setCalories(double calories) {
        this.calories = calories;
    }

    @Override
    public String toString() {
        return "Dish{" + "name=" + name + ", calories=" + calories + '}';
    }
    
    
    
}