import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int choice;

        String name = "";
        int age = 0;
        double height = 0.0;
        double weight = 0.0;

        while (true) {
            System.out.println("1 Введіть ім’я");
            System.out.println("2 Введіть вік");
            System.out.println("3 Введіть зріст");
            System.out.println("4 Введіть вагу");
            System.out.println("5 Показати інформацію про людину");
            System.out.println("0 Вихід");

            System.out.print("Виберіть дію (введіть номер від 1 до 5, або 0 для виходу): ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Вибрано пункт 1 – ввід ім’я.");
                    System.out.print("Введіть ім'я: ");
                    scanner.nextLine();
                    name = scanner.nextLine();
                    break;
                case 2:
                    System.out.println("Вибрано пункт 2 – ввід віку.");
                    System.out.print("Введіть вік: ");
                    age = scanner.nextInt();
                    break;
                case 3:
                    System.out.println("Вибрано пункт 3 – ввід зросту.");
                    System.out.print("Введіть зріст (у см): ");
                    height = scanner.nextDouble();
                    break;
                case 4:
                    System.out.println("Вибрано пункт 4 – ввід ваги.");
                    System.out.print("Введіть вагу (у кг): ");
                    weight = scanner.nextDouble();
                    break;
                case 5:
                    System.out.println("Вибрано пункт 5 – показати інформацію про людину.");
                    System.out.println("Ім'я: " + name);
                    System.out.println("Вік: " + age);
                    System.out.println("Зріст: " + height + " см");
                    System.out.println("Вага: " + weight + " кг");
                    break;
                case 0:
                    System.out.println("Програма завершує роботу. До побачення!");
                    return;
                default:
                    System.out.println("Некоректний вибір. Будь ласка, введіть правильний номер.");
            }
        }
    }
}
