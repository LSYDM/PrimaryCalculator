import java.awt.*;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.regex.Pattern;
import javax.swing.*;

public class PrimaryCalculator {
    private static final int WINDOW_WIDTH = 400;
    private static final int WINDOW_HEIGHT = 600;
    private static final int BUTTON_WIDTH = 80;
    private static final int BUTTON_HEIGHT = 70;
    private static final int MARGIN_X = 20;
    private static final int MARGIN_Y = 60;
    private final JFrame jf;
    private final JTextField inText;
    private final JButton buttonClear;
    private final JButton buttonBackspace;
    private final JButton buttonModule;
    private final JButton buttonDivision;
    private final JButton buttonMultiplication;
    private final JButton buttonSubtraction;
    private final JButton buttonAddition;
    private final JButton button0;
    private final JButton button1;
    private final JButton button2;
    private final JButton button3;
    private final JButton button4;
    private final JButton button5;
    private final JButton button6;
    private final JButton button7;
    private final JButton button8;
    private final JButton button9;
    private final JButton buttonPoint;
    private final JButton buttonEqual;
    int[] x = {MARGIN_X, MARGIN_X + 90, 200, 290, 380};
    int[] y = {MARGIN_Y, MARGIN_Y + 100, MARGIN_Y + 180, MARGIN_Y + 260, MARGIN_Y + 340, MARGIN_Y + 420};

