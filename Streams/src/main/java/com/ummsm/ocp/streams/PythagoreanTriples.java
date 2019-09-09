/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ummsm.ocp.streams;

import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 *
 * @author LENOVO
 */
public class PythagoreanTriples {

    public static void main(String[] args) {
        new PythagoreanTriples().printTriplesUntil(5);
    }

    private void printTriplesUntil(int limit) {
        IntStream.rangeClosed(1, 100)
                .boxed()
                .flatMap(this::getTriplesFrom)
                .limit(limit)
                .forEach(this::printTriple);
    }

    private Stream<int[]> getTriplesFrom(int a) {
        return IntStream.rangeClosed(a, 100)
                .boxed()
                .filter(b -> Math.sqrt(a * a + b * b) % 1 == 0)
                .map(b -> new int[]{a, b, (int) Math.sqrt(a * a + b * b)});
    }

    private void printTriple(int t[]) {
        System.out.println(t[0] + ", " + t[1] + ", " + t[2]);
    }

}
