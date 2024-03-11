# Practical exercise 1. Class Thread

1. Analyze examples 1-4 of practical lesson 1 (P1sem3.doc). Run the examples, explain the output to the console.
2. Create a program that creates several threads with different priorities. Make one thread with an infinite loop a
   daemon. Display on the console as much data as possible about the threads. Explain the output to the console, the
   order of completion of threads.
3. Create a program that creates three threads. When creating, a string of some text is passed to each thread (set in
   the code or read from a file).
   In each thread, the string is split into characters (charAt) and displayed character by character in a loop on the
   console. After outputting one character, make a short pause (sleep(1)). Option: the string is split into words (
   split). Let's experiment with the size of the pause. How to organize the output?
4. Create a program in which we change one variable from two competing threads (a shared resource). Create the shared
   resource in the main as a class object with one numeric field (class Account). That is, we will simulate working with
   an account - depositing/withdrawing funds. A reference to the object must be passed to the threads when they are
   created in the constructor. In one thread, this variable is incremented 100 times in a cycle by 1, in the other 100
   times by 1. That is, at the end of the threads, the account should have the initial value. In loops, in addition to
   changing the count, you can make a short pause (sleep(1)), simulating work. You can also try to break the count
   change with a pause:
   ````
   int a = account.x;
   sleep(1);
   account.x=a+1;
   ````

# Практичне заняття 1. Клас Thread

1. Розібрати приклади 1-4 практичного заняття 1 (П1сем3.doc). Запустити приклади, пояснити вивід на консоль.
2. Створити програму, в якій створюється кілька потоків з різними пріоритетами. Один потік з нескінченним циклом зробити
   демоном. Виводити на консоль як можна більше даних про потоки. Пояснити вивід на консоль, порядок завершення потоків.
3. Створити програму, в якій створюється три потоки. При створенні в кожен потік передається рядок деякого тексту (
   задати в коді або прочитати з файла).
   В кожному потоці рядок розбивається на символи (charAt) і посимвольно в циклі виводиться на консоль. Після виводу
   одного символу робити невелику паузу (sleep(1)). Варіант: рядок розбивається на слова (split). Експериментуємо з
   величиною паузи. Як упорядкувати вивід?
4. Створити програму, в якій з двох конкуруючих потоків змінюємо одну змінну (спільний ресурс). Спільний ресурс створити
   в main як об’єкт класу з одним числовим полем (клас Account). Тобто будемо імітувати роботу з рахунком –
   класти/знімати кошти. Посилання на об’єкт потрібно передати в потоки при їх створенні в конструктор. В одному потоці
   цю змінну збільшувати 100 раз в циклі на 1, в іншому 100 раз зменшувати на 1. Тобто в кінці роботи потоків рахунок
   повинен мати початкове значення. В циклах можна крім зміни рахунку робити коротку паузу (sleep(1)), імітуючи роботу.
   Спробувати також розбити зміну рахунку паузою:
   ````
   int a = account.x;
   sleep(1);
   account.x=a+1;
   ````