# Laboratory work 5. Iterator + inner class

Java has a large library of collections. Collections are unlimited in fixed length as arrays and implement various
algorithms and data structures, for example, stack, queue, list, tree, etc. Different collections have different ways of
accessing elements. But all of them make it possible to create an object that implements the `Iterator` interface (or
its descendant), which allows sequential access to the elements of the collection.
Let's create a simple collection class (in the form of an array) and an inner class for implementing the iterator.
The `MyArrayList` collection class is a very simplified version of the `Vector` class without extending the array.
The class has variables ` private Integer[ ] ar;` and `int size`. The array is created in the constructor, its size does
not change. The `size` variable is initially zero, increases when adding items to the list, decreases when deleted.
When `size==ar.length`, methods for adding elements do not work, similarly, when `size==0`, methods for deleting do not
work.
In the class, implement the functions

````
public MyArrayList(int n) - constructor, n - array size
public boolean add(Integer n) - adding element n to the end of the
of the list, increase the size
public Integer remove() returns the last element (if it
exists) and removes it from the list (reduce the size)
public String toString() // returns a string with the size of the elements
format: [1,5,...,3]
int size() //the number of items in the list (size)
//Creates a reference to an object of the inner iterator class:
public MyListIterator iterator(){
return new MyListIteratorImpl();
}
````

The inner iterator class of the collection `MyListIteratorImpl` implements the `MyListIterator` interface. This
interface is similar to the `ListIterator<T>` interface from the collection library (package `java.util`)
at `T==Integer`.
The list iterator allows you to move through the list in any direction, change list items during iteration, and get the
current position (cursor) of the iterator in the list. The iterator does not have a current element; its position always
lies between the element that will be returned by the `prev()` call and the element that will be returned by
the `next()` call. A list iterator of length `n` has `n+1` possible cursor positions.
The `MyListIteratorImpl` class must have a field for the cursor position `int cursor`.
If the list has `size` elements, then the element numbers are from 0 to (`size`-1), the cursor has `size`+1 positions,
which can be numbered from 0 to `size`. Position `cursor=0` means the position at the beginning of the list
before `ar[0]`; position `cursor`=1 - after `ar[0]`, before `ar[1]`; `...`; position `cursor=size` - after the last
element `ar[size-1]` at the end of the list.
**Remark 1.**  Consider the behavior of `add`.

1) The elements of array ar[i] store the values of `Ei`. Let the cursor be between the 1st and 2nd elements, that
   is, `cursor=2` and the call `next` will return `E2` and the call `previous` will return `E1`.
   We make the call `add(newE)`. The cursor has moved one position, the elements `E2`, `E3`, `...` have moved to the
   right in the array, and `ar[2]` has been freed for `newE`. Calling next will return `E2` as before, and
   calling `previous` will return `newE`.
2) The list is initially empty. Call `add(newE)`. The cursor has moved one position. Calling `hasNext` will
   return `false`, and calling previous will return newE.
3) The cursor is at the end of the list, `hasNext` will return `false`. Call `add(newE)`. The cursor has moved one
   position and is again at the end of the list. The call to `hasNext` will return false, and the call to previous will
   return `newE`.
   **Remark 2.** Let's look at remove. The initial position of `cursor`=2. remove after next, removes the
   element `E1 (ar[1])`, passed by `next`. remove after `previous`, removes the element `E2 (ar[2])`, passed
   by `previous`.
   The inner class `boolean hasNext()` has full access to the fields and methods of the outer
   class `MyArrayList`: `ar`, `size`, etc.
   Some functions are sensitive to what functions were called before them:  `next` or `previous` or `add` or `remove`.
   Therefore, you need a field that is set when these functions are called and checked or re-set in other functions. For
   example

````
int func;   
func=-1; set when in the previous function
func=1; set when in the next function
func=0; set when in the add or remove function
````

So, in the class `MyArrayList` we define the `private class MyListIteratorImpl` (private so that its object is
created only by the `iterator` method):

````
private class MyListIteratorImpl implements MyListIterator{
int cursor = 0;
int func = 0;   
//Implementation of functions
    ...
}
````

Examples of method implementation:

````
public boolean hasNext(){
   return cursor<size;
}
public Integer next(){
   if (!hasNext()) return null;
   func = 1; cursor++;
   return ar[cursor-1];
}
````

In the `main` method, conduct a "test" of classes.Create an instance of `MyArrayList` and then an instance of the
writer. Test all methods (on an empty array, partially filled, completely filled).

````
MyArrayList ma = new MyArrayList();
ma.add(1);
System.out.println(ma.toString());
MyListIteratorImpl it = ma.iterator();
it.next();
````

# Лабораторна робота 5. Ітератор + внутрішний клас

