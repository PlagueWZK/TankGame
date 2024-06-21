package tankgame;


public class Ammo implements Runnable{

    int x;
    int y;
    int direction;
    int frequency;
    int radius;
    boolean isLive = true;

    public Ammo(int x, int y, int direction,int radius, int frequency) {
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.direction = direction;
        this.frequency = frequency;
    }

    public int getRadius() {
        return radius;
    }

    @Override
    @SuppressWarnings({"BusyWait"})
    public void run() {
        while(isLive){
            if (!((x >= 0 && x <= Main.Bound_x) && (y >= 0 && y <= Main.Bound_y))) {
                System.out.println("子弹消失");
                isLive = false;
                break;
            }
            try {
                Thread.sleep(frequency);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            switch (direction) {
                case 0 -> y -= 1;
                case 1 -> x += 1;
                case 2 -> y += 1;
                case 3 -> x -= 1;
            }
        }
    }
}
