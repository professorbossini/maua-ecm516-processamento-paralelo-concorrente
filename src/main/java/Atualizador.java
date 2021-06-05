public class Atualizador implements Runnable{
    static int variavel = 0;

    @Override
    public void run() {
        for (int i = 0; i < 100000; i++){
            synchronized (this){
                variavel = variavel + 1;
            }
        }
    }

    //    @Override
//    public synchronized void run() {
//        for (int i = 0; i < 100000; i++){
//            variavel = variavel + 1;
//        }
//    }
}

