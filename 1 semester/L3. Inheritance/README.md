# Laboratory work 3. Inheritance

You are a developer of an information system for an American military base. Like any military base, your base is located
in the desert and is surrounded by a five-meter fence. Each hole in the fence has an automated checkpoint. All
information about the movement of personnel, vehicles and material assets through these checkpoints is fed into the
base's information system. Your task is to develop a module for accounting for all movements through these checkpoints -
from the outside world to the territory of the base and back.

1. To do this, you have developed the Base class. There are four balance variables in the class:
   ````
   int people_on_base; - the number of people on the territory of the base;
   int vehicles_on_base; - the number of vehicles on the territory of the base;
   double petrol_on_base; - the amount of gasoline at the local "gas station" (in liters);
   double goods_on_base; - the amount of "cargo" - various material assets (in tons).
   ````
   Since we have one base, and we are not going to create several of them, all fields will be static and the Base object
   will not be created. The initial values of the above variables (except for `vehicles_on_base=0`) can be set
   arbitrarily at your discretion.
   In the class, create a static `print()` method that prints the current balance.

2. Next, you need to develop a hierarchy of vehicle classes:
   Basic class `Vehicle` ("vehicle"). It is driven by one driver, carries neither cargo nor passengers, and has a
   certain amount of gasoline tank capacity.
   The heir to the class `Vehicle` is the class `Bus` ("vehicle for the transportation of personnel" - bus). It differs
   from `Vehicle` in that it has a certain number of seats for passengers.
   The heir of the class `Vehicle` is the class `Truck` ("truck"). It differs from Vehicle in that it can carry cargo (
   it has a given carrying capacity, measured in tons).
3. Each car class has methods `arrive()` (arrive at the base) and `leave()` (leave the territory of the base), which
   change the values of the "balance" variables of the base accordingly (add or reduce the number of people, cars,
   cargo, gasoline at the base).
   At the same time, each car must fill up a full tank of gasoline before leaving, each bus tries to take as many people
   as possible, each truck - as much cargo as possible (your base is slowly moving to a new location in a neighboring
   country). When a new vehicle arrives at the base, its passengers (and the driver) disembark (added to the base's
   inventory), the cargo is unloaded (also added to the base's cargo balance), but the gasoline is not drained.

4. The interface of the `Vehicle` class (public methods) should consist of the following methods:
   ````
   Vehicle(double petrol_amount, double tank_volume);
   //tank_volume - the volume of the tank,
   //petrol_amount - the actual amount of fuel in the tank
   double getTankVolume();// find out the volume of the gas tank in liters;
   double getPetrolAmount();
   void arrive(); // arrive at the base, the driver goes to the barracks;
   boolean leave();//fill the tank full, take the driver, leave the base;
   //if it is impossible to leave false;
   boolean isObBase();// whether the car is at the base
   ````
   Let the initial position at creation be outside the base
5. The Bus class interface extends the `Vehicle` class interface with the following operations:
   ````
   Bus(int people,int max_people,double petrol,double max_petrol);
   //max_people - number of seats for passengers,
   //people - actual passengers, without a driver
   int getPeopleCount(); //get the number of passengers;
   int getMaxPeople(); //get the number of passenger seats.
   ````
   The `arrive()` and `leave()` operations are naturally overridden and work differently.
   In addition to the operations in Vehicle, when arriving at the base, passengers disembark and the bus is empty, when
   leaving the base, the bus takes the maximum possible number of passengers.

6. The interface of the `Truck` class extends the interface of the Vehicle class with the following operations:
   ````
   Truck(double load,double max_load,double petrol,double max_petrol);
   //max_load - carrying capacity,
   //load - the actual amount of cargo
   double getCurrentLoad();
   double getMaxLoad();
   ````
   The `arrive()` and `leave()` operations are naturally overridden and work differently. In addition to the operations
   in `Vehicle`, when arriving at the base, the car is unloaded and stands empty, when leaving the base, the car takes
   the maximum possible amount of cargo.

### Technical details

1) It is convenient to place individual classes in separate files.
2) If you have several classes in one file, they should be placed "side by side". You should not place some classes
   inside others (but only one of them with the main function can be "`public`).
3) The "balance" static variables of `XXXX_on_base`, of course, cannot be less than zero, and your classes (or rather,
   the `arrive()` and `leave()` methods) must monitor this.
