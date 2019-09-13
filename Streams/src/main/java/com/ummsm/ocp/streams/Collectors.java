/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ummsm.ocp.streams;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import static java.util.stream.Collectors.*;

/**
 *
 * @author LENOVO
 */
public class Collectors {

    public static void main(final String[] args) {
        final List<Dish> list = DishFactory.getDishList();
        
        countDishes(list);
        findMostCaloriesDish(list);
        findLessCaloriesDish(list);
    }

    //Collectors than reduce to single value
    private static void countDishes(final List<Dish> list) {
        final long dishesCount = list.stream()
                                    .collect(counting());
        System.out.println("dishesCount: " + dishesCount);
    }
    
    private static void findMostCaloriesDish(final List<Dish> list) {
        final Optional<Dish> mostCaloriesDish = list.stream()
                                    .collect(maxBy(Comparator.comparing(Dish::getCalories)));
        System.out.println("most dish calories: " + mostCaloriesDish.get());
    }
    
    private static void findLessCaloriesDish(final List<Dish> list){
        final Optional<Dish> lessCaloriesDish = list.stream()
                                    .collect(minBy(Comparator.comparing(Dish::getCalories)));
        System.out.println("less dish calories: " + lessCaloriesDish.get());
    }

}
