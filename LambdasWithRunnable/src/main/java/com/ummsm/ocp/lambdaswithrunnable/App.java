/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ummsm.ocp.lambdaswithrunnable;

import java.util.function.Consumer;

/**
 *
 * @author LENOVO
 */
public class App {
    
    public static void main(String[] args) {
        Thread t = new Thread( () -> System.out.println("Hola mundo") );
        Thread t2 = new Thread( () -> System.out.println("Hola mundo2") );
        Thread t3 = new Thread( () -> System.out.println("Hola mundo3") );
        
        t.run();
        t2.run();
        t3.run();
        
        System.out.println("");
        
        lamdasCapturandoVariables();
    }
    
    static void lamdasCapturandoVariables(){
        int edad = 0;//variables locales deben ser final o efectivamente final
        Consumer<Integer> c = e -> System.out.println(edad);
        
        ejecutarConsumers(edad, c);
        
        Persona p = Persona.crearPersona("Antony");//No hay restriccion
        Consumer<String> c2 = s -> System.out.println(p.nombre);
        
        p.nombre = "Miguel";
        ejecutarConsumers(p.nombre, c2);
        
    }
    
    static <T> void ejecutarConsumers(T t ,Consumer<T> c){
        c.accept(t);
    }
    
}

class Persona{
    public String nombre;
    
    private Persona(){}
    
    public static Persona crearPersona(String nombre){
        Persona p = new Persona();
        p.nombre = nombre;
        return p;
    }
}