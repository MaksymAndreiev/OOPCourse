import java.util.Scanner;

public class Lab {

    public static void main(String[] args) {
        Vector[] array = new Vector[3];
        int[] ar = {3, 5, 6, 7, 9};
        int n, i = 0;
        boolean f = true;
        Scanner sc = new Scanner(System.in);
        System.out.println("Створюю масиви...");
        array[0] = new Vector();
        System.out.println("Яка ємність буде в масиві 2? ");
        int capacity = sc.nextInt();
        array[1] = new Vector(capacity);
        array[2] = new Vector(ar);
        System.out.println("Створено!");
        System.out.println("Тепер треба заповнити. ");
        while (f) {
            System.out.printf("Скільки елементів буде в масиві %d? ", i + 1);
            n = sc.nextInt();
            for (int j = 0; j < n; j++) {
                System.out.print("Введіть елемент: ");
                int value = sc.nextInt();
                ;
                array[i].add(value);
            }
            i++;
            if (i > 1) {
                f = false;
            }
        }
        System.out.println("Заповнили! Виводжу масиви на екран:");
        for (i = 0; i < 3; i++) {
            System.out.printf("Масив %d:\t", i + 1);
            System.out.println(array[i].toString());
        }
        System.out.println("Перевіримо розмір?");
        for (i = 0; i < 3; i++) {
            System.out.printf("Масив %d:\t", i + 1);
            System.out.println(array[i].size());
        }
        System.out.println("А може якийсь масив порожній?");
        for (i = 0; i < 3; i++) {
            System.out.printf("Масив %d:\t", i + 1);
            System.out.println(array[i].isEmpty());
        }
        System.out.println("Яка ємність масивів?");
        for (i = 0; i < 3; i++) {
            System.out.printf("Масив %d:\t", i + 1);
            System.out.println(array[i].capacity());
        }
        System.out.println("Візьмемо один елемент з масиву.");
        System.out.printf("1. Масив 1\t2. Масив 2\t3.Масив 3\n");
        n = sc.nextInt();
        System.out.print("Введіть позицію елементу: ");
        int index = sc.nextInt();
        System.out.println(array[n - 1].get(index));
        System.out.println("Видалимо один елемент з масиву. Виберіть з якого масиву будемо це робити:");
        System.out.printf("1. Масив 1\t2. Масив 2\t3.Масив 3\n");
        n = sc.nextInt();
        System.out.print("Введіть позицію елементу: ");
        index = sc.nextInt();
        System.out.print("Тут раніше був такий елемент: ");
        System.out.println(array[n - 1].remove(index));
        System.out.println("Але його вже немає...");
        System.out.println("Перевіряємо:");
        System.out.println(array[n - 1].toString());
        System.out.println("Перепишемо один елемент з масиву. Виберіть у якого масиву будемо це робити:");
        System.out.printf("1. Масив 1\t2. Масив 2\t3.Масив 3\n");
        n = sc.nextInt();
        System.out.print("Введіть позицію елементу та сам елемент: ");
        index = sc.nextInt();
        int newValue = sc.nextInt();
        System.out.print("Тут раніше був такий елемент: ");
        System.out.println(array[n - 1].set(index, newValue));
        System.out.println("Перевіряємо:");
        System.out.println(array[n - 1].toString());
        System.out.println("Добавимо в кінець масиву елемент. Виберіть до якого масиву будемо це робити:");
        System.out.printf("1. Масив 1\t2. Масив 2\t3.Масив 3\n");
        n = sc.nextInt();
        System.out.print("Введіть елемент: ");
        int value = sc.nextInt();
        array[n - 1].add(value);
        System.out.println("Перевіряємо:");
        System.out.println(array[n - 1].toString());
        System.out.println("Добавимо в будь-яке місце масиву елемент. Виберіть до якого масиву будемо це робити:");
        System.out.printf("1. Масив 1\t2. Масив 2\t3.Масив 3\n");
        n = sc.nextInt();
        System.out.print("Введіть позицію елементу та сам елемент: ");
        index = sc.nextInt();
        value = sc.nextInt();
        System.out.println();
        System.out.println(array[n - 1].add(index, value));
        System.out.println("Перевіряємо:");
        System.out.println(array[n - 1].toString());
        System.out.println("Добавимо масив ar в кінець масиву. Виберіть до якого масиву будемо це робити:");
        System.out.printf("1. Масив 1\t2. Масив 2\t3.Масив 3\n");
        n = sc.nextInt();
        array[n - 1].addAll(ar);
        System.out.println("Перевіряємо:");
        System.out.println(array[n - 1].toString());
        System.out.println("Добавимо масив ar в будь-яке місце масиву. Виберіть до якого масиву будемо це робити:");
        System.out.printf("1. Масив 1\t2. Масив 2\t3.Масив 3\n");
        n = sc.nextInt();
        System.out.print("Введіть позицію: ");
        index = sc.nextInt();
        System.out.println(array[n - 1].addAll(index, ar));
        System.out.println("Перевіряємо:");
        System.out.println(array[n - 1].toString());
        System.out.println("Перевіремо чи однакові в нас масиви:");
        System.out.printf("1. Масив 1\t2. Масив 2\t3.Масив 3\n");
        System.out.print("Введіть номери масивів, які треба порівняти: ");
        int n1 = sc.nextInt();
        int n2 = sc.nextInt();
        System.out.println(array[n1 - 1].equals(array[n2 - 1]));
        System.out.println("Тепер очищуємо масиви");
        for (i = 0; i < 3; i++) {
            System.out.printf("Масив %d:\n", i + 1);
            array[i].clear();
        }
    }

}

