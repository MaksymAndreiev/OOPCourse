public class Main {
    public static void main(String[] args) {
        try {
            MyContainer<Integer> ar = new MyContainer<Integer>(5);
            for (Integer i = 0; i < 5; i++) {
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
            System.out.println("Видалимо всі елементи");
            int tmp = ar.size();
            for (int i = 0; i < tmp; i++) {
                System.out.print(ar.remove() + " ");
            }
            System.out.println();
            System.out.println("Розмір масиву " + ar.size());
            System.out.println(ar.toString());
            //System.out.println("Видалимо ще щось");
            //ar.remove();
            System.out.println("-------------------------------------------------");
            MyContainer<Double> ard = new MyContainer<Double>(5);
            for (double i = 0; i < 5; i++) {
                ard.add(i + 1 + (i + 1) / 10);
            }
            System.out.println(ard.toString());
            System.out.println("Розмір масиву " + ard.size());
            for (int i = 0; i < ard.size(); i++) {
                System.out.println("Елемент під індексом " + i + ": " + ard.get(i));
            }
            System.out.println("Перепишемо елемент під індексом 2");
            ard.set(2, 33.3);
            System.out.println(ard.toString());
            System.out.println("Видалимо всі елементи");
            tmp = ard.size();
            for (int i = 0; i < tmp; i++) {
                System.out.print(ard.remove() + " ");
            }
            System.out.println();
            System.out.println("Розмір масиву " + ard.size());
            System.out.println(ard.toString());
            System.out.println("-------------------------------------------------");
            MyContainer<String> arstr = new MyContainer<String>(5);
            arstr.add("Один");
            arstr.add("Два");
            arstr.add("Три");
            arstr.add("Чотири");
            arstr.add("П'ять");
            System.out.println(arstr.toString());
            System.out.println("Розмір масиву " + arstr.size());
            for (int i = 0; i < arstr.size(); i++) {
                System.out.println("Елемент під індексом " + i + ": " + arstr.get(i));
            }
            System.out.println("Перепишемо елемент під індексом 2");
            arstr.set(2, "Тридцять три");
            System.out.println(arstr.toString());
            System.out.println("Видалимо всі елементи");
            tmp = arstr.size();
            for (int i = 0; i < tmp; i++) {
                System.out.print(arstr.remove() + " ");
            }
            System.out.println();
            System.out.println("Розмір масиву " + arstr.size());
            System.out.println(arstr.toString());
        } catch (MyWrongParamException ex) {
            System.out.println(ex.getMessage());
            System.out.println("Ви ввели " + ex.getNumber());
        } catch (MyFullContainerException | MyEmptyContainerException ex) {
            System.out.println(ex.getMessage());
        }
    }
}

class MyContainer<T> {
    private Object[] ar;
    private int size = 0;

    MyContainer(int n) throws MyWrongParamException {
        if (n <= 0) throw new MyWrongParamException("Розмір масиву менше або дорівнює 0", n);
        ar = new Object[n];
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

    T get(int index) throws MyWrongParamException {
        if (index < 0 || index > size - 1)
            throw new MyWrongParamException("Індекс повинен бути від 0 до size-1", index);
        return (T) ar[index];
    }

    T set(int index, T newObject) throws MyWrongParamException {
        if (index < 0 || index > size - 1)
            throw new MyWrongParamException("Індекс повинен бути від 0 до size-1", index);
        Object old = ar[index];
        ar[index] = newObject;
        return (T) old;
    }

    void add(T newValue) throws MyFullContainerException {
        if (size == ar.length) throw new MyFullContainerException("Масив повний. Неможливо додати");
        size++;
        ar[size - 1] = newValue;
    }

    T remove() throws MyEmptyContainerException {
        if (size == 0) throw new MyEmptyContainerException("Масив пустий. Нема що видаляти");
        Object deleted = ar[size - 1];
        size--;
        return (T) deleted;
    }
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

