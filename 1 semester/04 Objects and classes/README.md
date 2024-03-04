# Practical exercise 4. Objects and classes

1) Write a program from the subroutine for calculating the factorial in three variants that return the result
   of type `int`, `long`, `double`. (`factorial()`, `factorialL()`, `factorialD()`)

In the `main` procedure, print the results in the form of a table for an argument from 1 to 20:

```
n   factorial(n)        factorialL(n)      factorialD(n)

1      1                    1                    1.0

2      2                    2                    2.0

    …

20
```

2) Create a function (`static double f(x)`), which with an accuracy of $10^-6$ calculates the functional (power) series
   for the function
   $e^-x$

$e^{-1} = \sum_{k=0}^{\infty} (-1)^k\frac{x^k}{k!} = 1 - \frac{x}{1} + \frac{x^2}{2!} - \frac{x^3}{3!} + \ldots + (-1)
^k\frac{x^k}{k!}$

The calculation of the sum stops when the addition to the sum (not the sum itself) becomes less than $10^-6$ by absolute
value.

In the main function, call the function for different x (for example, x=1.0; x=-1.0) and print the result in the form:

`x= ... f(x)= ......`

To calculate the factorial, you should use `factorialD(n)`, since it is not known in advance at which _k_ will stop the
calculation of the sum will stop. The functions `factorial(n)` and `factorialL(n)` have restrictions on the parameter
_n_.

*You can not calculate the factor directly (using a method).

You can find the next term in the series using the previous one:

$u_k(x) = \frac{(-1)^k \cdot x^k}{k!} \Rightarrow k \Rightarrow u_{k+1}(x) = \frac{(-1)^{k+1} \cdot x^{k+1}}{(k+1)!}
\Rightarrow d_k(x) = \frac{u_{k+1}(x)}{u_k(x)} = \frac{(-1)^{k+1} \cdot x^{k+1}}{(k+1)!} \cdot \frac{k!}{(-1)^k \cdot
x^k} = \frac{(-1) \cdot x}{k+1}$

Eq.

$u_{k+1}(x) = d_k(x) \cdot u_k(x)$

# Практичне заняття 4. Об’єкти та класи

1) Написати програму з підпрограми обчислення факторіала в трьох варіантах, які повертають результат
   типу `int`, `long`, `double`. (`factorial()`, `factorialL()`, `factorialD()`)

В процедурі `main` роздрукувати результати у вигляді таблиці для аргументу від 1 до 20:

```
n   factorial(n)        factorialL(n)      factorialD(n)

1      1                    1                    1.0

2      2                    2                    2.0

    …

20
```

2) Створити функцію (`static double f(x)`), в якій з точністю $10^-6$ рахується функціональний (степеневий) ряд для
   функції
   $e^-x$

$e^{-1} = \sum_{k=0}^{\infty} (-1)^k\frac{x^k}{k!} = 1 - \frac{x}{1} + \frac{x^2}{2!} - \frac{x^3}{3!} + \ldots + (-1)
^k\frac{x^k}{k!}$

Підрахунок суми припиняється, коли добавка до суми (не сама сума) стане по модулю менше $10^-6$.

В функції main викликати функцію при різних x (наприклад х=1.0; х=-1.0) та надрукувати результат у формі:

`x= … f(x)= ……`

Для обчислення факторіалу слід використовувати `factorialD(n)`, оскільки наперед невідомо, при яких _k_ припинеться
обчислення суми. Функції `factorial(n)` і `factorialL(n)` мають обмеження по параметру _n_.

*Факторіал можна не рахувати напряму (за допомогою методу).

Можна знаходити наступний член ряду, використовуючи попередній:

$u_k(x) = \frac{(-1)^k \cdot x^k}{k!} \Rightarrow k \Rightarrow u_{k+1}(x) = \frac{(-1)^{k+1} \cdot x^{k+1}}{(k+1)!}
\Rightarrow d_k(x) = \frac{u_{k+1}(x)}{u_k(x)} = \frac{(-1)^{k+1} \cdot x^{k+1}}{(k+1)!} \cdot \frac{k!}{(-1)^k \cdot
x^k} = \frac{(-1) \cdot x}{k+1}$

Отже

$u_{k+1}(x) = d_k(x) \cdot u_k(x)$
