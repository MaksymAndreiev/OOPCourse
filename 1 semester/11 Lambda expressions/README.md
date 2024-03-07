# Practical exercise 11. Lambda expressions

1. Sorting.
   Similar to Task10, sort the rows of a two-dimensional array by different criteria using the `sort()` method of
   the `Arrays` class (package `java.util`). Use a variant of the method, the parameters of which are an array
   and a comparator. As a comparator, use a lambda expression that implements the `Comparator` interface:
    ````
   public interface Comparator<T> {
        int compare (T first, T second);
   }
   ````
   In brackets < > - the type of objects that are compared during sorting. In our case, `T` is int[ ] (a string of a
   two-dimensional
   array is a one-dimensional array).
   Lambda expressions are in some way a shortened form of internal anonymous classes.
   To compare array strings, it is enough to define a lambda expression that implements
   `Comparator<int[]> comp = (first, second)-> ...criterion;`
   Then it is enough to pass the comp object to the `Arrays.sort()` method as follows:
   `Arrays.sort(arr, comp);`
   or
   `Arrays.sort(arr, (first, second)-> ... criterion);`
    1) In the main method, create a two-dimensional array of integers and fill it with random positive and negative
       numbers (size no more than 4x4).
    2) In the `main` method, create several lambda expressions - objects of these comparators and sort the array.
    3) Print the array before sorting and after each sort.
       The lambda parameters `first`, `second` are references to the two lines of the array that are compared.
       The comparison criterion is specified on the right side of the lambda expression (after ->). If, according to the
       criterion, the first string is less than
       the second, -1 (or a negative number) is returned, if the strings are equal - 0, if the first is greater than the
       second +1 (or a positive
       or a positive number).  
       For complex criteria that cannot be written in one expression, use a block of code in curly brackets. In block
       lambda expressions, you can use loops, `if`, `witch` constructs, create variables, etc. If a block
       lambda expression must return the value res, then you can explicitly use the return res statement.
       The criteria in comparators are different, for example, you can sort
        - by increasing the sum of the elements of the string (Lab1)
        - in ascending order of the number of even numbers in the string
        - by increasing number of numbers in the string that are divisible by 3
          The menu is not required.
2. Passing a reference to another method as a parameter to a method
   1.In the same project, define an interface
   `interface MyCheck{ boolean isRight(int n);}`
   with a single method `isRight`, which must check the number n (input parameter) for compliance with a certain
   criterion and
   return true or false.
   2.In the class that contains the main method, write a static sum method:
   `private static int sum(int[][] ar, MyCheck func)`,
   which passes a two-dimensional array ar (the one that was sorted) and a reference to the method for checking the
   elements of the array func.
   The func variable is of type `MyCheck` - an interface with the `isRight` method. So in the body of the sum method,
   the function `func.isRight(int
   n)`. The sum method must return the sum of the array elements for which the `isRight` method returns true (passed the
   test according to the criterion specified in the `func` function passed to the `sum` method).
   3.In the class that contains the main method, write several static criteria methods that will be passed to the sum
   method.
   The names of the methods are arbitrary (but preferably meaningful), but must match the parameters and result with the
   method
   of the `MyCheck` functional interface:
   ````
   static boolean isEven(int n){ return n%2 == 0; } // evenness
   static boolean isPositive(int n){ return ...; } //positivity
   static boolean isNegative(int n){ return ...; } //negativity
   ...
   ````
   Since the validation methods are static, they will be passed to the sum method in the
   form `class_name::static_method_name`:
   ````
   int sumEven = sum(ar, Main::isEven); // or
   System.out.println(sum(nums, Main::isEven));
   ````
   (`Main` in this case is the class in which the `isEven` method is defined)
   The menu is not needed.

# Практичне заняття 11. Лямбда-вирази

