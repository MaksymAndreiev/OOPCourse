import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String[] args) {
        Store store = new Store();
        Producer producer = new Producer(store);
        Consumer consumer = new Consumer(store);
        Thread thread1 = new Thread(producer);
        Thread thread2 = new Thread(consumer);
        thread1.start();
        thread2.start();
        try {
            thread1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

// Клас Магазин, який зберігає вироблені товари
class Store {
    private int product = 0;
    Semaphore semaphore = new Semaphore(1);

    public void get() {
        boolean flag;
        flag = true;
        while (flag) {
            try {
                semaphore.acquire();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if (product >= 1) {
                product--;
                System.out.println("Покупець купив 1 товар");
                System.out.println("Товарів на складі: " + product);
                flag = false;
            }
            semaphore.release();
        }
    }

    public void put() {
        boolean flag;
        flag = true;
        while (flag) {
            try {
                semaphore.acquire();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (product < 3) {
                product++;
                System.out.println("Виробник додав 1 товар");
                System.out.println("Товарів на складі: " + product);
                flag = false;
            }
            semaphore.release();
        }
    }
}

// клас Виробник
class Producer implements Runnable {
    Store store;

    Producer(Store store) {
        this.store = store;
    }

    public void run() {
        for (int i = 1; i < 6; i++) {
            store.put();
        }
    }
}

// Клас Споживач
class Consumer implements Runnable {
    Store store;

    Consumer(Store store) {
        this.store = store;
    }

    public void run() {
        for (int i = 1; i < 6; i++) {
            store.get();
        }
    }
}