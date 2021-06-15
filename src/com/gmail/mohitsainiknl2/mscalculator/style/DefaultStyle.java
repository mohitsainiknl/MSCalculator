/*
 * Copyright (c) 2021 Mohit Saini, Under MIT License. Use is subject to license terms.
 * 
 */
package com.gmail.mohitsainiknl2.mscalculator.style;

import java.awt.Font;
import java.awt.Dimension;

/**
 * DefaultStyle is the default style and size of the frame, buttons and their fonts
 * used in the GUI of this Calculator.
 */
public class DefaultStyle implements Style{
    public static final Font numButtonFont = new Font("Arial", Font.PLAIN, 22);
    public static final Font oprButtonFont = new Font("Lucida Console", Font.PLAIN, 22);
    public static final Font mainFieldFont = new Font("Arial", Font.BOLD, 30);
    public static final Font subFieldFont = new Font("Arial", Font.PLAIN, 14);
    public static final Font signButtonFont = new Font("Arial", Font.PLAIN, 16);
    public static final int frameWidth = 258;
    public static final int frameHeight = 340;
    public static final int buttonWidth = 56;
    public static final int buttonHeight = 43;

    @Override
    public Font getNumButtonFont() {
        return numButtonFont;
    }

    @Override
    public Font getOprButtonFont() {
        return oprButtonFont;
    }

    @Override
    public Font getMainFieldFont() {
        return mainFieldFont;
    }

    @Override
    public Font getSubFieldFont() {
        return subFieldFont;
    }

    @Override
    public Font getSignButtonFont() {
        return signButtonFont;
    }

    @Override
    public Dimension getFrameSize() {
        return new Dimension(frameWidth, frameHeight);
    }

    @Override
    public Dimension getButtonSize() {
        return new Dimension(buttonWidth, buttonHeight);
    }

}