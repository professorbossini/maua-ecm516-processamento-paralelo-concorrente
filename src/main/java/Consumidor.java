import java.util.List;

public class Consumidor implements Runnable{

    private List<Integer> itens;
    private int total;

    public Consumidor (List <Integer> itens){
        this.itens = itens;
    }

    @Override
    public void run() {
        System.out.println ("Consumidor: " + Thread.currentThread().getName());
        while (true){
            synchronized (itens){
                //espera ocupada
                while (itens.isEmpty());//NO-OP
                int item = itens.get(0);
                System.out.println("Consumido: " + item);
                total += item;
                System.out.println ("Total: " + total);
                itens.remove(0);
            }
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
