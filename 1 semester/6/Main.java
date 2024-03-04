import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MyArray[] massiv = new MyArray[5];
        int[] ar = {3, 5, 6, 7, 12};
        int c = 0;
        int num, k = 100;
        boolean f, ff = true;
        while (ff) {
            System.out.println("1. Створити нові масиви");
            System.out.println("2. Надрукувати масиви");
            System.out.println("3. Створити копію масива ar");
            System.out.println("4. Розмір масиву");
            System.out.println("5. Надрукувати елемент");
            System.out.println("6. Переписати елемент");
            System.out.println("7. Відсортувати");
            System.out.println("8. Надрукувати елементи від і до");
            System.out.println("9. Порівняти два масива");
            System.out.println("10. Вихід");
            num = sc.nextInt();
            switch (num) {
                case 1:
                    massiv[0] = new MyArray();
                    massiv[0].fill(k);
                    System.out.println("Масив 1 успішно створено");
                    System.out.printf("Щоб створити масив 2, мені треба знати, чому дорівнює f:\n1. true\n2. false\n");
                    int p = sc.nextInt();
                    if (p == 1) {
                        f = true;
                    } else {
                        f = false;
                    }
                    massiv[1] = new MyArray(f);
                    System.out.println("Масив 2 успішно створено");
                    System.out.println("Введіть розмір 3 масиву:");
                    int sz = sc.nextInt();
                    massiv[2] = new MyArray(sz);
                    massiv[2].fill(k);
                    System.out.println("Масив 3 успішно створено");
                    System.out.println("Введіть розмір масиву 4:");
                    sz = sc.nextInt();
                    System.out.printf("Щоб створити масив 4, мені треба знати, чому дорівнює f:\n1. true\n2. false\n");
                    p = sc.nextInt();
                    if (p == 1) {
                        f = true;
                    } else {
                        f = false;
                    }
                    massiv[3] = new MyArray(sz, f);
                    massiv[3].fill(10);
                    System.out.println("Масив 4 успішно створено");
                    break;
                case 2:
                    for (int i = 0; i < 4; i++) {
                        System.out.printf("Масив %d: ", i + 1);
                        System.out.println(massiv[i].toString());
                    }
                    if (c > 0) {
                        System.out.print("Масив-копія масиву ar: ");
                        System.out.println(massiv[4].toString());
                    }
                    break;
                case 3:
                    c++;
                    System.out.print("Масив ar:");
                    for (int i = 0; i < ar.length; i++) {
                        System.out.print(ar[i] + " ");
                    }
                    System.out.println();
                    massiv[4] = new MyArray(ar);
                    System.out.print("Копія:");
                    System.out.println(massiv[4].toString());
                    break;
                case 4:
                    System.out.printf("1. Масив 1\n2. Масив 2\n3. Масив 3\n4. Масив 4\n");
                    if (c > 0) {
                        System.out.printf("5. Масив-копія масиву ar\n");
                    }
                    int n = sc.nextInt();
                    System.out.println(massiv[n - 1].size());
                    break;
                case 5:
                    System.out.printf("1. Масив 1\n2. Масив 2\n3. Масив 3\n4. Масив 4\n");
                    if (c > 0) {
                        System.out.printf("5. Масив-копія масиву ar\n");
                    }
                    n = sc.nextInt();
                    System.out.println("Введіть індекс елементу (нумерація починається з 0):");
                    int index = sc.nextInt();
                    System.out.println(massiv[n - 1].get(index));
                    break;
                case 6:
                    System.out.printf("1. Масив 1\n2. Масив 2\n3. Масив 3\n4. Масив 4\n");
                    if (c > 0) {
                        System.out.printf("5. Масив-копія масиву ar\n");
                    }
                    n = sc.nextInt();
                    System.out.println("Введіть індекс елементу (нумерація починається з 0):");
                    index = sc.nextInt();
                    System.out.println("Нове значення:");
                    int newValue = sc.nextInt();
                    System.out.println("Старий елемент:");
                    System.out.println(massiv[n - 1].set(index, newValue));
                    break;
                case 7:
                    System.out.printf("1. Масив 1\n2. Масив 2\n3. Масив 3\n4. Масив 4\n");
                    if (c > 0) {
                        System.out.printf("5. Масив-копія масиву ar\n");
                    }
                    n = sc.nextInt();
                    System.out.printf("Відсортувати у порядку:\n1. Зростання\n2. Спадання\n");
                    p = sc.nextInt();
                    if (p == 1) {
                        f = true;
                    } else {
                        f = false;
                    }
                    massiv[n - 1].sort(f);
                    break;
                case 8:
                    System.out.printf("1. Масив 1\n2. Масив 2\n3. Масив 3\n4. Масив 4\n");
                    if (c > 0) {
                        System.out.printf("5. Масив-копія масиву ar\n");
                    }
                    n = sc.nextInt();
                    System.out.println("Введіть індекс елементу з якого почати (нумерація починається з 0):");
                    int indexFrom = sc.nextInt();
                    System.out.println("Введіть індекс елементу яким закінчити (нумерація починається з 0):");
                    int indexTo = sc.nextInt();
                    int[] array = massiv[n - 1].subArray(indexFrom, indexTo);
                    for (int i = 0; i < array.length; i++) {
                        System.out.print(array[i] + " ");
                    }
                    System.out.println();
                    break;
                case 9:
                    System.out.printf("1. Масив 1\n2. Масив 2\n3. Масив 3\n4. Масив 4\n");
                    if (c > 0) {
                        System.out.printf("5. Масив-копія масиву ar\n");
                    }
                    int n1 = sc.nextInt();
                    System.out.printf("1. Масив 1\n2. Масив 2\n3. Масив 3\n4. Масив 4\n");
                    if (c > 0) {
                        System.out.printf("5. Масив-копія масиву ar\n");
                    }
                    int n2 = sc.nextInt();
                    System.out.println(massiv[n1 - 1].equals(massiv[n2 - 1]));
                    break;
                case 10:
                    ff = false;
                    break;
            }
        }
    }
}

