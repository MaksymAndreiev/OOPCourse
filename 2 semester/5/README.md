# Practical exercise 5. Formatted input and output. PrintStream and PrintWriter

1. Analyze the examples of practical lesson 5 (P5sem3.doc). Run the examples, explain the output to the console.
2. Using the DataInputStream class, read the header of the first (and only) file from movies.zip. Display the
   information received on the screen:

1) The version of the archiver required for unpacking.
2) The name of the file in the archive.
3) The date and time it was modified.
4) Its "compressed" and "uncompressed" size.
   For the header format, see https://en.wikipedia.org/wiki/Zip_(file_format)#File_headers (Local header).
   For more information: https://users.cs.jmu.edu/buchhofp/forensics/formats/pkzip.html.

**Notes.**
A) If you use readInt() / intShort() for "numeric" fields - for example, file size - the read number is interpreted as
big-endian (MSB first). However, in a zip file, it is stored as little-endian (LSB first). To convert one to the other,
you can use Integer.reverseBytes() (or Short.reverseBytes()).
B) The date and time must be parsed bit by bit

````
File modification time	stored in standard MS-DOS format:
                        Bits 00-04: seconds divided by 2
                        Bits 05-10: minute
                        Bits 11-15: hour
File modification date	stored in standard MS-DOS format:
                        Bits 00-04: day
                        Bits 05-08: month
                        Bits 09-15: years from 1980
````

Example

````
File modification time	0x7d1c = 0111110100011100
                        hour = (01111)10100011100 = 15
                        minute = 01111(101000)11100 = 40
                        second = 01111101000(11100) = 28 = 56 seconds
                        15:40:56
File modification date	0x354b = 0011010101001011
                        year = (0011010)101001011 = 26
                        month = 0011010(1010)01011 = 10
                        day = 00110101010(01011) = 11
                        10/11/2006
````

# Практичне заняття 5. Форматоване введення і виведення. PrintStream і PrintWriter

1. Розібрати приклади практичного заняття 5 (П5сем3.doc). Запустити приклади, пояснити вивід на консоль.
2. Використовуючи клас DataInputStream, прочитати заголовок першого (і єдиного) файлу з movies.zip. Вивести на екран
   отриману інформацію:

1) Необхідну для розпакування версію архіватора.
2) Назву файлу в архіві.
3) Дату і час його зміни.
4) Його "стислий" і "нестислий" розмір.
   Формат заголовка дивись в  https://en.wikipedia.org/wiki/Zip_(file_format)#File_headers  (Local header).
   Для більш докладної інформації: https://users.cs.jmu.edu/buchhofp/forensics/formats/pkzip.html

**Примітки.**
А) Якщо для "числових" полів - наприклад розмір файлу - використовувати readInt() / intShort () – прочитане число
інтерпретується як big-endian (MSB first). Однак, в zip-файлі воно зберігається як little-endian (LSB first). Для
конвертації одного в інше можна використовувати Integer.reverseBytes() (або Short.reverseBytes()).
Б)  Дату і час потрібно розібрати побітово

````
File modification time	stored in standard MS-DOS format:
                        Bits 00-04: seconds divided by 2
                        Bits 05-10: minute
                        Bits 11-15: hour
File modification date	stored in standard MS-DOS format:
                        Bits 00-04: day
                        Bits 05-08: month
                        Bits 09-15: years from 1980
````

Приклад

````
File modification time	0x7d1c = 0111110100011100
                        hour = (01111)10100011100 = 15
                        minute = 01111(101000)11100 = 40
                        second = 01111101000(11100) = 28 = 56 seconds
                        15:40:56
File modification date	0x354b = 0011010101001011
                        year = (0011010)101001011 = 26
                        month = 0011010(1010)01011 = 10
                        day = 00110101010(01011) = 11
                        10/11/2006
````
