/*
 * Copyright (c) 2021 Mohit Saini, Under MIT License. Use is subject to license terms.
 * 
 */
import style.Style;
import style.DefaultStyle;
import theme.Theme;
import theme.DefaultTheme;
import handler.GUIHandler;

/**
 * MainLauncher is the starting point of this Calculator, Moreover,
 * it also set it's look and launch the GUI Handler class,
 * Which handle the further execution.
 */
public class MainLauncher {
    GUIHandler gui;
    Style style;
    Theme theme;

    public MainLauncher() {         // <--- Constructor
        style = new DefaultStyle();
        theme = new DefaultTheme();
        gui = new GUIHandler(style, theme);
        gui.handle();
    }

    public static void main(String[] args) {    // <--- Main Method
        new MainLauncher();
    }
}