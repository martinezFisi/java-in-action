/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ummsm.ocp.streams;

import java.util.List;

/**
 *
 * @author LENOVO
 */
public class MapOfMap {
    
    public static void main(String[] args) {
        List<Dish> list = DishFactory.getDishList();
        
        list.stream()
                .map(Dish::getName)
                .map(String::getBytes)
                .forEach(System.out::println);
    }
    
}
