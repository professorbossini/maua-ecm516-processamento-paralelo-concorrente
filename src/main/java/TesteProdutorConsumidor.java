import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TesteProdutorConsumidor {
    public static void main(String[] args) throws Exception{
        ExecutorService pool = Executors.newCachedThreadPool();
        List<Integer> itens = new ArrayList<>();
        //Produtor produtor = new Produtor(itens);
        //Consumidor consumidor = new Consumidor(itens);
        //pool.submit(produtor);
        //pool.submit(consumidor);
        for (int i = 0; i < 50; i++){
            pool.submit(new Produtor (itens));
            pool.submit(new Consumidor(itens));
        }

    }
}
