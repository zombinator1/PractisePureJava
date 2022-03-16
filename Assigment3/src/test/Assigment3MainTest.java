package test;

import main.java.pasksoftware.assigment3.Request;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static main.java.pasksoftware.assigment3.Assigment3Main.mostOccuringIPsInAStatedPeriodOfTime;
import static org.junit.jupiter.api.Assertions.*;

@RunWith(Parameterized.class)
class Assigment3MainTest {

    private long timeWindowSpanSeconds;
    private LocalDateTime windowOpeningTime;
    private int X;
    private List<Request> requestList = new ArrayList<>();
    private List<String> expectedList;

    @Test
    void findMostOccuringIP2() {

        windowOpeningTime = LocalDateTime.now();
        timeWindowSpanSeconds = 10; //seconds
        X = 1; //more requests in a stated time than X

        expectedList = List.of("213.136.252.151", "213.136.252.152", "213.136.252.153");
        //                                  IP                  time of request
        //requests generated before the opening of the window
        requestList.add(new Request("213.136.252.159", LocalDateTime.now().minusSeconds(1)));
        requestList.add(new Request("213.136.252.159", LocalDateTime.now().minusSeconds(1)));
        requestList.add(new Request("213.136.252.159", LocalDateTime.now().minusSeconds(1)));
        requestList.add(new Request("213.136.252.159", LocalDateTime.now().minusSeconds(2)));
        requestList.add(new Request("213.136.252.159", LocalDateTime.now().minusSeconds(2)));
        requestList.add(new Request("213.136.252.159", LocalDateTime.now().minusSeconds(2)));
        //request inside the window
        //3x151
        requestList.add(new Request("213.136.252.151", LocalDateTime.now().plusSeconds(1)));
        requestList.add(new Request("213.136.252.151", LocalDateTime.now().plusSeconds(1)));
        requestList.add(new Request("213.136.252.151", LocalDateTime.now().plusSeconds(5)));
        //2x152
        requestList.add(new Request("213.136.252.152", LocalDateTime.now().plusSeconds(5)));
        requestList.add(new Request("213.136.252.152", LocalDateTime.now().plusSeconds(7)));
        //2x153
        requestList.add(new Request("213.136.252.153", LocalDateTime.now().plusSeconds(8)));
        requestList.add(new Request("213.136.252.153", LocalDateTime.now().plusSeconds(9)));
        //4x154
        requestList.add(new Request("213.136.252.154", LocalDateTime.now().plusSeconds(15)));
        requestList.add(new Request("213.136.252.154", LocalDateTime.now().plusSeconds(15)));
        requestList.add(new Request("213.136.252.154", LocalDateTime.now().plusSeconds(15)));
        requestList.add(new Request("213.136.252.154", LocalDateTime.now().plusSeconds(19)));
        //1x155
        requestList.add(new Request("213.136.252.155", LocalDateTime.now().plusSeconds(19)));


        System.out.println("List of IPs that send more than " + X + " requests in " + timeWindowSpanSeconds + " seconds");
        List<String> result = mostOccuringIPsInAStatedPeriodOfTime(requestList, windowOpeningTime, timeWindowSpanSeconds, X);

        assertEquals(expectedList, result);


    }

}