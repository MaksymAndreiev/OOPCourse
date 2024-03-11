# Laboratory work 4. Interface + composition + delegation

1. Create queue and stack classes.
   A queue is an object for temporary storage of items. Elements are added and removed from the stack according to the
   FIFO principle:  first input - first output. A stack is an object for temporary storage of elements. Items are added
   to and removed from the stack on a LIFO basis: last input - first output.
   The `MyQueue` queue class must implement the `IMyQueue` interface:
   ````
   interface IMyQueue {
   void enqueue(double val); // add an item to the end of the queue
   double dequeue(); //remove an item from the beginning of the queue
   double peek();();//look at the beginning of the queue (do not remove)
   int getSize(); //number of items in the queue
   void clear(); //clear the queue
   }
   ````
   The `MyStack` stack class must implement the `IMyStack` interface
   ````
   interface IMyStack {
   void push(double val); //add an element to the end of the stack
   double pop(); //remove an element from the end of the stack
   double peek();//look at the end of the stack (do not remove)
   int getSize(); //number of elements on the stack
   void clear(); //clear the stack
   }
   ````
   The size of the stack or queue is not limited.
   We programmed similar methods under other names in the `Vector` class.
   It can be used by converting it to store elements of type `double`. But inheriting the MyQueue and `MyStack` classes
   from the `Vector` class is not suitable, since all public methods of the `Vector` ancestor class will be available to
   users of the `MyQueue` and `MyStack` classes.
   You should use composition and delegation:
   ````
   class MyQueue implements IMyQueue {
   private Vector v = new Vector();; // composition
   //add an element to the end of the queue
   void enqueue(double val){ // delegation
   v.add(val);
   }
   // other interface methods
   ...
   }
   ````
   In the `main` method, "test" the classes: create stack and queue objects. Test all methods.
   **Notes**.
    1) Stack and queue operations can be delegated not to the `Vector` class, but to the ArrayList library class:
       ````
       class MyQueue implements IMyQueue {
          private arrayList<Double> v = new arrayList<>();
          ...
       }
       ````
    2) Classes can be placed in one file (only one class `public`).
2. Create versions of the queue and stack classes that implement the common `Container` interface.
   As you can easily see from the previous paragraph, the stack and the queue are very similar. Both are some kind of
   container that provides two operations: 1) add an element, 2) delete an element; (differences in implementation are
   already internal affairs of classes). Therefore, it will be useful to allocate a separate abstraction for this case -
   the `Container` interface:
   ````
   interface Container {
   void put(double val); //add an element
   double get(); //get the element
   double peek();();//view the element (do not take it away)
   int getSize(); //number of items in the container
   void clear(); //clear the container
   }
   ````
   New versions can be created in the same project (file) if the classes are given different names (for
   example, `MyQueue2` and `MyStack2`). Then the execution of methods can be delegated to the first version:
   ````
   class MyQueue2 implements Container {
   private MyQueue mq = new MyQueue();; // composition
   // add an item to the end of the queue
   void put(double val){
   mq.enqueue(val);
   }
   // other interface methods
   ...
   }
   ````
   In the main method, "test" the classes. Since `MyQueue2` and `MyStack2` implement the `Container` interface,
   references to these stack and queue objects can be stored in the `Container[]` array. Test all methods.

# Лабораторна робота 4. Інтерфейс + композиція + делегування

1. Створити класи черги та стеку.
   Черга це об’єкт для тимчасового зберігання елементів. Елементи додаються і забираються зі стеку по принципу FIFO:
   first input - first output (перший прийшов – перший пішов ). Стек це об’єкт для тимчасового зберігання елементів.
   Елементи додаються і забираються зі стеку по принципу LIFO:  last input - first output (останній прийшов – перший
   пішов ).
   Клас черги `MyQueue` має реалізувати інтерфейс `IMyQueue`:
   ````
   interface IMyQueue {
   void enqueue(double val); //додати елемент в кінець черги
   double dequeue(); //забрати елемент з початку черги
   double peek();();//подивитись на початок черги (не забирати)
   int getSize();  //кількість елементів в черзі
   void clear();   //очистити чергу
   }
   ````
   Клас стеку `MyStack` має реалізувати інтерфейс `IMyStack`
   ````
   interface IMyStack {
   void push(double val); //додати елемент в кінець стеку
   double pop();  //забрати елемент з кінця стеку
   double peek();//подивитись на кінець стеку(не забирати)
   int getSize(); //кількість елементів в стеку
   void clear();  //очистити стек
   }
   ````
   Розмір стеку чи черги не обмежений.
   Аналогічні методи під іншими іменами ми програмували в класі `Vector`.
   Його можна використати, переробивши на зберігання елементів типу `double`. Але наслідування класів MyQueue
   та `MyStack` від класу `Vector` не підходить, тому що всі публічні методи класу-предка `Vector`  будуть доступні
   користувачам класів `MyQueue` та `MyStack`.
   Слід використати композицію та делегування:
   ````
   class MyQueue implements IMyQueue {
   private Vector v = new Vector();;   // композиція
   //додати елемент в кінець черги
   void enqueue(double val){ // делегування
   v.add(val);
   }
   //інші методи інтерфейсу
   …
   }
   ````
   У методі `main` провести «випробування» класів: створити об'єкти стека та черги. Випробувати всі методи.
   **Зауваження**.
    1) Операції стеку та черги можна делегувати не класу `Vector` а бібліотечному класу ArrayList:
       ````
       class MyQueue implements IMyQueue {
          private arrayList<Double> v = new arrayList<>();
          …
       }
       ````
    2) Класи можна розташувати в одному файлі (тільки один клас `public`).
2. Створити версії класів черги та стеку, які імплементують спільний інтерфейс `Container`.
   Як легко бачити з попереднього пункту, стек і черга дуже схожі. І те, і інше - це деякий контейнер, що надає дві
   операції: 1) додати елемент, 2) видалити елемент; (Відмінності в реалізації - це вже внутрішні справи класів). Тому
   буде корисно виділити під цю справу окрему абстракцію – інтерфейс `Container`:
   ````
   interface Container {
   void put(double val); //додати елемент
   double get(); //забрати елемент
   double peek();();//подивитись елемент (не забирати)
   int getSize();  //кількість елементів в контейнері
   void clear();   //очистити контейнер
   }
   ````
   Нові версії можна створити в тому ж проекті (файлі), якщо класам задати інші імена (наприклад `MyQueue2`
   та `MyStack2`). Тоді виконання методів можна делегувати першій версії:
   ````
   class MyQueue2 implements Container {
   private MyQueue mq = new MyQueue();;   // композиція
   //додати елемент в кінець черги
   void put(double val){
   mq.enqueue(val);
   }
   //інші методи інтерфейсу
   …
   }
   ````
   У методі main провести «випробування» класів. Оскільки `MyQueue2` та `MyStack2` імплементують інтерфейс  `Container`,
   посилання на ці об'єкти стека та черги можена запам’ятати в масиві` Container[]`. Випробувати всі методи.
