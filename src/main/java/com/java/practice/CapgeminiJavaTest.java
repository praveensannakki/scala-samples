package com.java.practice;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.*;

public class CapgeminiJavaTest {

    public static void main(String[] args) {
        System.out.println("Hello Java");

        String [] names = new String[] {"Praveen","Devika","Iris", "Hucchi"};

        Stream.of(names);

        List<String> nameList = Arrays.asList(names);

        nameList.stream().forEach(name -> System.out.println(name));

        Stream.of(names[0], names[1], names[2]);

        Stream.Builder<String> nameStreamBuilder = Stream.builder();

        nameStreamBuilder.add(names[0]);
        nameStreamBuilder.accept(names[1]);

        Stream<String> namesStream = nameStreamBuilder.build();

        System.out.println(namesStream.collect(Collectors.joining(",")).toLowerCase().toString());

        List<String> filteredList = Stream.of(names)
                .map(s-> s.substring(0,s.length()))
                .filter(n -> n!=null)
                .filter(n -> n!="Hucchi")
                .collect(Collectors.toList());

        filteredList.stream().forEach(System.out::println);

        Stream.of(names).toArray();

        System.out.println(filteredList.stream().filter(n-> n!="Praveen").findFirst());

        //sorting on streams
        Stream.of(names)
                .sorted((n1,n2) -> n1.compareTo(n2))
                .collect(Collectors.toList())
                .forEach(System.out::println);

        //distinct
        List<Integer> intList = Arrays.asList(2, 5, 3, 2, 4, 3);
        List<Integer> distinctIntList = intList.stream().distinct().collect(Collectors.toList());

        //allMatch,anyMatch,noneMatch examples
        boolean allEven = intList.stream().allMatch(i -> i % 2 == 0);
        boolean oneEven = intList.stream().anyMatch(i -> i % 2 == 0);
        boolean noneMultipleOfThree = intList.stream().noneMatch(i -> i % 3 == 0);

        IntStream.of(1, 2, 3);
        IntStream.range(10, 20);

        Stream.of(1, 2, 3); //This returns a Stream<Integer> and not IntStream.


        Integer maxNumber = intList.stream()
                .mapToInt(i -> i+1)
                //.peek(System.out::println)
                .max()
                .orElseThrow(NoSuchElementException::new);

        System.out.println(maxNumber);

        System.out.println(intList.stream().mapToInt(n ->n+1).average().orElseThrow(NoSuchElementException::new));









    }
}
