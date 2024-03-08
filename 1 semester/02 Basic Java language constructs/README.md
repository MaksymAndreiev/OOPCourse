# Practical exercise 2: Basic Java language constructs

**Task 1)** Write a program to enter information about a person. Enter the name, age, height, weight through the
scanner. Then print the entered information using the printf function.

**Task 2)** Write a program that displays a numbered menu on the console and waits for the user to make a choice.

The menu, for example, may look like this:

```
1 Enter the name

2 Enter age

3 Enter height

...

0 Exit

Select an action (enter a number from 1 to N)
```

In the program, instead of _N_, there should be an integer - the serial number of the last item before the exit (depends
on the number of menu items).

After selecting the **Exit** item, the program should exit.

After selecting other items, the declared action should be performed. After it is completed, the menu is printed again
and the program waits for the user to make a choice.

At this stage, you can simply display information about the selected item on the console when selecting a menu item, for
example

`Item 2 is selected - height input.`

The entire implementation is in the `main` method. For implementation, use the `witch` statement and the `while` loop (
similar to C), a scanner for input.

To exit the program, you can call the `return;` statement when you select the Exit item.

# Практичне заняття 2. Основні мовні конструкції Java

**Завдання 1)**  Написати програму для введення інформації про людину. Через сканер вводити ім’я , вік, зріст, вагу.
Потім вивести введену інформацію за допомогою функції printf.

**Завдання 2)** Написати програму, яка виводить на консоль деяке пронумероване меню і чекає від користувача вибору.

Меню, наприклад, може виглядати так:

```
1 Введіть ім’я

2 Введіть вік

3 Введіть зріст

…

0 Вихід

Виберіть дію (введіть номер від 1 до N)
```

У програмі замість _N_ повинно стояти ціле число – порядковий номер останнього перед виходом пункту (залежить від
кількості пунктів меню).

Після вибору пункту **Вихід** програма повинна закінчити роботу.

Після вибору інших пунктів повинна виконуватись заявлена дія. Після її завершення знову друкується меню і програма чекає
від користувача вибору.

На цьому етапі можна при виборі пункту меню просто виводити на консоль інформацію про вибраний пункт, наприклад

`Вибрано пункт 2 – ввід зросту.`

Вся реалізація знаходиться в методі `main`. Для реалізації використати оператор `switch` та цикл `while` (аналогічні C),
сканер для вводу.

Для виходу з програми можна при виборі пункту Вихід викликати оператор `return;` .