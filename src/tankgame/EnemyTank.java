package tankgame;

import java.util.Vector;

public class EnemyTank extends Tank implements Runnable {

    Vector<Ammo> EnemyAmmos = new Vector<>();
    boolean isLive = true;

    EnemyTank(int x, int y, int speed, int direction, int speedOfAmmo, int radiusOfAmmo, CoolDown coolDown) {
        super(x, y, speed, direction, speedOfAmmo, radiusOfAmmo, coolDown);
    }

    public static EnemyTank getEnemyTank(int x, int y, int direction) {
        return new EnemyTank(x, y, 5, direction, 10, 1, new CoolDown(2000));
    }

    public Vector<Ammo> getEnemyAmmos() {
        return EnemyAmmos;
    }

    public boolean isLive() {
        return isLive;
    }

    @Override
    public void setLive(boolean live) {
        isLive = live;
    }

    @Override
    @SuppressWarnings({"BusyWait"})
    public void run() {
        while (isLive) {
            EnemyAmmos.add(new Ammo(getX(), getY() + EnemyTank.H_WHEEL_HEIGHT + getRadiusOfAmmo() + 1, getDirection(), 3, getFrequencyOfAmmo()));
            new Thread(EnemyAmmos.getLast()).start();
            try {
                Thread.sleep(getShotCDTime().getCDTime());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
