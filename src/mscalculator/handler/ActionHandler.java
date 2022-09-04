/*
 * Copyright (c) 2021 Mohit Saini, Under MIT License. Use is subject to license terms.
 *  
 */
package mscalculator.handler;

import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.awt.event.ActionEvent;

import com.gmail.mohitsainiknl2.util.debug.Assertion;

import mscalculator.handler.event.CalcUtilities;
import mscalculator.handler.event.FormatUtilities;
import mscalculator.handler.gui.CalcField;

/**
 * ActionHandler class handle the action when user click on the button,
 * with the help of the CalcUtil class and the Calculator class.
 */
public class ActionHandler implements ActionListener {
    private static boolean isNewMainNum;
    private static boolean isNewSubNum;
    private String mainText, subText;
    private final CalcField mainField, subField;

    private static CalcUtilities cUtil;


    /**
     * This constructor initialize the CalcField objects with the passed values,
     * also initialize the class' internal fields.
     * @param mainField this is the main field of the MSCalculator.
     * @param subField  this is the sub field of the MSCalculator.
     */
    public ActionHandler(CalcField mainField, CalcField subField) {
        this.mainField  = mainField;
        this.subField = subField;
        cUtil = new CalcUtilities();
        initializeZeroValues_toAll();
    }


    /**
     * initializeZeroValues_toAll method change/assign the initial zero
     * values to hte field of this class, which help in
     * clear action too.
     */
    private void initializeZeroValues_toAll() {
        isNewSubNum = false;
        subText = "";
        CalcUtilities.setBigPrevInt(new BigInteger("0"));
        CalcUtilities.setBigPrevDcml(new BigDecimal("0.0"));
        CalcUtilities.setIsInteger(true);
        Assertion.throwMessage("Integer --DataType");
        initializeZeroValues();
    }


    /**
     * initializeZeroValues method change/assign only the non-static fields
     * of this class. this is helpful when user entered the first value
     * and want to insert second value.
     */
    private void initializeZeroValues() {
        mainText = "0";
        isNewMainNum = false;
        cUtil.setBigMainInt(new BigInteger("0"));
        cUtil.setBigMainDcml(new BigDecimal("0.0"));
    }
    

    /**
     * actionPerformed method help to perform the actions on button click, with
     * the help of the source of the ActionEvent (passed as parameter).
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        String source = e.getActionCommand();
        initialize();

        int i;
        for (i = 0; i < 10; i++) {
            if(source.equals("" + i)) {
                break;
            }
        }
        
        if(i != 10) {
            mainText = mainText + i;
           FormatUtilities.setMainFieldText(mainField, FormatUtilities.firstZeroRemover(mainText));
        }
        else if(source.equals("C")) {
            FormatUtilities.clearField(mainField, subField);
            initializeZeroValues_toAll();
        }
        else if(source.equals("<")) {
            FormatUtilities.backSpaceTheInput(mainText, mainField);
            mainText = mainField.getText();
            cUtil.changeIsInteger(FormatUtilities.doWeNeedInteger(mainText, subText, CalcUtilities.getIsInteger()));
        }
        else if(source.equals("+/-")) {
            FormatUtilities.changeSign(mainText, mainField);
        }
        else if(source.equals(".")) {
            FormatUtilities.setDotInField(mainText, mainField);
            mainText = mainField.getText();
            cUtil.changeIsInteger(FormatUtilities.doWeNeedInteger(mainText, subText, CalcUtilities.getIsInteger()));
        }
        else if(source.equals("+")) {
            cUtil.calculateAndSetNum('+');
        }
        else if(source.equals("-")) {
            cUtil.calculateAndSetNum('-');
        }
        else if(source.equals("\u00D7")) {  // Here  \u00D7 = '×'
            cUtil.calculateAndSetNum('\u00D7');
        }
        else if(source.equals("\u00F7")) {  // Here  \u00F7 = '÷'
            cUtil.calculateAndSetNum('\u00F7');
        }
        else if(source.equals("=")) {
            cUtil.calculateAndSetNum('=');
        }
    }


    /**
     * This is the setter method of the isNewMainNum field.
     * @param isNewMainNum value we need to set.
     */
    public static void setNewMainNum(boolean isNewMainNum) {
        ActionHandler.isNewMainNum = isNewMainNum;
    }


    /**
     * This is the setter method of the isNewSubNum field.
     * @param isNewSubNum value we need to set.
     */
    public static void setNewSubNum(boolean isNewSubNum) {
        ActionHandler.isNewSubNum = isNewSubNum;
    }


    /**
     * initialize method initialize the variables and the object of Big-Datatype classes.
     * basically, it is a conditional initialization based on the static values.
     * this method also use some other method based on the conditions.
     */
    private void initialize() {
        if(!isNewMainNum){
            loadValuesFromMainField();
        }
        else {
            initializeZeroValues();
        }

        if(!isNewSubNum){
            subText = subField.getText();
        }
        else {
            subText = "";
            FormatUtilities.setSubFieldText(subField, subText);
            isNewSubNum = false;
        }
        cUtil.initialize(mainText, subText, mainField, subField);
    }


    /**
     * loadValuesFromMainField method load the values from the main-field,
     * and check the compatibility of datatype and throw error-message
     * if the not compatible.
     */
    private void loadValuesFromMainField() {
        mainText = mainField.getText();
        final boolean isInteger = CalcUtilities.getIsInteger();
        if(isInteger) {
            final boolean isDecimalMainField = FormatUtilities.isInString(mainText, '.');
            if(isDecimalMainField) {
                Assertion.throwErrorMessage(new Throwable("\"isInteger\" field has WRONG value, " + mainText + " --MainText"));
                return;
            }
        }

        final String mainNum = FormatUtilities.removeUnRequiredDot(mainText);
        if(isInteger) {
            cUtil.setBigMainInt(new BigInteger(mainNum));
        }
        else {
            cUtil.setBigMainDcml(new BigDecimal(mainNum));
        }
    }
}