1. Сортування
   Аналогічно до Завдання10 відсортувати рядки двовимірного масиву за різними критеріями за допомогою методу `sort()`
   класу `Arrays` (пакет `java.util`). Використати варіант методу, параметрами якого є масив і компаратор. В якості
   компаратора використати лямда-вираз, що реалізує інтерфейс `Comparator`:
    ````
   public interface Comparator<T> {
        int compare (T first, T second);
   }
   ````
   В дужках < > - тип об’єктів, що порівнюються при сортуванні. В нашому випадку `T` це int[ ] (рядок двовимірного
   масиву - це одновимірний масив).
   Лямда-вирази це в деякому роді скорочена форма внутрішніх анонімних класів.
   Щоб порівняти рядки масиву, досить визначити лямбда вираз, який реалізує
   `Comparator<int[]> comp = (first, second)-> …критерій;`
   Потім досить передати об'єкт comp методу `Arrays.sort()` наступним чином:
   `Arrays.sort(arr, comp);`
   або
   `Arrays.sort(arr, (first, second)-> …критерій);`
    1) В методі main створити двовимірний масив цілих чисел та заповнити його випадковими додатними та від’ємними
       числами  (розмір не більше 4х4).
    2) В методі `main` створити кілька лямбда-виразів - об’єктів цих компараторів та виконати сортування масиву.
    3) Перед сортуванням і після кожного сортування масив друкувати.
       Параметри лямбди `first`, `second` – це посилання на два рядки масиву, які порівнюються.
       Критерій порівняння задається в правій частині лямбда-виразу (після ->). Якщо по критерію перший рядок менше
       другого – повертається -1 (або від’ємне число), якщо рядки рівні – 0, якщо перший більше другого +1 (або додатне
       число).  
       Для складних критеріїв, які неможливо записати одним виразом використати блок коду в фігурних дужках. У блокових
       лямбда-виразах можна використовувати цикли, конструкції `if`, `switch`, створювати змінні і т.д. Якщо блочний
       лямбда-вираз має повертати значення res, то можна явно застосувати оператор return res.
       Критерії в компараторах різні, наприклад сортувати можна
       • по зростанню суми елементів рядка (Лаб1)
       • по зростанню кількості парних чисел в рядку
       • по зростанню кількості чисел в рядку, які діляться на 3
       Меню не потрібне.
2. Передача у метод в якості параметра посилання на інший метод
   1.В тому ж проекті визначити інтерфейс
   `interface MyCheck{ boolean isRight(int n);}`
   з єдиним методом `isRight`, який повинен перевіряти число n (вхідний параметр) на відповідність деякому критерію і
   повертати true або false.
   2.В класі, що містить метод main, записати статичний метод sum:
   `private static int sum(int[][] ar, MyCheck func)`,
   в який передається двовимірний масив ar (той що сортувався) і посилання на метод перевірки елементів масиву func.
   Змінна func має тип `MyCheck` – інтерфейс з методом `isRight`. Отже в тілі метода sum доступна
   функція `func.isRight(int
   n)`. Метод sum має повернути суму елементів масиву, для яких метод `isRight` повертає істину (пройшли перевірку по
   критерію, що заданий в переданій в метод `sum` функції `func`).
   3.В класі, що містить метод main, записати кілька статичних методів-критеріїв, які будуть передаватися в метод sum.
   Імена методів довільні (але бажано осмислені), але повинні збігатися по параметрам і результату з методом
   функціонального інтерфейсу `MyCheck`:
   ````
   static boolean isEven(int n){ return n%2 == 0; } //парність
   static boolean isPositive(int n){ return …; } //дотатність
   static boolean isNegative(int n){ return …; } //від’ємність
   …
   ````
   Оскільки методи перевірки статичні, у метод sum вони будуть передаватися у
   вигляді `ім'я_класу::імя_статичного_методу`:
   ````
   int sumEven = sum(ar, Main::isEven); // або
   System.out.println(sum(nums, Main::isEven));
   ````
   (`Main` в даному випадку – клас, в якому визначений метод `isEven`)
   Меню не потрібне.
