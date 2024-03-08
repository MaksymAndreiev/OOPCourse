# Practical exercise 6. Objects and classes (end)

Create the MyArray class, which encapsulates a one-dimensional array of integers (int) and methods (some operations on
the array, similar to Task 2 from Task 3, but in a class).  
In the class, the array of integers is represented by a private field of the class of type int[]. This field is
initialized in the constructor.
Write the constructors:

   ```   
   MyArray(); //default constructor, creates an array of size 8
   MyArray(boolean f); // creates an array of size 8, if f==true
   // the array is filled with random numbers 0-10
   MyArray(int size); //creates an array of size
   MyArray(int size, boolean f); //creates an array of size,
   //if f==true, the array is filled with random numbers 0-10
   MyArray(int[] ar); //creates an array - a copy of ar
   ```

The class must support the following operations (public methods):

   ````
   void fill(int k) // array is filled with random numbers 0-k
   String toString() // returns a string in the format: [1,5,...,3]
   int size() //returns the size of the array
   int get(int index) //returns the value of the specified array item
   int set(int index, int newValue) //sets the value to the specified position, returns the old value
   void sort(boolean f) // sorts the array in ascending order(f==true)
   // descending (f==false)
   int[] subArray(int indexFrom, int indexTo) // returns a new
   // array of elements from indexFrom to indexTo
   boolean equals(MyArray other) // compares arrays of two objects
   ````

Remarks.

1) Numbering of elements from 0, that is, 0 <= index < size()
2) The get() and set() methods return -1 (?) if the index is incorrect.
3) The subArray() method returns the existing elements of the specified range
4) The equals() method returns true if two objects have arrays of the same size with the same elements.
   In the main() method, test all public methods of the class. Check the equals() method in the following cases: a) in
   two objects arrays of different sizes; b) arrays of the same size and different elements; c) arrays of objects being
   compared are identical.

Translated with DeepL.com (free version)

# Практичне заняття 6. Об’єкти та класи (закінчення)

Створити клас MyArray, в якому інкапсульовано одновимірний масив цілих чисел (int) та методи (деякі операції над
масивом, подібно задачі 2 із Завдання3, але в класі).  
В класі масив цілих чисел представлений закритим (private) полем класу типу int[]. Це поле ініціалізується в
конструкторі.
Написати конструктори:

   ```   
   MyArray(); //к-р за замовчуванням, створює масив розміром 8
   MyArray(boolean f); //створює масив розміром 8, якщо f==true
   // масив заповнюється випадковими числами 0-10
   MyArray(int size); //створює масив розміром size
   MyArray(int size, boolean f); //створює масив розміром size,
   //якщо f==true масив заповнюється випадковими числами 0-10
   MyArray(int[] ar); //створює масив – копію ar
   ```

Клас повинен підтримувати наступні операції (public-методи):

   ````
   void fill(int k)  // масив заповнюється випадковими числами 0-k
   String toString() //повертає рядок в форматі: [1,5,…,3]
   int size() //повертає розмір масиву
   int get(int index) //повертає значення вказаного елементу масиву
   int set(int index, int newValue) //установлює значення у вказану позицію, повертає старе значення
   void sort(boolean f) //сортує масив в порядку зростання(f==true)
   // спадання (f==false)
   int[] subArray(int indexFrom, int indexTo) //повертає в новому
   // масиві елементи від indexFrom до indexTo
   boolean equals(MyArray other) //порівнює масиви двох об’єктів
   ````

Зауваження.

1) Нумерація елементів від 0, тобто 0 <= index < size()
2) Методи get() і set()  у випадку неправильного індексу повертають -1 (?).
3) Метод subArray() повертає існуючі елементи вказаного діапазону
4) Метод equals() повертає true у випадку, якщо у двох об’єктів масиви однакового розміру з однаковими елементами.
   В методі main() випробувати всі публічні методи класу. Перевірку методу equals() виконати у випадках: а) в двох
   об’єктах масиви різних розмірів; б) масиви одного розміру і різні елементи; в) масиви об’єктів, що порівнюються,
   ідентичні. 
