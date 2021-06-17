/*
 * Copyright (c) 2021 Mohit Saini, Under MIT License. Use is subject to license terms.
 * 
 */
package com.gmail.mohitsainiknl2.mscalculator.theme;

import java.awt.Color;

/**
 * Theme interface help to guide the program to make a new Theme for this Calculator.
 * Note :-
 * if one need to add new Color in color-plate,
 * then, one have to add the declaration of this color's getter-method in this Interface.
 */
public interface Theme {
    Color getPaneBKColor();
    Color getFieldFGColor();
    Color getNumFGColor();
    Color getNumBKColor();
    Color getOprFGColor();
    Color getOprBKColor();
    Color getResultFGColor();
    Color getResultBKColor();

    Color getButtonHoverBKColor();
    Color getButtonHoverFGColor();
    Color getButtonHoverBorderColor();
    Color getResultButtonHoverBKColor();
    Color getResultButtonHoverFGColor();
    Color getResultButtonHoverBorderColor();

    Color getButtonPressBKColor();
    Color getResultButtonPressBKColor();
}