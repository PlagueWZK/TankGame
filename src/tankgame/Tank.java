package tankgame;

public class Tank {
    protected int x;
    protected int y;
    protected int direction;
    protected final int speed;
    protected final int frequencyOfAmmo;
    protected final int radiusOfAmmo;
    protected final CoolDown shotCDTime;

    protected boolean isLive = true;

    protected final int span = 1;
    public static final int H_WHEEL_WIDTH = 5;
    public static final int H_WHEEL_HEIGHT = 30;
    public static final int H_BODY_WIDTH = 10;
    public static final int H_BODY_HEIGHT = 20;

    Tank(int x, int y, int speed, int direction,int frequencyOfAmmo, int radiusOfAmmo,CoolDown shotCDTime) {
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.direction = direction;
        this.frequencyOfAmmo = frequencyOfAmmo;
        this.radiusOfAmmo = radiusOfAmmo;
        this.shotCDTime = shotCDTime;
    }

    public void setLive(boolean live) {
        isLive = live;
    }

    public void moveUp() {
        y-=span;
    }
    public void moveRight() {
        x+=span;
    }
    public void moveDown() {
        y+=span;
    }
    public void moveLeft() {
        x-=span;
    }
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }

    public CoolDown getShotCDTime() {
        return shotCDTime;
    }


    public int getFrequencyOfAmmo() {
        return frequencyOfAmmo;
    }

    public int getRadiusOfAmmo() {
        return radiusOfAmmo;
    }

    public int getSpeed() {
        return speed;
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }
}
