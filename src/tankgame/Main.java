package tankgame;

import javax.swing.*;

public class Main extends JFrame {
    public static void main(String[] args) {
        new Main();
    }
    MyPanel panel = new MyPanel();
    public Main() {
        setTitle("Tank Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 750);
        setVisible(true);
        add(panel);
        addKeyListener(panel);
    }

}
