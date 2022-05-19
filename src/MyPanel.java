import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class MyPanel extends JPanel {
    static JTextField output = new JTextField();
    private JButton numbers[] = new JButton[10];
    private JButton back, equ, plus, minus, del, ymn;
    private Font font = new Font("SanSerif", Font.BOLD, 20);
    boolean bol = true;
    //boolean bol1 = true;
    static String t;
    double m;
    int n = 0;
    public MyPanel() {
        setLayout(null);

        back = new JButton("<");

        numbers[0] = new JButton(("0"));
        numbers[0].setBounds(70, 240, 50, 50);
        numbers[0].setFont(font);
        add(numbers[0]);


        for (int i = 0; i < 3; i++) {
            for (int m = 0; m < 3; m++) {
                numbers[i * 3 + m + 1] = new JButton((i * 3 + m + 1) + "");
                numbers[i * 3 + m + 1].setBounds(i * (50 + 10) + 10, m * (50 + 10) + 60, 50, 50);
                numbers[i * 3 + m + 1].setFont(font);
                add(numbers[i * 3 + m + 1]);
            }
        }
        output.setBounds(10, 10, 230, 45);
        output.setFont(font);
        output.setEditable(false);
        add(output);
        //=======================================
            ActionListener l = (ActionEvent e) -> {
                JButton b = (JButton) e.getSource();
                output.setText(output.getText() + b.getText());
            };

            for (JButton b : numbers) {
                b.addActionListener(l);
            }
        //========================================
        back = new JButton("<");
        back.setFont(font);
        back.setBounds(10, 240, 50, 50);
        back.addActionListener(e -> back());
        add(back);

        equ = new JButton("=");
        equ.setFont(font);
        equ.setBounds(130, 240, 50, 50);
        equ.addActionListener(e -> equals());
        add(equ);

        plus = new JButton("+");
        plus.setFont(font);
        plus.setBounds(190, 60, 50, 50);
        plus.addActionListener(e -> plus());
        add(plus);

        minus = new JButton("-");
        minus.setFont(font);
        minus.setBounds(190, 120, 50, 50);
        minus.addActionListener(e -> minus());
        add(minus);

        ymn = new JButton("*");
        ymn.setFont(font);
        ymn.setBounds(190, 180, 50, 50);
        ymn.addActionListener(e -> ymn());
        add(ymn);

        del = new JButton("/");
        del.setFont(font);
        del.setBounds(190, 240, 50, 50);
        del.addActionListener(e -> del());
        add(del);
    }
    public void keys(KeyEvent e){
            if(e.getKeyCode() == 48) {
                output.setText(output.getText() + "0");
                bol = false;
            }
            else if (e.getKeyCode() == 49){
                output.setText(output.getText() + "1");
                 bol = false;
            }
            else if (e.getKeyCode() == 50) {
                output.setText(output.getText() + "2");
                bol = false;
            }
            else if (e.getKeyCode() == 51){
                output.setText(output.getText() + "3");
                bol = false;
            }
            else if (e.getKeyCode() == 52){
                output.setText(output.getText() + "4");
                bol = false;
            }
            else if (e.getKeyCode() == 53){
                output.setText(output.getText() + "5");
                bol = false;
            }
            else if (e.getKeyCode() == 54){
                output.setText(output.getText() + "6");
                bol = false;
            }
            else if (e.getKeyCode() == 55){
                output.setText(output.getText() + "7");
                bol = false;
            }
            else if (e.getKeyCode() == 56){
                output.setText(output.getText() + "8");
                bol = false;
            }
            else if (e.getKeyCode() == 57){
                output.setText(output.getText() + "9");
                bol = false;
            }
            else if (e.getKeyCode() == 107 && !bol){
                plus();
            }
            else if (e.getKeyCode() == 109 && !bol){
                minus();
            }
            else if (e.getKeyCode() == 106 && !bol){
                ymn();
            }
            else if (e.getKeyCode() == 107 && !bol){
                del();
            }
            else if (e.getKeyCode() == 10 && !bol){
                equals();
            }
            else if (e.getKeyCode() == 8 && !bol){
                back();
            }
    }



    private void back() {
        output.setText("");
        n = 0;
        m = 0;
    }

    private void plus() {
        String t1 = output.getText();
        String[] str = t1.split(" ");
        if (!bol && str.length < 2) {
            output.setText(output.getText() + " " + plus.getText() + " ");
            bol = true;
            n++;
        }if(n > 0 && str.length > 2){
            equals();
            output.setText("");
            output.setText(m+" + ");
            n = 0;
        }
    }

    private void minus() {
        String t1 = output.getText();
        String[] str = t1.split(" ");
        if (!bol && str.length < 2) {
            output.setText(output.getText() + " " + minus.getText() + " ");
            bol = true;
            n++;
        }if(n > 0 && str.length > 2) {
            equals();
            output.setText("");
            output.setText(m + " - ");
            n = 0;
        }
    }

    private void ymn() {
        String t1 = output.getText();
        String[] str = t1.split(" ");
        if (!bol && str.length < 2) {
            output.setText(output.getText() + " " + ymn.getText() + " ");
            bol = true;
            n++;
        }if(n > 0 && str.length > 2) {
            equals();
            output.setText("");
            output.setText(m + " * ");
            n = 0;
        }
    }

    private void del() {
        String t1 = output.getText();
        String[] str = t1.split(" ");
        if (!bol && str.length < 2) {
            output.setText(output.getText() + " " + del.getText() + " ");
            bol = true;
            n++;
        }if(n > 0 && str.length > 2) {
            equals();
            output.setText("");
            output.setText(m + " / ");
            n = 0;
        }
    }

    public void equals() {
        String t = output.getText();
        String[] str = t.split(" ");
        if(str.length > 2) {
            m = Double.parseDouble(str[0]);
            double d = Double.parseDouble(str[str.length - 1]);
            if (str[str.length-2].equals("+")) {
                m += d;
            } else if (str[str.length-2].equals("-")) {
                m -= d;
            } else if (str[str.length-2].equals("*")) {
                m *= d;
            } else if (str[str.length-2].equals("/")) {
                m /= d;
            }
            output.setText("");
            output.setText(m + "");
            }
        }
    }