package tankgame;

import javax.swing.*;

public class Main extends JFrame {
    public static final int Bound_x = 1000;
    public static final int Bound_y = 750;
    public static MyPanel panel = new MyPanel();
    public static void main(String[] args) {
        new Main();
    }
    public Main() {
        setTitle("Tank Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(Bound_x, Bound_y);
        setVisible(true);
        add(panel);
        addKeyListener(panel);
        new Thread(panel).start();
    }
}
