public class Main {

    public static void main(String[] args) {
        Person[] ar = new Person[5];
        ar[0] = new Client("Владислав", "ПриватБанк", 10000, -3600);
        ar[1] = new Client("Світодар", "UKRSIBBANK", 1200, -700);
        ar[2] = new Client("Параскева", "АльфаБанк", 1500, -500);
        ar[3] = new Employee("Олександр", "ПриватБанк", 6000);
        ar[4] = new Employee("Сніжанна", "UKRSIBBANK", 8000);
        get(ar);
        System.out.println();
        set(ar);
        System.out.println();
        get(ar);
    }

    static void set(Person[] ar) {
        for (int i = 0; i < ar.length; i++) {
            int rnd = (int) (Math.random() * 10000);
            int rndsum = (int) (Math.random() * 10000 - Math.random() * 10000);
            if (ar[i] instanceof Employee) {
                System.out.println("Встановлена нова зарплатня:" + ((Employee) ar[i]).setSalary(rnd));
                System.out.println("Змінена мінімальна зарплатня:" + ((Employee) ar[i]).setMinSalary(rnd));
            }
            if (ar[i] instanceof Client) {
                System.out.println("Нова сума рахунку:" + ((Client) ar[i]).setSum(rnd));
                System.out.println("Новий кредитний мінімум:" + ((Client) ar[i]).setMinSum(rndsum));
            }
        }
    }

    static void get(Person[] ar) {
        for (int i = 0; i < ar.length; i++) {
            System.out.printf("%s\t", ar[i].getName());
            if (ar[i] instanceof Employee) {
                System.out.printf("%s\t", ((Employee) ar[i]).getBank());
                System.out.printf("%d\t", ((Employee) ar[i]).getSalary());
                System.out.printf("%d\n", ((Employee) ar[i]).getMinSalary());
            }
            if (ar[i] instanceof Client) {
                System.out.printf("%s\t", ((Client) ar[i]).getBank());
                System.out.printf("%d\t", ((Client) ar[i]).getSum());
                System.out.printf("%d\n", ((Client) ar[i]).getMinSum());
            }
        }
        System.out.println();
        for (int i = 0; i < ar.length; i++) {
            ar[i].display();
        }
    }
}

abstract class Person {
    private String name;

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract void display();
}

class Employee extends Person {
    private String bank;
    private int salary;
    static private int minSalary = 2000;

    public Employee(String name, String bank, int salary) {
        super(name);
        this.bank = bank;
        this.salary = salary;
    }

    public String getBank() {
        return bank;
    }

    public int getSalary() {
        return salary;
    }

    public boolean setSalary(int newSalary) {
        if (newSalary < minSalary) {
            return false;
        } else {
            this.salary = newSalary;
            return true;
        }
    }

    public void display() {
        System.out.printf("Ім'я працівника: %s\tБанк: %s\n", super.getName(), bank);
    }

    static public int getMinSalary() {
        return minSalary;
    }

    static public boolean setMinSalary(int newMinSalary) {
        if (newMinSalary < 0) {
            return false;
        } else {
            minSalary = newMinSalary;
            return true;
        }
    }
}

class Client extends Person {
    private String bank;
    private int sum;
    private int minSum;

    public Client(String name, String bank, int sum, int minSum) {
        super(name);
        this.bank = bank;
        this.sum = sum;
        this.minSum = minSum;
    }

    public String getBank() {
        return bank;
    }

    public int getSum() {
        return sum;
    }

    public boolean setSum(int newSum) {
        if (newSum < minSum) {
            return false;
        } else {
            this.sum = newSum;
            return true;
        }
    }

    public void display() {
        System.out.printf("Ім'я клієнта: %s\tБанк: %s\n", super.getName(), bank);
    }

    public int getMinSum() {
        return minSum;
    }

    public boolean setMinSum(int newMinSum) {
        if (newMinSum > sum) {
            return false;
        } else {
            this.minSum = newMinSum;
            return true;
        }
    }
}

