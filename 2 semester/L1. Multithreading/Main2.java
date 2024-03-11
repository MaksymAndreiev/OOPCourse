package javalab1;

import java.util.Scanner;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

import static java.lang.Math.pow;
import static java.lang.Thread.sleep;

public class Main2 {
    public static void main(String[] args) {
        boolean flag = true;
        ThreadLock threadLock = new ThreadLock();
        Thread thread = new Thread(threadLock);
        thread.start();
        while (flag) {
            int choice = menu();
            switch (choice) {
                case 1:
                    threadLock.myresume();
                    break;
                case 2:
                    threadLock.mysuspend();
                    break;
                case 3:
                    System.out.println(threadLock.getPi());
                    break;
                case 4:
                    System.out.println(toSting(threadLock.getTime()));
                    break;
                case 5:
                    threadLock.mystop();
                    flag = false;
                    break;
            }
        }
    }

    public static int menu() {
        System.out.print("1. Продовжити обчислення.\n" +
                "2. Зупинити обчислення.\n" +
                "3. Подивитися поточний результат.\n" +
                "4. Дізнатися сумарний час, витрачений на обчислення.\n" +
                "5. Вихід.\n");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        return choice;
    }

    public static String toSting(long time) {
        String string = "";
        string += time / 1000 + " с. " + time % 1000 + " мс.";
        return string;
    }
}

class ThreadLock implements Runnable {
    private double pi;
    private double sum = 0;
    private int k = 0;
    private int flag = 0;
    private long time;
    private Thread thread;
    ReentrantLock locker;
    Condition condition;

    ThreadLock() {
        locker = new ReentrantLock();
        condition = locker.newCondition();
    }

    @Override
    public void run() {
        thread = Thread.currentThread();
        System.out.println("R " + thread.getState());
        long startTime = System.currentTimeMillis();
        while (flag != 2) {
            sum += pow((-1), k) / (2 * k + 1);
            pi = 4 * sum;
            time = System.currentTimeMillis() - startTime;
            k++;
            locker.lock();
            try {
                if (flag == 1) {
                    condition.await();
                }
                condition.signalAll();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                locker.unlock();
            }
        }
    }

    void mysuspend() {
        locker.lock();
        flag = 1;
        locker.unlock();
    }

    void myresume() {
        locker.lock();
        flag = 0;
        condition.signal();
        locker.unlock();
    }

    void mystop() {
        locker.lock();
        flag = 2;
        condition.signalAll();
        locker.unlock();
    }

    public double getPi() {
        return pi;
    }

    public long getTime() {
        return time;
    }
}