package com.algorithmicefficiency.model;

import lombok.Data;
import org.thymeleaf.util.ArrayUtils;

import javax.persistence.*;
import java.math.BigDecimal;
import java.math.MathContext;
import java.sql.Array;
import java.util.*;

import static java.util.Map.Entry.comparingByValue;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import static java.util.stream.Collectors.*;
import static java.util.Map.Entry.*;

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

//    public static void main(String[] args)
//    {
//        ArrayList<Integer> arr = new ArrayList<>();
//        arr.add(4);
//        arr.add(3);
//        arr.add(1);
//        arr.add(1);
//        arr.add(2);
//        arr.add(2);
//        arr.add(3);
//        arr.add(3);
//        arr.add(2);
//
//        Collections.sort(arr);
//        System.out.println(arr);
//        System.out.println(frequency(arr));
//    }

    public Frequency() {

    }

    public void start() {
        for (int i = 0; i < this.arraySize.length; i++)
            this.timeTaken[i] = Double.toString(this.run(Integer.parseInt(this.arraySize[i])));
    }

    // Setting size of array to test
    public Double run(int size) {

        // Array Set Up
        ArrayList<Integer> arr = new ArrayList<>();

        for (int x = 1; x <= size; x++) {
            Random randomNum = new Random();
            arr.add(randomNum.nextInt(size));
        }

        // Timing of Actual Function
        Collections.sort(arr);
        long start = System.nanoTime();
        frequency(arr);
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

//    static Object frequency(ArrayList<Integer> array) {
//        ArrayList b = new ArrayList();
//        Map<Integer,Integer> map = new HashMap<>();
//        for(int i=0; i < array.size(); i++) {
//            Integer count = map.get(array.get(i));
//            map.put(array.get(i), count == null ? 1 : count + 1);
//        }
//        for(int j=1; j <= map.size(); j++) {
//            if(map.values().toArray()[j-1].equals(Collections.max(map.values()))) {
//                b.add(map.keySet().toArray()[j-1]);
//            }
//        }
//        return b;
//    }

//    static Object frequency(ArrayList<Integer> array, int n) {
//        ArrayList b = new ArrayList();
//        Map<Integer,Integer> map = new HashMap<>();
//        for(int i=0; i < n-1; i++) {
//            System.out.println("Start" + i);
//            System.out.println(array);
//            if (array.size() == 0) {
//                System.out.println("END");
//                if (map.containsValue(Collections.max(map.values()))){
//                    System.out.println(map.containsValue(Collections.max(map.values())));
//                    System.out.println(b);
//
//                }
//            } else {
//                Integer count = map.get(array.get(i));
//                if (array.size() != 1) {
//                    System.out.println(array.size());
//                    if (map.containsKey(array.get(i)) || array.get(i).equals(array.get(i + 1))) {
//                        System.out.println(array.get(i));
//                        System.out.println(array.get(i + 1));
//                        map.put(array.get(i), count == null ? 1 : count + 1);
//                        array.remove(i);
//                        i--;
//                        System.out.println("Added");
//                        System.out.println(map);
//                    } else {
//                        array.remove(i);
//                        i--;
//                        System.out.println("-1");
//                    }
//                    System.out.println("End" + i);
//                } else {
//                    System.out.println("Hi");
//                    if (map.containsKey(array.get(i))) {
//                        System.out.println("Hello");
//                        map.put(array.get(i), count == null ? 1 : count + 1);
//                        array.remove(i);
//                        System.out.println(map);
//                    } else {
//                        System.out.println("No");
//                        array.remove(i);
//                    }
//                }
//            }
//        }
//        return map;
//    }

    static Object frequency(ArrayList<Integer> array) {
        ArrayList c = new ArrayList();
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0; i < array.size(); i++) {
            Integer count = map.get(array.get(i));
            map.put(array.get(i), count == null ? 1 : count + 1);
        }
        Map<Integer, Integer> sorted = map
                    .entrySet()
                    .stream()
                    .sorted(comparingByValue())
                    .collect(
                            toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2,
                                    LinkedHashMap::new));
        while(sorted.containsValue(Collections.max(map.values()))) {

            c.add(Arrays.asList(sorted.keySet().toArray()).get(sorted.size()-1));
            sorted.remove(c.get(c.size()-1));
        }
        return c;
    }


}
