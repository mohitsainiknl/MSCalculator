/*
 * Copyright (c) 2021 Mohit Saini, Under MIT License. Use is subject to license terms.
 * 
 */ 
package handler.event;

import handler.gui.CalcField;

/**
 * CalcUtilities
 */
public class CalcUtilities {

    /**
     * 
     * @param mainField
     */
    public static void firstZeroRemover(CalcField mainField) {
        String temp = mainField.getText();
        if(temp.charAt(0) == '0' && temp.length() > 1 && temp.charAt(1)!='.') {
            mainField.setText(temp.substring(1));
        }
    }

    /**
     * 
     * @param text
     * @param ch
     * @return
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
     * 
     * @param text
     * @return
     */
    private static boolean allAreZeroDotSign(String text)  
    {  
        for(int i=0; i < text.length(); ++i) {
            if(text.charAt(i) != '0' && text.charAt(i) != '.' && text.charAt(i) != '-') {
                return false;  
            }
        }
        return true;  
    }  

    /**
     * 
     * @param text
     * @return
     */
    public static String removeUnevenDot(String text)  {  
        int i;
        final int length = text.length();
    
        for(i=0; i < length; ++i) {
            if(text.charAt(i) == '.') {
                break;
            }
        }
        if(i != length) {
            if(0 == Integer.parseInt("0" + text.substring(i+1)) || length == i+1) {
                return text.substring(0, i);
            }
            else {
                return text;
            }
        }
        else {
            return text;
        }
    }

    public static void backLastDigit(String mainText, CalcField mainField) {
        String temp;
        if((mainText.length()==2 && mainText.charAt(0)=='-') || (mainText.length()==1)) {
            mainField.setText("0");
        }
        else {
            temp = mainText.substring(0, mainText.length()-1);
            if(allAreZeroDotSign(temp) && temp.charAt(0)=='-') {
                temp = temp.substring(1);
            }
            mainField.setText(temp);
        }
    }

    public static void changeSign(String mainText, CalcField mainField) {
        if(mainText.length()==1 && mainText.charAt(0)=='0') {
            // Do-Nothing
        }
        else if(mainText.charAt(0) == '-') {
            mainField.setText(mainText.substring(1));
        }
        else if(! allAreZeroDotSign(mainText)) {
            mainField.setText("-" + mainText);
        }
    }

    public static boolean setDotInField(String mainText, CalcField mainField) {
        if(! isInString(mainText,'.')) {
            mainField.setText(mainText + '.');
            firstZeroRemover(mainField);
            return true; // value changed, is TRUE
        }
        return false;
    }

    public static boolean isDotInString(String text) {
        for(int i=0; i < text.length(); ++i) {
            if(text.charAt(i) == '.') {
                return true;
            }
        }
        return false;
    }

    public static char lastOperatorIn(String subText) {
        char operator = subText.charAt(subText.length()-2);
        return operator;
    }
}
