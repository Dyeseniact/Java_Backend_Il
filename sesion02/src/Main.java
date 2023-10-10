import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
       /* MiHilo hilo1 = new MiHilo("Uno");
        hilo1.start();

        MiHilo hilo2 = new MiHilo("Dos");
        hilo2.setDaemon(true);
        hilo2.start();

        MiHilo.pausar();
        hilo1.setParametro("terminar"); // Demostrar qué pasa si no se pone esta línea
        System.out.println("**Fin del hilo main**"); */

        //Reto 01 //
        /*HiloSeconds h1 = new HiloSeconds();
        HiloDaemon h2 = new HiloDaemon();
        h2.setDaemon(true);

        h1.start();
        h2.start();*/

        //-- Ejemplo 2-- //
        /*MiRunnable runnable1 = new MiRunnable("Uno");
        MiRunnable runnable2 = new MiRunnable("Dos");

        Thread t1 = new Thread(runnable1);
        t1.start();

        Thread t2 = new Thread(runnable2);
        t2.setDaemon(true);
        t2.start();

        MiRunnable.pausar();
        runnable1.setParametro("Terminar");
        System.out.println("----------------------------------");
        System.out.println("Fin del hilo main");
        System.out.println("----------------------------------");*/


        // Reto 02 ///
        /*Thread hilo1 = new Thread(new HiloSeconds());
        Thread hilo2 = new Thread(new HiloDaemon());
        hilo2.setDaemon(true);
        hilo1.start();
        hilo2.start();*/

        // Ejemplo 03 //

        ExecutorService pool = Executors.newCachedThreadPool();
        String[] nombres = {"uno", "dos", "tres"};
        for (String nombre : nombres) {
            pool.execute(new MiRunnablePool(nombre));
        }
        System.out.println("Estado del pool antes de apagar: isShutdown()=" + pool.isShutdown() + ", isTerminated()=" + pool.isTerminated());
        pool.shutdown(); // Apagamos el pool para que no pueda recibir nuevos hilos

        //pool.execute(new MiRunnablePool("Cuatro")); // si tratamos de hacer esto recibiremos una excepción
        System.out.println("Estado del pool después de apagar: isShutdown()=" + pool.isShutdown() + ", isTerminated()=" + pool.isTerminated());

        try {
            long tiempoLimiteMs = 100;
            System.out.println("Esperando que los hilos finalicen en " + tiempoLimiteMs + "ms...");

            boolean terminaron = pool.awaitTermination(tiempoLimiteMs, TimeUnit.MILLISECONDS); //Esperamos a los hilos por 100ms, retorna true si acabaron antes o hasta los 100ms o false si fueron interrumpidos
            System.out.println("¿Terminaron nuestros hilos? " +  terminaron);

            if(!terminaron){
                System.out.println("Llamando a shutdownNow()...");
                List<Runnable> pendientes = pool.shutdownNow(); //Termina los hilos que se estén ejecutando y retorna una lista de hilos pendientes a ejecutarse
                System.out.println(pendientes.size() + " hilos pendientes");
                terminaron = pool.awaitTermination(tiempoLimiteMs, TimeUnit.MILLISECONDS); //esperando otros 100ms a que terminen nuestros hilos

                if(!terminaron){
                    System.out.println("Aún hay hilos pendientes");
                }
                System.out.println("Saliendo de main");
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
