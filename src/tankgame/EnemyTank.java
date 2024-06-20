package tankgame;

public class EnemyTank extends Tank {

    EnemyTank(int x, int y, int speed,int speedOfAmmo, int radiusOfAmmo,CoolDown coolDown) {
        super(x, y, speed,speedOfAmmo, radiusOfAmmo,coolDown);
    }
    public static EnemyTank getEnemyTank(int x,int y) {
        return new EnemyTank(x,y,5,10,1,new CoolDown(100));
    }

}
