package main.java.pasksoftware.assigment3;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/*
Assignment 3
        Having the list of Request objects find IP addresses that send more than X requests in a time window of 10 seconds.
*/
//213.136.252.151


public class Assigment3Main {

    public static void main(String[] args) {

        LocalDateTime windowOpeningTime = LocalDateTime.now();
        int X = 2;

        List<Request> requestList = new ArrayList<>();
//Example list of requests. Requests are genereted in a random momenenst in time. Now it 20 second.

        System.out.println(LocalTime.now());
        requestList.add(new Request("213.136.252.151", Assigment3Main.randomTimeGenerator(20)));
        requestList.add(new Request("213.136.252.151", Assigment3Main.randomTimeGenerator(20)));
        requestList.add(new Request("213.136.252.152", Assigment3Main.randomTimeGenerator(20)));
        requestList.add(new Request("213.136.252.152", Assigment3Main.randomTimeGenerator(20)));
        requestList.add(new Request("213.136.252.152", Assigment3Main.randomTimeGenerator(20)));
        requestList.add(new Request("213.136.252.153", Assigment3Main.randomTimeGenerator(20)));
        requestList.add(new Request("213.136.252.153", Assigment3Main.randomTimeGenerator(20)));
        requestList.add(new Request("213.136.252.153", Assigment3Main.randomTimeGenerator(20)));
        requestList.add(new Request("213.136.252.153", Assigment3Main.randomTimeGenerator(20)));
        requestList.add(new Request("213.136.252.154", Assigment3Main.randomTimeGenerator(20)));
        requestList.add(new Request("213.136.252.161", Assigment3Main.randomTimeGenerator(20)));
        requestList.add(new Request("213.136.252.161", Assigment3Main.randomTimeGenerator(20)));
        requestList.add(new Request("213.136.252.161", Assigment3Main.randomTimeGenerator(20)));
        requestList.add(new Request("213.136.252.162", Assigment3Main.randomTimeGenerator(20)));
        requestList.add(new Request("213.136.252.162", Assigment3Main.randomTimeGenerator(20)));
        requestList.add(new Request("213.136.252.169", Assigment3Main.randomTimeGenerator(20)));
        requestList.add(new Request("213.136.252.169", Assigment3Main.randomTimeGenerator(20)));
        requestList.add(new Request("213.136.252.169", Assigment3Main.randomTimeGenerator(20)));
        requestList.add(new Request("213.136.252.169", Assigment3Main.randomTimeGenerator(20)));
        requestList.add(new Request("213.136.252.169", Assigment3Main.randomTimeGenerator(20)));
        for (Request r : requestList) {
            System.out.println(r);
        }
        //I take requests only from the defined window, limited by
        System.out.println("List of IPs that send requests more often than" + X + " times in 10 seconds");
        System.out.println(
                mostOccuringIPsIn10seconds(requestList, windowOpeningTime, X));
    }

    public static LocalDateTime randomTimeGenerator(int timePeriod) {
        LocalDateTime time = LocalDateTime.now();
        long secondsToAdd = (long) Math.floor(Math.random() * timePeriod);
        time = time.plusSeconds(secondsToAdd);
        return time;
    }

    public static List<String> mostOccuringIPsIn10seconds(List<Request> requestList, LocalDateTime windowOpeningTime, int X) {
        //request which appear in a stated period of tim
        long timeWindowSpanSeconds = 10; //10 seconds
        ArrayList<Request> requestInTheWindow = new ArrayList<>();
        for (Request request : requestList) {
            if (request.timestamp.isAfter(windowOpeningTime)
                    && request.timestamp.isBefore(windowOpeningTime.plusSeconds(timeWindowSpanSeconds))) {
                requestInTheWindow.add(request);
            }
        }

        return requestInTheWindow.stream().collect(Collectors.
                        groupingBy(Request::getIp, Collectors.counting())).
                entrySet().stream().filter(e -> e.getValue() > X).map(Map.Entry::getKey).toList();


    }


}//class
