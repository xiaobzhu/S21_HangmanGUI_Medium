import com.sun.org.apache.xpath.internal.operations.Equals;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * this class is used to setup the GUI part for the project, To avoid use to many files, dont want to make this file like the project
 * in the above, so I put the algorithm of this project in this file, I put them in the Keylistenner directly
 */
public class HangmanGUI extends JFrame {

    /**
     * this private this is a JTextField it is used from JFrame
     */
    private JTextField userGuessWord = new JTextField();
    /**
     * this private this is a JTextField it is used from JFrame
     */
    private JTextField finalAnswer = new JTextField();
    /**
     * this private value is a int that indicate how many times that the user still can do the guess
     */
    private int life = 6;
    /**
     * This char[] is used to be a temp value that can store the cahr[]
     */
    private char[] text;
    /**
     * This String is used to be a temp value for the result in String type
     */
    private String text1;
    /**
     * This char[] is used to be a temp value that can store the cahr[]
     */
    private char[] text2;
    /**
     * this String is used to store the mistake answer that user input
     */
    private String used = "";
    /**
     * this private value is JPasswordField that used to setup a password field that can hide the input into special
     * Character
     */
    private JPasswordField userInputGuessWord = new JPasswordField();
    /**
     * this private thing is used to setup a panel for drawing part
     */
    private JPanel drawPanel;
    /**
     * this private this is used to setup two button, one is named start , one is guess the other one is called Guess
     */
    private JButton start = new JButton("Start");

    private JButton guess = new JButton("Guess");

    private JButton answer = new JButton("Answer");
    /**
     * this private things is the JLabel that used to setup the Label in the GUI
     */
    private JLabel textLabel = new JLabel();

    private JLabel textLabel1 = new JLabel();

    private JLabel textLabel2 = new JLabel();

    /**
     * this is the constructor of the HangmanGUI, in this part it used to build up the GUI of the project
     * In this part it set up the size of the textfield, and the actionlistener of the GUI, and also the algorithm
     * of the project
     */
    public HangmanGUI() {
        super("Hangman Game");
        JPanel panel;
        JPanel panel1 = new JPanel();
        FlowLayout layout = new FlowLayout();//this line is used to set up the layout way of the GUI
        panel1.setLayout(layout);
        Dimension dimension = new Dimension(300, 50);//this line is used to set up the size
        userInputGuessWord.setPreferredSize(dimension);
        Dimension dimension1 = new Dimension(100, 50);
        start.setPreferredSize(dimension1);
        buttonHandler buttonhandler = new buttonHandler();
        start.addActionListener(buttonhandler);
        panel1.add(userInputGuessWord);
        panel1.add(start);


        JPanel panel2 = new JPanel();
        Dimension dimension2 = new Dimension(300, 50);
        userGuessWord.setPreferredSize(dimension2);
        Dimension dimension3 = new Dimension(100, 50);
        guess.setPreferredSize(dimension3);
        guess.addActionListener(buttonhandler);
        panel2.add(userGuessWord);
        panel2.add(guess);

        JPanel panel3 = new JPanel();
        Dimension dimension4 = new Dimension(300, 50);
        finalAnswer.setPreferredSize(dimension4);
        Dimension dimension7 = new Dimension(100, 50);
        answer.setPreferredSize(dimension7);
        answer.addActionListener(buttonhandler);
        panel3.add(finalAnswer);
        panel3.add(answer);


        Font tr = new Font("TimesRoman", Font.PLAIN, 18);//this line is used to set up the font of the text filed or label in the GUI
        textLabel.setFont(tr);
        Font tr1 = new Font("TimesRoman", Font.PLAIN, 15);
        textLabel1.setFont(tr1);
        textLabel2.setFont(tr1);
        textLabel.setText("Welcome to Hangman");//give the label text
        textLabel1.setText("Please enter a word to the textField next to start button to start.");
        textLabel2.setText("You only can have six wrong guesses");

        panel = new JPanel();
        FlowLayout layout1 = new FlowLayout();
        panel.setLayout(layout1);

        drawPanel = new JPanel();
        drawing draw = new drawing();
        Dimension dimension9 = new Dimension(220, 220);
        draw.setPreferredSize(dimension9);
        drawPanel.add(draw);
        JPanel panel4 = new JPanel();
        panel4.setPreferredSize(new Dimension(300, 50));

        panel4.add(textLabel);

        JPanel panel5 = new JPanel();
        panel5.setPreferredSize(new Dimension(600, 50));
        panel5.add(textLabel1);

        JPanel panel6 = new JPanel();
        panel6.setPreferredSize(new Dimension(300, 50));
        panel6.add(textLabel2);


        panel.add(panel1);//add the small panels to the main panel
        panel.add(panel2);
        panel.add(panel3);
        panel.add(panel4);
        panel.add(panel5);
        panel.add(panel6);
        panel.add(drawPanel);

        add(panel);//add all the panels into the frame
        //this.setSize(600, 1500);
    }

