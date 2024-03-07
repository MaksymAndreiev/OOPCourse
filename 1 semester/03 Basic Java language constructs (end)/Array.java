import java.util.*;

public class Array {
    static int[] mas = new int[10];

    public static void main(String[] args) {
        boolean f = true;
        Scanner sc = new Scanner(System.in);
        while (f) {
            System.out.println("1. Заполнить массив случайными числами");
            System.out.println("2. Изменить значение элемента массива");
            System.out.println("3. Отсортировать элементы");
            System.out.println("4. Напечатать массив");
            System.out.println("5. Выход");
            int number = sc.nextInt();
            switch (number) {
                case 1:
                    fillRndmas();
                    break;
                case 2:
                    itemReplacement();
                    break;
                case 3:
                    Sort();
                    break;
                case 4:
                    printMas();
                    break;
                case 5:
                    f = false;
                    break;
            }
        }

    }

    static void fillRndmas() {
        for (int i = 0; i < mas.length; i++) {
            mas[i] = (int) (Math.random() * 10);
        }
    }

    static void itemReplacement() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите номер элемента:");
        int i = sc.nextInt();
        System.out.println("Введите новый элемент:");
        int p = sc.nextInt();
        mas[i] = p;
    }

    static void printMas() {
        for (int i = 0; i < mas.length; i++) {
            System.out.print(mas[i] + " ");
        }
        System.out.println();
    }

    static void Sort() {
        for (int i = mas.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (mas[j] > mas[j + 1]) {
                    int tmp = mas[j];
                    mas[j] = mas[j + 1];
                    mas[j + 1] = tmp;
                }
            }
        }
    }
}