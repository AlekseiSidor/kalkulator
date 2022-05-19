import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MainWindow extends JFrame {
    class keylistener implements KeyListener{

        @Override
        public void keyTyped(KeyEvent e) {

        }

        @Override
        public void keyPressed(KeyEvent e) {
            System.out.println(e.getKeyCode());
            panel.keys(e);
        }

        @Override
        public void keyReleased(KeyEvent e) {

        }
    }
    MyPanel panel;
    public MainWindow(){
        super();
        addKeyListener(new keylistener());
        setFocusable(true);
        panel = new MyPanel();
        getContentPane().add(panel);
        setTitle("калькулятор");
        setDefaultCloseOperation(3);
        setResizable(false);
        setBounds(300,300,260,330);
    }
    public void run(){
        setVisible(true);
    }
}
