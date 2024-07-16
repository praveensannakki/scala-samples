package com.java.practice;

import java.util.*;
import java.util.stream.Collectors;

public class OccurrenceAndSort {

    public static void main(String[] args) {
        findOccurrenceAndSort("This is a sample sentence to test and this sentence can be anything");
    }

    public static void findOccurrenceAndSort(String s) {
        Map<String, Integer> occurrenceCount = new HashMap<>();

        Arrays.asList(s.split(" ")).forEach(word -> {
            if (occurrenceCount.containsKey(word)) {
                occurrenceCount.put(word, occurrenceCount.get(word) + 1);
            } else {
                occurrenceCount.put(word, 1);
            }
            //occurrenceCount.put(word, occurrenceCount.getOrDefault(word, 0) + 1);
        });


       LinkedHashMap<String, Integer> sortedMap =
               occurrenceCount.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (a, b) -> a,
                        LinkedHashMap:: new
                    ));
//                .entrySet()
//                .stream()
//                .forEach( element -> {
//                    System.out.println(element.getKey() + " : " + element.getValue());
//                });

        System.out.println(sortedMap);
    }
}
