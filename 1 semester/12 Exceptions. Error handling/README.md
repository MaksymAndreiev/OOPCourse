# Practice exercise 12. Exceptions. Handling of errors

1) Create the class MySimpleContainer, which stores integers (`int`). The container has a fixed size (set in the
   constructor when created), methods for adding/removing, reading/modifying elements.
   In the class, an array of integers is represented by a private field `ar` of type `int[]`, the number of elements is
   stored in the size field (similar to the Vector class, but simpler, without changing the size of the array).
   Obviously, 0<= `ar.size`<= `ar.length`, the elements in the container are placed in a row without spaces, can occupy
   positions in the array from 0 to `ar.size`-1 (inclusive).
   The class has methods:
   ```
   MySimpleContainer(int capacity); //k-p, array of size capacity
   String toString() //returns a string in the format: [1,5,...,3]
   int size() //returns the number of items entered into the container
   int get(int index) //returns the value of the specified element
   of the container
   int set(int index, int newValue) //sets the value to the
   to the specified position, returns the old value
   void add(int newValue) //adds an item to the container
   to the end
   int remove() //removes the last added item in the container,
   returns the removed element
   ```
   When we call constructors or methods, it is possible that they cannot be executed due to incorrect input parameters
   or other reasons. For example:
   It is impossible to remove an element from an empty container, add it to a fully filled container. You cannot read or
   change an element in a non-existent position.
   The user of the class, or the code that calls these methods, must receive information about these situations. In
   Java, in such cases, exceptions are thrown that are handled in external code.
2) Create your own exception classes `MyFullContainerException`, `MyEmptyContainerException`, `MyWrongParamException` (
   see Practice 12-TDO), create and throw these exceptions in the code of the methods of the `MySimpleContainer` class
   in case of appropriate situations.
   `MyWrongParamException`:
   constructor when `capacity`<=0 (you can prohibit the creation of a container with a size less than, for example, 5)
   `get(int index)`, `set(int index, int newValue)`, if index is not in the range 0 <= `index` <`size`
   `MyFullContainerException`: `add(int newValue)` method in case of a full container
   `MyEmptyContainerException`: `remove()` method in case of an empty container
3) In the main method, test the `MySimpleContainer` class. Organize the interception of exceptions.
   Call the constructor with an incorrect and correct parameter.
   On the object created by the constructor with the correct parameter, test all methods, create situations when they
   work correctly and when exceptions are thrown.

# Практичне заняття 12. Виключення. Обробка помилок

1) Створити клас MySimpleContainer, в якому зберігаються цілі числа (`int`). Контейнер має фіксований розмір (задається
   в конструкторі при створенні), методи додавання/вилучення, читання/зміни елементів.
   В класі масив цілих чисел представлений закритим (`private`) полем  `ar`  типу `int[]`, кількість елементів
   зберігається в полі size (аналогічно класу Vector, але простіше, без зміни розміру масиву). Очевидно, що
   0<= `size`<=`ar.length`, елементи в контейнері розміщені підряд без пропусків, можуть займати в масиві позиції від 0
   до `size`-1 (включно).
   Клас має методи:
   ```
   MySimpleContainer(int capacity); //к-р, масив розміром capacity
   String toString() //повертає рядок в форматі: [1,5,…,3]
   int size() //повертає кількість елементів, введених в контейнер
   int get(int index) //повертає значення вказаного елементу
   контейнера
   int set(int index, int newValue) //установлює значення у
   вказану позицію, повертає старе значення
   void add(int newValue) //додає елемент у контейнер
   в кінець
   int remove() //вилучає останній доданий елемент в контейнері,
   повертає вилучений елемент
   ```
   Коли ми викликаємо конструктор або методи, можлива ситуація, коли вони не можуть бути виконані із-за неправильних
   вхідних параметрів чи інших причин. Наприклад:
   Неможливо видалити елемент із пустого контейнера, додати в повністю заповнений. Не можна прочитати чи змінити елемент
   в неіснуючій позиції.
   Користувач класу, чи код, який викликає ці методи, повинен отримати інформацію про ці ситуації. В Java в таких
   випадках генерують виключення, які оброблюються в зовнішньому коді.
2) Створити власні класи виключень `MyFullContainerException`, `MyEmptyContainerException`, `MyWrongParamException`. (
   див. Практика12-ТДО), створити і викинути ці виключення в коді методів класу `MySimpleContainer` в разі виникнення
   відповідних ситуацій.
   `MyWrongParamException`:
   конструктор при `capacity`<=0 (можна заборонити створювати контенер з розміром менше, наприклад, 5)
   `get(int index)`, `set(int index, int newValue)`, якщо index не знаходиться в діапазоні 0 <= `index` <`size`
   `MyFullContainerException`: метод `add(int newValue)` у випадку заповненого контейнера
   `MyEmptyContainerException`: метод `remove()` у випадку пустого контейнера
3) У методі main протестувати клас `MySimpleContainer`. Організувати перехоплення виключних ситуацій.
   Викликати конструктор з неправильним і правильним параметром.
   На об’єкті, створеному конструктором з правильним параметром, протестувати всі методи, створити ситуації, коли вони
   працюють правильно і коли генеруються виключення.
