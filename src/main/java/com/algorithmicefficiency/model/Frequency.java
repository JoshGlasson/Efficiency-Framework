package com.algorithmicefficiency.model;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.math.MathContext;
import java.util.*;

@Data
@Entity
@Table(name = "FREQUENCY")
public class Frequency {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "arraysize", nullable = false)
    private String[] arraySize = {"50000", "100000", "150000", "200000", "250000", "300000","350000", "400000", "450000", "500000", "550000", "600000","650000", "700000", "750000", "800000", "850000", "900000","950000", "1000000"};
    @Column(name = "timetaken", nullable = false)
    private String[] timeTaken = new String[arraySize.length];

    public static void main(String[] args)
    {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(3);
        arr.add(1);
        arr.add(1);
        arr.add(1);
        arr.add(3);
        arr.add(3);
        arr.add(2);
        System.out.println(frequency(arr));
    }

    public Frequency() {

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
//        frequency(arr);
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

//    static String duplicates(Object[] array) {
//        ArrayList b = new ArrayList();
//        for (int i = 0; i < array.length; i++)
//            for (int k = i+1; k < array.length; k++)
//                if(array[k] == array[i]) {
//                    if(!b.contains(array[k])) {
//                        b.add(array[k]);
//                    }
//                }
//    return Arrays.toString(b.toArray());
//    }

    static Object frequency(ArrayList<Integer> array) {
        ArrayList b = new ArrayList();
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0; i < array.size(); i++) {
            Integer count = map.get(array.get(i));
            map.put(array.get(i), count == null ? 1 : count + 1);
        }
        for(int j=1; j <= map.size(); j++) {
            if(map.values().toArray()[j-1].equals(Collections.max(map.values()))) {
                b.add(map.keySet().toArray()[j-1]);
            }
        }
        return b;
    }

}


