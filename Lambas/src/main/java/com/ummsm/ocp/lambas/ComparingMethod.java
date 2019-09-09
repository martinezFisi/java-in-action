/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ummsm.ocp.lambas;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

/**
 *
 * @author LENOVO
 */
public class ComparingMethod {
 
    
    public static void main(String[] args) {
        final List<Fruit> list = Arrays.asList(new Fruit("Apple", 20),
                                         new Fruit("Orange", 10),
                                         new Fruit("Banana", 15));
        
        //Function<Fruit, String> f = fruit -> fruit.getName();
        Function<Fruit, String> f = Fruit::getName;
        
        list.sort( Comparator.comparing( f ) );
        list.stream().forEach(System.out::println);
        
        System.out.println("");
        
        list.sort( Comparator.comparing( Fruit::getWeight ) );
        list.stream().forEach(System.out::println);
    }
 
}


class Fruit{

    private String name;
    private Integer weight;

    public Fruit(String name, Integer weight) {
        this.name = name;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Fruit{" + "name=" + name + ", weight=" + weight + '}';
    }
    
}
