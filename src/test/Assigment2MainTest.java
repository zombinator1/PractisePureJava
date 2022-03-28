package test;


import main.java.pasksoftware.assigment2.Assigment2Main;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.List;

@RunWith(Parameterized.class)
class Assigment2MainTest {

    private String expected = "zombek";
    private List<String> listOfStrings = List.of("zombek", "zombek", "zombek", "zombek", "a", "a", "a", "zyla", "zyla to smiec", "zombek huj", "IT", "IT", "IT");

    @Test
    public void mostOccurring() {
        Assertions.assertEquals(expected, Assigment2Main.mostOccurring(listOfStrings));
    }
}