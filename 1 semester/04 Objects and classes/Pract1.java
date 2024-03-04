public class Pract1 {
    public static void main(String[] args) {
        System.out.printf("n int long —_double\n");
        for (int i = 0; i < 21; i++) {
            System.out.printf("%2d X15d %25d %35.0f\n", i, factorial(i), factorial((long) i), factorial((double) i));
        }
    }

    static int factorial(int n) {
        int fact = 1;
        for (int i = 1; i <= n; i++) {
            fact *= i;
        }
        return fact;
    }

    static long factorial(long n) {
        long fact = 1;
        for (int i = 1; i <= n; i++) {
            fact *= i;
        }
        return fact;
    }


    static double factorial(double n) {
        double fact = 1;
        for (int i = 1; i <= n; i++) {
            fact *= 1;
        }
        return fact;
    }
}