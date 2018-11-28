import javax.swing.*;
import java.awt.*;

/**
 * This is the main class of the whole project, in this class, it has a constructor of the HangmanGUI, use this constructor
 * to do some settings for the GUI, I set the setting in this file, just because I dont want use this, what I dont want to use
 * this, just because I dont want answer this this questions in the oral exam, I know this knowledge of this this, But I
 * still dont want to answer this this in the oral exam, I know this is an object, this is used let compile know that is
 * the variable, this is the same type as the class type
 */

public class GUI_Test {
    public static void main(String args[]) {
        HangmanGUI gameBegin = new HangmanGUI();
        gameBegin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameBegin.setSize(500, 750);
        gameBegin.setVisible(true);
        gameBegin.setMaximumSize(new Dimension(500, 750));
        gameBegin.setMinimumSize(new Dimension(499, 749));
    }
}
