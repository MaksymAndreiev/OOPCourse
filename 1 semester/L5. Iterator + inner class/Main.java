public class Main {
    public static final String red = "\u001B[31m";
    public static final String reset = "\u001B[0m";

    public static void main(String[] args) {
        System.out.println(red + "Пустий масив" + reset);
        MyArrayList ma = new MyArrayList(15);
        System.out.println(ma.toString());
        System.out.println("Масив складається з " + ma.size + " елементів");
        MyListIterator it = ma.iterator();
        System.out.print("Чи є в нас попередній елемент? ");
        System.out.println(it.hasPrevious());
        System.out.print("Чи є наступний елемент? ");
        System.out.println(it.hasNext());
        System.out.print("Індекс наступного елементу ");
        System.out.println(it.nextIndex());
        System.out.print("Індекс попереднього елементу масива ");
        System.out.println(it.previousIndex());
        System.out.println("Додаєм 1 елемент");
        ma.add(1);
        System.out.println(ma.toString());
        System.out.println("Масив складається з " + ma.size + " елементів");
        System.out.println("Перезапишемо елемент");
        it.set(11);
        System.out.println("Видаляємо останній елемент");
        it.remove();
        System.out.println(ma.toString());
        System.out.println("Іншим способом");
        System.out.println("Видалили" + ma.remove());
        System.out.println(ma.toString());
        System.out.println("Масив складається з " + ma.size + " елементів");
        System.out.println(red + "Частково заповнений масив" + reset);
        for (int i = 1; i < 11; i++) {
            ma.add(i);
        }
        System.out.println(ma.toString() + "\n Видаляємо останній елемент " + ma.remove());
        System.out.println(ma.toString());
        System.out.println("Масив складається з " + ma.size + " елементів");
        System.out.print("Спочатку курсор стоїть перед першим елементом. Чи є в нас попередній елемент? ");
        System.out.println(it.hasPrevious());
        System.out.print("Індекс наступного елементу ");
        System.out.println(it.nextIndex());
        System.out.println("Пройдемо 3 елемента:");
        System.out.print("[");
        for (int i = 0; i < 2; i++) {
            System.out.print(it.next() + ", ");
        }
        System.out.println(it.next() + "]");
        System.out.println("Перезапишемо елемент");
        it.set(33);
        System.out.println(ma.toString());
        System.out.print("Чи є наступний елемент? ");
        System.out.println(it.hasNext());
        System.out.print("Попередній? ");
        System.out.println(it.hasPrevious());
        System.out.println("Дійдемо до кінця масиву");
        System.out.print("[");
        for (int i = 0; i < 5; i++) {
            System.out.print(it.next() + ", ");
        }
        System.out.println(it.next() + "]");
        System.out.print("Чи є наступний елемент? ");
        System.out.println(it.hasNext());
        System.out.print("Індекс попереднього елементу масива ");
        System.out.println(it.previousIndex());
        System.out.println("Повертаємось назад");
        System.out.print("[");
        for (int i = ma.size; i > 1; i--) {
            System.out.print(it.previous() + ", ");
        }
        System.out.println(it.previous() + "]");
        System.out.println("Перезапишемо елемент");
        it.set(11);
        System.out.println(ma.toString() + "\nТа видалимо його:");
        it.remove();
        System.out.println(ma.toString());
        it.add(111);
        System.out.println("Добавимо новий елемент\n" + ma.toString());
        System.out.println("Знову видалимо? Чи ні?");
        it.remove();
        System.out.println("\"Виклик previous() поверне новий доданий елемент\". Перевіримо: " + it.previous());
        System.out.println(red + "Повністю заповнений масив" + reset);
        for (int i = 10; i <= 15; i++) {
            ma.add(i);
        }
        System.out.println(ma.toString());
        System.out.println("Наступний елемент після курсору це " + it.next());
        System.out.println("Спробуємо додати новий елемент");
        System.out.println(ma.add(64));
        System.out.println("Спробуємо додати новий елемент іншим методом");
        it.add(64);
        System.out.println("Видаляємо останній елемент " + ma.remove() + "\n" + ma.toString());
        System.out.println("Добавляємо в кінець новий елемент " + ma.add(1515) + "\n" + ma.toString());
        System.out.println("Видаляємо елемент " + it.next());
        it.remove();
        System.out.println(ma.toString());
        System.out.println("Масив складається з " + ma.size + " елементів");
        it.add(22);
        System.out.println(ma.toString());
        System.out.println("Масив складається з " + ma.size + " елементів");
        System.out.println("\"Виклик previous() поверне новий доданий елемент\". Перевіримо: " + it.previous());
        System.out.print("Індекс попереднього елементу масива ");
        System.out.println(it.previousIndex());
        System.out.print("Індекс наступного елементу ");
        System.out.println(it.nextIndex());
    }
}

