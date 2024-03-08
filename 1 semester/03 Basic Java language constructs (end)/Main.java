import java.util.Scanner;

public class Main {
    static String name = "";
    static int age = 0;
    static double height = 0.0;
    static double weight = 0.0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int choice;

        while (true) {
            System.out.println("1 Введіть ім’я");
            System.out.println("2 Введіть вік");
            System.out.println("3 Введіть зріст");
            System.out.println("4 Введіть вагу");
            System.out.println("5 Надрукувати інформацію про людину");
            System.out.println("0 Вихід");

            System.out.print("Виберіть дію (введіть номер від 1 до 5, або 0 для виходу): ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    inputName(scanner);
                    break;
                case 2:
                    inputAge(scanner);
                    break;
                case 3:
                    inputHeight(scanner);
                    break;
                case 4:
                    inputWeight(scanner);
                    break;
                case 5:
                    printInfo();
                    break;
                case 0:
                    System.out.println("Програма завершує роботу. До побачення!");
                    return;
                default:
                    System.out.println("Некоректний вибір. Будь ласка, введіть правильний номер.");
            }
        }
    }

    static void inputName(Scanner scanner) {
        System.out.print("Введіть ім'я: ");
        scanner.nextLine();
        name = scanner.nextLine();
    }

    static void inputAge(Scanner scanner) {
        System.out.print("Введіть вік: ");
        age = scanner.nextInt();
    }

    static void inputHeight(Scanner scanner) {
        System.out.print("Введіть зріст (у см): ");
        height = scanner.nextDouble();
    }

    static void inputWeight(Scanner scanner) {
        System.out.print("Введіть вагу (у кг): ");
        weight = scanner.nextDouble();
    }

    static void printInfo() {
        System.out.println("Ім'я: " + name);
        System.out.println("Вік: " + age);
        System.out.println("Зріст: " + height + " см");
        System.out.println("Вага: " + weight + " кг");
    }
}
