# Laboratory work 2. Vectors

**A "rubber array "** is a data structure in which n elements of the same type are stored one by one (without gaps) in
memory, and which automatically expands when new elements are added.

It supports 4 main operations:

- read an element at a given position;
- replace the (existing!) item at a given position;
- add a new item at a given position (shifting other items to the right);
- delete an element at a given position (with the other elements shifted to the left).
  A typical implementation (using the insertion operation as an example):

```
    public void insert(double val, int pos){

        if(all space is occupied){

            create a new array 2 times larger

            copy the elements

            assign a reference to it to the "old" array arr

        }//if.

        // the actual insertion:

        shift elements from pos to size-1 by 1 position to the right

        write val to position pos

        increase size by 1

    }//insert
```

The described functionality can be implemented using a "classical" pair: an array vec, allocated "with a margin", and
the variable size - how many elements of the array are currently in use.

The number of elements `size <= arr.length`. If `size == vec.length` - all places are occupied

### Task

Develop a Vector class to implement a "rubber" array (vector) of integers (the number of elements in the array can be
arbitrarily changed while working with it). Implement methods for getting and changing an element at a given position,
inserting an element at an arbitrary (existing) position and at the end, deleting an element from an arbitrary position,
deleting all elements.

Write the constructors:

```
Vector(); // creates an array of size 8, size=0

Vector(int capacity); //creates an array of size capacity, size=0

Vector(int[] ar); //creates an array as a copy of an existing one

                 //array ar (and some margin), size==ar.length
```

The class must support the following operations (public methods):

```
String toString() // returns a string with the size of the elements in the format:

                  // [1,5,...,3]

int size() //returns the number of inserted elements (size)

boolean isEmpty() //true if size==0

int capacity() //vector capacity vec.length

int get(int index)//returns the value of the specified vector element

int remove(int index); //returns the value of the specified element

                       //of the vector and removes it from the vector

int set(int index, int newValue) //sets the value to the specified

                    //position of the vector, returns the old value

void add(int value) //inserts an element at the end of the vector

boolean add(int index, int value) //inserts an element at position

     //If index is incorrect, no insertion is performed,

     // false is returned
     void addAll(int[] ar) //inserts elements of array ar

     //to the end of the vector

boolean addAll(int index, int[] ar) //inserts array elements

    //ar at position index, that is, elements from index to size-1

    //are shifted to the right by the length of the array ar. If index

    //is incorrect, the insertion does not occur false is returned

boolean equals(Vector other) //compares arrays of two vectors

void clear();//cleans the vector, just assign size=0
```

**Remark**. Some methods have an index parameter whose valid values range from 0 to size-1. If the index parameter has an
invalid value, nothing is done in the method. Methods that return an int instead of a boolean, for information about
this, let them return (-666)

In the `main` method, conduct a "test" of the class:

Create several objects using different constructors

Test all methods.

# Лабораторна робота 2. Вектори

**"Гумовий масив"** - структура даних, в якій n однотипних елементів зберігаються один за іншим (без пропусків) в
пам’яті, і яка автоматично розширюється при додаванні нових елементів.

Підтримує 4 основні операції:

- прочитати елемент в заданій позиції;
- замінити (існуючий!) елемент в заданій позиції;
- додати новий елемент в задану позицію (із зсувом інших елементів вправо);
- видалити елемент в заданій позиції (із зсувом інших елементів вліво).
  Типова реализация (на прикладі операції вставки):

```
    public void insert(double val, int pos){

        if(все місце зайнято){

            створити новий масив в 2 раза більше

            скопіювати елементи

            присвоїти посилання на нього "старому" масиву arr

        }//if

        // власне вставка:

        зсунути елементи від pos до size-1 на 1 позицію вправо

        в позицію pos записати val

        збільшити size на 1

    }//insert
```

Описану функціональність можна реалізувати за допомогою "класичної" пари: масиву vec, виділеного "з запасом", і змінної
size - скільки елементів масиву використовується на даний момент.

Кількість елементів  `size <= arr.length`. Якщо `size == vec.length` – всі місця зайнято

### Завдання

Розробити клас Vector для реалізації «гумового» масиву (вектора) цілих чисел (кількість елементів в масиві може довільно
змінюватися в ході роботи з ним). Реалізувати методи отримання і зміни елемента в заданій позиції, вставки елемента в
довільну (існуючу) позицію а також в кінець, видалення елемента з довільної позиції, видалення всіх елементів.

Написати конструктори:

```
Vector(); //створює масив розміром 8, size=0

Vector(int capacity); //створює масив розміром capacity, size=0

Vector(int[] ar);//створює масив у вигляді копії вже існуючого

                 //масиву ar (і деякого запасу), size==ar.length
```

Клас повинен підтримувати наступні операції (public-методи):

```
String toString() //повертає рядок із size елементів в форматі:

                  // [1,5,…,3]

int size() //повертає кількість вставлених елементів (size)

boolean isEmpty() //true якщо size==0

int capacity()  //місткість вектора vec.length

int get(int index)//повертає значення вказаного елементу вектора

int remove(int index); //повертає значення вказаного елементу

                       //вектора і видаляє його з вектора

int set(int index, int newValue) //установлює значення в указану

                    //позицію вектора, повертає старе значення

void add(int value) //вставляє елемент в кінець вектора

boolean add(int index, int value) //вставляє елемент в позицію

     //index. Якщо index неправильний, вставка не відбувається,

     // повертається false

void addAll(int[] ar) //вставляє елементи масиву ar

     //в кінець вектора

boolean addAll(int index, int[] ar) //вставляє елементи масиву

    //ar в позицію index, тобто елементи від index до size-1

    //зсуваються вправо на довжину масиву ar. Якщо index

    //неправильний, вставка не відбувається повертається false

boolean equals(Vector other) //порівнює масиви двох векторів

void clear();//очищує вектор, достатньо присвоїти size=0
```

**Зауваження**. Деякі методи мають параметр index, допустимі значення якого в діапазоні від 0 до size-1. Якщо параметр
index має недопустиме значення - в методі нічого не робиться. Методи, що повертають не boolean а int, для інформації про
це нехай повертають (‑666)

У методі `main` провести «випробування» класу:

Створити кілька об'єктів, використовуючи різні конструктори

Випробувати всі методи.