import java.util.*;

public class Pract2 {
    Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.printf("%f\n", Summa());
    }

    static double Factorial(double n) {
        double fact = 1;
        for (int i = 1; i <= n; i++) {
            fact *= i;
        }
        return fact;
    }

    static double Summa() {
        Scanner sc = new Scanner(System.in);
        double eps = 0.000001;
        double slog = 1;
        double sum = 0;
        int k = 0;
        System.out.println("Enter x:");
        int x = sc.nextInt();
        while (Math.abs(slog) >= eps) {
            slog = Math.pow(-1, k) * (Math.pow(x, k) / Factorial(k));
            sum += slog;
            k++;
        }
        return sum;
    }
}