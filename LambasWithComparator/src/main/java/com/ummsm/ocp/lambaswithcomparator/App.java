/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ummsm.ocp.lambaswithcomparator;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author LENOVO
 */
public class App {
    
    public static void main(String[] args) {
        List<Apple> list = Arrays.asList( new Apple(Color.GREEN, 200),
                                          new Apple(Color.RED, 150),
                                          new Apple(Color.YELLOW, 100) );
        
        list.sort( (Apple a1, Apple a2) ->  a1.getWeight().compareTo(a2.getWeight()) );
        
        System.out.println(list);
        
    }
    
}

class Apple{
    private Color color;
    private Float weight;

    public Apple(Color color, float weight) {
        this.color = color;
        this.weight = weight;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Apple{" + "color=" + color + ", weight=" + weight + '}';
    }
    

}

enum Color{
    GREEN, RED, YELLOW
}
