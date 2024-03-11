package lab3;

public class Lab {

    public static void main(String[] args) {
        Base.print();
        System.out.printf("\n");
        Vehicle[] auto = new Vehicle[2];
        System.out.println("------------------B U S------------------");
        auto[0] = new Bus(35, 45, 150, 250);
        if (auto[0] instanceof Bus) {
            Bus bus = (Bus) auto[0];
            System.out.println("Кількість пасажирів:" + bus.getPeopleCount());
            System.out.println("Максимальна кількість пасажирів:" + bus.max_people);
        }
        System.out.printf("\n");
        System.out.println("Повертаємось на базу");
        auto[0].arrive();
        Base.print();
        System.out.println("Може виїхати з бази? " + auto[0].leave());
        System.out.printf("\n");
        Base.print();
        System.out.printf("\n");
        if (auto[0] instanceof Bus) {
            Bus bus = (Bus) auto[0];
            System.out.println("Кількість пасажирів:" + bus.getPeopleCount());
            System.out.println("Максимальна кількість пасажирів:" + bus.max_people);
            System.out.printf("\n");
            System.out.println("Можемо змінити дані автобусу? " + bus.set(15, 70));
            System.out.println("Кількість пасажирів:" + bus.getPeopleCount());
            System.out.println("Кількість палива:" + bus.getPetrolAmount() + "л");
            System.out.println("Об'єм бака:" + bus.getTankVolume() + "л");
        }
        System.out.printf("\n");
        System.out.println("Повертаємось на базу");
        System.out.printf("\n");
        auto[0].arrive();
        Base.print();
        System.out.println("----------------T R U C K----------------");
        System.out.printf("\n");
        auto[1] = new Truck(0.4, 3, 200, 500);
        if (auto[1] instanceof Truck) {
            Truck truck = (Truck) auto[1];
            System.out.println("Кількість вантажу:" + truck.getCurrentLoad());
            System.out.println("Вантажопідйомність:" + truck.getMaxLoad());
        }
        System.out.printf("\n");
        System.out.println("Повертаємось на базу");
        auto[1].arrive();
        Base.print();
        System.out.println("Може виїхати з бази? " + auto[1].leave());
        System.out.printf("\n");
        Base.print();
        if (auto[1] instanceof Truck) {
            Truck truck = (Truck) auto[1];
            System.out.println("Кількість вантажу:" + truck.getCurrentLoad() + "т");
            System.out.println("Вантажопідйомність:" + truck.getMaxLoad() + "т");
            System.out.printf("\n");
            System.out.println("Можемо змінити дані вантажівки? " + truck.set(-15, 70));
            System.out.println("Кількість вантажу:" + truck.getCurrentLoad() + "т");
            System.out.println("Кількість палива:" + truck.getPetrolAmount() + "л");
            System.out.println("Об'єм бака:" + truck.getTankVolume() + "л");
        }
        System.out.printf("\n");
        System.out.println("Повертаємось на базу");
        System.out.printf("\n");
        auto[1].arrive();
        Base.print();
        System.out.println("-----------------------------------------");
    }

}

class Base {
    static int people_on_base = 3600;
    static int vehicles_on_base = 0;
    static double petrol_on_base = 500;
    static double goods_on_base = 100;

    static void print() {
        System.out.println("Кількість людей на базі: " + people_on_base);
        System.out.println("Кількість тз на базі: " + vehicles_on_base);
        System.out.println("Кількість палива на базі: " + petrol_on_base + "л");
        System.out.println("Кількість вантажа на базі: " + goods_on_base + "т");
        System.out.printf("\n");
    }

}
