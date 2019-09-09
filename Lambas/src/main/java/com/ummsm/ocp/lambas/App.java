/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ummsm.ocp.lambas;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 *
 * @author LENOVO
 */
public class App {
    
    public static void main(String[] args) {
        Nada n = () -> {};
        Nada n2 = () -> {return;};
        
        Consumer c = a -> {};
        Consumer c2 = (a) -> {return;};
        Consumer<String> c3 = (a) -> {return;};
        Consumer<String> c4 = (a) -> {System.out.println(a.toString());return;};
        Consumer<String> c5 = (a) -> System.out.println("");
        
        Function<String, String> f = s -> "";
        Function<String, String> f2 = (s) -> "Hola mundo";
        
        System.out.println("");
        
        ordernarUnaLista();
        
        System.out.println("");
        
        metodosDeReferencia();
        
        System.out.println("");
        
        //TriFunction<RGB, Integer, Integer, Integer> tf = (r, g, b) -> new RGB(r, g, b);
        TriFunction<RGB, Integer, Integer, Integer> tf = RGB::new;
        tf.apply( 255, 255, 255);
    }
 
    static <T,K,Z> T hola(T p, K p2, Z p3){
        return p;
    }
    
    static void ordernarUnaLista(){
        List<Manzana> list = Arrays.asList( new Manzana(200, "Azul"), 
                                            new Manzana(100, "Rojo"),
                                            new Manzana(300, "Amarillo"),
                                            new Manzana(400, "Verde") );
        list.sort( (m1, m2) -> m1.compareTo(m2) );
        System.out.println(list);
    }
    
    static void metodosDeReferencia(){
        Consumer<String> c = System.out::println;
        Nada nada = App::ordernarUnaLista;
        
        c.accept("Hola metodos de referencia");
    }
}

class Manzana implements Comparable<Manzana>{
    int peso;
    String color;

    public Manzana(int peso, String color) {
        this.peso = peso;
        this.color = color;
    }

    @Override
    public int compareTo(Manzana m) {
        return this.peso < m.peso ? -1 : ( this.peso == m.peso ? 0 : 1 );
    }

    @Override
    public String toString() {
        return "Manzana{" + "peso=" + peso + ", color=" + color + '}';
    }
    
    
    
}

@FunctionalInterface
interface Nada{
    void hacerNada();
}

@FunctionalInterface
interface TriFunction<T, K, N, V>{
    T apply(K k, N n, V v);
} 

class RGB{
    RGB(int r, int g, int b){
        System.out.println("r= " + r + " g= " + g + " b= " + b);
    }
}
