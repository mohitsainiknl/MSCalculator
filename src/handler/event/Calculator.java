/*
 * Copyright (c) 2021 Mohit Saini, Under MIT License. Use is subject to license terms.
 * 
 */
package handler.event;

import java.math.BigDecimal;
import java.math.BigInteger;

public class Calculator {

    /**
     * 
     * @param NumOne
     * @param NumTwo
     * @param operator
     * @return
     */
    public static String calculate(BigInteger NumOne, BigInteger NumTwo, char operator) {
        String result = "0";
        System.out.print("NumOne = " + NumOne);
        System.out.println(", NumTwo = " + NumTwo);
        switch(operator) {
            case '+' : result = NumOne.add     (NumTwo).toString(); break;
            case '-' : result = NumOne.subtract(NumTwo).toString(); break;
            case '×' : result = NumOne.multiply(NumTwo).toString(); break;
            case '÷' : result = NumOne.divide  (NumTwo).toString(); break;
            case '=' : result = NumOne                  .toString(); break;
            default  : System.out.println("Operator is NOT in Calculator!");
        }
        return result;
    }

    /**
     * 
     * @param NumOne
     * @param NumTwo
     * @param operator
     * @return
     */
    public static String calculate(BigDecimal NumOne, BigDecimal NumTwo, char operator) {
        String result = "0";
        System.out.print("NumOne = " + NumOne);
        System.out.println(", NumTwo = " + NumTwo);
        switch(operator) {
            case '+' : result = NumOne.add     (NumTwo).toString(); break;
            case '-' : result = NumOne.subtract(NumTwo).toString(); break;
            case '×' : result = NumOne.multiply(NumTwo).toString(); break;
            case '÷' : result = NumOne.divide  (NumTwo).toString(); break;
            case '=' : result = NumOne                  .toString(); break;
            default  : System.out.println("Operator is NOT in Calculator!");
        }
        return result;
    }
}
