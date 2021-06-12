package handler.gui;

import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;

import theme.Theme;
import style.Style;

/**
 * CalcButton
 */
public class CalcButton extends JButton {
    private static final int borderThickness = 1;
    private ButtonType type;
    private Style style;
    private Theme theme;

    public CalcButton(String text, ButtonType type, Style style, Theme theme) {
        super(text);
        this.type = type;
        this.style = style;
        this.theme = theme;

        setFocusable(false);
        setPreferredSize(new Dimension(56, 43));

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

    private void settingForOpr() {
        setFont(style.getOprButtonFont());
        setForeground(theme.getOprFGColor());
        setBackground(theme.getOprBKColor());
        setBorder(new LineBorder(theme.getOprBKColor(), borderThickness));
    }

    private void settingForResult() {
        setFont(style.getOprButtonFont());
        setForeground(theme.getResultFGColor());
        setBackground(theme.getResultBKColor());
        setBorder(new LineBorder(theme.getResultBKColor(), borderThickness));
    }

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