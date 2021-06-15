/*
 * Copyright (c) 2021 Mohit Saini, Under MIT License. Use is subject to license terms.
 *  
 */
package com.gmail.mohitsainiknl2.mscalculator.handler;

import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.awt.event.ActionEvent;

import com.gmail.mohitsainiknl2.mscalculator.handler.event.CalcUtilities;
import com.gmail.mohitsainiknl2.mscalculator.handler.event.Calculator;
import com.gmail.mohitsainiknl2.mscalculator.handler.gui.CalcField;

/**
 * ActionHandler
 */
public class ActionHandler extends CalcUtilities implements ActionListener {
    private static boolean isNewMainNum = false;
    private static boolean isNewSubNum = false;
    private String mainText, subText;
    private CalcField mainField, subField;

    private BigInteger BigMainInt = new BigInteger("0");
    private BigDecimal BigMainDcml = new BigDecimal("0.0");
    private static BigInteger BigPrevInt = new BigInteger("0");
    private static BigDecimal BigPrevDcml = new BigDecimal("0.0");
    private static Boolean isInteger = true;

    /**
     * 
     * @param mainField
     * @param subField
     */
    public ActionHandler(CalcField mainField, CalcField subField) {
        this.mainField  = mainField;
        this.subField = subField;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        String source = (String)e.getActionCommand();
        initialize();
        
        int i;
        for (i = 0; i < 10; i++) {
            if(source.equals("" + i)) {
                break;
            }
        }
        
        if(i != 10) {
            mainField.setText(mainText + i);
            firstZeroRemover(mainField);
        }
        else if(source.equals("C")) {
            clearfield();
        }
        else if(source.equals("<")) {
            backLastDigit(mainText, mainField);
        }
        else if(source.equals("+/-")) {
            changeSign(mainText, mainField);
        }
        else if(source.equals(".")) {
            if(setDotInField(mainText, mainField) && (isInteger == true)) {
                setIsInteger(false);    // We don't need Integer, we need Decimal
            }
        }
        else if(source.equals("+")) {
            calculateAndSetNum('+');
        }
        else if(source.equals("-")) {
            calculateAndSetNum('-');
        }
        else if(source.equals("×")) {
            calculateAndSetNum('×');
        }
        else if(source.equals("÷")) {
            calculateAndSetNum('÷');
        }
        else if(source.equals("=")) {
            calculateResult();
        }
        final String text = (isInteger)? "Integer" : "Decimal";
        System.out.println(text);
    }

    /*
     * 
     */
    private void initialize() {
        if(isNewMainNum == false){
            mainText = mainField.getText();
            final String mainNum = removeUnevenDot(mainText);
            if(isInteger) {
                BigMainInt = new BigInteger(mainNum);
            }
            else {
                BigMainDcml = new BigDecimal(mainNum);
            }
        }
        else {
            mainText = "0";
            BigMainInt = new BigInteger("0");
            BigMainDcml = new BigDecimal("0.0");
            isNewMainNum = false;
        }

        if(isNewSubNum == false){
            subText = subField.getText();
        }
        else {
            subText = "";
            subField.setText(subText);
            isNewSubNum = false;
        }
    }

    /**
     * 
     */
    private void clearfield() {
        mainField.setText("0");
        subField.setText("");
        BigPrevInt = new BigInteger("0");
        BigPrevDcml = new BigDecimal("0.0");
    }

    private void calculateAndSetNum(char opr) {
        String mainNum;
        String prevNum;
        if(isInteger) {
            mainNum = BigMainInt.toString();
            prevNum = BigPrevInt.toString();
        }
        else {
            mainNum = BigMainDcml.toPlainString();
            prevNum = BigPrevDcml.toPlainString();
        }

        if(mainNum.equals("0") == false) {
            mainText = removeUnevenDot(mainText);
            subField.setText(subText + mainText + " " + opr + " ");
            if(subText.length() == 0) {
                prevNum = mainNum;
                mainField.setText(mainText);
                isNewMainNum = true;
            }
            else {
                prevNum = calculate(prevNum, mainNum);
            }
        }
        else if(subText.length() != 0) {
            subText = subText.substring(0, subText.length()-2) + opr + " ";
            subField.setText(subText);
            isNewMainNum = true;
        }

        if(isInteger) {
            mainNum = removeUnevenDot(mainNum);
            BigMainInt = new BigInteger(mainNum);
            BigPrevInt = new BigInteger(prevNum);
        }
        else {
            BigMainDcml = new BigDecimal(mainNum);
            BigPrevDcml = new BigDecimal(prevNum);
        }
    }

    private void calculateResult() {
        String mainNum;
        String prevNum;
        if(isInteger) {
            mainNum = BigMainInt.toString();
            prevNum = BigPrevInt.toString();
        }
        else {
            mainNum = BigMainDcml.toPlainString();
            prevNum = BigPrevDcml.toPlainString();
        }

        if(mainNum.equals("0") == false && subText.length() != 0) {
            mainText = removeUnevenDot(mainText);
            subField.setText(subText + mainText + " = ");
        }
        else if(subText.length() != 0) {
            subText = subText.substring(0, subText.length()-2) + "= ";
            subField.setText(subText);
        }

        if(subText.length() == 0) {
            return;
        }
        else {
            prevNum = calculate(prevNum, mainNum);
            mainField.setText(prevNum);
            isNewSubNum = true;
        }

        if(isInteger) {
            mainNum = removeUnevenDot(mainNum);
            BigMainInt = new BigInteger(mainNum);
            BigPrevInt = new BigInteger(prevNum);
        }
        else {
            BigMainDcml = new BigDecimal(mainNum);
            BigPrevDcml = new BigDecimal(prevNum);
        }
    }

    private String calculate(String mainNum, String prevNum) {
        final char lastOpr = lastOperatorIn(subText);
        if(isInteger) {
            prevNum = Calculator.calculate(new BigInteger(mainNum), new BigInteger(prevNum), lastOpr);
            prevNum = removeUnevenDot(prevNum);
            mainField.setText(prevNum);
            isNewMainNum = true;
            if(isDotInString(prevNum) == true && isInteger == true) {
                setIsInteger(false);
            }
        }
        else {
            prevNum = Calculator.calculate(new BigDecimal(mainNum), new BigDecimal(prevNum), lastOpr);
            prevNum = removeUnevenDot(prevNum);
            mainField.setText(prevNum);
            isNewMainNum = true;
            if(isDotInString(prevNum) == false && isInteger == false) {
                setIsInteger(true);
            }
        }
        return prevNum;
    }

    private void setIsInteger(Boolean value) {
        if(isInteger != value) {
            isInteger = value;
            if (value) {
                final String mainNum = BigMainDcml.toPlainString();
                final String subNum  = BigPrevDcml.toPlainString();
                if(isDotInString(mainNum) == false && isDotInString(subNum) == false) {
                    BigMainInt = new BigInteger(mainNum);
                    BigPrevInt = new BigInteger(subNum);
                }
                else {
                    System.out.println("Can NOT change Decimal into Integer!");
                }
            }
            else {
                BigMainDcml = new BigDecimal(BigMainInt);
                BigPrevDcml = new BigDecimal(BigPrevInt);
            }
        }
    }
}
