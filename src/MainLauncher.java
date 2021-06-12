import javax.swing.SwingUtilities;
import handler.GUIHandler;
import style.Style;
import style.DefaultStyle;
import theme.DefaultTheme;
import theme.Theme;

/**
 * MainLauncher
 */
public class MainLauncher {
    GUIHandler gui;
    Style style;
    Theme theme;

    public MainLauncher() {
        style = new DefaultStyle();
        theme = new DefaultTheme();
        gui = new GUIHandler(style, theme);
        gui.handle();
    }
 
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable(){
            public void run() {
                new MainLauncher();
            }
        });
    }
}