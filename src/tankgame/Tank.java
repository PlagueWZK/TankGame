package tankgame;

public class Tank {
    private int x;
    private int y;
    private int direction;
    private final int speed;
    public static final int WIDTH = 10;
    public static final int HEIGHT = 60;
    public static final int BODY_WIDTH = 20;
    public static final int BODY_HEIGHT = 40;
    public static final int LENGTH = 30;

    Tank(int x, int y,int speed) {
        this.x = x;
        this.y = y;
        this.speed = speed;
    }
    public void moveUp() {
        y-=speed;
    }
    public void moveRight() {
        x+=speed;
    }
    public void moveDown() {
        y+=speed;
    }
    public void moveLeft() {
        x-=speed;
    }
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public int getSpeed() {
        return speed;
    }
}
