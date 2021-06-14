/*
 * Copyright (c) 2021 Mohit Saini, Under MIT License. Use is subject to license terms.
 * 
 */
package handler.gui;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;

import theme.Theme;
import style.Style;

/**
 * CalcButton class used to design buttons specially for MSCalculator by extending the
 * JButton class of the JavaSE and with the help of style and theme. Moreover,
 * the hover effect of the button is also handled by this class, with
 * the help of ButtonType interface.
 */
public class CalcButton extends JButton {
    private static final int borderThickness = 1;
    private ButtonType type;
    private Style style;
    private Theme theme;

    /**
     * This constructor of CalcButton is point where this class initialize its field
     * and destributing the field-values according to the button type,
     * with the help of the argument passed as the paramerter.
     * @param text  this is the text we want to write on the button.
     * @param type  this is the type of button we are forming.
     * @param style this is the style and the size used by the button.
     * @param theme this is the theme used by the button.
     */
    public CalcButton(String text, ButtonType type, Style style, Theme theme) {
        super(text);
        this.type = type;
        this.style = style;
        this.theme = theme;

        setFocusable(false);
        setPreferredSize(style.getButtonSize());

        if(type == ButtonType.NUMPAD || type == ButtonType.SIGN) {
            settingForNum();
        }
        else if(type == ButtonType.OPERATOR) {
            settingForOpr();
        }
        else if(type == ButtonType.RESULT) {
            settingForResult();
        }

        setHoverEffect();
    }

    /*
     * settingForNum set the field according to the NUMPAD ButtonType.
     * Numpad buttons have its own look-and-feel in this calculator.
     */
    private void settingForNum() {
        if(type == ButtonType.SIGN) {
            setFont(style.getSignButtonFont());
        }
        else {
            setFont(style.getNumButtonFont());
        }
        setForeground(theme.getNumFGColor());
        setBackground(theme.getNumBKColor());
        setBorder(new LineBorder(theme.getNumBKColor(), borderThickness));
    }

    /*
     * settingForOpr set the field according to the OPERATOR ButtonType,
     * These buttons also have its own look-and-feel.
     */
    private void settingForOpr() {
        setFont(style.getOprButtonFont());
        setForeground(theme.getOprFGColor());
        setBackground(theme.getOprBKColor());
        setBorder(new LineBorder(theme.getOprBKColor(), borderThickness));
    }

    /*
     * settingForOpr set the field according to the RESULT ButtonType,
     * These result button has different look-and-feel.
     */
    private void settingForResult() {
        setFont(style.getOprButtonFont());
        setForeground(theme.getResultFGColor());
        setBackground(theme.getResultBKColor());
        setBorder(new LineBorder(theme.getResultBKColor(), borderThickness));
    }

    /*
     * setHoverEffect set hover effect to the button with ButtonType 
     * by using the repective theme color.
     */
    private void setHoverEffect() {
        addMouseListener(new MouseAdapter() {
            
            @Override
            public void mouseEntered(MouseEvent e) {
                if(type == ButtonType.NUMPAD || type == ButtonType.OPERATOR || type == ButtonType.SIGN) {
                    setBackground(theme.getButtonHoverBKColor());
                    setForeground(theme.getButtonHoverFGColor());
                    setBorder(new LineBorder(theme.getButtonHoverBorderColor(), borderThickness));
                }
                else if(type == ButtonType.RESULT) {
                    setBackground(theme.getResultButtonHoverBKColor());
                    setForeground(theme.getResultButtonHoverFGColor());
                    setBorder(new LineBorder(theme.getResultButtonHoverBorderColor(), borderThickness));
                }
            }
            
            @Override
            public void mousePressed(MouseEvent e) {
                if(type == ButtonType.RESULT) {
                    UIManager.put("Button.select", theme.getResultButtonPressBKColor());
                }
            }
            
            @Override
            public void mouseReleased(MouseEvent e) {
                if(type == ButtonType.RESULT) {
                    UIManager.put("Button.select", theme.getButtonPressBKColor());
                }
            }
        
            @Override
            public void mouseExited(MouseEvent e) {
                if(type == ButtonType.NUMPAD || type == ButtonType.SIGN) {
                    settingForNum();
                }
                else if(type == ButtonType.OPERATOR) {
                    settingForOpr();
                }
                else if(type == ButtonType.RESULT) {
                    settingForResult();
                }
            }
        });
    }

}