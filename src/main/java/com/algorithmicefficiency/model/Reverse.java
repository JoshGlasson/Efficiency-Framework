package com.algorithmicefficiency.model;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.math.MathContext;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

@Data
@Entity
@Table(name = "REVERSE")
public class Reverse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "arraysize", nullable = false)
    private String[] arraySize = {"50000", "100000", "150000", "200000", "250000", "300000","350000", "400000", "450000", "500000", "550000", "600000","650000", "700000", "750000", "800000", "850000", "900000","950000", "1000000"};
    @Column(name = "timetaken", nullable = false)
    private String[] timeTaken = new String[arraySize.length];

//    public static void main(String[] args)
//    {
//        ArrayList arr = new ArrayList();
//        arr.add(10);
//        arr.add(20);
//        arr.add(30);
//        arr.add(40);
//        arr.add(50);
//        arr.add(60);
//        arr.add(70);
//        System.out.println(reverse(arr, arr.size()));
//    }

    public Reverse() {

    }

    public void start() {
        for (int i = 0; i < this.arraySize.length; i++)
            this.timeTaken[i] = Double.toString(this.run(Integer.parseInt(this.arraySize[i])));
    }

    // Setting size of array to test
    public Double run(int size) {

        // Array Set Up
        ArrayList arr = new ArrayList();

        for (int x = 1; x <= size; x++) {
            Random randomNum = new Random();
            arr.add(randomNum.nextInt(size));
        }

        // Timing of Actual Function
        long start = System.nanoTime();
//        reverse(arr, arr.size());
        Collections.reverse(arr);
        long finish = System.nanoTime();
        long timeElapsed = finish - start;

        // Round to milliseconds
        BigDecimal bd = new BigDecimal(timeElapsed);
        bd = bd.round(new MathContext(3));
        double rounded = bd.doubleValue();

//        // Print results
//        System.out.printf("Modified arr[] : %s", Arrays.toString(arr));
//        System.out.println(" ");
//        System.out.println("Time Elapsed: " + rounded/1000000 + " Milliseconds");

        return rounded / 1000000;

    }

//    static Object reverse(ArrayList a) {
//        ArrayList b = new ArrayList();
//
//        for (int i = 1; i <= a.size()/2; i++) {
//            b.add(b.size()-1, a.get(i));
//        }
//
//        return b;
//    }


//
//    static Object reverse(ArrayList a, int n) {
//        for (int i = 0; i <= n; i++) {
//            a.add(i, a.get(n-1));
//            a.remove(n);
//        }
//        return a;
//    }


}


