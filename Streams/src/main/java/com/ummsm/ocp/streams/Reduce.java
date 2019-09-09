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
public class Reduce {
    
    public static void main(String[] args) {
        sum();
        concat();
        ageSum();
        countNumOfDishes();
    }
    
    private static void sum(){
        List<Integer> list = Arrays.asList(1, 2, 3, 4);
        
        int sum = list.stream()
                        .reduce(0, Integer::sum);
        
        System.out.println("sum: " + sum);
    }
    
    private static void concat(){
        List<String> list = Arrays.asList("Hola", " Mundo", " Java");
        
        String concat = list.stream()
                                .reduce("", (s1, s2) -> s1+s2);
        
        System.out.println(concat);
                
    } 
    
    private static void ageSum(){
        List<Person> list = Arrays.asList( new Person(20), new Person(25), new Person(30) );
        
        Person p = list.stream()
                            .reduce( new Person(0), (p1, p2) -> new Person(p1.getAge() + p2.getAge()) );
        
        System.out.println("Age sum: " + p.getAge());
    }
    
    private static void  countNumOfDishes(){
        List<Dish> list = DishFactory.getDishList();
        
        int numDishes = list.stream()
                                .map( d -> 1 )
                                .reduce(0, Integer::sum);
        
        System.out.println("numDishes = " + numDishes);
    }
    
}


class Person{
    private Integer age;

    public Person(Integer age) {
        this.age = age;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    
    
    
}
