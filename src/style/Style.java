/*
 * Copyright (c) 2021 Mohit Saini, Under MIT License. Use is subject to license terms.
 * 
 */
package style;

import java.awt.Font;
import java.awt.Dimension;

/**
 * Style interface help programer to set the Style and Scale
 * of the frame, buttons and their fonts used in this Calculator.
 */
public interface Style {
    Dimension getFrameSize();
    Dimension getButtonSize();
    Font getNumButtonFont();
    Font getOprButtonFont();
    Font getMainFieldFont();
    Font getSubFieldFont();
    Font getSignButtonFont();
}