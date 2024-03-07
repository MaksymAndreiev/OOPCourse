import java.util.*;

public class Main {
    public static void main(String[] args) {
        int[][] mas = new int[4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                mas[i][j] = (int) (Math.random() * 100);
            }
        }
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.printf("%d ", mas[i][j]);
            }
            System.out.println();
        }
        Arrays.sort(mas, (first, second) -> {
            int sum1 = 0, sum2 = 0;
            for (int i = 0; i < first.length; i++) {
                sum1 += first[i];
            }
            for (int i = 0; i < second.length; i++) {
                sum2 += second[i];
            }
            if (sum1 > sum2) {
                return 1;
            } else if (sum1 < sum2) {
                return -1;
            } else {
                return 0;
            }
        });
        System.out.println("\nЗа сумою рядка\n");
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.printf("%d ", mas[i][j]);
            }
            System.out.println();
        }
        Arrays.sort(mas, (first, second) -> {
            int count1 = 0, count2 = 0;
            for (int i = 0; i < first.length || i < second.length; i++) {
                if (first[i] % 10 == 0) {
                    count1++;
                }
                if (second[i] % 10 == 0) {
                    count2++;
                }
            }
            if (count1 > count2) {
                return 1;
            } else if (count2 > count1) {
                return -1;
            } else {
                return 0;
            }
        });
        System.out.println("\nЗа кількістю чисел, що діляться націло на 10\n");
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.printf("%d ", mas[i][j]);
            }
            System.out.println();
        }
        Arrays.sort(mas, (first, second) -> {
            if (first[0] > second[0]) {
                return 1;
            } else if (second[0] > first[0]) {
                return -1;
            } else {
                return 0;
            }
        });
        System.out.println("\nЗа величиною першого елемента\n");
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.printf("%d ", mas[i][j]);
            }
            System.out.println();
        }
        System.out.println("Сума парних: " + sum(mas, Main::isEven));
        System.out.println("Сума додатних: " + sum(mas, Main::isPositive));
        System.out.println("Сума від'ємних: " + sum(mas, Main::isNegative));
    }

    static boolean isEven(int n) {
        return n % 2 == 0;
    }

    static boolean isPositive(int n) {
        return n > 0;
    }

    static boolean isNegative(int n) {
        return n < 0;
    }

    private static int sum(int[][] mas, MyCheck func) {
        int sum = 0;
        for (int i = 0; i < mas.length; i++) {
            for (int j = 0; j < mas[i].length; j++) {
                if (func.isRight(mas[i][j])) {
                    sum += mas[i][j];
                }
            }
        }
        return sum;
    }
}

interface MyCheck {
    boolean isRight(int n);
}

