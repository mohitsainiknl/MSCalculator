package gui;

import java.awt.Color;

import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import style.Style;
import theme.Theme;

/**
 * CalcField
 */
public class CalcField extends JTextField{

    public CalcField(String text, Style style, Theme theme) {
        super(text);

        setFocusable(false);
        setEditable(false);
        setHorizontalAlignment(JTextField.RIGHT);
        setBorder(new LineBorder(Color.WHITE, 0));
        setOpaque(false);
        setForeground(theme.getFieldFGColor());
    }
}