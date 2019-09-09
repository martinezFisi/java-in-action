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
public class FlatMap {
    
    public static void main(String[] args) {
        pairOfNumbersThatSumIsDivisibleFor3();
    }
    
    public static void testFlatMapping(){
        List<String> list = Arrays.asList("Hello", "Word");
        
        list.stream()
                .map( s -> s.split(""))
                .flatMap( Arrays::stream )//Convertimos los string en streams y con flat maps los juntamos en un solo stream
                .distinct()
                .forEach(System.out::println);
    }
    
    public static void square(){
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        
        list.stream()
                .map( d -> d*d )
                .forEach(System.out::println);
    }
    
    public static void pairOfNumbers(){
        List<Integer> list = Arrays.asList(1, 2, 3);
        List<Integer> list2 = Arrays.asList(3, 4);
        
        list.stream()
                .flatMap( i -> list2.stream()
                                        .map(j -> new int[]{i, j}) )
                .forEach( p -> System.out.println("(" + p[0] + ", " + p[1] + ")") );
    }
    
    public static void pairOfNumbersThatSumIsDivisibleFor3(){
        List<Integer> list = Arrays.asList(1, 2, 3);
        List<Integer> list2 = Arrays.asList(3, 4);
        
        list.stream()
                .flatMap( i -> list2.stream()
                                        .map(j -> new int[]{i, j}) )
                .filter( p -> (p[0] + p[1]) % 3 == 0 )
                .forEach( p -> System.out.println("(" + p[0] + ", " + p[1] + ")") );
    }
}
