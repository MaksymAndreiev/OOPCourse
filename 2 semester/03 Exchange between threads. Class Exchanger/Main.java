import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
    public static void main(String[] args) {
        Store store = new Store();
        Producer producer1 = new Producer(store, 10, 1);
        Producer producer2 = new Producer(store, 20, 2);
        Consumer consumer = new Consumer(store, 10);
        Thread thread1 = new Thread(producer1);
        thread1.start();
        Thread thread2 = new Thread(producer2);
        thread2.start();
        Thread thread3 = new Thread(consumer);
        thread3.start();
    }
}

// Клас Магазин, який зберігає вироблені товари
class Store {
    private int product1 = 0;
    private int product2 = 0;
    ReentrantLock locker1;
    ReentrantLock locker2;
    Condition condition1;
    Condition condition2;

    Store() {
        locker1 = new ReentrantLock();
        locker2 = new ReentrantLock();
        // отримуємо умову, пов'язану з блокуванням
        condition1 = locker1.newCondition();
        condition2 = locker2.newCondition();
    }

    public void get() {
        locker1.lock();
        try {
            // поки немає доступних товарів на складі, очікуємо
            while (product1 < 1)
                condition1.await();
            product1--;
            System.out.println("Покупець купив 1 товар");
            //сигналізуємо
            condition1.signalAll();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        } finally {
            locker1.unlock();
        }
        locker2.lock();
        try {
            while (product2 < 2) {
                condition2.await();
            }
            product2 -= 2;
            System.out.println("Покупець купив 2 товарa");
            condition2.signalAll();

        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        } finally {
            locker2.unlock();
        }
        System.out.println("Товарів на складі: товар1:" + product1 + " товар 2: " + product2);
    }

    public void put(int flag) {
        try {
            if (flag == 1) {
                locker1.lock();
                while (product1 >= 3) {
                    condition1.await();
                }
                product1++;
                System.out.println("Виробник1 додав 1 товар");
                condition1.signalAll();
            } else if (flag == 2) {
                locker2.lock();
                while (product2 >= 4) {
                    condition2.await();
                }
                product2++;
                System.out.println("Виробник2 додав 1 товар");
                condition2.signalAll();
            }
            System.out.println("Товарів на складі: товар1:" + product1 + " товар 2: " + product2);
            // сигналізуємо
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        } finally {
            if (flag == 1) {
                locker1.unlock();
            } else if (flag == 2) {
                locker2.unlock();
            }
        }
    }
}

// клас Виробник
class Producer implements Runnable {
    Store store;
    private int c;
    private int flag;

    Producer(Store store, int c, int flag) {
        this.store = store;
        this.c = c;
        this.flag = flag;
    }

    public void run() {
        for (int i = 0; i < c; i++) {
            store.put(flag);
        }
    }
}

// Клас Споживач
class Consumer implements Runnable {
    Store store;
    private int c;

    Consumer(Store store, int c) {
        this.store = store;
        this.c = c;
    }

    public void run() {
        for (int i = 0; i < c; i++) {
            store.get();
        }
    }
}

