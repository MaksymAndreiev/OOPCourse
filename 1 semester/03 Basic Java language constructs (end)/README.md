# Practical exercise 3: Basic Java language constructs (end)

**Task 1)** Rewrite the program from the previous task, which displays a menu on the console, waiting for the user to
make a choice.

Implement actions in accordance with the selected menu item (except for the Exit item) in additional methods. В
the `switch` statement, just call the appropriate methods.

In the menu items, information about a certain person is entered and printed:

```
1 Enter the name

2 Enter the age

3 Enter the height

...

N Print

0 Exit
```

Select an action (enter a number from 0 to N)

In the program, instead of N, there should be an integer - the sequence number of the item (depends on the number of
menu items).

When you select **Print**, all the information entered above is printed.

After selecting the **Exit** item, the program should exit.

After selecting other items, the declared action should be performed. After its completion, the menu is printed again
and the program waits for the user to make a choice.

The implementation of the menu is in the `main` method. To implement the menu, use the `while` loop and the `switch`
statement (similar to
C).

To exit the program, you can call the `return;` statement when you select the **Exit** item.

Implementation of actions in accordance with the selected menu item (except for the Exit item) is performed in
_additional methods_. In the switch statement
just call the appropriate methods.

Methods in which information is entered use a scanner.
The variables that store the entered information must be **global** for the methods.

**Task 2)** Write a program for operations on a one-dimensional array of numbers, which displays a menu on the console,
waiting for the user to make a choice. The array is created at program startup. The size of the array is no more than
10.

Implement the following actions (menu items):

```
1) Fill the array with random numbers.

2) Change the value of an array item (Enter the item number first, then the new value of the item)

3) Sort the array elements in ascending order (use any sorting algorithm)

4) Print the array

0) Exit
```

Implement the actions in separate methods.

# Практичне заняття 3. Основні мовні конструкції Java (закінчення)

**Завдання 1)** Переписати програму з попереднього завдання, яка виводить на консоль меню, чекає від користувача вибору.

Реалізації дій відповідно до вибраного пункту меню (крім пункту Вихід) виконати в додаткових методах. В
операторі `switch` просто викликати відповідні методи.

В пунктах меню вводиться та друкується інформація про деяку персону:

```
1 Введіть ім’я

2 Введіть вік

3 Введіть зріст

…

N Надрукувати

0 Вихід
```

Виберіть дію (введіть номер від 0 до N)

У програмі замість N повинно стояти ціле число – порядковий номер пункту (залежить від кількості пунктів меню).

При виборі пункту **Надрукувати** - друкується вся введена вище інформація.

Після вибору пункту **Вихід** програма повинна закінчити роботу.

Після вибору інших пунктів повинна виконуватись заявлена дія. Після її завершення знову друкується меню і програма чекає
від користувача вибору.

Реалізація меню знаходиться в методі `main`. Для реалізації меню використати цикл `while` та оператор `switch` (
аналогічні
C).

Для виходу з програми можна при виборі пункту **Вихід** викликати оператор `return;` .

Реалізації дій відповідно до вибраного пункту меню (крім пункту Вихід) виконати в _додаткових методах_. В операторі
switch
просто викликати відповідні методи.

Методи, в яких інформація вводиться, використовують сканер.

Змінні, що зберігають введену інформацію, повинні бути **глобальними** для методів.

**Завдання 2)** Написати програму для операцій над одновимірним масивом чисел, яка виводить на консоль меню, чекає від
користувача вибору. Масив створюється при запуску програми. Розмір масива не більше 10.

Реалізувати такі дії (пункти меню):

```
1) Заповнити масив випадковими числами.

2) Змінити значення елемента масива (Ввести спочатку номер елемента, потім нове значення елемента)

3) Відсортувати елементи масиву за зростанням (використати будь-який алгоритм сортування)

4) Надрукувати масив

0) Вихід
```

Дії реалізувати в окремих методах.