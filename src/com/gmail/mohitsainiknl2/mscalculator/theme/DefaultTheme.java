/*
 * Copyright (c) 2021 Mohit Saini, Under MIT License. Use is subject to license terms.
 * 
 */
package com.gmail.mohitsainiknl2.mscalculator.theme;

import java.awt.Color;

/**
 * DefaultTheme is the default Color theme for this Calculator.
 * This class implements the Theme interface, So, this class must
 * define all methods declared in such interface.
 */
public class DefaultTheme implements Theme{
    public static final Color PANE_BK_COLOR = new Color(235, 235, 235);
    public static final Color FIELD_FG_COLOR = Color.BLACK;

    public static final Color NUM_BK_COLOR = Color.WHITE;
    public static final Color NUM_FG_COLOR = Color.BLACK;
    public static final Color OPR_BK_COLOR = new Color(245, 245, 245);
    public static final Color OPR_FG_COLOR = Color.BLACK;
    public static final Color RESULT_BK_COLOR = new Color(138, 186, 224);
    public static final Color RESULT_FG_COLOR = Color.BLACK;

    public static final Color BTN_HVR_BK_COLOR = new Color(210, 210, 210);
    public static final Color BTN_HVR_FG_COLOR = Color.BLACK;
    public static final Color BTN_HVR_BDR_COLOR = new Color(180, 180, 180);
    public static final Color RESULT_BTN_HVR_BK_COLOR = new Color(58, 143, 208);
    public static final Color RESULT_BTN_HVR_FG_COLOR = Color.BLACK;
    public static final Color RESULT_BTN_HVR_BDR_COLOR = new Color(52, 127, 185);

    public static final Color BTN_PRS_BK_COLOR = new Color(180, 180, 180);
    public static final Color RESULT_BTN_PRS_BK_COLOR = new Color(184, 207, 229);

    @Override
    public Color getPaneBKColor() {
        return PANE_BK_COLOR;
    }

    @Override
    public Color getFieldFGColor() {
        return FIELD_FG_COLOR;
    }

    @Override
    public Color getNumFGColor() {
        return NUM_FG_COLOR;
    }

    @Override
    public Color getNumBKColor() {
        return NUM_BK_COLOR;
    }

    @Override
    public Color getOprFGColor() {
        return OPR_FG_COLOR;
    }

    @Override
    public Color getOprBKColor() {
        return OPR_BK_COLOR;
    }

    @Override
    public Color getResultFGColor() {
        return RESULT_FG_COLOR;
    }

    @Override
    public Color getResultBKColor() {
        return RESULT_BK_COLOR;
    }

    @Override
    public Color getButtonHoverBKColor() {
        return BTN_HVR_BK_COLOR;
    }

    @Override
    public Color getButtonHoverFGColor() {
        return BTN_HVR_FG_COLOR;
    }

    @Override
    public Color getButtonHoverBorderColor() {
        return BTN_HVR_BDR_COLOR;
    }

    @Override
    public Color getResultButtonHoverBKColor() {
        return RESULT_BTN_HVR_BK_COLOR;
    }

    @Override
    public Color getResultButtonHoverFGColor() {
        return RESULT_BTN_HVR_FG_COLOR;
    }

    @Override
    public Color getResultButtonHoverBorderColor() {
        return RESULT_BTN_HVR_BDR_COLOR;
    }


    @Override
    public Color getButtonPressBKColor() {
        return BTN_PRS_BK_COLOR;
    }

    @Override
    public Color getResultButtonPressBKColor() {
        return RESULT_BTN_PRS_BK_COLOR;
    }
}