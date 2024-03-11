# Laboratory work 1. Multithreading

Implement 2 versions of a multi-threaded program with allegedly "heavy computations". As "heavy computations", calculate
the number Pi using the Leibniz series:
`4*(1 - 1/3 + 1/5-1/7 + 1/9 -...)`
In the first variant, use ``synchronized`` (blocks or methods), in the second - ``ReentrantLock``
**Note**: this series converges very poorly, so to achieve a more or less decent accuracy, you need to calculate for a
very long time.
In the main thread, implement a menu that will allow you to control the flow of calculations.
The program provides the user (in the console) with the following menu:

````
1. Continue calculations.
2. Stop the calculation.
3. View the current result.
4. Find out the total time spent on the calculation.
5. Exit.
````

Implement the menu in the main thread. The actual calculation of the series is performed by a separate thread (in an
infinite loop). The main thread can pause it (to do this, you need to force the computing thread to call `wait()`),
continue (`notify()`), show the current achieved calculation result (actually, the number Pi, but perhaps not very
accurate yet). When paused, the CPU utilization (in the "task manager") should drop to a small value of about 0, and
when continued, it should increase to about 100%. When the calculations are paused, the operation "see the current
result" should show the same thing when it is repeatedly executed (because the current value of Pi does not change);
during calculations, respectively, with each repeated viewing, Pi should become more and more accurate.
The "find out the total time" operation shows how many seconds (or milliseconds) the computational thread has been
running. That is, when it is "sleeping" in pause mode, this value does not change; when it is working, it increases at a
rate of "one second per second".

# Лабораторна робота 1. Багатопоточність

Реалізувати 2 варіанти многопоточної програми з нібито "важкими обчисленнями". В якості "важких обчислень" проводити
обчислення числа Пі з допомогою ряду Лейбніца:
`4*(1 - 1/3 + 1/5-1/7 + 1/9 -…)`
В першому варіанті використати `synchronized` (блоки або методи), в другому - `ReentrantLock`
**Примітка**: цей ряд дуже погано сходиться, тому щоб досягти більш-менш пристойної точності, треба дуже довго
обчислювати.
В головному потоці реалізувати меню, що дозволить управляти потоком обчислень.
Програма надає користувачеві (в консолі) меню наступного виду:

````
1. Продовжити обчислення.
2. Зупинити обчислення.
3. Подивитися поточний результат.
4. Дізнатися сумарний час, витрачений на обчислення.
5. Вихід.
````

Меню реалізувати в головному потоці. Власне обчислення ряду виконує окремий потік (в нескінченному циклі). Головний
потік може його призупинити (для цього потрібно змусити обчислювальний потік здійснити виклик` wait ()`),
продовжити (`notify()`), показати поточний досягнутий результат обчислень (власне, число Пі, але можливо поки не дуже
точне). При призупиненні завантаженість процесора (в "диспетчері завдань") повинна падати до невеликого значення близько
0, при продовженні - зростати до близько 100%. Коли обчислення призупинені, операція "подивитися поточний результат" при
багаторазовому її виконанні повинна показувати одне і те ж (бо поточне значення Пі не змінюється); під час обчислень -
відповідно - при кожному повторному перегляді Пі повинно ставати все точніше і точніше.
Операція "дізнатися сумарний час" - показує скільки секунд (чи мілісекунд) пропрацював обчислювальний потік. Тобто, коли
він "спить" в режимі паузи - ця величина не змінюється; коли працює - збільшується зі швидкістю "одна секунда в
секунду".
