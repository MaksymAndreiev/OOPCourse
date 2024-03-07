public class Main {
    public static void main(String[] args) {
        try {
            //MySimpleContainer ar= new MySimpleContainer(-34);
            MySimpleContainer ar = new MySimpleContainer(5);
            for (int i = 0; i < 5; i++) {
                ar.add(i + 1);
            }
            System.out.println(ar.toString());
            System.out.println("Розмір масиву " + ar.size());
            for (int i = 0; i < ar.size(); i++) {
                System.out.println("Елемент під індексом " + i + ": " + ar.get(i));
            }
            //System.out.print("Елемент під індексом "+-2+": ");
            //System.out.println(ar.get(-2));
            //ar.add(1);
            System.out.println("Перепишемо елемент під індексом 2");
            ar.set(2, 33);
            System.out.println(ar.toString());
            //System.out.println("Перепишемо елемент під індексом -2");
            //ar.set(-2, 33);
            //System.out.println(ar.toString());
            System.out.println("Видалимо всі елементи");
            int tmp = ar.size();
            //при видаленні буде змінюватися й розмір масиву, тому i<ar.size() буде некоректно,
            //замість цього я зберігаю початковий розмір в окрему змінну
            for (int i = 0; i < tmp; i++) {
                ar.remove();
            }
            System.out.println("Розмір масиву " + ar.size());
            System.out.println(ar.toString());
            System.out.println("Видалимо ще щось");
            ar.remove();
        } catch (MyWrongParamException ex) {
            System.out.println(ex.getMessage());
            System.out.println("Ви ввели " + ex.getNumber());
        } catch (MyFullContainerException | MyEmptyContainerException ex) {
            System.out.println(ex.getMessage());
        }
    }
}

class MySimpleContainer {
    private int[] ar;
    private int size = 0;

    MySimpleContainer(int capacity) throws MyWrongParamException {
        if (capacity <= 0) throw new MyWrongParamException("Розмір масиву менше або дорівнює 0", capacity);
        ar = new int[capacity];
    } //к-р, масив розміром capacity

    public String toString() {
        if (size() == 0) return "Пусто";
        String str = "";
        for (int i = 0; i < size - 1; i++) {
            str = str + ar[i] + ", ";
        }
        return "[" + str + ar[size - 1] + "]";
    } //повертає рядок в форматі: [1,5,…,3]

    int size() {
        return size;
    } //повертає кількість елементів, введених в контейнер

    int get(int index) throws MyWrongParamException {
        if (index < 0 || index > size - 1)
            throw new MyWrongParamException("Індекс повинен бути від 0 до size-1", index);
        return ar[index];
    } //повертає значення вказаного елементу контейнера

    int set(int index, int newValue) throws MyWrongParamException {
        if (index < 0 || index > size - 1)
            throw new MyWrongParamException("Індекс повинен бути від 0 до size-1", index);
        int old = ar[index];
        ar[index] = newValue;
        return old;
    } //установлює значення у вказану позицію, повертає старе значення

    void add(int newValue) throws MyFullContainerException {
        if (size == ar.length) throw new MyFullContainerException("Масив повний. Неможливо додати");
        size++;
        ar[size - 1] = newValue;
    } //додає елемент у контейнер в кінець

    int remove() throws MyEmptyContainerException {
        if (size == 0) throw new MyEmptyContainerException("Масив пустий. Нема що видаляти");
        int deleted = ar[size - 1];
        size--;
        return deleted;
    } //вилучає останній доданий елемент в контейнері, повертає вилучений елемент
}

class MyFullContainerException extends Exception {
    public MyFullContainerException(String message) {
        super(message);
    }
}

class MyEmptyContainerException extends Exception {
    public MyEmptyContainerException(String message) {
        super(message);
    }
}

class MyWrongParamException extends Exception {
    private int number;

    public int getNumber() {
        return number;
    }

    public MyWrongParamException(String message, int num) {
        super(message);
        number = num;
    }
}

