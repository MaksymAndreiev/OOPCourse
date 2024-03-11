# Practical exercise 4. Input and output streams

1. Analyze examples 1-7 of practical lesson 4 (P4sem3.doc). Run the examples, explain the output to the console.
2. Write a program to copy files: 1 byte is read from `FileInputStream` in a loop, which is immediately written to
   `FileOutputStream`. Measure the copying speed. Then "wrap" the file streams in `BufferedInputStream` /
   `BufferedOutputStream` - and measure the speed again.
3. In Example 1 from P4sem3.doc, add Cyrillic text to the line that is written to the file. What will be in the file?
   Read about the `getBytes` method of the `String` class.

# Практичне заняття 4. Потоки введення-виведення

1. Розібрати приклади 1-7 практичного заняття 4 (П4сем3.doc). Запустити приклади, пояснити вивід на консоль.
2. Напишіть програму для копіювання файлів: з `FileInputStream`'а в циклі читається по 1 байту, які тут же записуються в
   `FileOutputStream`. Виміряйте швидкість копіювання. Потім "оберніть" файлові потоки в `BufferedInputStream` /
   `BufferedOutputStream` - і виміряйте швидкість повторно.
3. В прикладі 1 із П4сем3.doc в рядок, що записується в файл, додайте текст кирилицею. Що буде в файлі? Почитайте про
   метод `getBytes` класу `String`.
