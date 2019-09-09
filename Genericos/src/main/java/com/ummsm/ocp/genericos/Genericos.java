/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ummsm.ocp.genericos;

import com.sun.javafx.scene.control.skin.VirtualFlow;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LENOVO
 */
public class Genericos {
    
    public static void recorrerLista(){
        List list = new ArrayList();
        list.add("Hola");
        list.add(5);
        
        list.forEach( o -> {
                            Integer i = (Integer) o; } 
                    );
    }
    
    public static void main(String[] args) {
        createListAndGetFirstElement();
    }
    
    //asignar StringList A ObjectList, Spoiler: No se puede
    public static void asignarStringListAObjectList(){
        List<String> stringList = new ArrayList<>();
        stringList.add("Java");
        
        //List<Object> objectList = stringList; //no compila
        List<?> objectList = stringList;
        String s = (String)objectList.get(0);
        
        //Integer i = (Integer)objectList.get(0); //java.lang.ClassCastException
        
        System.out.println(s);
    }
    
    public static void asignarStringArrayAObjectArray(){
        String[] stringArray = new String[]{"Java", "Spring"};
        
        Object[] objectArray = stringArray;
        
        Integer i = (Integer)objectArray[0];
    }
    
    public static void genericoUnbounded(){
        List<String> list = new ArrayList<>();
        list.add("Java");
        
        List<Integer> list2 = new ArrayList<>();
        list2.add(5);
        
        List<?> list3 = list;
        list3 = list2;
    }
    
    public static void genericoUpperBounded(){
        List<? extends Number> list;        
        
        List<String> stringList = new ArrayList<>();
        List<Integer> integerList = new ArrayList<>();
        List<Number> numberList = new ArrayList<>();
        
        //list = stringList; //no compila, tipos incompatibles
        list = integerList;
        list = numberList;
        
        Number num = list.get(0);
        Integer i = (Integer) list.get(0);
        
    }
    
    public static void genericoLowerBounded(){
        List<? super Integer> list;
        
        List<String> stringList = new ArrayList<>();
        List<Integer> integerList = new ArrayList<>();
        List<Number> numberList = new ArrayList<>();
        List<Object> objectList = new ArrayList<>();
        
        //list = stringList; //no compila, String no es padre de Integer
        list = integerList;
        list = numberList;
        list = objectList;
        
        Object o = list.get(0);
        Integer i = (Integer) list.get(0);
    }
    
    public static void addElementToUnboundedGeneric(List<?> list){
        //list.add("Java"); //no compila, list es inmutable
    }
    
    public static void addElementToUpperBoundedGeneric(List<? extends Number> list){
        //list.add(new Integer(5)); //no compila, list es inmutable
    }
    
    public static void addElementToLowerBoundedGeneric(){
        List<? super IOException> list = new ArrayList<Exception>();
        //list.add( new Exception() ); 
    }
    
    public static void addElementToObject(List<Object> list){
        list.add("Java");
    }
    
    //*************
    
    public static void createListAndGetFirstElement(){
        List<Number> list = new ArrayList<>();
        list.add( new Integer("25") );
        list.add( new Double("10") );
        Number n = getElementFromList(list);
        System.out.println(list);
    }
    
    public static <T> T getElementFromList(List<? extends T> list){
        List<Integer> integerList = new ArrayList<>();
        List<Number> numberList = new ArrayList<>();
        
        //list = integerList; //no compila xq en tiempo de compilacion el T no se conoce
        
        return list.get(0);
    }
    
    public static <T> T getANumber(List<? extends T> list){
        return list.get(0);
    }
    
    public static <T> T getANumber2(List<? super T> list){
        return (T) list.get(0);//cast Object to T
    }
    
    public static void getANumber3(List<? extends Number> list){
        Number n = list.get(0);
        Integer i = (Integer) list.get(0);
    }
    
    void method4(List<? super Integer> list) {
    }
}
