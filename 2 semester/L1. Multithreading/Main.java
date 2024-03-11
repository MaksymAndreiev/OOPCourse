package javalab1;

import java.util.Scanner;

import static java.lang.Math.pow;

public class Main {

    public static void main(String[] args) {
        boolean flag = true;
        ThreadSync threadSync = new ThreadSync();
        Thread thread = new Thread(threadSync);
        thread.start();
        while (flag) {
            int choice = menu();
            switch (choice) {
                case 1:
                    threadSync.myresume();
                    break;
                case 2:
                    threadSync.mysuspend();
                    break;
                case 3:
                    System.out.println(threadSync.getPi());
                    break;
                case 4:
                    System.out.println(toSting(threadSync.getTime()));
                    break;
                case 5:
                    threadSync.mystop();
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

class ThreadSync implements Runnable {
    private double pi;
    private double sum = 0;
    private int k = 0;
    private int flag = 0;
    private long time;
    private Thread thread;

    @Override
    public void run() {
        thread = Thread.currentThread();
        System.out.println("R " + thread.getState());
        long startTime = System.currentTimeMillis();
        while (flag != 2) {
            try {
                sum += pow((-1), k) / (2 * k + 1);
                pi = 4 * sum;
                time = System.currentTimeMillis() - startTime;
                k++;
                synchronized (this) {
                    if (flag == 1) {
                        wait();
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    synchronized void mysuspend() {
        flag = 1;
    }

    synchronized void myresume() {
        flag = 0;
        notify();
    }

    synchronized void mystop() {
        flag = 2;
        notify();
    }

    public double getPi() {
        return pi;
    }

    public long getTime() {
        return time;
    }
}