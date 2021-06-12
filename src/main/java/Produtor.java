import java.util.List;
import java.util.Random;

public class Produtor implements Runnable{

    private List<Integer> itens;
    private int maximo = 1;
    private Random gerador = new Random();

    public Produtor (List <Integer> itens){
        this.itens = itens;
    }
    @Override
    public void run(){
        //System.out.println ("Produtor: " + Thread.currentThread().getName());
        while (true){
            synchronized (itens){
               while (itens.size() >= maximo){
                    try {
                        itens.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                int item = gerador.nextInt(6) + 1;
                System.out.printf ("Item produzido(%s): %d\n", Thread.currentThread().getName(), item);
                itens.add(item);
                itens.notifyAll();
            }
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
