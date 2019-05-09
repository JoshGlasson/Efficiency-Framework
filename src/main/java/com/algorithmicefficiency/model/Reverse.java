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
    private String[] arraySize = {"5000", "10000", "15000", "20000", "25000", "30000","35000", "40000","45000", "50000","55000", "60000","65000", "70000", "75000", "80000", "85000", "90000","95000", "100000"};
    @Column(name = "timetaken", nullable = false)
    private String[] timeTaken = new String[arraySize.length];

//    public static void main(String[] args)
//    {
//        int [] arr = {10, 20, 30, 40, 50};
//        reverse(arr, arr.length);
//        System.out.println(reverse(arr, arr.length));
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
//        reverse(arr.toArray(), size);
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

//    static String reverse(Object[] a, int n) {
//        int[] b = new int[n];
//        int j = n;
//        for (int i = 0; i < n; i++) {
//            b[j - 1] = (int) a[i];
//            j = j - 1;
//        }
//
//        return  Arrays.toString(b);
//    }
}