4) After arriving at the base, the car adds itself (`vehicles_on_base`), its driver (`people_on_base`), all its
   passengers or cargo to the "balance" of the base.
5) If the car cannot fill the tank with gas or there is no one left on the base (no driver) when trying to
   leave (`leave()`, the car refuses to leave and returns `false`. Note: we will assume that the car does not need a
   specific driver - any person from the base can drive it.
6) Bus and truck behave exactly like Vehicle when trying to leave, but additionally - they try to take a full cabin of
   people or a full body of cargo, respectively. If there are fewer people or cargo left at the base than a given
   vehicle can carry, it takes as many as it has.
7) We assume that the initial state of any car is outside the base. Immediately after its creation, a car can enter, but
   not leave. That is, in the car class (obviously in the `Vehicle` class), you need a variable
   ````   
   boolean isOnBase;
   ````
   which is set to false in the constructor.

8) In addition to the car classes, you need to add a set method that will work only for cars outside the base (empty
   cars are on the base) and set the amount of gasoline, passengers, cargo. The method should be used if the car that
   left the base is going to return. Without this method, the car returns in the same state as when it left (the same
   amount of gasoline, cargo, and passengers). With incorrect parameters, the method does not change anything in the
   object and returns `false`.
9) In the main method, we create several cars of different types and test their public methods. In between calls to
   these methods, we print the state of the database (`Base.print()`).
   We try to remove everything from the database, especially the staff.

# Лабораторна робота 3. Наслідування

Ви - розробник інформаційної системи для американської військової бази. Як і будь-яка військова база, ваша база
знаходиться в пустелі і обгороджена п'ятиметровим парканом. У кожної дірки в паркані встановлений автоматизований КПП.
Вся інформація про переміщення особового складу, транспортних засобів і матеріальних цінностей через ці КПП надходить в
інформаційну систему бази. Ваше завдання - розробити модуль обліку всіх переміщень через ці КПП - з зовнішнього світу на
територію бази і назад.

1. Для цього ви розробили клас Base. В класі чотири балансові змінні:
   ````
   int people_on_base; - кількість людей на території бази;
   int vehicles_on_base; - кількість транспортних засобів на території бази;
   double petrol_on_base; - кількість бензину на місцевій "заправці" (в літрах);
   double goods_on_base; - кількість "вантажу" - різних матеріальних цінностей (в тоннах).
   ````
   Так як база у нас одна, і кілька штук ми їх створювати не збираємося - то всі поля будуть статичними і об’єкт Base
   створюватись не буде. Початкові значення перерахованих вище змінних (крім `vehicles_on_base=0`) можна задати довільно
   на власний розсуд.
   В класі створити статичний метод `print()`, який друкує поточний баланс.
2. Далі, Вам необхідно розробити ієрархію класів транспортних засобів:
   Базовий клас `Vehicle` ( «транспортний засіб»). Управляється одним водієм, ні вантажу, ні пасажирів не перевозить,
   має певний об’єм бензобаку.
   Спадкоємець класу `Vehicle` - клас `Bus` ( "машина для перевезення особового складу" - автобус). Відрізняється
   від `Vehicle` тим, що має деяку кількість місць для пасажирів.
   Спадкоємець класу `Vehicle` - клас `Truck` ( "вантажівка"). Відрізняється від Vehicle тим, що може перевозити
   вантаж (має задану вантажопідйомність, вимірюється в тоннах).
3. У кожного автомобільного класу є методи `arrive()` (приїхати на базу) і `leave()` (покинути територію бази), які
   відповідним чином змінюють значення "балансових" змінних бази (додають або зменшують кількість людей, машин, вантажу,
   бензину на базі).
   При цьому кожна машина перед від'їздом обов’язково повинна заправити повний бак бензину, кожен автобус намагається
   забрати з собою якомога більше людей, кожна вантажівка - якомога більше вантажу (ваша база потихеньку переміщається
   на нове місце дислокації в сусідній країні). При приїзді на територію бази нового транспортного засобу його
   пасажири (і водій) висаджуються (додаються складу бази), вантаж вивантажується (теж додається до балансу вантажу
   бази), але бензин не зливається.
