package test;

import main.java.pasksoftware.assigment1.Assigment1;
import main.java.pasksoftware.assigment1.InvalidTransaction;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

//Now you can use also parametrized tests, as you mentioned in your comment
@RunWith(Parameterized.class)
class Assigment1Test {

    private List<String> listOfTransactions = List.of("69 31 100", "69 31      100");
    private BigDecimal expectedValue = new BigDecimal(31).setScale(5, RoundingMode.HALF_UP);
    //List for the seecond test
    private List<String> invalidListOfTransactions = List.of("70 31 100");

    @Parameterized.Parameters
    public static Collection parameters{

        List<List<String>> list = new ArrayList<>();
        list.add(List.of("69 31 100", "69 31      100"));
        list.add(List.of("69 31 100", "69 31 100"));
        list.add(List.of("69 31 100", "69 31      100"));
        list.add(List.of("69 31 100", "69 31      100"));
        list.add(List.of("69 31 100", "69 31      100"));



        return new Arrays.asList(new Object[] []{3,   });
    @Test
    void calculateRealTax() {
        assertEquals(expectedValue, Assigment1.calculateTax(listOfTransactions));

    }

    @Test
    void calculateRealTaxExceptionTest() {
        assertThrows(InvalidTransaction.class, () -> Assigment1.calculateTax(invalidListOfTransactions));


    }


}