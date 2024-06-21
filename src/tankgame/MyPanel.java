package tankgame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Vector;

public class MyPanel extends JPanel implements KeyListener, Runnable {
    private static final Hero hero = Hero.getHero(0);
    private static final Vector<EnemyTank> enemyTanks = new Vector<>();
    private static boolean gameOver = false;
    public MyPanel() {
        new Thread(hero).start();
        int initialCount = 3;
        for (int i = 0; i < initialCount; i++) {
            enemyTanks.add(EnemyTank.getEnemyTank((i + 1) * 100, 100, 2));
            new Thread(enemyTanks.get(i)).start();
        }
    }

    public static Hero getHero() {
        return hero;
    }

    public static void setGameOver(boolean gameOver) {
        MyPanel.gameOver = gameOver;
    }

    public static Vector<EnemyTank> getEnemyTanks() {
        return enemyTanks;
    }
    public void paint(Graphics g) {
        super.paint(g);
        g.fillRect(0, 0, 1000, 750);


        for (EnemyTank enemyTank : enemyTanks) {
            drawTank(enemyTank.getX(), enemyTank.getY(), g, enemyTank.getDirection(), 1);
            if (!enemyTank.getEnemyAmmos().isEmpty()) {
                Ammo ammo;
                for (int i = 0; i < enemyTank.getEnemyAmmos().size(); i++) {
                    ammo = enemyTank.getEnemyAmmos().get(i);
                    if (!ammo.isLive) enemyTank.getEnemyAmmos().remove(ammo);
                    else drawAmmo(ammo, g);
                }
            }
        }
        drawTank(hero.getX(), hero.getY(), g, hero.getDirection(), 0);

        if (!hero.getAmmo().isEmpty()) {
            Ammo ammo;
            for (int i = 0; i < hero.getAmmo().size(); i++) {
                ammo = hero.getAmmo().get(i);
                if (!ammo.isLive) hero.getAmmo().remove(ammo);
                else drawAmmo(ammo, g);
            }
        }

        if (gameOver) gameOver(g);
    }

    public static boolean hitTank(Ammo ammo, Tank tank) {
        switch (tank.getDirection()) {
            case 0, 2 -> {
                if (ammo.x + ammo.getRadius() > tank.getX() - Tank.H_WHEEL_WIDTH * 2 - Tank.H_BODY_WIDTH
                        && ammo.x - ammo.getRadius()< tank.getX() + Tank.H_WHEEL_WIDTH * 2 + Tank.H_BODY_WIDTH
                        && ammo.y + ammo.getRadius()> tank.getY() - Tank.H_WHEEL_HEIGHT
                        && ammo.y - ammo.getRadius()< tank.getY() + Tank.H_WHEEL_HEIGHT) {
                    System.out.println("接触坦克");
                    return true;
                }
            }
        }
        return false;
    }

    public void drawAmmo(Ammo ammo, Graphics g) {
        g.fillOval(ammo.x - ammo.getRadius(), ammo.y - ammo.getRadius(), ammo.getRadius() * 2, ammo.getRadius() * 2);
    }

    public void drawTank(int x, int y, Graphics g, int direction, int type) {
        switch (type) {
            case 0 -> g.setColor(Color.cyan);
            case 1 -> g.setColor(Color.yellow);
        }
        switch (direction) {
            case 0 -> {
                WAndS(x, y, g);
                g.drawLine(x, y, x, y - Tank.H_WHEEL_HEIGHT);
            }
            case 1 -> {
                AAndD(x, y, g);
                g.drawLine(x, y, x + Tank.H_WHEEL_HEIGHT, y);
            }
            case 2 -> {
                WAndS(x, y, g);
                g.drawLine(x, y, x, y + Tank.H_WHEEL_HEIGHT);

            }
            case 3 -> {
                AAndD(x, y, g);
                g.drawLine(x, y, x - Tank.H_WHEEL_HEIGHT, y);
            }
        }

    }

    public void AAndD(int x, int y, Graphics g) {
        g.fill3DRect(x - Tank.H_WHEEL_HEIGHT, y - (Tank.H_BODY_WIDTH + Tank.H_WHEEL_WIDTH * 2), Tank.H_WHEEL_HEIGHT * 2, Tank.H_WHEEL_WIDTH * 2, false);
        g.fill3DRect(x - Tank.H_WHEEL_HEIGHT, y + Tank.H_BODY_WIDTH, Tank.H_WHEEL_HEIGHT * 2, Tank.H_WHEEL_WIDTH * 2, false);
        g.fill3DRect(x - Tank.H_BODY_HEIGHT, y - Tank.H_BODY_WIDTH, Tank.H_BODY_HEIGHT * 2, Tank.H_BODY_WIDTH * 2, false);
        g.fillOval(x - Tank.H_BODY_WIDTH, y - Tank.H_BODY_WIDTH, Tank.H_BODY_WIDTH * 2, Tank.H_BODY_WIDTH * 2);
    }

    public void WAndS(int x, int y, Graphics g) {
        g.fill3DRect(x - (Tank.H_BODY_WIDTH + Tank.H_WHEEL_WIDTH * 2), y - Tank.H_WHEEL_HEIGHT, Tank.H_WHEEL_WIDTH * 2, Tank.H_WHEEL_HEIGHT * 2, false);
        g.fill3DRect(x + Tank.H_BODY_WIDTH, y - Tank.H_WHEEL_HEIGHT, Tank.H_WHEEL_WIDTH * 2, Tank.H_WHEEL_HEIGHT * 2, false);
        g.fill3DRect(x - Tank.H_BODY_WIDTH, y - Tank.H_BODY_HEIGHT, Tank.H_BODY_WIDTH * 2, Tank.H_BODY_HEIGHT * 2, false);
        g.fillOval(x - Tank.H_BODY_WIDTH, y - Tank.H_BODY_WIDTH, Tank.H_BODY_WIDTH * 2, Tank.H_BODY_WIDTH * 2);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_S) {
            hero.setDirection(2);
            hero.setSLoop(true);
        }
        if (e.getKeyCode() == KeyEvent.VK_W) {
            hero.setDirection(0);
            hero.setWLoop(true);
        }
        if (e.getKeyCode() == KeyEvent.VK_D) {
            hero.setDirection(1);
            hero.setDLoop(true);
        }
        if (e.getKeyCode() == KeyEvent.VK_A) {
            hero.setDirection(3);
            hero.setALoop(true);
        }
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            if (hero.getShotCDTime().isReady()) {
                hero.shot();
                new Thread(hero.getShotCDTime()).start();
            }

        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_W) {
            hero.setWLoop(false);
        }
        if (e.getKeyCode() == KeyEvent.VK_D) {
            hero.setDLoop(false);
        }
        if (e.getKeyCode() == KeyEvent.VK_A) {
            hero.setALoop(false);
        }
        if (e.getKeyCode() == KeyEvent.VK_S) {
            hero.setSLoop(false);
        }
    }
    public static void gameOver(Graphics g) {
        g.setColor(Color.RED);
        g.setFont(new Font("Serif", Font.BOLD, 50));
        g.drawString("GAME OVER", Main.Bound_x / 2, Main.Bound_y / 2);
    }
    @Override
    @SuppressWarnings({"InfiniteLoopStatement", "BusyWait"})
    public void run() {
        while (true) {
            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            this.repaint();
        }
    }
}
