/*
 * Copyright (c) 2021 Mohit Saini, Under MIT License. Use is subject to license terms.
 * 
 */ 
package mscalculator.handler.event;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;

import com.gmail.mohitsainiknl2.util.debug.Assertion;

/**
 * Calculator class is the core class of MSCalculator, which actually perform the
 * arithmetic operations.
 */
public class Calculator {

    /**
     * precision field help to specify the number of precision in the
     * calculate with the divide operator.
     */
    private static final int precision = 8;

    /**
     * this calculate method perform the operation on the BigIntegers only,
     * and return the result in the String format.
     * @param numOne    this is the first operand for the calculation.
     * @param numTwo    this is the second operand for the calculation.
     * @param operator  this is the operator of the calculation.
     * @return  return the result of the calculation in String format.
     */
    public static String calculate(BigInteger numOne, BigInteger numTwo, char operator) {
        String result = numOne.toString();
        Assertion.throwMessage("(" + numOne + " " + operator + " " + numTwo + ") --At Calculation");

        switch (operator) {
            case '+' -> result = numOne.add(numTwo).toString();
            case '-' -> result = numOne.subtract(numTwo).toString();
            case '×' -> result = numOne.multiply(numTwo).toString();
            case '÷' -> result = (new BigDecimal(numOne)).divide(new BigDecimal(numTwo), precision, RoundingMode.HALF_UP).toString();
            case '=' -> result = numOne.toString();
            default -> Assertion.throwErrorMessage(new Throwable("\"" + operator + "\" Operator is NOT in Calculator!"));
        }
        return result;
    }

    /**
     * this calculate method perform the operation on the BigDecimal only,
     * and return the result in the String format.
     * @param numOne    this is the first operand for the calculation.
     * @param numTwo    this is the second operand for the calculation.
     * @param operator  this is the operator of the calculation.
     * @return  return the result of the calculation in String format.
     */
    public static String calculate(BigDecimal numOne, BigDecimal numTwo, char operator) {
        String result = numOne.toString();
        Assertion.throwMessage("(" + numOne + " " + operator + " " + numTwo + ") --At Calculation");

        switch (operator) {
            case '+' -> result = numOne.add(numTwo).toString();
            case '-' -> result = numOne.subtract(numTwo).toString();
            case '×' -> result = numOne.multiply(numTwo).toString();
            case '÷' -> result = numOne.divide(numTwo, precision, RoundingMode.HALF_UP).toString();
            case '=' -> result = numOne.toString();
            default -> Assertion.throwErrorMessage(new Throwable("\"" + operator + "\" Operator is NOT in Calculator!"));
        }
        return result;
    }

}
