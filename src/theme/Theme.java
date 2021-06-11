package theme;

import java.awt.Color;

/**
 * Theme
 */
public interface Theme {
    Color getPaneBKColor();
    Color getFieldFGColor();
    Color getNumFGColor();
    Color getNumBKColor();
    Color getOprFGColor();
    Color getOprBKColor();
    Color getResultFGColor();
    Color getResultBKColor();

    Color getButtonHoverBKColor();
    Color getButtonHoverFGColor();
    Color getButtonHoverBorderColor();
    Color getResultButtonHoverBKColor();
    Color getResultButtonHoverFGColor();
    Color getResultButtonHoverBorderColor();

    Color getButtonPressBKColor();
    Color getResultButtonPressBKColor();
}