    public PrimaryCalculator() {
        jf = new JFrame("PrimaryCalculator");
        jf.setContentPane(new MyPane());
        jf.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        jf.setLocationRelativeTo(null);
        jf.getContentPane().setBackground(new Color(70, 61, 61));

        inText = new JTextField("0");
        inText.setOpaque(false);
        inText.setBorder(new RoundedBorder(20));
        inText.setForeground(new Color(255, 106, 161));
        inText.setBounds(x[0], y[0], 350, 85);
        inText.setEditable(false);
        inText.setFont(new Font("宋体", Font.BOLD, 43));
        jf.add(inText);

        buttonClear = initButton("C", x[0], y[1], event -> {
            repaintFont();
            inText.setText("0");
        });

        buttonBackspace = initButton("<-", x[1], y[1], event -> {
            repaintFont();
            String str = inText.getText();
            StringBuilder str2 = new StringBuilder();
            for (int i = 0; i < (str.length() - 1); i++) {
                str2.append(str.charAt(i));
            }
            if (str2.toString().equals("")) {
                inText.setText("0");
            } else {
                inText.setText(str2.toString());
            }
        });

        buttonModule = initButton("%", x[2], y[1], event -> {
            repaintFont();
            inText.setText(inText.getText() + "%");
        });

        buttonDivision = initButton("/", x[3], y[1], event -> {
            repaintFont();
            inText.setText(inText.getText() + "/");
        });

        buttonMultiplication = initButton("*", x[3], y[2], event -> {
            repaintFont();
            inText.setText(inText.getText() + "*");
        });

        buttonSubtraction = initButton("-", x[3], y[3], event -> {
            repaintFont();
            inText.setText(inText.getText() + "-");
        });

        buttonAddition = initButton("+", x[3], y[4], event -> {
            repaintFont();
            inText.setText(inText.getText() + "+");
        });

        button1 = initButton("1", x[0], y[4], event -> {
            repaintFont();
            if (Pattern.matches("0*", inText.getText())) {
                inText.setText("1");
            } else {
                inText.setText(inText.getText() + "1");
            }
        });

        button2 = initButton("2", x[1], y[4], event -> {
            repaintFont();
            if (Pattern.matches("0*", inText.getText())) {
                inText.setText("2");
            } else {
                inText.setText(inText.getText() + "2");
            }
        });

        button3 = initButton("3", x[2], y[4], event -> {
            repaintFont();
            if (Pattern.matches("0*", inText.getText())) {
                inText.setText("3");
            } else {
                inText.setText(inText.getText() + "3");
            }
        });

        button4 = initButton("4", x[0], y[3], event -> {
            repaintFont();
            if (Pattern.matches("0*", inText.getText())) {
                inText.setText("4");
            } else {
                inText.setText(inText.getText() + "4");
            }
        });

        button5 = initButton("5", x[1], y[3], event -> {
            repaintFont();
            if (Pattern.matches("0*", inText.getText())) {
                inText.setText("5");
            } else {
                inText.setText(inText.getText() + "5");
            }
        });

        button6 = initButton("6", x[2], y[3], event -> {
            repaintFont();
            if (Pattern.matches("0*", inText.getText())) {
                inText.setText("6");
            } else {
                inText.setText(inText.getText() + "6");
            }
        });

        button7 = initButton("7", x[0], y[2], event -> {
            repaintFont();
            if (Pattern.matches("0*", inText.getText())) {
                inText.setText("7");
            } else {
                inText.setText(inText.getText() + "7");
            }
        });

        button8 = initButton("8", x[1], y[2], event -> {
            repaintFont();
            if (Pattern.matches("0*", inText.getText())) {
                inText.setText("8");
            } else {
                inText.setText(inText.getText() + "8");
            }
        });

        button9 = initButton("9", x[2], y[2], event -> {
            repaintFont();
            if (Pattern.matches("0*", inText.getText())) {
                inText.setText("9");
            } else {
                inText.setText(inText.getText() + "9");
            }
        });

        buttonPoint = initButton(".", x[0], y[5], event -> {
            repaintFont();
            inText.setText(inText.getText() + ".");
        });

        button0 = initButton("0", x[1], y[5], event -> {
            repaintFont();
            if (Pattern.matches("0*", inText.getText())) {
                inText.setText("0");
            } else {
                inText.setText(inText.getText() + "0");
            }
        });

        buttonEqual = initButton("=", x[2], y[5], event -> {

            String relativePath = "\\src\\hy\\resources\\Python37\\python.exe";
            String currentPath = System.getProperty("user.dir") + relativePath;
            try {
                ProcessBuilder pb = new ProcessBuilder(currentPath, "-c", String.format("print(%s)", inText.getText()));
                Process p = pb.start();
                BufferedReader in = new BufferedReader(new InputStreamReader(p.getInputStream()));
                String outPut;
                while ((outPut = in.readLine()) != null) {
                    if (outPut.length() > 14) {
                        outPut = outPut.substring(0, 13) + outPut.charAt(outPut.length() - 1);
                    } else {
                        inText.setText(outPut);
                    }
                    inText.setText(outPut);
//                    System.out.println(outPut);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        buttonEqual.setSize(2 * BUTTON_WIDTH + 10, BUTTON_HEIGHT);

        JButton[] buttonList = {button0, button1, button2, button3, button4, button5, button6, button7, button8, button9, buttonPoint,
                buttonClear, buttonBackspace,
                buttonModule, buttonDivision, buttonMultiplication, buttonSubtraction, buttonAddition, buttonEqual};
        for (int i = 0; i <= 18; i++) {
            buttonList[i].setBorder(new RoundedBorder(20));

            buttonList[i].setUI(new GradientButtonTextUI(buttonList[i]));
            buttonList[i].setContentAreaFilled(false);
        }

        jf.setLayout(null);
        jf.setResizable(false);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        jf.setVisible(true);
    }

    private JButton initButton(String label, int x, int y, ActionListener event) {
        RoundButton button = new RoundButton(label, 10);
        button.setBounds(x, y, BUTTON_WIDTH, BUTTON_HEIGHT);
        button.setFont(new Font("宋体", Font.PLAIN, 28));
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        button.addActionListener(event);
        button.setFocusable(false);
        jf.add(button);

        return button;
    }

    private void repaintFont() {
        inText.setFont(inText.getFont().deriveFont(Font.PLAIN));
    }

    public static void main(String[] args) {
        new PrimaryCalculator();
    }
}