import java.util.*;
public class Lab {
    static int[][] mas = new int[3][4];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        fillmas();
        boolean f = true;
        while (f) {
            System.out.println(&quot;1. Створити новий масив&quot;);
            System.out.println(&quot;2. Змінити значення елемента масива&quot;);
            System.out.println(&quot;3. Відсортувати рядки масиву за зростанням

            суми елементів рядка &quot;);

            System.out.println(&quot;4. Надрукувати масив&quot;);
            System.out.println(&quot;5. Вихід&quot;);
            int num = sc.nextInt();
            switch (num) {
                case 1:
                    newmas();
                    break;
                case 2:
                    changing();
                    break;
                case 3:
                    sort();
                    break;
                case 4:
                    print();
                    break;
                case 5:
                    f = false;
                    break;
            }
        }
    }

    static void fillmas() {
        for (int i = 0; i &lt; 3; i++) {
            for (int j = 0; j &lt; 4; j++) {
                mas[i][j] = (int) (Math.random() * 100);
            }
        }
    }
    static void newmas() {
        Scanner sc = new Scanner(System.in);
        System.out.println(&quot;Введіть розміри нового розміру:&quot;);
        int n = sc.nextInt();
        int m = sc.nextInt();
        mas = new int[n][m];
        for (int i = 0; i &lt; n; i++) {
            for (int j = 0; j &lt; m; j++) {
                mas[i][j] = (int) (Math.random() * 100);
            }
        }
    }
    static void changing() {
        int counter = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println(&quot;Введіть координати елементу (i,j):&quot;);
        int k = sc.nextInt();
        int l = sc.nextInt();
        for (int i = 0; i &lt; mas.length; i++) {
            for (int j = 0; j &lt; mas[i].length; j++) {
                if (k - 1 == i &amp;&amp; l - 1 == j) {
                    System.out.println(&quot;Введіть значення елементу:&quot;);
                    mas[i][j] = sc.nextInt();
                    counter++;
                }
            }
        }
        if (counter == 0) {
            System.out.println(&quot;Не знайдено такого елементу&quot;);
        }
    }
    static void sort() {
        int tmp;
        int sum1, sum2;
        int f;
        do {
            f = 0;
            for (int i = 0; i &lt; mas.length - 1; i++) {
                sum1 = sum2 = 0;
                for (int j = 0; j &lt; mas[i].length; j++) {
                    sum1 += mas[i][j];
                    sum2 += mas[i + 1][j];
                }
                if (sum1 &gt; sum2) {
                    for (int j = 0; j &lt; mas[i].length; j++) {
                        f++;
                        tmp = mas[i][j];
                        mas[i][j] = mas[i + 1][j];
                        mas[i + 1][j] = tmp;
                    }
                }

            }
        } while (f != 0);
    }
    static void print() {
        for (int i = 0; i &lt; mas.length; i++) {
            for (int j = 0; j &lt; mas[i].length; j++) {
                System.out.printf(&quot;%d &quot;, mas[i][j]);
            }
            System.out.println();
        }
    }
}