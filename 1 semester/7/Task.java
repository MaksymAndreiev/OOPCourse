import packB.*;
import packD.*;
public class Task {
    public static void main(String[] args) {
        A a = new A();
        B b = new B();
        C c = new C();
        D d = new D();
        System.out.println("Виводимо А першим способом:");
        System.out.println("A public int iPub="+a.iPub);
        //System.out.println("A private int iPriv="+a.iPriv); не спрацює, буде помилка
        a.setIPriv(50);
        System.out.println("A private int iPriv="+a.getIPriv());
        System.out.println("A protected int iProt="+a.iProt);
        System.out.println("An int i="+a.i);
        System.out.println("Виводимо А другим способом:");
        a.printfInfo();//виводить private int, бо у класі він доступний, а так з іншого класу беспосередньо читати неможна
        System.out.println("Виводимо В:");
        System.out.println("A public int iPub="+b.iPub);
        b.setIPriv(25);
        System.out.println("A private int iPriv="+b.getIPriv());
        b.setIProt(25);
        System.out.println("A protected int iProt="+b.getIProt());//protected діє тільки в своєму класі, тому вивод здійснюється через метод
        System.out.println("An int i="+b.getI()); //The field B.i is not visible так як він не public, використовуємо
        System.out.println("Виводимо В через С:");
        c.printInfo();
        System.out.println("Bиводимо В через D:");
        d.printInfo();
    }

}
class A{
    public int iPub=1;
    private int iPriv=2;
    protected int iProt=3;
    int i=4;
    public void setIPriv(int i) {
        iPriv=i;
    }
    public int getIPriv() {
        return iPriv;
    }
    public void printfInfo() {
        System.out.println("A public int iPub="+iPub);
        System.out.println("A private int iPriv="+iPriv);
        System.out.println("A protected int iProt="+iProt);
        System.out.println("An int i="+i);
    }
}

