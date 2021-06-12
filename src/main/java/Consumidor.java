import java.util.List;

public class Consumidor implements Runnable{

    private List<Integer> itens;
    private int total;

    public Consumidor (List <Integer> itens){
        this.itens = itens;
    }

    @Override
    public void run() {
        //System.out.println ("Consumidor: " + Thread.currentThread().getName());
        while (true){
            synchronized (itens){
                while (itens.isEmpty()){
                    try {
                        itens.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                total += itens.get(0);
                itens.remove(0);
                System.out.printf("Total(%s): %d\n", Thread.currentThread().getName(), total);
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
