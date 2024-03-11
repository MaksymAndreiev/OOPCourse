import java.util.*;

public class Main {

    public static void main(String[] args) {
        MyQueue q = new MyQueue();
        MyStack s = new MyStack();
        Container[] mas = new Container[2];
        mas[0] = new MyQueue2();
        mas[1] = new MyStack2();
        double tmp;
        System.out.println("-------- Черга 1 --------");
        System.out.print("Черга ");
        for (int i = 0; i < 5; i++) {
            tmp = i + 1;
            System.out.print(tmp + " ");
            q.enqueue(tmp);
        }
        System.out.println();
        System.out.println("Голова черги " + q.peek());
        System.out.println("Розмір черги " + q.getSize());
        System.out.println("Видалили " + q.dequeue());
        System.out.println("Голова черги " + q.peek());
        System.out.println("Розмір черги " + q.getSize());
        System.out.println("Очищуємо чергу");
        q.clear();
        System.out.println("Розмір черги " + q.getSize());
        System.out.println("-------- Стек 1 --------");
        System.out.print("Стек ");
        for (int i = 0; i < 5; i++) {
            tmp = i + 2;
            System.out.print(tmp + " ");
            s.push(tmp);
        }
        System.out.println();
        System.out.println("Голова стеку " + s.peek());
        System.out.println("Розмір стеку " + s.getSize());
        for (int i = 0; i < 2; i++) {
            System.out.println("Видалили " + s.pop());
            System.out.println("Голова стеку " + s.peek());
            System.out.println("Розмір стеку " + s.getSize());
        }
        System.out.println("Очищуємо стек");
        s.clear();
        System.out.println("Розмір стеку " + s.getSize());
        System.out.println("-------- Черга 2 --------");
        System.out.print("Черга ");
        for (int i = 0; i < 5; i++) {
            tmp = i + 1.5;
            System.out.print(tmp + " ");
            mas[0].put(tmp);
        }
        System.out.println();
        System.out.println("Голова черги " + mas[0].peek());
        System.out.println("Розмір черги " + mas[0].getSize());
        for (int i = 0; i < 3; i++) {
            System.out.println("Видалили " + mas[0].get());
            System.out.println("Голова черги " + mas[0].peek());
            System.out.println("Розмір черги " + mas[0].getSize());
        }
        System.out.println("Очищуємо чергу");
        mas[0].clear();
        System.out.println("Розмір черги " + mas[0].getSize());
        System.out.println("-------- Стек 2 --------");
        System.out.print("Стек ");
        for (int i = 0; i < 5; i++) {
            tmp = i + 1.33;
            System.out.print(tmp + " ");
            mas[1].put(tmp);
        }
        System.out.println();
        System.out.println("Голова стеку " + mas[1].peek());
        System.out.println("Розмір стеку " + mas[1].getSize());
        for (int i = 0; i < 4; i++) {
            System.out.println("Видалили " + mas[1].get());
            System.out.println("Голова стеку " + mas[1].peek());
            System.out.println("Розмір стеку " + mas[1].getSize());
        }
        System.out.println("Очищуємо стек");
        mas[1].clear();
        System.out.println("Розмір стеку " + s.getSize());
    }
}

interface IMyQueue {
    void enqueue(double val); // додати елемент в кінець черги

    double dequeue(); // забрати елемент з початку черги

    double peek();// подивитись на початок черги (не забирати)

    int getSize(); // кількість елементів в черзі

    void clear(); // очистити чергу
}

interface IMyStack {
    void push(double val); // додати елемент в кінець стеку

    double pop(); // забрати елемент з кінця стеку

    double peek();// подивитись на кінець стеку(не забирати)

    int getSize(); // кількість елементів в стеку

    void clear(); // очистити стек
}

interface Container {
    void put(double val); // додати елемент

    double get(); // забрати елемент

    double peek();// подивитись елемент (не забирати)

    int getSize(); // кількість елементів в контейнері

    void clear(); // очистити контейнер
}

class MyQueue implements IMyQueue {
    private ArrayList<Double> v = new ArrayList<>(); // композиція

    public void enqueue(double val) { // делегування
        v.add(val);
    }

    @Override
    public double dequeue() {
        double val = v.remove(0);
        return val;
    }

    @Override
    public double peek() {
        return v.get(0);
    }

    @Override
    public int getSize() {
        return v.size();
    }

    @Override
    public void clear() {
        v.clear();
    }

}

class MyQueue2 implements Container {
    private MyQueue mq = new MyQueue(); // композиція
    // додати елемент в кінець черги

    public void put(double val) {
        mq.enqueue(val);
    }

    public double get() {
        return mq.dequeue();
    }

    public double peek() {
        return mq.peek();
    }

    public int getSize() {
        return mq.getSize();
    }

    public void clear() {
        mq.clear();
    }

}

class MyStack implements IMyStack {
    private ArrayList<Double> v = new ArrayList<>();

    public void push(double val) {
        v.add(val);
    }

    public double pop() {
        double val = v.remove(v.size() - 1);
        return val;
    }

    public double peek() {
        return v.get(v.size() - 1);
    }

    public int getSize() {
        return v.size();
    }

    public void clear() {
        v.clear();
    }

}

class MyStack2 implements Container {
    private MyStack ms = new MyStack();

    public void put(double val) {
        ms.push(val);

    }

    public double get() {
        return ms.pop();
    }

    public double peek() {
        return ms.peek();
    }

    public int getSize() {
        return ms.getSize();
    }

    public void clear() {
        ms.clear();
    }

}