    /**
     * this class is used to build up the Buttonhandler, that used to get the user action and
     * how does the program work after get the user action
     */
    public class buttonHandler implements ActionListener {
        /**
         * This method is override the button handler , to get the user action
         *
         * @param e the action event
         */
        @Override
        public void actionPerformed(ActionEvent e) {

            if (e.getSource() == start) {//this if statement is used to make sure where is the source from
                text = userInputGuessWord.getPassword();
                if (text.length == 0) {
                    textLabel1.setText("Please input a word");
                    throw new IllegalArgumentException("         Please input a word         ");
                }
                for (int i = 0; i < text.length; i++) {
                    if (Character.isLetter(text[i])) {
                        textLabel1.setText("         You are correct, Continue the Game!      ");
                    }
                    if (!Character.isLetter(text[i])) {
                        textLabel1.setText("         Please input a word            ");
                        throw new IllegalArgumentException("Please input a word with letter.");
                    }

                    text2 = new char[text.length];
                    for (int j = 0; j < text.length; j++) {
                        text2[j] = '_';
                    }
                    //check space
                    if (text[i] == ' ') {
                        throw new IllegalArgumentException("Please input a word without a space.");
                    }
                    text1 = text1 + text[i];
                }

                start.setEnabled(false);
                userInputGuessWord.setEnabled(false);
                finalAnswer.setText(String.valueOf(text2));
                finalAnswer.setEnabled(false);


            }

            if (e.getSource() == guess) {//this is to decide the user action
                boolean isTrue = false;

                if (!userGuessWord.getText().equals("")) {
                    text1 = userGuessWord.getText();

                    if (text1.length() > 1) {
                        textLabel.setText("ONLY FIRST CAN BE COUNTED!");
                    }

                    for (int i = 0; i < text.length; i++) {
                        text[i] = Character.toUpperCase(text[i]);
                        if (text[i] == Character.toUpperCase(text1.charAt(0))) {
                            text2[i] = text[i];
                            finalAnswer.setText(String.valueOf(text2));
                            isTrue = true;
                        }

                    }

                    if (!isTrue) {//this if is used to do the action on the life variable
                        life = life - 1;
                        textLabel2.setText("You still have " + life + " lifes");

                        used += text1.substring(0, 1).toUpperCase() + "   ";
                        textLabel1.setText("Missed: " + used);
                    }
                    if (life == 0) {//when the life is zero to the setting for the GUI
                        textLabel2.setText("The correct Answer is " + String.valueOf(text));
                        guess.setEnabled(false);
                        answer.setEnabled(false);
                        finalAnswer.setEnabled(false);
                    }
                    drawPanel.repaint();
                }
            }
            if (e.getSource() == answer) {
                String answer1 = finalAnswer.getText();
                String textfinal = userInputGuessWord.getText();
                char[] toTry;
                boolean flag = true;
                toTry = answer1.toCharArray();
                char[] toTest;
                toTest = textfinal.toCharArray();

                for (int i = 0; i < toTry.length; i++) {
                    toTry[i] = Character.toUpperCase(toTry[i]);
                    toTest[i] = Character.toUpperCase(toTest[i]);
                    if (toTry[i] != toTest[i]) {
                        flag = false;
                    }

                }
                if (flag) {
                    textLabel1.setFont(new Font("TimesRoman", Font.PLAIN, 30));
                    textLabel1.setText("You win");
                    guess.setEnabled(false);
                    userGuessWord.setEnabled(false);
                    textLabel.setText("                    ");
                    textLabel2.setText("                                         ");
                }
            }
        }
    }

