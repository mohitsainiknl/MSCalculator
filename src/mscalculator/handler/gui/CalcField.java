/*
 * Copyright (c) 2021 Mohit Saini, Under MIT License. Use is subject to license terms.
 * 
 */
package mscalculator.handler.gui;

import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import mscalculator.theme.Theme;

/**
 * CalcField class used to set-up the JTextField according to the MSCalculator.
 * This class help to reuse this code-block for all textFields.
 */
public class CalcField extends JTextField{
    private static final long serialVersionUID = 3035451494840107479L;

	/**
     * This constructor is used to set-up initial field of the JTextField,
     * with the help of parameters.
     * @param text  this is the initial text in the field.
     * @param theme this is the theme used in this calculator.
     */
    public CalcField(String text, Theme theme) {
        super(text);

        setFocusable(false);
        setEditable(false);
        setHorizontalAlignment(JTextField.RIGHT);
        setBorder(new LineBorder(Color.WHITE, 0));
        setOpaque(false);
        setForeground(theme.getFieldFGColor());
    }
}