Java має велику бібліотеку колекцій. Колекції необмежені фіксованою довжиною як масиви і реалізують різні алгоритми та
структури даних, наприклад, стек, черга, список, дерево і т.д. Різні колекції мають різні способі доступу до елементів.
Але всі вони дають можливість створити об’єкт, що реалізує інтерфейс `Iterator` (або його нащадка), який дає можливість
послідовного доступу до елементів колекції.
Створимо простий клас колекції (у вигляді масиву) і внутрішній клас для реалізації ітератора.
Клас колекції `MyArrayList` є дуже спрощеною версією класі `Vector` без розширення масиву.
Клас має змінні ` private Integer[ ] ar;` та `int size`. Масив створюється в конструкторі, його розмір не змінюється.
Змінна `size` спочатку дорівнює нулю, збільшується при додаванні елементів у список, зменшується при видаленні.
Коли `size==ar.length` методи додавання елементів не діють, аналогічно, при `size==0` не діють методи видалення.
В класі реалізувати функції

````
public MyArrayList(int n) – конструктор, n – розмір масиву
public boolean add(Integer n) – додавання елементу n в кінець
списку, збільшуємо size
public Integer remove() повертає останній елемент (якщо він
існує) і видаляє  його зі списку (зменшуємо size)
public String toString() //повертає рядок із size елементів
форматі: [1,5,…,3]
int size() //кількість елементів списку (size)
//Cтворює посилання на об’єкт внутрішнього класу-ітератора:
public MyListIterator iterator(){
return new MyListIteratorImpl();
}
````

Внутрішній клас ітератора колекції    `MyListIteratorImpl` імплементує інтерфейс `MyListIterator`. Цей інтерфейс
аналогічний інтерфейсу  `ListIterator<T>`  із бібліотеки колекцій (пакет `java.util`) при `T==Integer`
Ітератор списку дозволяє пересуватися по списку у будь-якому напрямку, змінювати елементи списку під час ітерації та
отримувати поточне положення (курсор) ітератора у списку. У ітератора немає поточного елемента; його положення завжди
лежить між елементом, який буде повернутий викликом `prev()` і елементом, який буде повернутий викликом `next()`.
Ітератор списку довжиною `n` має `n+1` можливих позицій курсору.
Клас `MyListIteratorImpl` повинен мати поле для положення курсора `int cursor`.
Якщо у списку `size` елементів, то номера елементів від 0 до (`size`-1), курсор має `size`+1 позицій, які можна
пронумерувати від 0 до `size`. Позіція `cursor=0` означає положення на початку списку перед `ar[0]`; позиція `cursor`=1
–після `ar[0]`, перед `ar[1]`;`…`; позиція `cursor=size` –після останнього елемента `ar[size-1]` в кінці списку.
**Зауваження 1.**  Розглянемо поведінку `add`.

1) В елементах масиву ar[i] зберігаються значення `Ei`. Нехай курсор між 1-м і 2-м елементами, тобто `cursor=2` і
   виклик  `next` поверне  `E2` а виклик `previous` поверне `E1`.
   Робимо виклик `add(newE)`. Курсор змістився на одну позицію, елементи `E2`, `E3`, `…` змістилися в масиві вправо,
   звільнили `ar[2]`  для `newE`. Виклик next поверне, як і раніше,  `E2` а виклик `previous` поверне `newE`.
2) Список спочатку пустий. Викликаємо `add(newE)`. Курсор змістився на одну позицію. Виклик  `hasNext` поверне `false`,
   а виклик previous поверне newE.
3) Курсор в кінці списку, `hasNext` поверне `false`. Викликаємо `add(newE)`. Курсор змістився на одну позицію і знову
   знаходиться на кінці списку. Виклик  `hasNext` поверне false, а виклик previous поверне `newE`.  
   **Зауваження 2.**  Розглянемо remove. Початкове положення `cursor`=2. remove після next, видаляється
   елемент `E1 (ar[1])`, пройдений `next`. remove після `previous`, видаляється елемент `E2 (ar[2])`,
   пройдений `previous`.
   Внутрішній клас `boolean hasNext()` має повний доступ до полів та методів зовнішнього
   класу `MyArrayList`: `ar`, `size`  і т.д.
   Деякі функції чутливі до того, які функції викликались перед ними:  `next` або `previous` або `add` чи `remove`. Тому
   потрібне поле, що установлюється при виклику цих функцій і перевіряється або переустановлюється в інших. Наприклад

````
int func;   
func=-1;   установлюємо при в функції previous  (назад)
func=1;   установлюємо при в функції next   (вперед)
func=0   установлюємо при в функції add чи remove
````

Отже в класі `MyArrayList` визначаємо `private class MyListIteratorImpl` (приватний щоб його об’єкт створювався
тільки методом `iterator`):

````
private class MyListIteratorImpl implements MyListIterator{
   int cursor = 0;
   int func = 0;   
   //Імплементація функцій
   …
}
````

Приклади імплементації методів:

````
public boolean hasNext(){
   return cursor<size;
}
public Integer next(){
   if (!hasNext()) return null;
   func = 1; cursor++;
   return ar[cursor-1];
}
````

У методі `main` провести «випробування» класів.Створити екземпляр `MyArrayList` і потім екземпляр літератора.
Випробувати всі методи (на пустому масиві, завовненому частково, повністю).

````
MyArrayList ma = new MyArrayList();
ma.add(1);
System.out.println(ma.toString());
MyListIteratorImpl it = ma.iterator();
it.next();
````