class MyArray {
    private int[] mas;

    public MyArray() {
        this(8, false);
    }

    public MyArray(boolean f) {
        this.mas = new int[8];
        if (f == true) {
            fill(10);
        } else {
            fill(100);
        }
    }

    public MyArray(int size) {
        this(size, false);
    }

    public MyArray(int size, boolean f) {
        if (size > 0) {
            this.mas = new int[size];
        } else {
            this.mas = new int[8];
        }
        if (f == true) {
            fill(10);
        } else {
            fill(100);
        }
    }

    public MyArray(int[] ar) {
        this.mas = new int[ar.length];
        for (int i = 0; i < ar.length; i++) {
            mas[i] = ar[i];
        }
    }

    public void fill(int k) {
        for (int i = 0; i < mas.length; i++) {
            mas[i] = (int) (Math.random() * k);
        }
    }

    public String toString() {
        String str = "";
        for (int i = 0; i < mas.length - 1; i++) {
            str = str + mas[i] + ", ";
        }
        return "[" + str + mas[mas.length - 1] + "]";
    }

    public int size() {
        return mas.length;
    }

    public int get(int index) {
        if ((index < mas.length) && (index >= 0)) {
            return mas[index];
        } else {
            return -1;
        }
    }

    public int set(int index, int newValue) {
        if ((index >= mas.length) || (index < 0)) {
            return -1;
        }
        int tmp = mas[index];
        mas[index] = newValue;
        return tmp;
    }

    public void sort(boolean f) {
        int tmp;
        if (f == true) {
            for (int i = mas.length - 1; i > 0; i--) {
                for (int j = 0; j < i; j++) {
                    if (mas[j] > mas[j + 1]) {
                        tmp = mas[j];
                        mas[j] = mas[j + 1];
                        mas[j + 1] = tmp;
                    }
                }
            }
        }
        if (f == false) {
            for (int i = mas.length - 1; i > 0; i--) {
                for (int j = 0; j < i; j++) {
                    if (mas[j + 1] > mas[j]) {
                        tmp = mas[j + 1];
                        mas[j + 1] = mas[j];
                        mas[j] = tmp;
                    }
                }
            }
        }
    }

    public int[] subArray(int indexFrom, int indexTo) {
        int[] newmas = new int[indexTo - indexFrom + 1];
        for (int i = 0; i < newmas.length; i++) {
            newmas[i] = mas[indexFrom + i];
        }
        System.out.println();
        return newmas;
    }

    public boolean equals(MyArray other) {
        int c = 0;
        if (this == other) {
            return true;
        } else if (this.mas.length == other.mas.length) {
            for (int i = 0; i < this.mas.length; i++) {
                if (this.mas[i] == other.mas[i]) {
                    c++;
                }
            }
            if (c != this.mas.length) {
                return false;
            } else {
                return true; //это не произойдет но компилятор требует
            }
        } else {
            return false;
        }
    }
}

