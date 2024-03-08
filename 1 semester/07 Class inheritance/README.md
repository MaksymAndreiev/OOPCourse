# Practical exercise 7. Class inheritance

Let's create several classes. In each class, we define variables

````
public int iPub=1;
private int iPriv=2;
protected int iProt=3;
int i=4;
````

In situations where the field is not available, we create `set` and `get` methods for it. (for the
field `iPriv - public void setIPriv(int i), public int getIPriv()`).

1) Access to class elements in the same package
   Create a class `A` in the package where the starting class with the `main` function is located.
   In the `main` method, create an object of class `A` and try direct access (if not, through `get`):
   ````
   A a = new A();
   System.out.println("A public int iPub="+a.iPub);
   ...
   System.out.println("A private int iPriv="+a.getIPriv());
   ````
2) Access to elements within the class.
   In the class `A` create a `public method printInfo()`, in which to print all the fields, call the method in `main`.
   ````
   a.printInfo(); // what are the conclusions?
   ````
3) Access to class elements in another package
   Create a class `B` in another package (for example, package `packB`).
   In the `main` method, create an object of class `B` and try direct access (if not, through `get`).
   Pay attention to `import`.
4) Access to elements of a superclass, if the superclass is in the same package.
   Create a class `C` - a subclass of class B in the same package with `B`. (`B` is a superclass).
   In class `C` create a `public` method `printInfo()`, in which to print all the fields of the superclass.
   Remarks. In subclass `C` and superclass B, the fields have the same names, so access to the fields of the
   superclass: `super.iPriv` or `super.getIPriv()`,`super.setIPriv(...)`
   In the main method, create an object of class `C` and call the `printInfo()` method.
5) Access to elements of a superclass, if the superclass is in another package.
   Create a class `D` - a subclass of class B in another package (for example, package `packD`). (`B` is a superclass).
   In class `D` create a `public method printInfo()`, in which to print all the fields of the superclass.
   Remarks. In the subclass `D` and superclass `B` fields have the same names, so access to the fields of the
   superclass: `super.iPriv` or `super.getIPriv()`,`super.setIPriv(...)`
   In the main method, create an object of class `D` and call the `printInfo()` method.

# Практичне заняття 7. Наслідування класів

Створимо кілька класів. В кожному класі визначимо змінні

````
public int iPub=1;
private int iPriv=2;
protected int iProt=3;
int i=4;
````

У ситуаціях, коли поле недоступне, створюємо для нього `set` і `get` методи. (для
поля `iPriv – public void setIPriv(int i), public int getIPriv()`).

1) Доступ до елементів класу в тому ж пакеті
   Створити клас `А` в пакеті, де знаходиться стартовий клас з функцією `main`.
   В методі `main` створити об’єкт класу `А` і спробувати прямий доступ (при невдачі – через `get`):
   ````
   A a = new A();
   System.out.println(“A public int iPub=”+a.iPub);
   …
   System.out.println(“A private int iPriv=”+a.getIPriv());
   ````
2) Доступ до елементів всередині класу.
   В класі `А` створити  `public метод printInfo()`, в якому надрукувати всі поля, викликати метод в `main`.
   ````
   a.printInfo();  // які висновки?
   ````
3) Доступ до елементів класу в іншому ж пакеті
   Створити клас `В` в іншому пакеті (наприклад пакет `packB`).
   В методі `main` створити об’єкт класу `В` і спробувати прямий доступ (при невдачі – через `get`).
   Звертаємо увагу на `import`.
4) Доступ до елементів суперкласу, якщо суперкласс в тому ж пакеті.
   Створити клас `С` - підклас класу В в одному пакеті з `В`. (`В` - суперклас).
   В класі `С` створити  `public` метод `printInfo()`, в якому надрукувати всі поля суперкласу.
   Зауваження. В підкласі `С` і суперкласі В поля мають однакові імена, тому доступ до полів суперкласу: `super.iPriv`
   або `super.getIPriv()`,`super.setIPriv(…)`
   В методі main створити об’єкт класу `С` і викликати метод `printInfo()`.
5) Доступ до елементів суперкласу, якщо суперклас в іншому пакеті.
   Створити клас `D` - підклас класу В в іншому пакеті (наприклад пакет `packD`). (`В` - суперклас).
   В класі `D` створити  `public метод printInfo()`, в якому надрукувати всі поля суперкласу.
   Зауваження. В підкласі `D` і суперкласі `В` поля мають однакові імена, тому доступ до полів суперкласу: `super.iPriv`
   або `super.getIPriv()`,`super.setIPriv(…)`
   В методі main створити об’єкт класу `D` і викликати метод `printInfo()`.
