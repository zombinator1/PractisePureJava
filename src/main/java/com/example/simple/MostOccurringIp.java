package com.example.simple;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MostOccurringIp {

    private MostOccurringIp() {
    }

    public static List<String> find(List<Request> requestList, Integer threshold) {
        LocalDateTime rateStart = LocalDateTime.now().minusSeconds(5);
        LocalDateTime rateEnd = LocalDateTime.now().plusSeconds(5);
        return requestList.stream()
                .filter(request -> request.timestamp().isAfter(rateStart) && request.timestamp().isBefore(rateEnd))
                .collect(Collectors.groupingBy(Request::ip))
                .entrySet()
                .stream()
                .filter(e -> e.getValue().size() >= threshold)
                .map(Map.Entry::getKey)
                .toList();
    }
}

record Request(String ip, LocalDateTime timestamp, String body) {

}