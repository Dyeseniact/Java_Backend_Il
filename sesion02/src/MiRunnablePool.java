import java.util.concurrent.TimeUnit;

public class MiRunnablePool implements Runnable{
    private String nombre;

    public MiRunnablePool(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void run() {
        try {
            while(true){
                System.out.println(nombre + " en ejecución");
                TimeUnit.SECONDS.sleep(2);
            }
        } catch (InterruptedException e){
            Thread.currentThread().interrupt();
            System.out.println(nombre + " fue interrumpido");
            System.out.println(nombre + " Thread.currentThread().isInterrupted()=" + Thread.currentThread().isInterrupted());

        }
    }
}