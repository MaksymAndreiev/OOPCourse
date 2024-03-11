import java.util.*;

public class Main {

    public static void main(String[] args) {
        try {
            MyArrayList<String> aString = new MyArrayList<>(15);
            System.out.println("-----------Пустий масив-----------");
            System.out.println(aString.toString());
            System.out.println("Масив складається з " + aString.size() + " елементів");
            MyListIterator itStr = aString.iterator();
            System.out.println("Чи є в нас попередній елемент? " + itStr.hasPrevious());
            System.out.println("Чи є наступний елемент? " + itStr.hasNext());
            System.out.println("Індекс наступного елементу " + itStr.nextIndex());
            System.out.println("Індекс попереднього елементу масива " + itStr.previousIndex());
            System.out.println("Додаєм 1 елемент");
            aString.add("Один");
            System.out.println(aString.toString());
            System.out.println("Масив складається з " + aString.size() + " елементів");
            //System.out.println("Перезапишемо елемент");
            //itStr.set("Одинадцять");
            System.out.println("Видаляємо останній елемент");
            //itStr.remove();
            System.out.println("Видалили " + aString.remove());
            System.out.println(aString.toString());
            System.out.println("Масив складається з " + aString.size() + " елементів");
            //System.out.println("Видалили " + aString.remove());
            System.out.println("-----------Частково заповнений масив-----------");
            MyArrayList<Integer> aInteger = new MyArrayList<>(15);
            MyListIterator itInt = aInteger.iterator();
            for (int i = 1; i < 11; i++) {
                aInteger.add(i);
            }
            System.out.println(aInteger.toString() + "\nВидаляємо останній елемент [" + aInteger.remove() + "]");
            System.out.println(aInteger.toString());
            System.out.println("Масив складається з " + aInteger.size() + " елементів");
            System.out.print("Спочатку курсор стоїть перед першим елементом. Чи є в нас попередній елемент? ");
            System.out.println(itInt.hasPrevious());
            System.out.print("Індекс наступного елементу ");
            System.out.println(itInt.nextIndex());
            System.out.println("Пройдемо 3 елемента:");
            System.out.print("[");
            for (int i = 0; i < 2; i++) {
                System.out.print(itInt.next() + ", ");
            }
            System.out.println(itInt.next() + "]");
            System.out.println("Перезапишемо елемент");
            itInt.set(33);
            System.out.println(aInteger.toString());
            System.out.print("Чи є наступний елемент? ");
            System.out.println(itInt.hasNext());
            System.out.print("Попередній? ");
            System.out.println(itInt.hasPrevious());
            System.out.println("Дійдемо до кінця масиву");
            System.out.print("[");
            for (int i = 0; i < 5; i++) {
                System.out.print(itInt.next() + ", ");
            }
            System.out.println(itInt.next() + "]");
            System.out.print("Чи є наступний елемент? ");
            System.out.println(itInt.hasNext());
            System.out.print("Індекс попереднього елементу масива ");
            System.out.println(itInt.previousIndex());
            System.out.println("Повертаємось назад");
            System.out.print("[");
            for (int i = aInteger.size(); i > 1; i--) {
                System.out.print(itInt.previous() + ", ");
            }
            System.out.println(itInt.previous() + "]");
            System.out.println("Перезапишемо елемент");
            itInt.set(11);
            System.out.println(aInteger.toString() + "\nТа видалимо його:");
            itInt.remove();
            System.out.println(aInteger.toString());
            itInt.add(111);
            System.out.println("Добавимо новий елемент\n" + aInteger.toString());
            //System.out.println("Знову видалимо? Чи ні?");
            //itInt.remove();
            System.out.println("\"Виклик previous() поверне новий доданий елемент\". Перевіримо: " + itInt.previous());
            System.out.println("-----------Повністю заповнений масив-----------");
            MyArrayList<Double> aDouble = new MyArrayList<>(15);
            MyListIterator itDbl = aDouble.iterator();
            for (double i = 1; i <= 15; i++) {
                aDouble.add(i + i / 100);
            }
            System.out.println(aDouble.toString());
            System.out.println("Наступний елемент після курсору це " + itDbl.next());
            System.out.println("Спробуємо додати новий елемент");
            //System.out.println(aDouble.add(64.5));
            //System.out.println("Спробуємо додати новий елемент іншим методом");
            //itDbl.add(64.5);
            System.out.println("Видаляємо останній елемент " + aDouble.remove() + "\n" + aDouble.toString());
            System.out.println("Добавляємо в кінець новий елемент " + aDouble.add(15.51) + "\n" + aDouble.toString());
            System.out.println("Видаляємо елемент " + itDbl.next());
            itDbl.remove();
            System.out.println(aDouble.toString());
            System.out.println("Масив складається з " + aDouble.size() + " елементів");
            System.out.println("Добавляємо новий елемент ");
            itDbl.add(22.22);
            System.out.println(aDouble.toString());
            System.out.println("Масив складається з " + aDouble.size() + " елементів");
            System.out.println("\"Виклик previous() поверне новий доданий елемент\". Перевіримо: " + itDbl.previous());
            System.out.print("Індекс попереднього елементу масива ");
            System.out.println(itDbl.previousIndex());
            System.out.print("Індекс наступного елементу ");
            System.out.println(itDbl.nextIndex());
        } catch (NoSuchElementException | IllegalStateException | IndexOutOfBoundsException ex) {
            System.out.println(ex.getMessage());
        }
    }
}

