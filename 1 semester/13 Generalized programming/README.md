# Practical exercise 13. Generalized programming

Make the class `MySimpleContainer` from task 12 generalized, adapted for storing objects of a given type T.
`public class MySimpleContainer <T> {...}`
The letter T in the class definition indicates that this type T will be used by this class, the collection stores
objects of this type
of this type are stored in the collection.
Objects are stored in a private array ar. The array is created in the constructor, its size does not change. But in Java
it is forbidden to create arrays of generic types, we will not be able to perform the operation `T[ ] ar = new T[10];`.
Therefore, we will declare an array of type `Object[ ]` in the class, which we initialize in the constructor.

````
Object[] ar;
ar = new Object[n]; //constructor
````

Some of the methods will become generic:

````
T get(int index)
T set(int index, T newObject)
void add(T newValue)
T remove()
````

In the `add` function, an object of type T is entered into an array of type `Object`, which is acceptable,
since `Object` is the ancestor of all types (classes).
In methods that return an object, you need to cast the type `Object` to type T, which is acceptable, since it is
impossible to
insert an object into the list that is incompatible with T:

````
T get(int index) {
...
return (T)ar[index];
}
````

In the `main` method, test the `MySimpleContainer` class.
Create instances of MySimpleContainer with different types (`String`, `Integer`, `Double`, ...)
Organize the interception of exceptions.
On an object created by the constructor with the correct parameter, test all methods, create situations when they
work correctly and when exceptions are thrown.

# Практичне заняття 13. Узагальнене програмування

Клас `MySimpleContainer` із завдання 12 зробити генералізованим, пристосованим для зберігання об’єктів заданого типу T.
`public class MySimpleContainer <T> {…}`
Літера T у визначенні класу вказує, що даний тип T буде використовуватися цим класом, в колекції зберігаються об’єкти
цього типу.
Об’єкти зберігаються у приватному масиві ar. Масив створюється в конструкторі, його розмір не змінюється. Але в Java
заборонено створювати масиви узагальнених типів, ми не зможемо виконати операцію `T[ ]  ar = new T[10];`.
Тому в класі об’явимо масив типу `Object[ ]`, який ініціалізуємо у конструкторі.

````
Object[] ar;
ar = new Object[n]; //конструктор
````

Деякі з методів стануть узагальненими:

````
T get(int index)
T set(int index, T newObject)
void add(T newValue)
T remove()
````

У функції `add` об’єкт типу Т заноситься в масив типу `Object`, що допустимо, оскільки `Object` - предок всіх типів (
класів).
В методах, що повертають об’єкт, потрібно зробити приведення типу `Object` до типу Т, що допустимо, оскільки неможливо
вставити в список об’єкт, несумісний з Т:

````
T get(int index) {
...
return (T)ar[index];
}
````

У методі `main` протестувати клас `MySimpleContainer`.
Створити екземпляри MySimpleContainer з різними типами (`String`, `Integer`, `Double`, …)
Організувати перехоплення виключних ситуацій.
На об’єкті, створеному конструктором з правильним параметром, протестувати всі методи, створити ситуації, коли вони
працюють правильно і коли генеруються виключення.
