import java.util.*;

public class Main {

    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<Integer>();
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        ArrayDeque<Integer> arrayDeque = new ArrayDeque<Integer>();
        System.out.printf("                               \tArrayList\tLinkedList\tArrayDeque\n");
        long startTimeArrayList = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            arrayList.add(0, (int) (Math.random() * 100000));
        }
        long endTimeArrayList = System.currentTimeMillis();
        long startTimeLinkedList = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            linkedList.addFirst((int) (Math.random() * 100000));
        }
        long endTimeLinkedList = System.currentTimeMillis();
        long startTimeArrayDeque = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            arrayDeque.addFirst((int) (Math.random() * 100000));
        }
        long endTimeArrayDeque = System.currentTimeMillis();
        System.out.printf("Вставка в початок\t%21d\t%10d\t%10d\n", endTimeArrayList - startTimeArrayList, endTimeLinkedList - startTimeLinkedList, endTimeArrayDeque - startTimeArrayDeque);
        startTimeArrayList = startTimeLinkedList = startTimeArrayDeque = endTimeArrayList = endTimeLinkedList = endTimeArrayDeque = 0;
        startTimeArrayList = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            arrayList.set((int) (Math.random() * 100000), (int) (Math.random() * 100000));
        }
        endTimeArrayList = System.currentTimeMillis();
        startTimeLinkedList = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            linkedList.set((int) (Math.random() * 100000), (int) (Math.random() * 100000));
        }
        endTimeLinkedList = System.currentTimeMillis();
        startTimeArrayDeque = System.currentTimeMillis();
        endTimeArrayDeque = System.currentTimeMillis();
        System.out.printf("Модифікація       \t%21d\t%10d\t%10d\n", endTimeArrayList - startTimeArrayList, endTimeLinkedList - startTimeLinkedList, endTimeArrayDeque - startTimeArrayDeque);
        startTimeArrayList = startTimeLinkedList = startTimeArrayDeque = endTimeArrayList = endTimeLinkedList = endTimeArrayDeque = 0;
        startTimeArrayList = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            arrayList.remove(0);
        }
        endTimeArrayList = System.currentTimeMillis();
        startTimeLinkedList = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            linkedList.removeFirst();
        }
        endTimeLinkedList = System.currentTimeMillis();
        startTimeArrayDeque = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            arrayDeque.removeFirst();
        }
        endTimeArrayDeque = System.currentTimeMillis();
        System.out.printf("Видалення з початку\t%21d\t%10d\t%10d\n", endTimeArrayList - startTimeArrayList, endTimeLinkedList - startTimeLinkedList, endTimeArrayDeque - startTimeArrayDeque);
        startTimeArrayList = startTimeLinkedList = startTimeArrayDeque = endTimeArrayList = endTimeLinkedList = endTimeArrayDeque = 0;
        startTimeArrayList = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            arrayList.add((int) (Math.random() * 100000));
        }
        endTimeArrayList = System.currentTimeMillis();
        startTimeLinkedList = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            linkedList.addLast((int) (Math.random() * 100000));
        }
        endTimeLinkedList = System.currentTimeMillis();
        startTimeArrayDeque = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            arrayDeque.addLast((int) (Math.random() * 100000));
        }
        endTimeArrayDeque = System.currentTimeMillis();
        System.out.printf("Вставка в кінець\t%21d\t%10d\t%10d\n", endTimeArrayList - startTimeArrayList, endTimeLinkedList - startTimeLinkedList, endTimeArrayDeque - startTimeArrayDeque);
        startTimeArrayList = startTimeLinkedList = startTimeArrayDeque = endTimeArrayList = endTimeLinkedList = endTimeArrayDeque = 0;
        startTimeArrayList = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            arrayList.remove(arrayList.size() - 1);
        }
        endTimeArrayList = System.currentTimeMillis();
        startTimeLinkedList = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            linkedList.removeLast();
        }
        endTimeLinkedList = System.currentTimeMillis();
        startTimeArrayDeque = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            arrayDeque.removeLast();
        }
        endTimeArrayDeque = System.currentTimeMillis();
        System.out.printf("Видалення з кінця\t%21d\t%10d\t%10d\n", endTimeArrayList - startTimeArrayList, endTimeLinkedList - startTimeLinkedList, endTimeArrayDeque - startTimeArrayDeque);
        startTimeArrayList = startTimeLinkedList = startTimeArrayDeque = endTimeArrayList = endTimeLinkedList = endTimeArrayDeque = 0;
        startTimeArrayList = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            int pos = (int) (arrayList.size() * Math.random());
            arrayList.add(pos, (int) (Math.random() * 100000));
        }
        endTimeArrayList = System.currentTimeMillis();
        startTimeLinkedList = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            int pos = (int) (linkedList.size() * Math.random());
            linkedList.add(pos, (int) (Math.random() * 100000));
        }
        endTimeLinkedList = System.currentTimeMillis();
        startTimeArrayDeque = System.currentTimeMillis();
        endTimeArrayDeque = System.currentTimeMillis();
        System.out.printf("Вставка в задовільне місце\t%13d\t%10d\t%10d\n", endTimeArrayList - startTimeArrayList, endTimeLinkedList - startTimeLinkedList, endTimeArrayDeque - startTimeArrayDeque);
        startTimeArrayList = startTimeLinkedList = startTimeArrayDeque = endTimeArrayList = endTimeLinkedList = endTimeArrayDeque = 0;
        startTimeArrayList = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            int pos = (int) (arrayList.size() * Math.random());
            arrayList.remove(pos);
        }
        endTimeArrayList = System.currentTimeMillis();
        startTimeLinkedList = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            int pos = (int) (linkedList.size() * Math.random());
            linkedList.remove(pos);
        }
        endTimeLinkedList = System.currentTimeMillis();
        startTimeArrayDeque = System.currentTimeMillis();
        endTimeArrayDeque = System.currentTimeMillis();
        System.out.printf("Видалення із задовільного місця\t%9d\t%10d\t%10d\n", endTimeArrayList - startTimeArrayList, endTimeLinkedList - startTimeLinkedList, endTimeArrayDeque - startTimeArrayDeque);
    }
}

