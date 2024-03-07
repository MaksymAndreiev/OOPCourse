public class Main {
    public static void main(String[] args) {
        Publication[] publ = new Publication[5];
        System.out.println("------------------------ B O O K - 1 ------------------------");
        publ[0] = new Book("White Fang", "Jack London", 356, 57, true, false, false, 0, 0);
        publ[0].print();
        System.out.println("Закладка на сторінці " + publ[0].getReadMark());
        publ[0].setReadMark(34);
        System.out.println("Закладка на сторінці " + publ[0].getReadMark());
        System.out.println("Прочитано " + publ[0].read(14) + " сторінок.");
        System.out.println("Закладка на сторінці " + publ[0].getReadMark());
        publ[0].info();
        System.out.println("------------------------ B O O K - 2 ------------------------");
        publ[1] = new Book("Моє життя та робота", "Генрі Форд", 0, 0, false, false, true, 671, 68);
        publ[1].print();
        publ[1].info();
        publ[1].read(20);
        if (publ[1] instanceof Listenable) {
            System.out.println("Закінчили слухати на " + ((Listenable) publ[1]).getListenMark() + " хвилині");
            ((Listenable) publ[1]).listen(5000);
            System.out.println("Закінчили слухати на " + ((Listenable) publ[1]).getListenMark() + " хвилині");
        }
        System.out.println("------------------------ B O O K - 3 ------------------------");
        publ[2] = new Book("Краткий курс высшей математики", "И.И.Баврин", 326, 320, false, true, false, 0, 0);
        publ[2].print();
        publ[2].info();
        System.out.println("Закладка на сторінці " + publ[2].getReadMark());
        System.out.println("Прочитано " + publ[2].read(14) + " сторінок.");
        System.out.println("Закладка на сторінці " + publ[2].getReadMark());
        System.out.println("------------------ J O U R N A L - 1 ------------------");
        publ[3] = new Journal("Motorrad", 32, 4, false, true);
        publ[3].print();
        publ[3].info();
        System.out.println("Закладка на сторінці " + publ[3].getReadMark());
        System.out.println("Прочитано " + publ[3].read(10) + " сторінок.");
        System.out.println("Закладка на сторінці " + publ[3].getReadMark());
        System.out.println("------------------ J O U R N A L - 2 ------------------");
        publ[4] = new Journal("Сумський вісник", 4, 2, true, false);
        publ[4].print();
        publ[4].info();
        System.out.println("Закладка на сторінці " + publ[4].getReadMark());
        System.out.println("Прочитано " + publ[4].read(-10) + " сторінок.");
        System.out.println("Закладка на сторінці " + publ[4].getReadMark());
    }
}

interface Printable {
    void print();
}

interface Readable {
    int read(int pageCount);

    int getReadMark();

    void setReadMark(int page);
}

interface Publication extends Printable, Readable {
    void info();
}

interface Listenable {
    int listen(int minute);

    int getListenMark();

    void setListenMark(int minute);
}

class Book implements Publication, Listenable {
    String name;
    String author;
    int pageCount;
    int pageMark;
    boolean isPaper;
    boolean isDocFile;
    boolean isAudioFile;
    int minuteCount;
    int listenMark;

    public Book(String name, String author, int pageCount, int pageMark, boolean isPaper, boolean isDocFile, boolean isAudioFile, int minuteCount, int listenMark) {
        this.name = name;
        this.author = author;
        this.isPaper = isPaper;
        this.isDocFile = isDocFile;
        this.isAudioFile = isAudioFile;
        if (this.isPaper == true || this.isDocFile == true) {
            this.pageCount = pageCount;
            this.pageMark = pageMark;
            if (this.pageMark > this.pageCount) {
                this.pageMark = this.pageCount;
            }
        }
        if (this.isAudioFile == true) {
            this.minuteCount = minuteCount;
            this.listenMark = listenMark;
        }
    }

    public int listen(int minute) {
        if (this.isAudioFile == false) {
            System.out.println("Неможливо прослуховувати.");
            return 0;
        }
        while (this.listenMark + minute > this.minuteCount) {
            System.out.println("Книгу прослухано.");
            this.listenMark = minute - this.minuteCount;
            minute = this.listenMark;
        }
        this.listenMark += minute;
        return minute;
    }

    public int getListenMark() {
        return this.listenMark;
    }

    public void setListenMark(int minute) {
        if (minute <= this.minuteCount) {
            this.listenMark = minute;
        }
    }

    public void print() {
        if (this.isDocFile == false && this.isPaper == false) {
            System.out.println("Відсутній текстовий файл.");
        } else {
            System.out.println("Друкую книгу " + this.name + " " + this.author + " Сторінок:" + this.pageCount);
        }
    }

    public int read(int pageCount) {
        if (this.isDocFile == false && this.isPaper == false) {
            System.out.println("Hеможливо читати.");
            return 0;
        }
        if (pageCount < 0) {
            return 0;
        }
        if (this.pageMark + pageCount < this.pageCount) {
            this.pageMark += pageCount;
        } else {
            System.out.println("Книгу прочитано.");
            pageCount = this.pageCount - this.pageMark;
            this.pageMark = this.pageCount;
        }
        return pageCount;
    }

    public int getReadMark() {
        return this.pageMark;
    }

    public void setReadMark(int page) {
        if (page <= this.pageCount && page > 0) {
            this.pageMark = page;
        }
    }

    public void info() {
        if (this.isDocFile == true || this.isPaper == true) {
            System.out.println("Назва: " + this.name + " Автор: " + this.author + " Сторінок: " + this.pageCount);
        } else if (this.isAudioFile == true) {
            System.out.println("Назва: " + this.name + " Автор: " + this.author + " Хвилин: " + this.minuteCount);
        }
        System.out.println("У паперовому вигляді: " + this.isPaper + "\nВ електронному форматі: " + this.isDocFile + "\nАудіокнига: " + this.isAudioFile);
    }
}

class Journal implements Publication {
    String name;
    int pageCount;
    int pageMark;
    boolean isPaper;
    boolean isDocFile;

    public Journal(String name, int pageCount, int pageMark, boolean isPaper, boolean isDocFile) {
        this.name = name;
        this.pageCount = pageCount;
        this.pageMark = pageMark;
        this.isPaper = isPaper;
        this.isDocFile = isDocFile;
    }

    public void print() {
        System.out.println("Друкую журнал " + this.name + " Сторінок:" + this.pageCount);
    }

    public int read(int pageCount) {
        if (pageCount < 0) {
            return 0;
        }
        if (this.pageMark + pageCount < this.pageCount) {
            this.pageMark += pageCount;
        } else {
            System.out.println("Книгу прочитано.");
            this.pageMark = this.pageCount;
        }
        return pageCount;
    }

    public int getReadMark() {
        return pageMark;
    }

    public void setReadMark(int page) {
        if (page <= this.pageCount && page > 0) {
            this.pageMark = page;
        }
    }

    public void info() {
        System.out.println("Назва: " + this.name + " Сторінок: " + this.pageCount + "\nУ паперовому вигляді: " + this.isPaper + "\nВ електронному форматі: " + this.isDocFile);
    }
}