class MyArrayList {
    public class MyListIteratorImpl implements MyListIterator {
        int cursor = 0, func = 0;

        public boolean hasNext() {
            return cursor < size;
        }

        public boolean hasPrevious() {
            return cursor > 0;
        }

        public Integer next() {
            if (!hasNext()) return null;
            else {
                cursor++;
                func = 1;
                return ar[cursor - 1];
            }
        }

        public Integer previous() {
            if (!hasPrevious()) return null;
            else {
                cursor--;
                func = -1;
                return ar[cursor];
            }
        }

        public void set(Integer n) {
            if (func == 0) {
                System.out.println("Метод можна викликати лише у випадку, якщо після останнього next() чи previous() не викликали метод add() чи remove().");
            } else if (func == 1) {
                ar[cursor - 1] = n;
            } else if (func == -1) {
                ar[cursor] = n;
            }
        }

        public void remove() {
            if (func == 0) {
                System.out.println("Метод можна викликати лише один раз після кожного виклику next() чи previous() у випадку, якщо після цього не викликали метод add().");
                return;
            } else if (func == 1) {
                for (int i = cursor - 1; i < size - 1; i++) {
                    ar[i] = ar[i + 1];
                }
            } else if (func == -1) {
                for (int i = cursor; i < size - 1; i++) {
                    ar[i] = ar[i + 1];
                }
            }
            ar[size - 1] = null;
            size--;
            func = 0;
        }

        public int nextIndex() {
            if (hasNext()) {
                return cursor;
            } else {
                return size;
            }
        }

        public int previousIndex() {
            if (hasPrevious()) {
                return cursor - 1;
            } else {
                return -1;
            }
        }

        public void add(Integer n) {
            if (size != ar.length) {
                size++;
                if (size > 1) {
                    for (int i = size - 1; i > cursor; i--) {
                        ar[i] = ar[i - 1];
                    }
                }
                ar[cursor] = n;
                cursor++;
                func = 0;
            } else {
                System.out.println("Неможливо добавити");
            }
        }
    }

    private Integer[] ar;
    int size = 0;

    public MyArrayList(int n) {
        ar = new Integer[n];
    }

    public boolean add(Integer n) {
        if (size != ar.length) {
            ar[size] = n;
            size++;
            return true;
        } else {
            return false;
        }
    }

    public Integer remove() {
        if (size > 0) {
            int del = ar[size - 1];
            ar[size - 1] = null;
            size--;
            return del;
        } else {
            return 0;
        }
    }

    public String toString() {
        if (size() == 0) return "Пусто";
        String str = "";
        for (int i = 0; i < size - 1; i++) {
            str = str + ar[i] + ", ";
        }
        return "[" + str + ar[size - 1] + "]";
    }

    int size() {
        return size;
    }

    public MyListIterator iterator() {
        return new MyListIteratorImpl();
    }
}

interface MyListIterator {
    boolean hasNext();

    boolean hasPrevious();

    Integer next();

    Integer previous();

    void set(Integer n);

    void remove();

    int nextIndex();

    int previousIndex();

    void add(Integer n);
}
