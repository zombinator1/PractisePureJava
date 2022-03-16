package main.java.pasksoftware.assigment1;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

//Assignment 1
//       From the list of strings in format “net, tax, gross” calculate the overall percentage of taxes included in the final price.
public class Assigment1 {

    public static void main(String[] args) {

        List<String> listOfTransactions = List.of("69 31 100","900 100 1000","800 200 1000");
        BigDecimal tax = calculateTax(listOfTransactions);
        System.out.println(tax + "%");

    }

    public static BigDecimal calculateTax(List<String> listOfTransactions) {
        ArrayList<BigDecimal> net = new ArrayList<>();
        ArrayList<BigDecimal> gross = new ArrayList<>();
        int columnForNet = 0;
        int columnForTax = 1;
        int columnForGross = 2;
        for (String singleTransaction : listOfTransactions) {
            String[] splittedArray = singleTransaction.split("\\s+");
            if (!isTransactionRight(splittedArray, columnForNet, columnForTax, columnForGross)) {
                throw new InvalidTransaction(singleTransaction);
            } else {
                net.add(new BigDecimal(splittedArray[columnForTax]));
                gross.add(new BigDecimal(splittedArray[columnForGross]));
            }
        }

        BigDecimal netSum = (net.stream().
                reduce(BigDecimal.ZERO, BigDecimal::add));
        BigDecimal grosSum = (gross.stream().
                reduce(BigDecimal.ZERO, BigDecimal::add));

        return netSum.divide(grosSum, 5, RoundingMode.HALF_UP).multiply(new BigDecimal(100));
    }

    public static boolean isTransactionRight(String[] splitedArray, int columnForNet, int columnForTax, int columnForGross) {
        if (splitedArray.length < 3) {
            return false;
        }
        for (int i = 0; i < splitedArray.length; i++) {
            if (splitedArray[i] == null || splitedArray[i].equals("null")) {
                return false;  //nulls are not acceptable
            }
        }
        // net + tax == gros ?
        if (new BigDecimal(splitedArray[columnForNet]).add(new BigDecimal(splitedArray[columnForTax])).
                compareTo(new BigDecimal(splitedArray[columnForGross])) != 0) {
            return false;
        }

        for (int i = 0; i < splitedArray.length; i++) {
            BigDecimal number = new BigDecimal(splitedArray[i]);
            // 0 tax is acceptable, net and gros mustn't equal to 0
            if (number.compareTo(new BigDecimal(0)) == 0 && i != columnForTax) {
                return false;
                //values cannot be less than 0
            } else if (number.compareTo(new BigDecimal(0)) == -1) {
                return false;
            }
        }
        return true;
    }


}
