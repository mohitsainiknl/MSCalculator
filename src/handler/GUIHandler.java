package handler;

import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import handler.gui.ButtonType;
import handler.gui.CalcButton;
import handler.gui.CalcField;
import style.Style;
import theme.Theme;
import com.gmail.mohitsainiknl2.gui.GridBagPanel;

/**
 * GUILauncher
 */
public class GUIHandler {
    Style style;
    Theme theme;
    JFrame frame;
    GridBagPanel panel, fieldPanel;
    CalcField mainField, subField;
    CalcButton numButton[], addButton, subButton, mtpyButton, divButton;
    CalcButton dotButton,signButton, resultButton, clearButton, backButton;
    // KeyHandler key;

    public GUIHandler(Style style, Theme theme) {
        this.style = style;
        this.theme = theme;
    }

    public void handle() {
        UIManager.put("Button.select", theme.getButtonPressBKColor());

        mainField = new CalcField("25", style, theme);
            mainField.setFont(style.getMainFieldFont());
        subField = new CalcField("12 + 13 = 25", style, theme);
            subField.setFont(style.getSubFieldFont());
        fieldPanel = new GridBagPanel();
        fieldPanel.setOpaque(false);
        fieldPanel.setGridWeight(1.0, 1.0);
        fieldPanel.add(subField,  0, 0,  1, 1);
        fieldPanel.add(mainField,  0, 1,  1, 2);

        numButton = new CalcButton[10];
        for (int i = 0; i <= 9; ++i) {
            numButton[i] = new CalcButton(i + "", ButtonType.NUMPAD, style, theme);
        }
        dotButton = new CalcButton(".", ButtonType.NUMPAD, style, theme);
        signButton = new CalcButton("+/-", ButtonType.SIGN, style, theme);

        addButton = new CalcButton("+", ButtonType.OPERATOR, style, theme);
        subButton = new CalcButton("-", ButtonType.OPERATOR, style, theme);
        mtpyButton = new CalcButton("×", ButtonType.OPERATOR, style, theme);
        divButton = new CalcButton("÷", ButtonType.OPERATOR, style, theme);
        clearButton = new CalcButton("C", ButtonType.OPERATOR, style, theme);
        backButton = new CalcButton("<", ButtonType.OPERATOR, style, theme);
        resultButton = new CalcButton("=", ButtonType.RESULT, style, theme);
            resultButton.setVerticalAlignment(JButton.NORTH);
        
        panel = new GridBagPanel(new Insets(1, 1, 1, 1));
        panel.setBackground(theme.getPaneBKColor());
        panel.setBorder(new LineBorder(theme.getPaneBKColor(), 1));

        panel.setGridWeight(1.0, 1.0);
        panel.add(fieldPanel, 0, 0, 4, 1, 1.0, 1.0);

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

        frame = new JFrame("MSCalculator");
        frame.getContentPane().add(panel, BorderLayout.CENTER);
        frame.setAlwaysOnTop(true);
        frame.setSize(style.getFrameWidth(), style.getFrameHeight());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        {
            setKeyListener();
            setActionListener();
        }
        frame.setVisible(true);
    }

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

    private void setKeyListener() {
        frame.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                final String key = KeyEvent.getKeyText(e.getKeyCode());
                if(key.equals("Period") || key.equals("NumPad .")) {
                    dotButton.doClick();
                }
                else if(key.equals("NumPad +")) {
                    addButton.doClick();
                }
                else if(key.equals("NumPad -")) {
                    subButton.doClick();
                }
                else if(key.equals("NumPad *")) {
                    mtpyButton.doClick();
                }
                else if(key.equals("NumPad /")) {
                    divButton.doClick();
                }
                else if(key.equals("C")) {
                    clearButton.doClick();
                }
                else if(key.equals("Backspace")) {
                    backButton.doClick();
                }
                else if(key.equals("Enter")) {
                    UIManager.put("Button.select", theme.getResultButtonPressBKColor());
                    resultButton.doClick();
                    UIManager.put("Button.select", theme.getButtonPressBKColor());
                }
                else {
                    for (int i = 0; i < 10; i++) {
                        if(key.equals("" + i) || key.equals("NumPad-" + i)) {
                            numButton[i].doClick();
                        }
                    }
                }
            }
        });
    }
}