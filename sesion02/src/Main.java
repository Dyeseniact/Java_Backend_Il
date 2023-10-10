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
        Thread hilo1 = new Thread(new HiloSeconds());
        Thread hilo2 = new Thread(new HiloDaemon());
        hilo2.setDaemon(true);
        hilo1.start();
        hilo2.start();
    }


}
