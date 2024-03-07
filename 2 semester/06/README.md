# Practical exercise 6.

1. Analyze the examples from Practical Exercise 6 (P6sem3.doc). Run the examples, explain the output to the console.
   Example 8 from Practical lesson 6 should be converted to unpacking the movies.zip archive.
2. The movies.zip file contains the movies.csv file, which contains a list of movies in the following form (one movie
   one line):
   ````
   movieId,title,genres
   1,Toy Story (1995),Adventure|Animation|Children|Comedy|Fantasy
   …
   29,"City of Lost Children, The (CitГ© des enfants perdus, La) (1995)",Adventure|Drama|Fantasy|Mystery|Sci-Fi
   …
   ````
    1) Identification number,
    2) title (includes year of release in parentheses),
    3) genres (genre names are separated by a vertical line).
       The number, title, and genre are separated by a comma. Please note that if the movie title contains a comma(s),
       the movie title is written in double quotes in the file.
        - Create a text file with the following contents:
          ````
          1,Toy Story (1995),Adventure|Animation|Children|Comedy|Fantasy
          2,Jumanji (1995),Adventure|Children|Fantasy
          11,"American President, The (1995)",Comedy|Drama|Romance
          29,"City of Lost Children, The (CitГ© des enfants perdus, La) (1995)",Adventure|Drama|Fantasy|Mystery|Sci-Fi
          ````

        - Create a program that reads data from a text file line by line (movie), and then splits each line into three
          parts: movieId,title,genres
          That is, the line `1,Toy Story (1995),Adventure|Animation|Children|Comedy|Fantasy` is split into three lines:
          ````
          1
          Toy Story (1995)
          Adventure|Animation|Children|Comedy|Fantasy
            ````
          Line
          29,`"City of Lost Children, The (CitГ© des enfants perdus, La) (1995)",Adventure|Drama|Fantasy|Mystery|Sci-Fi`
          should also be split into three lines
          ````
          29
          City of Lost Children, The (CitГ© des enfants perdus, La) (1995)      (без подвійних лапок)
          Adventure|Drama|Fantasy|Mystery|Sci-Fi
          ````
   You can read lines from a file using the `readLine()` method from the `BufferedReader` input stream (lecture 5) or
   object `Scanner` (constructors `Scanner(File source)`, `File(String pathname)` )
   You can split a string into substrings using the `split(",")` method of the `String` class or the `Scanner` object.
   Note: correctly handle the situation with the comma in the name.

# Практичне заняття 6.

1. Розібрати приклади практичного заняття 6 (П6сем3.doc). Запустити приклади, пояснити вивід на консоль.
   Приклад 8 із практичного заняття 6 переробити на розпаковку архіву movies.zip.
2. В файлі movies.zip заархівовано файл movies.csv, в якому зберігається список фільмів у такому вигляді (один фільм –
   один рядок):
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
        - Створіть текстовий файл з таким вмістом:
       ````
       1,Toy Story (1995),Adventure|Animation|Children|Comedy|Fantasy
       2,Jumanji (1995),Adventure|Children|Fantasy
       11,"American President, The (1995)",Comedy|Drama|Romance
       29,"City of Lost Children, The (CitГ© des enfants perdus, La) (1995)",Adventure|Drama|Fantasy|Mystery|Sci-Fi
       ````
        - Створіть програму, в якій з текстового файлу дані вичитуються по рядкам (фільм), а потім кожен рядок
          розбивається на три частини: movieId,title,genres
          Тобто рядок   `1,Toy Story (1995),Adventure|Animation|Children|Comedy|Fantasy`
          розбивається на три рядки:
       ````
       1
       Toy Story (1995)
       Adventure|Animation|Children|Comedy|Fantasy
       ````
       Рядок
       29,`”City of Lost Children, The (CitГ© des enfants perdus, La) (1995)”,Adventure|Drama|Fantasy|Mystery|Sci-Fi`
       теж повинен розбиватись на три рядки
       ````
       29
       City of Lost Children, The (CitГ© des enfants perdus, La) (1995)      (без подвійних лапок)
       Adventure|Drama|Fantasy|Mystery|Sci-Fi
       ````
   Читати рядки з файлу можна методом `readLine()` з вхідного потоку `BufferedReader`  (лекція 5) або
   об’єкту `Scanner`  (конструктори  `Scanner(File source)`,  `File(String pathname)` )
   Розбити рядок на підрядки, можна за допомогою методу `split(“,”)` класу `String` або об’єкту `Scanner`.
   Зауваження: правильно опрацюйте ситуацію з комою у назві.
