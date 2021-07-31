/*
 * Copyright (c) 2021 Mohit Saini, Under MIT License. Use is subject to license terms.
 * 
 */

package mscalculator;

import mscalculator.handler.GUIHandler;
import mscalculator.style.DefaultStyle;
import mscalculator.style.Style;
import mscalculator.theme.DefaultTheme;
import mscalculator.theme.Theme;

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