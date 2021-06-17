/*
 * Copyright (c) 2021 Mohit Saini, Under MIT License. Use is subject to license terms.
 * 
 */ 
package com.gmail.mohitsainiknl2.mscalculator.handler.event;

import com.gmail.mohitsainiknl2.mscalculator.handler.gui.CalcField;
import com.gmail.mohitsainiknl2.util.debug.Assertion;

/**
 * FormatUtilities class help the ActionHandler to manipulate the field text,
 * All Utilities/Methods are handle some part of the manipulation.
 */
public class FormatUtilities {

    /**
     * firstZeroRemover method remove the left-side zeros from the parameterized text,
     * and then return the resultant text.
     * @param mainText this is the initial text we need.
     * @return return the non-left-side-zeros text.
     */
    public static String firstZeroRemover(String mainText) {
        if( (mainText.charAt(0) == '0')  &&
            (mainText.length() > 1 )  &&
            (mainText.charAt(1)!='.')
          ) {
            return mainText.substring(1);
        }
        return mainText;
    }

    /**
     * clearField method is help in clear the all field, by using the parameters.
     * And, separate the assertion if enabled.
     * @param mainField this is the first text-field we need to clear.
     * @param subField this is the second text-field we need to clear.
     */
    public static void clearField(CalcField mainField, CalcField subField) {
        setMainFieldText(mainField, "0");
        setSubFieldText(subField, "");
        Assertion.throwMessage("\n--------- Cleared ---------\n");
    }

    /**
     * isInString method help to find, whether a character is in the String
     * or not, with help of the passed values.
     * @param text the text, we need to find in.
     * @param ch the character, we need to find for.
     * @return result of finding process in boolean value.
     */
    public static boolean isInString(String text, char ch)  
    {  
        for(int i=0; i < text.length(); ++i) {
            if(text.charAt(i)==ch) {
                return true;  
            }
        }
        return false;  
    }  

    /**
     * removeUnRequiredDot method remove the dot which we not need, like - 250.00,
     * from the String passed as parameter. this method help in formatting the
     * number in the text-field of the calculator.
     * @param num number, in the form of String, we need to check.
     * @return the resultant number in the form of String.
     */
    public static String removeUnRequiredDot(String num)  {
        int i;
        final int length = num.length();
    
        for(i=0; i < length; ++i) {
            if(num.charAt(i) == '.') {
                break;
            }
        }
        if(i != length) {
            boolean isFractionalPartZero = true;
            {
                String fractionalPart = num.substring(i+1);
                for (int j = 0; j < fractionalPart.length(); j++) {
                    if(fractionalPart.charAt(j) != '0') {
                        isFractionalPartZero = false;
                        break;
                    }
                }
            }
            if(isFractionalPartZero || length == i+1) {
                return num.substring(0, i);
            }
            else {
                return num;
            }
        }
        else {
            return num;
        }
    }

    /**
     * backSpaceTheInput method clear the last digit/dot in the field.
     * but, set zero for some conditions.
     * @param mainText this is text we need to Backspace.
     * @param mainField this is the text-field we need to update.
     */
    public static void backSpaceTheInput(String mainText, CalcField mainField) {
        final boolean conditionOne = (mainText.length() == 2) && (mainText.charAt(0) == '-');
        final boolean conditionTwo = (mainText.length() == 3) && (mainText.charAt(0) == '-') && (mainText.charAt(2) == '.');

        if(conditionOne || conditionTwo || (mainText.length()==1)) {
            setMainFieldText(mainField, "0");
        }
        else {
            mainText = mainText.substring(0, mainText.length()-1);
            setMainFieldText(mainField, mainText);
        }
    }

    /**
     * changeSign method change the sign of the number, it change -ve into +ve
     * and +ve into -ve.
     * @param mainText this is the number in the form of String.
     * @param mainField this is the text-field we need to update.
     */
    public static void changeSign(String mainText, CalcField mainField) {
        if(mainText.length()==1 && mainText.charAt(0)=='0') {
            // Do-Nothing
        }
        else if(mainText.charAt(0) == '-') {
            setMainFieldText(mainField, mainText.substring(1));
        }
        else {
            setMainFieldText(mainField, "-" + mainText);
        }
    }

    /**
     * setDotInField method set the dot in the text and reflect the changes to the text-field.
     * @param mainText text in which we need to add dot.
     * @param mainField text-field to reflect changes.
     */
    public static void setDotInField(String mainText, CalcField mainField) {
        if(! isInString(mainText,'.')) {
            mainText = mainText + '.';
            setMainFieldText(mainField, mainText);
        }
    }


    /**
     * doWeNeedInteger method check whether we need Integer datatype or not, this method
     * help in maintaining both numbers with the same datatype.
     * @param mainText text of mainField.
     * @param subText text of subfield.
     * @param isInteger value before this method execute.
     * @return the result, whether we need integer or not.
     */
    public static boolean doWeNeedInteger(String mainText, String subText, boolean isInteger) {
        if(isInString(mainText, '.') || isInString(subText, '.') && isInteger) {
            return false;
        }
        return true;
    }


    /**
     * lastOperatorIn method help to find the last operator in the subfield's text, sometime,
     * we need to complete previous calculation before taking the next operator.
     * @param subText text of the subfield.
     * @return the last operator.
     */
    public static char lastOperatorIn(String subText) {
        char operator = subText.charAt(subText.length()-2);
        if(operator == '+' ||operator == '-' ||operator == '÷' ||operator == '×') {
            return operator;
        }
        return '0';
    }


    /**
     * setMainFieldText method help in formatting the output, before setting it
     * to the mainField of the calculator. We can use this method to
     * print numbers like - 20,000,000,000 (so that the no. is
     * more readable).
     * @param mainField mainField of the calculator.
     * @param text text we need to set.
     */
    public static void setMainFieldText(CalcField mainField,String text) {
        mainField.setText(text);
    }


    /**
     * setSubFieldText method help in formatting the output, before setting it
     * to the subfield of the calculator(so that the no. is
     * more readable).
     * @param subField subfield of the calculator.
     * @param text text we need to set.
     */
    public static void setSubFieldText(CalcField subField,String text) {
        subField.setText(text);
    }
}
