package main.java.pasksoftware.assigment2;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Assigment2Main {

//    Assignment 2
//    Having a list of strings, find the most frequently occurring string in the list.

    public static void main(String[] args) {
        List<String> listOfStrings = List.of("a", "a", "a", "zyla", "zyla to smiec", "zombek huj", "IT", "IT", "IT");
        System.out.println(mostOccurring(listOfStrings));
    }

    public static String mostOccurring(List<String> listOfStrings) {
        if (listOfStrings.isEmpty()) {
            return "the list is empty";
        }

    return listOfStrings.stream().collect(Collectors.
            groupingBy(Function.identity(), Collectors.counting())).
            entrySet().stream().max(new MaxComparator()).orElse(null).getKey();
    }
}
