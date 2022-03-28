package com.example.simple;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SimpleTests {

    @Test
    void calculateRealTaxTest() {
        // given
        List<String> strings = List.of("80,20,100", "60,40,100", "30,70,100");

        // when
        BigDecimal realTax = SimpleTaxParser.calculateRealTax(strings);

        // then
        assertEquals(new BigDecimal(43), realTax);
    }

    @Test
    void mostOccurringStringTest() {
        // given
        List<String> strings = List.of("a", "c", "a", "b", "b", "c", "a", "d");

        // when
        String actual = MostOccurringString.find(strings);

        // then
        assertEquals("a", actual);
    }

    @Test
    void findMostOccurringIP() {
        // given
        List<Request> requestList = List.of(
                generateRequest("213.136.252.151", 1),
                generateRequest("213.136.252.154", -1),
                generateRequest("213.136.252.154", 2),
                generateRequest("213.136.252.154", 3),
                generateRequest("213.136.252.151", -2),
                generateRequest("213.136.252.151", 4),
                generateRequest("213.136.252.153", 6),
                generateRequest("213.136.252.154", 4),
                generateRequest("213.136.252.151", -4),
                generateRequest("213.136.252.155", -2),
                generateRequest("213.136.252.152", -2),
                generateRequest("213.136.252.152", -3),
                generateRequest("213.136.252.153", 4),
                generateRequest("213.136.252.153", -4)
        );
        // when
        List<String> ips = MostOccurringIp.find(requestList, 3);
        // then
        assertEquals(List.of("213.136.252.151", "213.136.252.154"), ips);
    }

    Request generateRequest(String ip, Integer seconds) {
        return new Request(ip, LocalDateTime.now().plusSeconds(seconds), "");
    }
}