4. Інтерфейс класу `Vehicle` (публічні методи) повинен складатися з таких методів:
   ````
   Vehicle(double petrol_amount, double tank_volume);
   //tank_volume – об’єм бака,
   //petrol_amount – фактична кількість пального в баці
   double getTankVolume();// дізнатися обсяг бензобака в літрах;
   double getPetrolAmount();
   void arrive(); //приїхати на базу, водій іде в казарму;
   boolean leave();//залити повний бак, взяти водія, покинути базу;
   //у разі неможливості виїхати false;
   boolean isObBase();// чи знаходиться авто на базі
   ````
   Нехай початкове положення при створенні – за межами бази
5. Інтерфейс класу Bus розширює інтерфейс класу `Vehicle` наступними операціями:
   ````
   Bus(int people,int max_people,double petrol,double max_petrol);
   //max_people – місць для пасажирів,
   //people – фактично пасажирів, без водія
   int getPeopleCount(); //отримати кількість пасажирів;
   int getMaxPeople (); //отримати кількість пасажирських місць.
   ````
   Операції `arrive()` і `leave()`, природно, перевизначаються і працюють по-іншому.
   Додатково до операцій в Vehicle при прибутті на базу пасажири висаджуються і автобус стоїть пустим, при від’їду з
   бази автобус бере максимально можливу кількість пасажирів.
6. Інтерфейс класу `Truck` розширює інтерфейс класу Vehicle наступними операціями:
   ````
   Truck(double load,double max_load,double petrol,double max_petrol);
   //max_load – вантажопідйомність,
   //load – фактична кількість вантажу
   double getCurrentLoad();
   double getMaxLoad();
   ````
   Операції `arrive()` і `leave()`, природно, перевизначаються і працюють по-іншому. Додатково до операцій в `Vehicle`
   при прибутті на базу машина розвантажуться і стоїть пустою, при від’їду з бази машина бере максимально можливу
   кількість вантажу.

### Технічні подробиці

1) Окремі класи зручно поміщати в окремі файли.
2) Якщо у вас кілька класів у одному файлі - вони повинні бути розташовані "поруч". Поміщати одні класи всередину інших
   не слід (але при цьому тільки один з них з функцією main може бути "`public`").
3) "Балансові" статичні змінні `XXXX_on_base`, природно, не можуть бути менше нуля, і ваші класи (вірніше,
   методи `arrive()` і `leave()`) повинні за цим стежити.
4) Після приїзду на базу машина додає до "балансу" бази себе (`vehicles_on_base`), свого водія (`people_on_base`), всіх
   своїх пасажирів або вантаж.
5) Якщо при спробі виїхати (`leave()`) машина не може залити повний бак або на базі не залишилося жодної людини (немає
   водія), машина відмовляється їхати і повертає `false`. Зауваження: будемо вважати, що машині не потрібен конкретно її
   водій - керувати нею може будь-яка людина з бази.
6) Автобус і вантажівка при спробі виїхати поводяться точно так же, як Vehicle, але додатково - намагаються відвезти
   повний салон людей або повний кузов вантажу відповідно. Якщо на базі залишилося людей або вантажу менше, ніж вміщує
   дана машина - вона забирає стільки, скільки є.
7) Вважаємо, що початковий стан будь-якого автомобіля – за межами бази. Відразу після створення авто може в’їхати, але
   не виїхати. Тобто в класі авто (очевидно в класі `Vehicle`) потрібна змінна
   ````   
   boolean isOnBase;
   ````
   яка в конструкторі задається false.

8) Додатково до класів автомобілів потрібно додати метод set, який буде працювати тільки для авто за межами бази (на
   базі авто стоять порожні) і встановлювати кількість бензину, пасажирів, вантажу. Метод слід використовувати, якщо
   авто, що виїхало з бази, збирається повернутися. Без цього метода авто повертається в тому ж стані в якому виїхало (
   та ж кількість бензину, вантажу, пасажирів). При неправильних параметрах метод нічого не міняє в об’єкті і
   повертає `false`.
9) В методі main створюємо кілька авто різних типів і випробуємо їх публічні методи. У проміжках між викликами цих
   методів друкуємо стан бази (`Base.print()`).
   Намагаємося все вивезти з бази, особливо персонал. 
