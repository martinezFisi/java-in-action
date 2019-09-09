/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ummsm.ocp.streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author LENOVO
 */
public class TradersAndTransactions {

    public static void main(String[] args) {
        List<Transaction> list = TransactionsFactory.getTransactionList();

        //1. Find all transactions in the year 2011 and sort them by value (small to high).
        findTransactionsOn2011AndOrderForValue(list);newLine();

        //2. What are all the unique cities where the traders work?
        uniqueCitiesWhereTradersWork(list);newLine();

        //3. Find all traders from Cambridge and sort them by name.
        findTradesOfCambridgeAndOrderForName(list);newLine();

        //4. Return a string of all traders’ names sorted alphabetically.
        getStringOfAllNamesTradersOrderAlphabetic(list);newLine();

        //5. Are any traders based in Milan?
        areAnyTradeBasedInMilan(list);newLine();

        //6. Print the values of all transactions from the traders living in Cambridge.
        valuesOfTransactionsOfTradersLivingInCambridge(list);newLine();

        //7. What’s the highest value of all the transactions?
        theHighestValueOfAllTheTransactions(list);newLine();
        
        //8. Find the transaction with the smallest value.
        findTransactionWithTheSmallestValue(list);
    }

    private static void findTransactionsOn2011AndOrderForValue(List<Transaction> list) {
        list.stream()
                .filter(t -> t.getYear() == 2011)
                .sorted(Comparator.comparing(Transaction::getValue))
                .forEach(System.out::println);
    }

    private static void uniqueCitiesWhereTradersWork(List<Transaction> list) {
        list.stream()
                .map(Transaction::getTrader)
                .map(Trader::getCity)
                .distinct()
                .forEach(System.out::println);
    }

    private static void findTradesOfCambridgeAndOrderForName(List<Transaction> list) {
        list.stream()
                .map(Transaction::getTrader)
                .distinct()
                .filter(t -> t.getCity().equals("Cambridge"))
                .sorted(Comparator.comparing(Trader::getName))
                .forEach(System.out::println);
    }

    private static void getStringOfAllNamesTradersOrderAlphabetic(List<Transaction> list) {
        String s = list.stream()
                .map(Transaction::getTrader)
                .map(Trader::getName)
                .distinct()
                .sorted()
                .reduce("", (s1, s2) -> s1.concat(" " + s2));

        System.out.println("String: " + s);
    }

    private static void areAnyTradeBasedInMilan(List<Transaction> list) {
        boolean areAnyTradeBasedInMilan = list.stream()
                .map(Transaction::getTrader)
                .anyMatch(t -> "Milan".equals(t.getCity()));

        System.out.println("areAnyTradeBasedInMilan? : " + areAnyTradeBasedInMilan);
    }

    private static void valuesOfTransactionsOfTradersLivingInCambridge(List<Transaction> list) {
        list.stream()
                .filter(t -> "Cambridge".equals(t.getTrader().getCity()))
                .map(Transaction::getValue)
                .forEach(System.out::println);
    }

    private static void theHighestValueOfAllTheTransactions(List<Transaction> list) {
        list.stream()
                .map(Transaction::getValue)
                .reduce(Integer::max)
                .ifPresent(System.out::println);
    }
    
    private static void findTransactionWithTheSmallestValue(List<Transaction> list){
        list.stream()
                .sorted(Comparator.comparing(Transaction::getValue))
                .findFirst()
                .ifPresent(System.out::println);
    }

    private static void newLine(){
        System.out.println("");
    }
}

class Trader {

    private final String name;
    private final String city;

    public Trader(String n, String c) {
        this.name = n;
        this.city = c;
    }

    public String getName() {
        return this.name;
    }

    public String getCity() {
        return this.city;
    }

    @Override
    public String toString() {
        return "Trader:" + this.name + " in " + this.city;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Trader) {
            Trader t = (Trader) obj;
            return this.hashCode() == t.hashCode();
        }
        return false;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.name);
        hash = 79 * hash + Objects.hashCode(this.city);
        return hash;
    }

}

class Transaction {

    private final Trader trader;
    private final int year;
    private final int value;

    public Transaction(Trader trader, int year, int value) {
        this.trader = trader;
        this.year = year;
        this.value = value;
    }

    public Trader getTrader() {
        return this.trader;
    }

    public int getYear() {
        return this.year;
    }

    public int getValue() {
        return this.value;
    }

    @Override
    public String toString() {
        return "{" + this.trader + ", "
                + "year: " + this.year + ", "
                + "value:" + this.value + "}";
    }
}

class TransactionsFactory {

    public static List<Transaction> getTransactionList() {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");
        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );
        return transactions;
    }

    
}
