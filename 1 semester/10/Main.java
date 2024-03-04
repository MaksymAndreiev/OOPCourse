import java.util.*;

public class Main {
    public static class MyComparator2 implements Comparator<int[]> {
        public int compare(int[] first, int[] second) {
            int count1 = 0, count2 = 0, res = 0;
            for (int i = 0; i < 4; i++) {
                if (first[i] % 2 == 0) {
                    count1++;
                }
                if (second[i] % 2 == 0) {
                    count2++;
                }
            }
            if (count1 > count2) {
                res = 1;
            } else if (count1 < count2) {
                res = -1;
            }
            return res;
        }
    }

    public static void main(String[] args) {
        class MyComparator1 implements Comparator<int[]> {
            public int compare(int[] first, int[] second) {
                int res = 0;
                int sum1 = 0;
                int sum2 = 0;
                for (int i = 0; i < 4; i++) {
                    sum1 += first[i];
                    sum2 += second[i];
                }
                if (sum1 > sum2) {
                    res = 1;
                } else if (sum1 < sum2) {
                    res = -1;
                }
                return res;
            }
        }
        int[][] mas1 = new int[4][4];
        int[][] mas2 = new int[4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                mas1[i][j] = (int) (Math.random() * 100);
                mas2[i][j] = (int) (Math.random() * 100);
            }
        }
        System.out.println("Масив 1\t\tМасив 2");
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.printf("%d ", mas1[i][j]);
            }
            System.out.printf("\t");
            for (int j = 0; j < 4; j++) {
                System.out.printf("%d ", mas2[i][j]);
            }
            System.out.println();
        }
        Arrays.sort(mas1, new MyComparator1());
        Arrays.sort(mas2, new MyComparator1());
        System.out.println("\nВсі сортування за зростанням\n\nЗа сумою рядка\n");
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.printf("%d ", mas1[i][j]);
            }
            System.out.printf("\t");
            for (int j = 0; j < 4; j++) {
                System.out.printf("%d ", mas2[i][j]);
            }
            System.out.println();
        }
        Arrays.sort(mas1, new MyComparator2());
        Arrays.sort(mas2, new MyComparator2());
        System.out.println("\nЗа кількісттю парних чисел\n");
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.printf("%d ", mas1[i][j]);
            }
            System.out.printf("\t");
            for (int j = 0; j < 4; j++) {
                System.out.printf("%d ", mas2[i][j]);
            }
            System.out.println();
        }
        Comparator<int[]> anonimComp = new Comparator<int[]>() {
            public int compare(int[] first, int[] second) {
                int res = 0;
                if (first[0] > second[0]) {
                    return 1;
                } else if (first[0] < second[0]) {
                    res = -1;
                }
                return res;
            }
        };
        Arrays.sort(mas1, anonimComp);
        Arrays.sort(mas2, anonimComp);
        System.out.println("\nЗа значенням першого елемента рядка\n");
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.printf("%d ", mas1[i][j]);
            }
            System.out.printf("\t");
            for (int j = 0; j < 4; j++) {
                System.out.printf("%d ", mas2[i][j]);
            }
            System.out.println();
        }
    }
}

