package main.java.pasksoftware.assigment1;

public class InvalidTransaction extends RuntimeException {



    public InvalidTransaction( String singleTransaction) {
        String message =
                " this transaction is invalid, maybe not every value is inserted, one of the value is less than 0 or net + tax is not equal to gross";
       System.out.println("["+singleTransaction+"]" +message);

    }
}
