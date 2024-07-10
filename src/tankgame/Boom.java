package tankgame;


public class Boom{
    int x,y,life = 50;
    boolean isLive = true;
    Boom(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getLife() {
        return life;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void lifeDown() {
        if (life > 0) {
            life--;
        }else {
            isLive = false;
        }
    }
}
