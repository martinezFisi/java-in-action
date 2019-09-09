/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ummsm.ocp.prettyprintapples;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LENOVO
 */
public class App {
    
    public static void prettyPrintApple(List<Apple> inventory, PrintApplePredicate p) {
        for(Apple apple: inventory) {
            String output = p.printApple(apple);
            System.out.println(output);
        }
    }
    
    public static void main(String[] args) {
        List<Apple> list = new ArrayList<>();
        list.add( new Apple(Color.GREEN, 200) );
        list.add( new Apple(Color.GREEN, 100) );
        list.add( new Apple(Color.GREEN, 50) );
        list.add( new Apple(Color.RED, 80) );
        
        //Parametrizacion de funcionalidad, sin lambdas
        prettyPrintApple(list, new PrintIsWeightApple());
        prettyPrintApple(list, new PrintWeightApple());
        //Con lambdas
        prettyPrintApple(list, a -> a.getColor().toString());
        //Con clase anonima
        prettyPrintApple(list, new PrintApplePredicate() {
            @Override
            public String printApple(Apple apple) {
                return apple.toString();
            }
        });
    }
    
}

//Functional interface, only one abstract method
interface PrintApplePredicate{
    String printApple(Apple apple);
}

class PrintWeightApple implements PrintApplePredicate{
    @Override
    public String printApple(Apple apple) {
        return apple.getWeight().toString();
    }
}

class PrintIsWeightApple implements PrintApplePredicate{
    @Override
    public String printApple(Apple apple) {
        return apple.getWeight() > 100 ? "Pesada" : "Ligera";
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
    GREEN, RED
}