public class StoreClient {
    public static final int NUM_ITER = 1000;
    public static final Store store = new Store();
    static class Client extends Thread {
        private java.util.Random rand = new java.util.Random();
        public void run() {
            for (int i=0; i < NUM_ITER; i++) {
                //random number to choose a random product from the store
                int cod1 = rand.nextInt(100);
                int cod2 = rand.nextInt(100);
                int cod3 = rand.nextInt(100);
                store.buyProducts(cod1, cod2, cod3);
            }
        }
    }
    public static void main(String[] args) throws Exception {
        Thread a = new Client();
        Thread b = new Client();
        a.start();
        b.start();
        a.join();
        b.join();
        System.out.println("Final stock: " + store.totalStock());
    }
}
