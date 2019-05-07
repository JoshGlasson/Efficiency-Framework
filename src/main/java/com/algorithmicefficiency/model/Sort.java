package com.algorithmicefficiency.model;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.Arrays;
import java.util.Random;

public class Sort {

    // Setting size of array to test
    static int arraySize = 1000;

    public static void main(String[] args)
    {
        // Array Set Up
        int[] arr = new int[arraySize];

        for (int x = 1; x <= arraySize; x++) {
            for(int i = 0; i < arr.length; i++) {
                Random randomNum = new Random();
                arr[i] = randomNum.nextInt(arraySize);

            }
        }

        // Timing of Actual Function
        System.out.println("Start");
        long start = System.nanoTime();

        Arrays.sort(arr);

        long finish = System.nanoTime();
        long timeElapsed = finish - start;

        // Round to milliseconds
        BigDecimal bd = new BigDecimal(timeElapsed);
        bd = bd.round(new MathContext(3));
        double rounded = bd.doubleValue();

        // Print results
        System.out.printf("Modified arr[] : %s", Arrays.toString(arr));
        System.out.println(" ");
        System.out.println("Time Elapsed: "+ rounded/1000000 + " Milliseconds");
    }
}
