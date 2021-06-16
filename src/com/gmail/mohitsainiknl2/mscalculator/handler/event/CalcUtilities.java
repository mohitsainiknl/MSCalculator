package com.gmail.mohitsainiknl2.mscalculator.handler.event;

import java.math.BigInteger;
import java.math.BigDecimal;

import com.gmail.mohitsainiknl2.mscalculator.handler.ActionHandler;
import com.gmail.mohitsainiknl2.mscalculator.handler.gui.CalcField;
import com.gmail.mohitsainiknl2.util.debug.Assertion;

/**
 * CalcUtilities class help the ActionHandler class to perfom the calculation 
 * process. this class also take help of the Calculator class to perfom
 * the actual calculation in the MSCalculator.
 */
public class CalcUtilities {
    private String mainText, subText;
    private CalcField mainField, subField;

    private BigInteger bigMainInt;
    private BigDecimal bigMainDcml;
    private static BigInteger bigPrevInt;
    private static BigDecimal bigPrevDcml;
    private static Boolean isInteger;

    /**
     * initialize method initialize the parameter of this class with the help of the
     * parameter of the method.
     * @param mainText the text of the mainField.
     * @param subText the text of the subField.
     * @param mainField the main field of the calculator.
     * @param subField the sub field of the calculator.
     */
    public void initialize(String mainText, String subText, CalcField mainField, CalcField subField) {
        this.mainText = mainText;
        this.subText = subText;
        this.mainField = mainField;
        this.subField = subField;
    }

    /**
     * setBigMainDcml method is the setter method for the bigMainDcml field.
     * @param bigMainDcml value we need to set.
     */
    public void setBigMainDcml(BigDecimal bigMainDcml) {
        this.bigMainDcml = bigMainDcml;
    }

    /**
     * setBigMainInt method is the setter method for the bigMainInt field.
     * @param bigMainInt value we need to set.
     */
    public void setBigMainInt(BigInteger bigMainInt) {
        this.bigMainInt = bigMainInt;
    }

    /**
     * setBigMainInt method is the setter method for the bigMainInt field.
     * @param bigMainInt value we need to set.
     */
    public static void setBigPrevDcml(BigDecimal bigPrevDcml) {
        CalcUtilities.bigPrevDcml = bigPrevDcml;
    }

    /**
     * setBigPrevInt method is the setter method for the bigPrevInt field.
     * @param bigPrevInt value we need to set.
     */
    public static void setBigPrevInt(BigInteger bigPrevInt) {
        CalcUtilities.bigPrevInt = bigPrevInt;
    }

    /**
     * setIsInteger method is the setter method for the isInteger field.
     * @param isInteger value we need to set.
     */
    public static void setIsInteger(Boolean isInteger) {
        CalcUtilities.isInteger = isInteger;
    }

    /**
     * setIsIneger method is the setter method for the isIneger field.
     * @return the value of isInteger.
     */
    public static Boolean getIsInteger() {
        return isInteger;
    }
    
    /**
     * calculateAndSetNum method perfom the calculation of all the operator
     * button, according to the operator passed to it.
     * @param operator this is the operator we need to use.
     */
    public void calculateAndSetNum(char operator) {
        String mainNum = new String();
        String prevNum = new String();
        if(isInteger) {
            mainNum = bigMainInt.toString();
            prevNum = bigPrevInt.toString();
        }
        else {
            mainNum = bigMainDcml.toPlainString();
            prevNum = bigPrevDcml.toPlainString();
        }
        mainNum = FormtUtilities.removeUnrequiredDot(mainNum);  //<-- help to change 0.0 into 0

        if(operator == '=') {
            calculateResult(mainNum, prevNum);
        }
        else {
            calculateResult(mainNum, prevNum, operator);
        }
    }


    /**
     * This calculateResult method help in preparing and calling the Calculator class method 
     * to perform calculation.
     * @param mainNum number in the mainField.
     * @param prevNum number of the prev mainField.
     * @param operator operator for the calculation.
     */
    private void calculateResult(String mainNum, String prevNum, char operator) {
        if(!mainNum.equals("0")) {
            mainText = FormtUtilities.removeUnrequiredDot(mainText);
            FormtUtilities.setSubFieldText(subField, subText + mainText + " " + operator + " ");
            if(subText.length() == 0) {
                prevNum = mainNum;
            }
            else {
                prevNum = calculate(prevNum, mainNum);
            }
            ActionHandler.setNewMainNum(true);
        }
        else if(subText.length() != 0) {    //<--- Change Sign
            subText = (FormtUtilities.lastOperatorIn(subText)=='0')? subText : subText.substring(0, subText.length()-2);
            subText = subText + operator + " ";
            FormtUtilities.setSubFieldText(subField, subText);
            ActionHandler.setNewMainNum(true);
        }
        convertStringIntoBigNum(mainNum, prevNum);
    }