class MyArrayList<T> {
    public class MyListIteratorImpl<T> implements MyListIterator<T> {
        int cursor = 0, func = 0;

        public boolean hasNext() {
            return cursor < size;
        }

        public boolean hasPrevious() {
            return cursor > 0;
        }

        public T next() {
            if (!hasNext()) throw new NoSuchElementException("Немає наступного елементу");
            else {
                cursor++;
                func = 1;
                return (T) ar[cursor - 1];
            }
        }

        public T previous() {
            if (!hasPrevious()) throw new NoSuchElementException("Немає попереднього елементу");
            else {
                cursor--;
                func = -1;
                return (T) ar[cursor];
            }
        }

        public void set(Object n) {
            if (func == 0)
                throw new IllegalStateException("\"Метод можна викликати лише у випадку, якщо після останнього next() чи previous() не викликали метод add() чи remove().\"");
            else if (func == 1) {
                ar[cursor - 1] = n;
            } else if (func == -1) {
                ar[cursor] = n;
            }
        }

        public void remove() {
            if (func == 0)
                throw new IllegalStateException("\"Метод можна викликати лише один раз після кожного виклику next() чи previous() у випадку, якщо після цього не викликали метод add().\nГенерує виключення IllegalStateException якщо не був викликаний next() або previous(), або після них був remove() чи add()\"");
            else if (func == 1) {
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

        public void add(T n) {
            if (size == ar.length) throw new IllegalStateException("Масив повністю заповнений");
            size++;
            if (size > 1) {
                for (int i = size - 1; i > cursor; i--) {
                    ar[i] = ar[i - 1];
                }
            }
            ar[cursor] = n;
            cursor++;
            func = 0;
        }
    }

    private Object[] ar;
    private int size = 0;

    public MyArrayList(int n) {
        if (n <= 0) throw new IllegalArgumentException();
        ar = new Object[n];
    }

    public boolean add(T o) {
        if (size >= ar.length) throw new IndexOutOfBoundsException("Масив повністю заповнений");
        ar[size] = o;
        size++;
        return true;
    }

    public T remove() {
        if (size == 0) throw new NoSuchElementException("Масив пуст");
        Object deleted = ar[size - 1];
        ar[size - 1] = null;
        size--;
        return (T) deleted;
    }

    public String toString() {
        if (size == 0) return "Пусто";
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

interface MyListIterator<T> {
    boolean hasNext();

    boolean hasPrevious();

    T next();

    T previous();

    void set(T n);

    void remove();

    int nextIndex();

    int previousIndex();

    void add(T n);
}
