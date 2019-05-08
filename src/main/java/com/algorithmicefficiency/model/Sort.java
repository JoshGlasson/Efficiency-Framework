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
@Table(name = "SORT")
public class Sort{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "arraysize", nullable = false)
    private String[] arraySize = {"10", "50", "100", "250", "500", "1000", "2000", "3000", "4000", "5000", "6000", "7000", "8000", "9000", "10000"};
    @Column(name = "timetaken", nullable = false)
    private String[] timeTaken = new String[arraySize.length];

    public Sort() {

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
            Collections.sort(arr);
            long finish = System.nanoTime();
            long timeElapsed = finish - start;

            // Round to milliseconds
            BigDecimal bd = new BigDecimal(timeElapsed);
            bd = bd.round(new MathContext(3));
            double rounded = bd.doubleValue();

        return rounded / 1000000;

    }


}
