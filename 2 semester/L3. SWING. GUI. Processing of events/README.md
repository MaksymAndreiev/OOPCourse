# Laboratory work 3. SWING. GUI. Processing of events

Write a program using the library SWING.
The main window (frame) - `resizeable`.
Deal with the `LayoutManager`'s and fill the window with components:

1. At the top of the window (`NORTH`) - the inscription (`Label`).
2. In the middle of the window (`CENTER`) - the picture.
3. At the bottom (`SOUTH`) - a panel with four buttons: "Good morning", "Good afternoon", "Good evening", "Good night".
   When you press the buttons, the pictures and the inscription on top change.
4. On the left (`WEST`) - three `CheckBoxes` to change the color of the panel (change the background of the entire
   window). Think of a way to set 8 colors with the help of three `CheckBoxes`.
5. On the right, `RadioButtons` () to change the color of the text of the inscription (three or more).

To arrange these 5 groups, you can use the `BorderLayout` layout manager, in which the container is divided into 5
parts.

![image](https://github.com/MaksymAndreiev/OOPCourse/assets/29687267/22178b54-851d-4b4c-936f-408b42cea191)

Buttons, RadioButtons, etc. are placed on separate panels with their own layout managers (or without them).

# Лабораторна робота 3. SWING. GUI. Обробка подій

Написати програму з використання бібліотеки SWING.
Головне вікно (фрейм) – `resizeable`.
Розберіться з `LayoutManager`'ами і заповніть вікно компонентами:

1. Зверху вікна (`NORTH`) - напис (`Label`).
2. В середині вікна (`CENTER`) - картинка.
3. Внизу (`SOUTH`) - панель четирма кнопками: «Доброго ранку», «Доброго дня», «Доброго вечора», «Доброї ночі». При
   натисканні на кнопки міняются картинки і напис зверху.(Можливі варіанти картинок і написів)
4. Зліва (`WEST`) - три `CheckBox`'а для зміни кольору панелі (змінювати фон всього вікна). Придумайте, як з допомогою
   трьох `CheckBox`'ів задавати 8 кольрів
5. Справа `RadioButton`'и () для зміни кольору текста напису (три або більше).

Для розміщення цих 5 груп можна використати менеджер компоновки `BorderLayout`, при якому контейнер розділений на 5
частин.

![image](https://github.com/MaksymAndreiev/OOPCourse/assets/29687267/22178b54-851d-4b4c-936f-408b42cea191)

Кнопки, `RadioButton`'и і т.д. розміщуються на окремих панелях зі своїми менеджерами компоновки (чи без них).
