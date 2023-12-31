# Laboratory work 1. Arrays
Write a program for operations on a two-dimensional array of numbers that displays a menu on the console and waits for the user to select an operation. The array is created at program startup (size 3x4) and filled with random values.

You need to program the following actions:

1) Create a new array. At the same time, new array dimensions are entered, an array is created (replaces the existing one), and filled with random values.

2) Change the value of an array item (Enter the row and column number of the item first, then the new value of the item)

3) Sort the array rows in ascending order of the sum of the row elements (use any sorting algorithm)

4) Print the array

5) Exit

Implement the actions in separate methods.

To generate random numbers, use the `random()` method of the `Math` class.

`int x = (int)(100*Math.random());`

When sorting, the elements inside the strings are not rearranged.  The entire strings are rearranged (not element by element).

# Лабораторна робота 1. Масиви
Написати програму для операцій над двовимірним масивом чисел, яка виводить на консоль меню,  чекає від користувача вибору операції. Масив створюється при запуску програми (розмір 3х4)  і заповнюється випадковими значеннями.

Потрібно запрограмувати такі дії:

1) Створити новий масив. При цьому вводяться нові розміри масиву, створюється масив (заміщує існуючий), заповнюється випадковими значеннями.

2) Змінити значення елемента масива (Ввести спочатку номер рядка та стовпчика елемента, потім нове значення елемента)

3) Відсортувати рядки масиву за зростанням суми елементів рядка (використати будь-який алгоритм сортування)

4) Надрукувати масив

5) Вихід

Дії реалізувати в окремих методах.

Для генерации випадкових чисел використайте метод `random()` класу `Math`.

`int x =(int)(100*Math.random());`

При сортуванні елементи всередині рядків не переставляються.  Пересталяються між собою рядки цілком  (не поелементно).  
