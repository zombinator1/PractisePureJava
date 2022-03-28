package com.example.simple;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MostOccurringString {

    private MostOccurringString() {
    }

    public static String find(List<String> listOfStrings) {
        Map<String, Integer> cache = new HashMap<>();
        int maxOccurrence = 0;
        String mostFrequentOccurredString = "";
        for (String str : listOfStrings) {
            Integer counter = cache.getOrDefault(str, 0);
            if (counter == 0) {
                cache.put(str, 1);
            } else {
                if (counter > maxOccurrence) {
                    maxOccurrence = counter;
                    mostFrequentOccurredString = str;
                    cache.put(str, ++counter);
                }
            }
        }
        return mostFrequentOccurredString;
    }
}
