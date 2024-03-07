# Laboratory work 2. Input and output from files. Serialization

Write a program that allows you to conveniently edit a list of movies (`ArrayList<Film>`) and perform a convenient search
in it (year, genre).
The following information is stored in the Film object about the movie:
`int id`, `String name`, `int year`, `String genres`.
The program should read the list of movies from the file at startup and write the edited list to files in two formats
upon completion - a text file (`movies.txt`) and a serialization file (`movies.dat`).
The `movies.csv` file (from `movies.zip`) stores the list of movies in text format (one movie - one line):

````
movieId,title,genres
1,Toy Story (1995),Adventure|Animation|Children|Comedy|Fantasy
…
29,"City of Lost Children, The (CitГ© des enfants perdus, La) (1995)",Adventure|Drama|Fantasy|Mystery|Sci-Fi
…
````

1) Identification number,
2) Title (includes the year of release in parentheses),
3) genres (genre names are separated by a vertical line).
   The number, title, and genre are separated by a comma. Please note that if the movie title contains a comma(s), the
   movie title is written in double quotes in the file.
   When you start the program, the movie list is initially empty.   
   You can fill it in one of three ways (three menu items):
    1. Initialization\
       Lines from n to m are read from the movies.csv file (n, m are specified, m-n>1000), split into elements, Film
       objects are created and added to the `ArrayList`.
    2. Read from a text file\
       All lines are read from the `movies.txt` file (the format is similar to `movies.csv`), split into elements, create
       Film objects and add them to the `ArrayList`.
    3. Deserialization.
       Restore the list of movies (`ArrayList`) from the serialization file `movies.dat`.
       Other menu items:
    4. Search
    5. delete
    6. add.
       Search by year of release or genre. Deletion by the specified id. When adding, the id is set automatically, the
       rest of the fields are entered from the keyboard.
    7. Edit\
       *Optional. When editing in an object specified by id, we change individual fields.
    0. Exit\
       The edited list is written to the `movies.txt` file (in the `movies.csv` file format) and serialized in the
       `movies.dat` file

# Лабораторна робота 2. Ввід вивід з файлів. Серіалізація

Написати програму, що дозволяє зручно редагувати список фільмів (`ArrayList<Film>`) та здійснювати в ньому зручний пошук (
рік, жанр).
В об’єкті Film про фільм зберігається така інформація:
`int id`, `String name`, `int year`, `String genres`.
Програма повинна читати список фільмів із файлу при запуску і записувати при завершенні відредагований список в файли в
двох форматах – текстовий файл (`movies.txt`) і файл серіалізації (`movies.dat`).
В файлі `movies.csv` (із `movies.zip`) зберігається список фільмів у текстовому форматі (один фільм – один рядок):

````
movieId,title,genres
1,Toy Story (1995),Adventure|Animation|Children|Comedy|Fantasy
…
29,"City of Lost Children, The (CitГ© des enfants perdus, La) (1995)",Adventure|Drama|Fantasy|Mystery|Sci-Fi
…
````

1) Ідентифікаційний номер,
2) назва (включає рік випуску у круглих дужках),
3) жанри (назви жанрів розділяються вертикальною лінією).
   Номер, назва, жанр відділяються комою. Зверніть увагу, що коли у назві фільму є кома(и) – назва фільму записана у
   файлі в подвійних лапках.
   При старті програми список фільмів спочатку пустий.   
   Його можна заповнити одним із трьох способів (три пункта меню):
    1. Ініціалізація\
       Із файлу movies.csv читаються рядки від n до m (n, m задаються, m-n>1000), розбиваються на елементи, створюються
       об’єкти `Film` і додаються до `ArrayList`.
    2. Прочитати з текстового файлу\
       Із файлу `movies.txt` (формат аналогічний `movies.csv`) читаються всі рядки, розбиваються на елементи, створюються
       об’єкти `Film` і додаються до ArrayList.
    3. Десеарелізація.\
       Відновити список фільмів (`ArrayList`) із файлу серіалізації movies.dat.
       Інші пункти меню:
    4. Пошук
    5. видалення
    6. додавання\
       Пошук по року випуску або жанру. Видалення по заданому id. При додаванні id задається автоматично, інші поля
       вводяться з клавіатури.
    7. Редагування\
       *Необов’язкове. При редагування в об’єкті заданому по id змінюємо окремі поля.
    0. Вихід\
       Відредагований список записується в файли `movies.txt` (в форматі файлу `movies.csv`) та серіалізується в файлі
       `movies.dat`
