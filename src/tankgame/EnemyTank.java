package tankgame;

public class EnemyTank extends Tank {

    EnemyTank(int x, int y, int speed,int speedOfAmmo, int radiusOfAmmo) {
        super(x, y, speed,speedOfAmmo, radiusOfAmmo);
    }
    public static EnemyTank getEnemyTank(int x,int y) {
        return new EnemyTank(x,y,5,10,1);
    }

}
