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
        System.out.println ("Produtor: " + Thread.currentThread().getName());
        while (true){
            synchronized (itens){
                //espera ocupada
                while (itens.size() >= maximo); //NO-OP
                int item = gerador.nextInt(6) + 1;
                itens.add(item);
            }
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
