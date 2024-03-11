# Laboratory work 6. Exceptions. Generics

Finalization of laboratory work 5.

1. Let's make our simple collection class (in the form of an array) generic:
   ````
   public class MyArrayList<T> {...}
   ````
   The letter `T` in the class definition indicates that this type `T` will be used by this class, objects of this type
   are stored in the collection.
   Objects are stored in a private array `ar`. The array is created in the constructor, its size does not change. But in
   Java it is forbidden to create arrays of generic types, we will not be able to perform the
   operation `T[ ] ar = new T[10];`.
   Therefore, we will declare an array of type `Object[ ]` in the class, which we initialize in the constructor.
   ````
   Object[] ar;
   ar = new Object[n]; //constructor
   ````
   Some of the functions will become generic: `public boolean add(T o)`, `public T remove()`, etc.
   In the add function, an object of type `T` is entered into an array of type `Object`, which is acceptable,
   since `Object` is the ancestor of all types (classes). In methods that return an object, you need to cast the
   type `Object` to the type `T`, which is acceptable, since it is impossible to insert an object into the list that is
   incompatible with `T`:
   ````
   T get(int index) {
   ...
   return (T)ar[index];
   }
   ````
2. Also, in case of errors when calling class methods, we will throw exceptions and intercept and handle them in the
   code that calls these methods (`main`). You can use suitable library exceptions:
   `public MyArrayList(int n)` - `IllegalArgumentException`,
   if the size of the array is incorrect
   `public boolean add(T o)` - `IndexOutOfBoundsException`,
   if the array is full
   `public Integer remove()` - `NoSuchElementException` empty array

In the inner class of the collection iterator `MyListIteratorImpl`, some methods will become generic or will be able to
throw exceptions.
In the `main` method, conduct a "test" of classes. Create instances of `MyArrayList` with different
types (`String`, `Integer`, `Double`, ...) and then an instance of the literalizer.
`MyArrayList<String> aString = new MyArrayList<>(5);`
Test all methods (on an empty array, partially filled, completely filled).
Get all the exceptions thrown, catch them.

# Лабораторна робота 6. Виключення (винятки). Узагальнення (Generics)

Доопрацювання лабораторної роботи 5.

1. Наш простий клас колекції (у вигляді масиву) зробімо узагальненим:
   ````
   public class MyArrayList<T> {…}
   ````
   Літера `T` у визначенні класу вказує, що даний тип `T` буде використовуватися цим класом, в колекції зберігаються
   об’єкти цього типу.
   Об’єкти зберігаються у приватному масиві `ar`. Масив створюється в конструкторі, його розмір не змінюється. Але в
   Java заборонено створювати масиви узагальнених типів, ми не зможемо виконати операцію  `T[ ]  ar = new T[10];`.
   Тому в класі об’явимо масив типу `Object[ ]`, який ініціалізуємо у конструкторі.
   ````
   Object[] ar;
   ar = new Object[n]; //конструктор
   ````
   Деякі з функцій стануть узагаленими: `public boolean add(T о)`, `public T remove()` і т.д.
   У функції add об’єкт типу `Т` заноситься в масив типу `Object`, що допустимо, оскільки `Object` - предок всіх типів (
   класів). В методах, що повертають об’єкт, потрібно зробити приведення типу `Object` до типу `Т`, що допустимо,
   оскільки неможливо вставити в список об’єкт, несумісний з `Т`:
   ````
   T get(int index) {
   ...
   return (T)ar[index];
   }
   ````
2. Також у випадку помилкових ситуацій при виклику методів класу будемо генерувати виключення і перехоплювати та
   обробляти їх в коді, який ці методи викликає (`main`). Можна використовувати підходящі бібліотечні виключення:
   `public MyArrayList(int n)` – `IllegalArgumentException`,
   якщо неправильний розмір масиву
   `public boolean add(T o)` – `IndexOutOfBoundsException`,
   якщо масив заповнений
   `public Integer remove()` - `NoSuchElementException` пустий масив

У внутрішньго класу ітератора колекції    `MyListIteratorImpl` деякі методи стануть узагальненими або зможуть генерувати
виключення.
У методі `main` провести «випробування» класів. Створити екземпляри `MyArrayList` з різними
типами (`String`, `Integer`, `Double`, …)   і потім екземпляр літератора.
`MyArrayList<String> aString = new MyArrayList<>(5);`
Випробувати всі методи (на пустому масиві, заповненому частково, повністю).
Добитися появи всіх виключень, перехопити їх.
