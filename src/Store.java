public class Store {
    private Counter[] products = new Counter[100];
    public Store() {
        for (int i=0; i < products.length; i++) {
            //store with 10000 products
            products[i] = new Counter(10000);
        }
    }
    public void buyProducts(int cod1, int cod2, int cod3) {
        //may create a deadlock
        synchronized(products[cod1]){
            synchronized(products[cod2]){
                synchronized(products[cod3]){
                    //the products selected by the client is removed from the store
                    products[cod1].decrement();
                    products[cod2].decrement();
                    products[cod3].decrement();
                }
            }
        }
    }
    public int totalStock() {
        int sum = 0;
        for (int i=0; i < products.length; i++) {
            sum += products[i].value();
        }
        return sum;
    }
}
