/*
 * Copyright (c) 2021 Mohit Saini, Under MIT License. Use is subject to license terms.
 * 
 */

package com.gmail.mohitsainiknl2.mscalculator;

import com.gmail.mohitsainiknl2.mscalculator.style.Style;
import com.gmail.mohitsainiknl2.mscalculator.style.DefaultStyle;
import com.gmail.mohitsainiknl2.mscalculator.theme.Theme;
import com.gmail.mohitsainiknl2.mscalculator.theme.DefaultTheme;
import com.gmail.mohitsainiknl2.mscalculator.handler.GUIHandler;

/** 
 * MainLauncher is the starting point of this Calculator, Moreover,
 * it also set it's look and launch the GUI Handler class,
 * Which handle the further execution.
 */
public class MainLauncher {
    GUIHandler gui;
    Style style;
    Theme theme;

    private MainLauncher() {         // <--- Internal Constructor
        style = new DefaultStyle();
        theme = new DefaultTheme();
        gui = new GUIHandler(style, theme);
        gui.handle();
    }

    public static void main(String[] args) {    // <--- Main Method
        new MainLauncher();
    }
}