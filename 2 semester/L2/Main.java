import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Film> list = new ArrayList<Film>();
        boolean flag_to_exit = true;
        boolean flag_of_init = false, flag_of_add = false, flad_of_edit = false, flag_of_del = false;
        String header = "";
        while (flag_to_exit) {
            int choice = menu();
            switch (choice) {
                case 0:
                    if (flag_of_init || flad_of_edit || flag_of_add || flag_of_del) {
                        try (FileWriter fileWriter = new FileWriter("movies.txt", false)) {
                            fileWriter.write(header + '\n');
                            for (int i = 0; i < list.size(); i++) {
                                String toWrite = "";
                                if (!list.get(i).getName().contains(",")) {
                                    toWrite = list.get(i).getId() + "," + list.get(i).getName() + '(' +
                                            list.get(i).getYear() + ')' + ',' + list.get(i).getGenres() + '\n';
                                } else {
                                    toWrite = list.get(i).getId() + "," + '"' + list.get(i).getName() + '(' +
                                            list.get(i).getYear() + ')' + '"' + "," + list.get(i).getGenres() + '\n';
                                }
                                fileWriter.write(toWrite);
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        try {
                            try (ObjectOutputStream outputStream = new ObjectOutputStream(
                                    new FileOutputStream("movies.dat"))) {
                                outputStream.writeObject(list);
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    flag_to_exit = false;
                    break;
                case 1:
                    flag_of_init = true;
                    System.out.println("Введіть n та m (m-n>1000):");
                    Scanner scanner = new Scanner(System.in);
                    int n = scanner.nextInt();
                    int m = scanner.nextInt();
                    try (Scanner sc = new Scanner(new File("movies.csv"))) {
                        String unnecessary;
                        if (n == 0) {
                            header = sc.nextLine();
                        } else {
                            unnecessary = sc.nextLine();
                        }
                        int c = 0;
                        while (c < n) {
                            unnecessary = sc.nextLine();
                            c++;
                        }
                        while (c < m) {
                            String string = sc.nextLine();
                            String[] strings = string.split(",");
                            String name = "";
                            if (strings.length < 4) {
                                name = strings[1];
                            } else if (strings.length >= 4) {
                                strings[1] = strings[1].substring(1);
                                String s1 = strings[strings.length - 2];
                                s1 = s1.substring(0, s1.length() - 1);
                                strings[strings.length - 2] = s1;
                                name = strings[1];
                                for (int j = 2; j < strings.length - 1; j++) {
                                    name += ',' + strings[j];
                                }
                            }
                            int id = Integer.parseInt(strings[0]);
                            String name_ = name;
                            int count_of_char = name_.split("\\(", -1).length - 1;
                            String[] name_year;
                            int year = 0;
                            if (count_of_char < 2) {
                                name_year = name.split("\\(");
                                name = name_year[0];
                                year = Integer.parseInt(name_year[1].substring(0, name_year[1].length() - 1));
                            } else {
                                name_ = "";
                                name_year = name.split("\\(");
                                for (int i = 0; i < count_of_char - 1; i++) {
                                    name_ += name_year[i] + "(";
                                }
                                name_ += name_year[count_of_char - 1];
                                name = name_;
                                year = Integer.parseInt(name_year[count_of_char].substring(0, name_year[count_of_char].length() - 1));
                            }
                            String genres = strings[strings.length - 1];
                            Film film = new Film(id, name, year, genres);
                            list.add(film);
                            c++;
                        }
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                    break;
                case 2:
                    try (Scanner sc = new Scanner(new File("movies.txt"))) {
                        header = sc.nextLine();
                        while (sc.hasNextLine()) {
                            String string = sc.nextLine();
                            String[] strings = string.split(",");
                            String name = "";
                            if (strings.length < 4) {
                                name = strings[1];
                            } else if (strings.length >= 4) {
                                strings[1] = strings[1].substring(1);
                                String s1 = strings[strings.length - 2];
                                s1 = s1.substring(0, s1.length() - 1);
                                strings[strings.length - 2] = s1;
                                name = strings[1];
                                for (int j = 2; j < strings.length - 1; j++) {
                                    name += ',' + strings[j];
                                }
                            }
                            int id = Integer.parseInt(strings[0]);
                            String name_ = name;
                            int count_of_char = name_.split("\\(", -1).length - 1;
                            String[] name_year;
                            int year = 0;
                            if (count_of_char < 2) {
                                name_year = name.split("\\(");
                                name = name_year[0];
                                year = Integer.parseInt(name_year[1].substring(0, name_year[1].length() - 1));
                            } else {
                                name_ = "";
                                name_year = name.split("\\(");
                                for (int i = 0; i < count_of_char - 1; i++) {
                                    name_ += name_year[i] + "(";
                                }
                                name_ += name_year[count_of_char - 1];
                                name = name_;
                                year = Integer.parseInt(name_year[count_of_char].substring(0, name_year[count_of_char].length() - 1));
                            }
                            String genres = strings[strings.length - 1];
                            Film film = new Film(id, name, year, genres);
                            list.add(film);
                        }
                    } catch (FileNotFoundException e) {
                        System.out.println("Спочатку треба ініціалізувати");
                    }
                    break;
                case 3:
                    try (ObjectInputStream inputStream = new ObjectInputStream(
                            new FileInputStream("movies.dat"))) {
                        list = (ArrayList<Film>) inputStream.readObject();
                    } catch (FileNotFoundException e) {
                        System.out.println("Спочатку треба ініціалізувати");
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                    break;
                case 4:
                    System.out.println("1. По року випуску \n2. По жанру");
                    Scanner sc = new Scanner(System.in);
                    int search = sc.nextInt();
                    int counter = 0;
                    switch (search) {
                        case 1:
                            System.out.println("Рік: ");
                            int year = sc.nextInt();
                            for (int i = 0; i < list.size(); i++) {
                                if (year == list.get(i).getYear()) {
                                    System.out.println(list.get(i).getId() + "," + list.get(i).getName() + '(' +
                                            list.get(i).getYear() + ')' + ',' + list.get(i).getGenres());
                                    counter++;
                                }
                            }
                            if (counter == 0) {
                                System.out.println("Не знайдено");
                            }
                            break;
                        case 2:
                            System.out.println("Жанр: ");
                            Scanner s = new Scanner(System.in);
                            String genre = s.nextLine();
                            for (int i = 0; i < list.size(); i++) {
                                if (list.get(i).getGenres().contains(genre)) {
                                    System.out.println(list.get(i).getId() + "," + list.get(i).getName() + '(' +
                                            list.get(i).getYear() + ')' + ',' + list.get(i).getGenres());
                                    counter++;
                                }
                            }
                            if (counter == 0) {
                                System.out.println("Не знайдено");
                            }
                            break;
                    }
                    counter = 0;
                    break;
                case 5:
                    flag_of_del = true;
                    int c = 0;
                    System.out.println("id:");
                    Scanner scanner1 = new Scanner(System.in);
                    int id = scanner1.nextInt();
                    for (int i = 0; i < list.size(); i++) {
                        if (list.get(i).getId() == id) {
                            list.remove(i);
                            c++;
                        }
                    }
                    if (c == 0) {
                        System.out.println("Не знайдено");
                    }
                    break;
                case 6:
                    flag_of_add = true;
                    Scanner scn = new Scanner(System.in);
                    Scanner scn2 = new Scanner(System.in);
                    Scanner scanner2 = null;
                    try {
                        scanner2 = new Scanner(new File("movies.csv"));
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                    String string = "";
                    while (scanner2.hasNextLine()) {
                        string = scanner2.nextLine();
                    }
                    String[] strings = string.split(",");
                    int id_ = Integer.parseInt(strings[0]) + 1;
                    try {
                        scanner2 = new Scanner(new File("movies.txt"));
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                    String string2 = "";
                    while (scanner2.hasNextLine()) {
                        string = scanner2.nextLine();
                    }
                    String[] strings2 = string.split(",");
                    int id_2 = Integer.parseInt(strings[0]) + 1;
                    if (id_2 > id_) {
                        id_ = id_2;
                    }
                    System.out.println("Введіть назву:");
                    String name = scn.nextLine();
                    System.out.println("Введіть рік:");
                    int year = scn2.nextInt();
                    System.out.println("Введіть жанри:");
                    String genres = scn.nextLine();
                    Film film = new Film(id_, name, year, genres);
                    list.add(film);
                    break;
                case 7:
                    int count = 0;
                    flad_of_edit = true;
                    Scanner scanner3 = new Scanner(System.in);
                    Scanner scanner4 = new Scanner(System.in);
                    System.out.println("Введіть id:");
                    int id__ = scanner4.nextInt();
                    for (int i = 0; i < list.size(); i++) {
                        if (list.get(i).getId() == id__) {
                            count++;
                        }
                    }
                    if (count == 0) {
                        System.out.println("Не знайдено");
                        break;
                    }
                    System.out.println("Відредагувати: \n" +
                            "1. Назву\n" +
                            "2. Рік\n" +
                            "3. Жанр\n"
                    );
                    int choice_ = scanner4.nextInt();
                    switch (choice_) {
                        case 1:
                            System.out.println("Нова назва:");
                            String title = scanner3.nextLine();
                            for (int i = 0; i < list.size(); i++) {
                                if (list.get(i).getId() == id__) {
                                    list.get(i).setName(title);
                                }
                            }
                            break;
                        case 2:
                            System.out.println("Новий рік:");
                            int y = scanner4.nextInt();
                            for (int i = 0; i < list.size(); i++) {
                                if (list.get(i).getId() == id__) {
                                    list.get(i).setYear(y);
                                }
                            }
                            break;
                        case 3:
                            System.out.println("Новий жанр: ");
                            String gnr = scanner3.nextLine();
                            for (int i = 0; i < list.size(); i++) {
                                if (list.get(i).getId() == id__) {
                                    list.get(i).setGenres(gnr);
                                }
                            }
                            break;
                    }
                    break;
            }
        }
    }

    public static int menu() {
        System.out.println("1. Ініціалізація \n" +
                "2. Прочитати з текстового файлу \n" +
                "3. Десеарелізація\n" +
                "4. Пошук\n" +
                "5. Видалення по заданому id\n" +
                "6. Додавання\n" +
                "7. Редагування\n" +
                "0. Вихід\n"
        );
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
}

class Film implements Serializable {
    private int id;
    private int year;
    private String name;
    private String genres;

    Film(int id, String name, int year, String genres) {
        this.id = id;
        this.year = year;
        this.name = name;
        this.genres = genres;
    }

    public int getId() {
        return id;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGenres() {
        return genres;
    }

    public void setGenres(String genres) {
        this.genres = genres;
    }
}