    /**
     * this class is used to do the drawing panel thing, that used to do the drawing part its extends thing from JPanel
     */
    private class drawing extends JPanel {
        /**
         * this method is used to override the paintCompoment, to do the exactly drawing option
         *
         * @param graphics
         */
        @Override
        public void paintComponent(Graphics graphics) {
            super.paintComponent(graphics);
            /**
             * setBackground is uesd to set the drawing panel's background color
             */
            setBackground(Color.black);
            /**
             * setColor is used to set up the color of the drawing part
             */
            graphics.setColor(Color.white);
            /**
             * it is used to drawing part
             */
            graphics.fillRect(20, 35, 150, 20);
            graphics.fillRect(150, 50, 20, 230);
            graphics.fillRect(10, 270, 175, 20);
            graphics.drawLine(90, 55, 90, 70);

            //draw a hang man based on life count remaining
            if (life == 6) {
                graphics.fillRect(20, 35, 150, 20);
                graphics.fillRect(150, 50, 20, 230);
                graphics.fillRect(10, 270, 175, 20);
                graphics.drawLine(90, 55, 90, 70);
            }
            if (life == 5) {
                graphics.fillRect(20, 35, 150, 20);
                graphics.fillRect(150, 50, 20, 230);
                graphics.fillRect(10, 270, 175, 20);
                graphics.drawLine(90, 55, 90, 70);
                graphics.drawArc(70, 70, 40, 40, 360, 360);//head
            }
            if (life == 4) {
                graphics.fillRect(20, 35, 150, 20);
                graphics.fillRect(150, 50, 20, 230);
                graphics.fillRect(10, 270, 175, 20);
                graphics.drawLine(90, 55, 90, 70);
                graphics.drawLine(90, 110, 90, 170);//body
                graphics.drawArc(70, 70, 40, 40, 360, 360);//head
            }
            if (life == 3) {
                graphics.fillRect(20, 35, 150, 20);
                graphics.fillRect(150, 50, 20, 230);
                graphics.fillRect(10, 270, 175, 20);
                graphics.drawLine(90, 55, 90, 70);
                graphics.drawLine(90, 110, 90, 170);//body
                graphics.drawArc(70, 70, 40, 40, 360, 360);//head
                graphics.drawLine(90, 120, 70, 160);//arm1
            }
            if (life == 2) {
                graphics.fillRect(20, 35, 150, 20);
                graphics.fillRect(150, 50, 20, 230);
                graphics.fillRect(10, 270, 175, 20);
                graphics.drawLine(90, 55, 90, 70);
                graphics.drawLine(90, 110, 90, 170);//body
                graphics.drawArc(70, 70, 40, 40, 360, 360);//head
                graphics.drawLine(90, 120, 70, 160);//arm1
                graphics.drawLine(90, 120, 110, 160);//arm2
            }
            if (life == 1) {
                graphics.fillRect(20, 35, 150, 20);
                graphics.fillRect(150, 50, 20, 230);
                graphics.fillRect(10, 270, 175, 20);
                graphics.drawLine(90, 55, 90, 70);
                graphics.drawLine(90, 110, 90, 170);//body
                graphics.drawArc(70, 70, 40, 40, 360, 360);//head
                graphics.drawLine(90, 120, 70, 160);//arm1
                graphics.drawLine(90, 120, 110, 160);//arm2
                graphics.drawLine(90, 170, 70, 210);//leg1
            }
            if (life == 0) {
                graphics.fillRect(20, 35, 150, 20);
                graphics.fillRect(150, 50, 20, 230);
                graphics.fillRect(10, 270, 175, 20);
                graphics.drawLine(90, 55, 90, 70);
                graphics.drawLine(90, 110, 90, 170);//body
                graphics.drawArc(70, 70, 40, 40, 360, 360);//head
                graphics.drawLine(90, 120, 70, 160);//arm1
                graphics.drawLine(90, 120, 110, 160);//arm2
                graphics.drawLine(90, 170, 70, 210);//leg1
                graphics.drawLine(90, 170, 110, 210);//leg2
                graphics.drawString("YOU DIED", 65, 20);//die message
            }

        }
    }


}
