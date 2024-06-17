package tankgame;

import java.util.Vector;

public class Hero extends Tank implements Runnable{
    private final Vector<Ammo> ammos = new Vector<>();

    private boolean WLoop;
    private boolean DLoop;
    private boolean SLoop;
    private boolean ALoop;

    public void setWLoop(boolean WLoop) {
        this.WLoop = WLoop;
    }

    public void setDLoop(boolean DLoop) {
        this.DLoop = DLoop;
    }

    public void setSLoop(boolean SLoop) {
        this.SLoop = SLoop;
    }

    public void setALoop(boolean ALoop) {
        this.ALoop = ALoop;
    }

    Hero(int x, int y, int speed, int frequencyOfAmmo, int radiusOfAmmo) {
        super(x, y,speed,frequencyOfAmmo,radiusOfAmmo);
    }

    @Override
    public void run() {
       while (true) {
           if (WLoop) moveUp();
           if (DLoop) moveRight();
           if (SLoop) moveDown();
           if (ALoop) moveLeft();
           try {
               Thread.sleep(getSpeed());
           } catch (InterruptedException e) {
               throw new RuntimeException(e);
           }
       }
    }

    public Vector<Ammo> getAmmo() {
        return ammos;
    }

    public void shot() {
        switch (getDirection()) {
            case 0-> ammos.add(new Ammo(getX(),getY()- Tank.H_WHEEL_HEIGHT,0,getRadiusOfAmmo(), getFrequencyOfAmmo()));
            case 1-> ammos.add(new Ammo(getX()+ H_WHEEL_HEIGHT,getY(),1,getRadiusOfAmmo(), getFrequencyOfAmmo()));
            case 2-> ammos.add(new Ammo(getX(),getY()+ Tank.H_WHEEL_HEIGHT,2,getRadiusOfAmmo(), getFrequencyOfAmmo()));
            case 3-> ammos.add(new Ammo(getX()- H_WHEEL_HEIGHT,getY(),3,getRadiusOfAmmo(), getFrequencyOfAmmo()));
        }
        new Thread(ammos.getLast()).start();
     }

     public static Hero getHero() {
        return new Hero(500,600,10,1,5);
     }
}