    /**
     * This calculateResult method is a special purpose method, use to perfom
     * the calculation. The behavior of the result button is different from the
     * operator button.
     * @param mainNum number of the mainField.
     * @param prevNum number of the prev mainField.
     */
    private void calculateResult(String mainNum, String prevNum) {
        if(!mainText.equals("0") && subText.length() != 0) {
            if(FormtUtilities.lastOperatorIn(subText) != '0') {
                mainText = FormtUtilities.removeUnrequiredDot(mainText);
                FormtUtilities.setSubFieldText(subField, subText + mainText + " = ");
                    
                prevNum = calculate(prevNum, mainNum);
                FormtUtilities.setMainFieldText(mainField, prevNum);
                ActionHandler.setNewSubNum(true);
                convertStringIntoBigNum(mainNum, prevNum);
            }
        }
    }

    /**
     * convertStringIntoBigNum method convert the number String into their Big number values.
     * @param mainNum number of the mainField.
     * @param prevNum number of the prev mainField.
     */
    private void convertStringIntoBigNum(String mainNum, String prevNum) {
        if(isInteger) {
            mainNum = FormtUtilities.removeUnrequiredDot(mainNum);
            bigMainInt = new BigInteger(mainNum);
            bigPrevInt = new BigInteger(prevNum);
        }
        else {
            bigMainDcml = new BigDecimal(mainNum);
            bigPrevDcml = new BigDecimal(prevNum);
        }
    }


    /**
     * calculate method of this class help to prepare the number to before pushing
     * it to the Calculator class to claculate the result. this method help
     * to diffenciate the calculation for integer and decimal.
     * @param mainNum this is the number in main-field.
     * @param prevNum this is the previously typed number.
     * @return result of the claculation in String type.
     */
    private String calculate(String mainNum, String prevNum) {
        final char lastOpr = FormtUtilities.lastOperatorIn(subText);
        if(lastOpr == '0') {
            Assertion.throwErrorMessage(new Throwable("Somthing went wrong with operator!"));
            return mainNum;
        }

        String result;
        if(isInteger) {
            result = Calculator.calculate(new BigInteger(mainNum), new BigInteger(prevNum), lastOpr);
        }
        else {
            result = Calculator.calculate(new BigDecimal(mainNum), new BigDecimal(prevNum), lastOpr);
        }
        {
            result = FormtUtilities.removeUnrequiredDot(result);
            mainField.setText(result);

            if(FormtUtilities.isInString(result, '.') && isInteger) {   //<--- Check, Result change the Type (like- 3 ÷ 2 = 1.5) type changed
                final boolean change = (isInteger)? false : true;
                changeIsInteger(change);
            }
            prevNum = result;
        }
        return prevNum;
    }


    /**
     * setIsInteger method help to change the big datatyle from BigInteger
     * to BigDecimal and from BigDecimal to BigIneger.
     * @param value change datatype according to this.
     */
    public void changeIsInteger(Boolean value) {
        if(isInteger != value) {
            isInteger = value;
            {
                final String type = (isInteger)? "Integer" : "Decimal";
                Assertion.throwMessage(type + " --DataType");
            }
            if (value) {
                final String mainNum = bigMainDcml.toPlainString();
                final String subNum  = bigPrevDcml.toPlainString();
                if(FormtUtilities.isInString(mainNum, '.') == false && FormtUtilities.isInString(subNum, '.') == false) {
                    bigMainInt = new BigInteger(mainNum);
                    bigPrevInt = new BigInteger(subNum);
                }
                else {
                    Assertion.throwErrorMessage(new Throwable("Can NOT change Decimal into Integer!"));
                }
            }
            else {
                bigMainDcml = new BigDecimal(bigMainInt);
                bigPrevDcml = new BigDecimal(bigPrevInt);
            }
        }
    }
}
