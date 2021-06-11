package style;

import java.awt.Font;

/**
 * DefaultStyle
 */
public class DefaultStyle implements Style{
    public static final Font numButtonFont = new Font("Arial", Font.PLAIN, 22);
    public static final Font oprButtonFont = new Font("Lucida Console", Font.PLAIN, 22);
    public static final Font mainFieldFont = new Font("Arial", Font.BOLD, 30);
    public static final Font subFieldFont = new Font("Arial", Font.PLAIN, 14);
    public static final Font signButtonFont = new Font("Arial", Font.PLAIN, 16);
    public static final int frameWidth = 258;
    public static final int frameHeight = 340;

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
    public int getFrameWidth() {
        return frameWidth;
    }

    @Override
    public int getFrameHeight() {
        return frameHeight;
    }

}