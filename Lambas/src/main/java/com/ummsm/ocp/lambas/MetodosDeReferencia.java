/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ummsm.ocp.lambas;

import java.util.function.Consumer;

/**
 *
 * @author LENOVO
 */
public class MetodosDeReferencia {

    Persona p = new Persona();

    public static void main(String[] args) {
        //Metodo de Referencia a Metodo Estatico
        consumir(MetodosDeReferencia::saludar, "Antony");

        //Metodo de Referencia a Metodo de Instancia de un Objecto
        MetodosDeReferencia mr = new MetodosDeReferencia();
        System.out.println("Vieja edad: " + mr.p.edad);
        Consumer<Integer> c = mr::setearEdad;
        consumir(c, 20);
        System.out.println("Nueva edad: " + mr.p.edad);

        //Metodo de referencia a Metodo de Instancia de Clase
        MetodosDeReferencia mr2 = new MetodosDeReferencia();
        System.out.println("Vieja edad: " + mr2.p.edad);
        BiConsumer bc = MetodosDeReferencia::setearEdad;
        consumir(bc, mr2, 30);
        System.out.println("Nueva edad: " + mr2.p.edad);
    }

    static <T> void consumir(Consumer<T> c, T t) {
        c.accept(t);
    }
    
    static void consumir(BiConsumer bc, MetodosDeReferencia mr, Integer i) {
        bc.accept(mr, i);
    }
 

    static void saludar(String nombre) {
        System.out.println("Hola " + nombre);
    }

    void setearEdad(Integer edad) {
        p.edad = edad;
    }
}

class Persona {

    Integer edad = 0;
}


//Interface
interface BiConsumer{
    void accept(MetodosDeReferencia mr, Integer i);
}