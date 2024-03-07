# Practical exercises 8-9. Event handling

Edit Example 4 (a simple graphic editor that allows you to create, move, and erase squares on the canvas).
In the new version:

* Squares are colored blue when created.
* Squares have the following life stages:
    1. [x] when created (by clicking the button on an empty space) - colored blue
    2. [x] when you double-click on a blue square, the square turns red
    3. [x] when you double-click on a red square, the square is erased.

The coordinates and sizes of the squares are stored in the list (`ArrayList`) of objects `Rectangle2D`.
You need to distinguish the states of the squares (newborn - blue, dying - red). For example, when changing the
state of a square, you can change its size (from 10x10 to 12x12) without changing its position. When painting
squares, you need to set the color (`setPaint`) for each square depending on its size.
Double-clicking on a 10x10 square resizes it, and double-clicking on a 12x12 square deletes it.
Make sure that the drag-and-drop works correctly.

# Практичне заняття 8-9. Обробка подій

Відредагуйте приклад 4 (простий графічний редактор, що дозволяє створювати, переміщати і стирати квадрати на полотні.)
В новій редакції:

* Квадратики при створенні зафарбовані синім кольором.
* Квадратики мають такі стадії життя:
    1. [x] при створенні (натиснення кнопки на вільному місці) – зафарбовані синім
    2. [x] при подвійному кліку на синьому квадратику – квадратик стає червоним
    3. [x] при подвійному кліку на червоному квадратику - квадратик стирається.

Координати і розміри квадратиків зберігаються в списку (`ArrayList`) об’єктів `Rectangle2D`.
Потрібно розрізняти стани квадратиків (новонароджений – синій, передсмертний - червоний). Можна, наприклад, при
зміні стану квадратика міняти його розмір (з 10х10 на 12х12) не змінюючи положення. При малюванні квадратиків
потрібно устанавлювати колір (`setPaint`) для кожного квадратика в залежності від його розміру.
При подвійному кліку на квадратику 10х10 – змінюємо розмір, а подвій клік на квадратику 12х12 приводить до його
видалення.
Прослідкуйте за правильною роботою перетягування квадратиків.
