import java.util.concurrent.TimeUnit;

public class HiloDaemon extends Thread {
    @Override
    public void run() {
        while(true){
            System.out.println("Hilo2: Sigo en ejecución...");
            try {
                TimeUnit.MILLISECONDS.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
