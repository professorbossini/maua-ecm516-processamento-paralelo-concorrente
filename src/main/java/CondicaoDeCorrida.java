public class CondicaoDeCorrida {
    public static void main(String[] args) throws InterruptedException {
        Atualizador a1 = new Atualizador();
        Atualizador a2 = new Atualizador();
        Thread t1 = new Thread (a1);
        Thread t2 = new Thread(a2);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(Atualizador.variavel);
    }
}
