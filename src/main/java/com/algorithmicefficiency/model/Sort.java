package com.algorithmicefficiency.model;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.Arrays;
import java.util.Random;


import javax.persistence.*;

import lombok.Data;

@Data
@Entity
@Table(name = "SORT")
public class Sort{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "arraysize", nullable = false)
    private int arraySize;
    @Column(name = "timetaken", nullable = false)
    private Double timeTaken;

    private Sort() {};

    // Setting size of array to test
    public Sort(String arraySize) {
        if (arraySize != null) {
            this.arraySize = Integer.parseInt(arraySize);

            // Array Set Up
            int[] arr = new int[this.arraySize];

            for (int x = 1; x <= this.arraySize; x++) {
                for (int i = 0; i < arr.length; i++) {
                    Random randomNum = new Random();
                    arr[i] = randomNum.nextInt(this.arraySize);
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
            this.timeTaken = rounded/1000000;
            System.out.println("Time Elapsed: " + this.timeTaken);
        }
    }

    public int getArraySize() {
        return this.arraySize;
    }

    public Double getTimeTaken() {
        return this.timeTaken;
    }

    public void setArraySize(int arraySize) {
        this.arraySize = arraySize;
    }

}
