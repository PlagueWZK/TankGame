package tankgame;

public class Tank {
    private int x;
    private int y;
    private int direction;
    private final int speed;
    private final int frequencyOfAmmo;
    private final int radiusOfAmmo;
    public static final int H_WHEEL_WIDTH = 5;
    public static final int H_WHEEL_HEIGHT = 30;
    public static final int H_BODY_WIDTH = 10;
    public static final int H_BODY_HEIGHT = 20;

    Tank(int x, int y, int speed, int frequencyOfAmmo, int radiusOfAmmo) {
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.frequencyOfAmmo = frequencyOfAmmo;
        this.radiusOfAmmo = radiusOfAmmo;
    }
    public void moveUp() {
        y-=1;
    }
    public void moveRight() {
        x+=1;
    }
    public void moveDown() {
        y+=1;
    }
    public void moveLeft() {
        x-=1;
    }
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
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
