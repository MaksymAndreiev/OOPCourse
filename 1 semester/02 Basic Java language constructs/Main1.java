import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введіть ім'я: ");
        String name = scanner.nextLine();
        System.out.print("Введіть вік: ");
        int age = scanner.nextInt();
        System.out.print("Введіть зріст (у см): ");
        double height = scanner.nextDouble();
        System.out.print("Введіть вагу (у кг): ");
        double weight = scanner.nextDouble();
        System.out.printf("Ім'я: %s\nВік: %d\nЗріст: %.2f см\nВага: %.2f кг\n", name, age, height, weight);
        scanner.close();
    }
}
