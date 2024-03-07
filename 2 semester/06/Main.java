import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String nm = null;
        int i = 0;
        try (Scanner scanner = new Scanner(new File("src/movies.csv"))) {
            String header = scanner.nextLine();
            while (i < 24951) {
                String s = scanner.nextLine();
                i++;
            }
            while (/*scanner.hasNextLine()*/ i < 24955) {
                String s = scanner.nextLine();
                String[] strings = s.split(",");
                if (strings.length < 4) {
                    nm = strings[1];
                } else if (strings.length >= 4) {
                    strings[1] = strings[1].substring(1);
                    String s1 = strings[strings.length - 2];
                    s1 = s1.substring(0, s1.length() - 1);
                    strings[strings.length - 2] = s1;
                    nm = strings[1];
                    for (int j = 2; j < strings.length - 1; j++) {
                        nm += ',' + strings[j];
                    }
                }
                System.out.println("Ідентифікаційний номер: " + strings[0]);
                System.out.println("Ім'я: " + nm);
                System.out.println("Жанри: " + strings[strings.length - 1] + "\n");
                i++;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}

