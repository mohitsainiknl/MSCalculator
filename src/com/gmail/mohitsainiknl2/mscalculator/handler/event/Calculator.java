/*
 * Copyright (c) 2021 Mohit Saini, Under MIT License. Use is subject to license terms.
 * 
 */ 
package com.gmail.mohitsainiknl2.mscalculator.handler.event;

import java.math.BigDecimal;
import java.math.BigInteger;

import com.gmail.mohitsainiknl2.util.debug.Assertion;

public class Calculator {

    /**
     * 
     * @param NumOne
     * @param NumTwo
     * @param operator
     * @return
     */
    public static String calculate(BigInteger NumOne, BigInteger NumTwo, char operator) {
        String result = NumOne.toString();
        Assertion.throwMessage("NumOne = " + NumOne + ", NumTwo = " + NumTwo);
        Assertion.throwErrorMessage(new Throwable("\"" + operator + "\" Operator is NOT in Calculator!"));

        switch(operator) {
            case '+' : result = NumOne.add     (NumTwo).toString(); break;
            case '-' : result = NumOne.subtract(NumTwo).toString(); break;
            case '×' : result = NumOne.multiply(NumTwo).toString(); break;
            case '÷' : result = NumOne.divide  (NumTwo).toString(); break;
            case '=' : result = NumOne                  .toString(); break;
            default  : Assertion.throwErrorMessage(new Throwable("\"" + operator + "\" Operator is NOT in Calculator!"));
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
        String result = NumOne.toString();
        Assertion.throwMessage("NumOne = " + NumOne + ", NumTwo = " + NumTwo);

        switch(operator) {
            case '+' : result = NumOne.add     (NumTwo).toString(); break;
            case '-' : result = NumOne.subtract(NumTwo).toString(); break;
            case '×' : result = NumOne.multiply(NumTwo).toString(); break;
            case '÷' : result = NumOne.divide  (NumTwo).toString(); break;
            case '=' : result = NumOne                  .toString(); break;
            default  : Assertion.throwErrorMessage(new Throwable("\"" + operator + "\" Operator is NOT in Calculator!"));
        }
        return result;
    }

}
