package tankgame;

public class CoolDown implements Runnable{
    private final int CDTime;
    private boolean isReady = true;

    public CoolDown(int CDTime) {
        this.CDTime = CDTime;
    }

    public boolean isReady() {
        return isReady;
    }

    @Override
    public void run() {
        isReady = false;
        try {
            Thread.sleep(CDTime);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        isReady = true;
    }

    public int getCDTime() {
        return CDTime;
    }
}
