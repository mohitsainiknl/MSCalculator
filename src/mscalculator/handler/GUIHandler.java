/*
 * Copyright (c) 2021 Mohit Saini, Under MIT License. Use is subject to license terms.
 * 
 */
package mscalculator.handler;

import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import com.gmail.mohitsainiknl2.util.gui.GridBagPanel;

import mscalculator.handler.gui.ButtonType;
import mscalculator.handler.gui.CalcButton;
import mscalculator.handler.gui.CalcField;
import mscalculator.style.Style;
import mscalculator.theme.Theme;

/**
 * GUILauncher class handle the gui functioning of this Calculator, Moreover,
 * The key listener and the action listener is also add, to the component accordingly,
 * here in this class. In short, this is the manager class of this calculator.
 */
public class GUIHandler {
    Style style;
    Theme theme;
    JFrame frame;
    GridBagPanel panel, fieldPanel;
    CalcField mainField, subField;
    CalcButton[] numButton;
    CalcButton addButton, subButton, mtpyButton, divButton;
    CalcButton dotButton,signButton, resultButton, clearButton, backButton;

    /**
     * This constructor of GUIHandler help to initialize the initial component
     * used throughout the class, with the help of parameters, respectively.
     * @param style this defines the style and the size of the Calculator.
     * @param theme this defines the theme of the Calculator, with help of it's color-plate.
     */
    public GUIHandler(Style style, Theme theme) {
        this.style = style;
        this.theme = theme;
    }

    /**
     * handle method is used to start the handling process of the gui.
     * All the component are initialize, bind and set-up here in this class.
     */
    public void handle() {
        UIManager.put("Button.select", theme.getButtonPressBKColor());

        mainField = new CalcField("0", theme);       //<--- Field Panel
            mainField.setFont(style.getMainFieldFont());
        subField = new CalcField("", theme);
            subField.setFont(style.getSubFieldFont());
        fieldPanel = new GridBagPanel();
        fieldPanel.setOpaque(false);
        fieldPanel.setGridWeight(1.0, 1.0);
        fieldPanel.add(subField,  0, 0,  1, 1);
        fieldPanel.add(mainField,  0, 1,  1, 2);

        numButton = new CalcButton[10];         //<--- Buttons
        for (int i = 0; i <= 9; ++i) {
            numButton[i] = new CalcButton(i + "", ButtonType.NUMPAD, style, theme);
        }
        dotButton = new CalcButton(".", ButtonType.NUMPAD, style, theme);
        signButton = new CalcButton("+/-", ButtonType.SIGN, style, theme);

        addButton = new CalcButton("+", ButtonType.OPERATOR, style, theme);
        subButton = new CalcButton("-", ButtonType.OPERATOR, style, theme);
        mtpyButton = new CalcButton("\u00D7", ButtonType.OPERATOR, style, theme);
        divButton = new CalcButton("\u00F7", ButtonType.OPERATOR, style, theme);
        clearButton = new CalcButton("C", ButtonType.OPERATOR, style, theme);
        backButton = new CalcButton("<", ButtonType.OPERATOR, style, theme);
        resultButton = new CalcButton("=", ButtonType.RESULT, style, theme);
            resultButton.setVerticalAlignment(JButton.NORTH);
        
        panel = new GridBagPanel(new Insets(1, 1, 1, 1));       //<--- Panel
        panel.setBackground(theme.getPaneBKColor());
        panel.setBorder(new LineBorder(theme.getPaneBKColor(), 1));
        addCompsOnPanel();

        frame = new JFrame("MSCalculator");                     //<--- Frame
        frame.getContentPane().add(panel, BorderLayout.CENTER);
        frame.setAlwaysOnTop(true);
        frame.setResizable(false);
        frame.setSize(style.getFrameSize());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        {
            setKeyListener();
            setActionListener();
        }
        frame.setVisible(true);
    }

    /**
     * addCompsOnPanel method help to add the required component to the panel,
     * With the help of the GridBagLayout.
     */
    private void addCompsOnPanel() {
        panel.setGridWeight(1.0, 1.0);
        panel.add(fieldPanel, 0, 0, 4, 1);

        panel.setGridDimension(1, 1);
        panel.setGridWeight(1.0, 0.0);
        panel.add(divButton, 0, 1);
        panel.add(mtpyButton, 1, 1);
        panel.add(subButton, 2, 1);
        panel.add(addButton, 3, 1);

        panel.add(numButton[7], 0, 2);
        panel.add(numButton[8], 1, 2);
        panel.add(numButton[9], 2, 2);
        panel.add(clearButton, 3, 2);

        panel.add(numButton[4], 0, 3);
        panel.add(numButton[5], 1, 3);
        panel.add(numButton[6], 2, 3);
        panel.add(backButton, 3, 3);

        panel.add(numButton[1], 0, 4);
        panel.add(numButton[2], 1, 4);
        panel.add(numButton[3], 2, 4);
        panel.add(resultButton, 3, 4, 1, 2);

        panel.add(signButton, 0, 5);
        panel.add(numButton[0], 1, 5);
        panel.add(dotButton, 2, 5);
    }

    /**
     * setActionListener method is used to set the action to buttons,
     * with the help of addActionListener and ActionHandler class.
     */
    private void setActionListener() {
        ActionListener listener  = new ActionHandler(mainField, subField);

        for (int i = 0; i < 10; i++) {
            numButton[i].addActionListener(listener);
        }
        dotButton.addActionListener(listener);
        signButton.addActionListener(listener);

        addButton.addActionListener(listener);
        subButton.addActionListener(listener);
        mtpyButton.addActionListener(listener);
        divButton.addActionListener(listener);
        clearButton.addActionListener(listener);
        backButton.addActionListener(listener);
        resultButton.addActionListener(listener);
    }

    /**
     * setKeyListener method is used to set the keystroke (of keyboard)
     * to the respective action of the button.
     */
    private void setKeyListener() {
        frame.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
            final String key = KeyEvent.getKeyText(e.getKeyCode());
            switch (key) {
                case "Period":
                case "NumPad .":
                    dotButton.doClick();
                    break;
                case "NumPad +":
                    addButton.doClick();
                    break;
                case "NumPad -":
                    subButton.doClick();
                    break;
                case "NumPad *":
                    mtpyButton.doClick();
                    break;
                case "NumPad /":
                    divButton.doClick();
                    break;
                case "C":
                    clearButton.doClick();
                    break;
                case "Backspace":
                    backButton.doClick();
                    break;
                case "Enter":
                    UIManager.put("Button.select", theme.getResultButtonPressBKColor());
                    resultButton.doClick();
                    UIManager.put("Button.select", theme.getButtonPressBKColor());
                    break;
                default:
                    for (int i = 0; i < 10; i++) {
                        if (key.equals("" + i) || key.equals("NumPad-" + i)) {
                            numButton[i].doClick();
                        }
                    }
                    break;
            }
            }
        });
    }
}