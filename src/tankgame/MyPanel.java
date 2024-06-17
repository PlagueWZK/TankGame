package tankgame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Vector;

@SuppressWarnings({"all"})
public class MyPanel extends JPanel implements KeyListener {
    Hero hero = null;
    Vector<EnemyTank> enemyTanks = new Vector<>();
    public MyPanel() {
        hero = new Hero(100, 100,5);
        int initialCount = 10;
        for (int i = 0; i < initialCount; i++) {
            enemyTanks.add(new EnemyTank(i*100,0,5));
        }
    }

    public void paint(Graphics g) {
        super.paint(g);
        g.fillRect(0, 0, 1000, 750);

        for (EnemyTank enemyTank :enemyTanks) {
            drawTank(enemyTank.getX(),enemyTank.getY(),g, enemyTank.getDirection(), 1);
        }
        drawTank(hero.getX(), hero.getY(), g, hero.getDirection(), 0);
    }

    public void drawTank(int x, int y, Graphics g, int direction, int type) {
        switch (type) {
            case 0 -> g.setColor(Color.cyan);
            case 1 -> g.setColor(Color.yellow);
        }
        switch (direction) {
            case 0 -> {
                g.fill3DRect(x, y, Tank.WIDTH, Tank.HEIGHT, false);
                g.fill3DRect(x + Tank.WIDTH + Tank.BODY_WIDTH, y, Tank.WIDTH, Tank.HEIGHT, false);
                g.fill3DRect(x + Tank.WIDTH, y + ((Tank.HEIGHT - Tank.BODY_HEIGHT) / 2), Tank.BODY_WIDTH, Tank.BODY_HEIGHT, false);
                g.fillOval(x + Tank.WIDTH, y + ((Tank.HEIGHT - Tank.BODY_HEIGHT) / 2 + (Tank.BODY_HEIGHT - Tank.BODY_WIDTH) / 2),
                        Tank.BODY_WIDTH, Tank.BODY_WIDTH);
                g.drawLine(x + Tank.WIDTH + Tank.BODY_WIDTH / 2, y + Tank.HEIGHT / 2, x + Tank.WIDTH + Tank.BODY_WIDTH / 2, y);
            }
            case 1 -> {
                g.fill3DRect(x, y, Tank.HEIGHT, Tank.WIDTH, false);
                g.fill3DRect(x, y + Tank.WIDTH + Tank.BODY_WIDTH, Tank.HEIGHT, Tank.WIDTH, false);
                g.fill3DRect(x + ((Tank.HEIGHT - Tank.BODY_HEIGHT) / 2), y + Tank.WIDTH, Tank.BODY_HEIGHT, Tank.BODY_WIDTH, false);
                g.fillOval(x + (Tank.HEIGHT - Tank.BODY_HEIGHT) / 2 + (Tank.BODY_HEIGHT - Tank.BODY_WIDTH) / 2,
                        y + Tank.WIDTH, Tank.BODY_WIDTH, Tank.BODY_WIDTH);
                g.drawLine(x + Tank.HEIGHT / 2, y + Tank.WIDTH + Tank.BODY_WIDTH / 2, x + Tank.HEIGHT, y + Tank.WIDTH + Tank.BODY_WIDTH / 2);
            }
            case 2 -> {
                g.fill3DRect(x, y, Tank.WIDTH, Tank.HEIGHT, false);
                g.fill3DRect(x + Tank.WIDTH + Tank.BODY_WIDTH, y, Tank.WIDTH, Tank.HEIGHT, false);
                g.fill3DRect(x + Tank.WIDTH, y + ((Tank.HEIGHT - Tank.BODY_HEIGHT) / 2), Tank.BODY_WIDTH, Tank.BODY_HEIGHT, false);
                g.fillOval(x + Tank.WIDTH, y + ((Tank.HEIGHT - Tank.BODY_HEIGHT) / 2 + (Tank.BODY_HEIGHT - Tank.BODY_WIDTH) / 2),
                        Tank.BODY_WIDTH, Tank.BODY_WIDTH);
                g.drawLine(x + Tank.WIDTH + Tank.BODY_WIDTH / 2, y + Tank.HEIGHT / 2, x + Tank.WIDTH + Tank.BODY_WIDTH / 2, y + Tank.HEIGHT);

            }
            case 3 -> {
                g.fill3DRect(x, y, Tank.HEIGHT, Tank.WIDTH, false);
                g.fill3DRect(x, y + Tank.WIDTH + Tank.BODY_WIDTH, Tank.HEIGHT, Tank.WIDTH, false);
                g.fill3DRect(x + ((Tank.HEIGHT - Tank.BODY_HEIGHT) / 2), y + Tank.WIDTH, Tank.BODY_HEIGHT, Tank.BODY_WIDTH, false);
                g.fillOval(x + (Tank.HEIGHT - Tank.BODY_HEIGHT) / 2 + (Tank.BODY_HEIGHT - Tank.BODY_WIDTH) / 2,
                        y + Tank.WIDTH, Tank.BODY_WIDTH, Tank.BODY_WIDTH);
                g.drawLine(x + Tank.HEIGHT / 2, y + Tank.WIDTH + Tank.BODY_WIDTH / 2, x, y + Tank.WIDTH + Tank.BODY_WIDTH / 2);
            }
        }

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_S) {
            hero.setDirection(2);
            hero.moveDown();
        }else if (e.getKeyCode() == KeyEvent.VK_W) {
            hero.setDirection(0);
            hero.moveUp();
        }else if (e.getKeyCode() == KeyEvent.VK_D) {
            hero.setDirection(1);
            hero.moveRight();
        }else if (e.getKeyCode() == KeyEvent.VK_A) {
            hero.setDirection(3);
            hero.moveLeft();
        }
        repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
