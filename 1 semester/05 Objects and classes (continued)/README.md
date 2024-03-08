# Practical exercise 5. Objects and classes (continued)
1) Program the Stakan class, make it work correctly.

As you know, a glass has two main characteristics: mass (double mass) and volume (double volume) of the liquid it holds. You have started to compile a catalog of all the glasses in your cafeteria. Develop a class for this task.

The class will be called Stakan, and it will support the following operations (public methods):
````
Stakan(); // default constructor

Stakan(double m, double v); // constructor with parameters

double getMass();

double getVolume();

boolean setMass(double m); // returns true if successful

boolean setVolume(double v);

String toString();
````
Add another field to the Stakan class: double content - the volume of liquid poured into the glass. Create methods
````
double getContent()

boolean setContent(double с).
````
Initially, content = 0.

Technical details.

set methods return true if the glass is successfully modified and false if the input data is incorrect. For mass and volume, values equal to or less than zero are obviously incorrect (and for content ?).

In case of passing incorrect parameters to the constructor, use the default mass of 30 and volume of 200.

The toString() method returns a string with information in the following format:

"Mass: 30.0 g, Volume: 200.0 ml, Content: 0.0 ml".

In the main method, conduct a "test" of the class:

Create several objects using different constructors

Create an array of objects

Test all methods in the method.

# Практичне заняття 5. Об’єкти та класи (продовження)
1) Запрограмувати клас Stakan, заставити його правильно працювати.

Як відомо,  у стакана є дві основні характеристики: маса (double mass) та об’єм (double volume) рідини, що вміщується. Ви зайнялися складанням каталогу всіх стаканів в вашому буфеті. Розробіть під цю задачу клас.

Клас буде називатися Stakan, і він буде підтримувати наступні операції (public-методи):
````
Stakan();                   // конструктор за замовчуванням

Stakan(double m, double v); // конструктор з параметрами

double getMass();

double getVolume();

boolean setMass(double m); //повертає true у випадку успіху

boolean setVolume(double v);

String toString();
````
Додати в клас Stakan ще одно поле: double content  - об’єм налитої в стакан рідини. Створити  методи
````
double getContent()

boolean setContent(double с).
````
Спочатку  content = 0.

Технічні деталі.

set-методи повертають true у випадку успішної модифікації стакана и false - у випадку некоректних вхідних даних. Для маси і об’єму некоректними очевидно є значення рівне або менше нуля (а для content  ?).

У випадку передачі некоректних параметрів у конструктор, і в конструкторі за замовченням використати масу 30 і об’єм 200.

Метод toString() повертає рядок з інформацією в такому форматі:

"Mass: 30.0 g, Volume: 200.0 ml, Content: 0.0 ml".

В методі main провести «випробування» класу:

Створити кілька об’єктів, використовуючи різні конструктори

Створити масив об’єктів

Випробувати всі методи в методі.