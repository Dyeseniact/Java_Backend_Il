import java.util.concurrent.TimeUnit;

public class HiloSeconds implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i <= 10; i++) {
            System.out.println("Hilo1: " + i);
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