class Vector {
    private int[] vec;
    private int size;

    public Vector() {
        this.vec = new int[8];
        this.size = 0;
    }

    public Vector(int capacity) {
        this.vec = new int[capacity];
        this.size = 0;
    }

    public Vector(int[] ar) {
        this.vec = new int[ar.length];
        this.size = ar.length;
        for (int i = 0; i < ar.length; i++) {
            vec[i] = ar[i];
        }
    }

    public String toString() {
        String str = "";
        for (int i = 0; i < size - 1; i++) {
            str = str + vec[i] + ", ";
        }
        return "[" + str + vec[size - 1] + "]";
    }

    public int size() {
        return size;
    }

    boolean isEmpty() {
        if (size == 0) {
            return true;
        } else {
            return false;
        }
    }

    public int capacity() {
        return vec.length;
    }

    int get(int index) {
        if ((index < vec.length) && (index >= 0)) {
            return vec[index];
        } else {
            return -666;
        }
    }

    int remove(int index) {
        if ((index >= size) || (index < 0)) {
            return -666;
        }
        size--;
        int tmp = vec[index];
        for (int i = index; i <= size - 1; i++) {
            vec[i] = vec[i + 1];
        }
        return tmp;
    }

    int set(int index, int newValue) {
        if ((index >= size) || (index < 0)) {
            return -666;
        }
        int tmp = vec[index];
        vec[index] = newValue;
        return tmp;
    }

    void add(int value) {
        if (size == vec.length) {
            for (int i = 0; i < vec.length; i++) {
                int[] tmp = new int[vec.length];
                for (int i1 = 0; i1 < vec.length; i1++) {
                    tmp[i1] = vec[i1];
                }
                vec = new int[size + 10];
                for (int i1 = 0; i1 < tmp.length; i1++) {
                    vec[i1] = tmp[i1];
                }
            }
        }
        ++size;
        vec[size - 1] = value;
    }

    boolean add(int index, int value) {
        if ((index > size) || (index < 0)) {
            return false;
        } else {
            if (size < vec.length) {
                for (int i = size; i > index; --i) {
                    vec[i] = vec[i - 1];
                }
                vec[index] = value;
                ++size;
                return true;
            } else {
                for (int i = 0; i < vec.length; i++) {
                    int[] tmp = new int[vec.length];
                    for (int i1 = 0; i1 < vec.length; i1++) {
                        tmp[i1] = vec[i1];
                    }
                    vec = new int[size + 10];
                    for (int i1 = 0; i1 < tmp.length; i1++) {
                        vec[i1] = tmp[i1];
                    }
                }
                return true;
            }
        }

    }

    void addAll(int[] ar) {
        int sz = size, sztmp = vec.length;
        size = size + ar.length;
        if (size > vec.length) {
            int[] tmp = new int[vec.length];
            for (int i = 0; i < vec.length; i++) {
                tmp[i] = vec[i];
            }
            vec = new int[size + 10];
            for (int i = 0; i < sztmp; i++) {
                vec[i] = tmp[i];
            }
        }
        for (int i = 0; i < ar.length; i++) {
            vec[sz + i] = ar[i];
        }
    }

    boolean addAll(int index, int[] ar) {
        int sz = size, c1 = 0, c2 = 0;
        if ((index > size) || (index < 0)) {
            return false;
        } else {
            size = size + ar.length;
            int[] tmp1 = new int[sz];
            int[] tmp2 = new int[sz];
            int j = 0;
            if (size > vec.length) {
                for (int i = 0; i < index; i++) { //сохраняю часть до индекса
                    tmp1[i] = vec[i];
                    c1++;
                }
                for (int i = index; i < sz; i++) { //сохраняю часть после индекса
                    tmp2[i] = vec[i];
                    c2++;
                }
                vec = new int[size + 10];
                for (int i = index; i < index + ar.length; i++) { //записываю массив ар
                    vec[i] = ar[j];
                    j++;
                }
                for (int i = 0; i < c1; i++) { //записываю первую часть обратно
                    vec[i] = tmp1[i];
                }
                for (int i = index + ar.length; i < index + ar.length + c2; i++) { //записываю вторую часть обратно
                    vec[i] = tmp2[i - ar.length];
                }
            } else {
                for (int i = index; i < sz; i++) { //сохраняю часть после индекса
                    tmp2[i] = vec[i];
                    c2++;
                }
                for (int i = index; i < index + ar.length; i++) { //записываю массив ар
                    vec[i] = ar[j];
                    j++;
                }
                for (int i = index + ar.length; i < index + ar.length + c2; i++) { //записываю вторую часть обратно
                    vec[i] = tmp2[i - ar.length];
                }
            }
            return true;
        }
    }

    public boolean equals(Vector other) {
        if (size == other.size) {
            for (int i = 0; i < size; i++) {
                if (vec[i] != other.vec[i]) {
                    return false;
                }
            }
            return true;
        } else {
            return false;
        }
    }

    void clear() {
        size = 0;
        System.out.println("Очищено");
    }
}
