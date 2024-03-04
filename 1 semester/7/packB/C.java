package packB;

public class C extends B {
    public int iPub = 1;
    private int iPriv = 2;
    protected int iProt = 3;
    int i = 4;

    public void printInfo() {
        System.out.println("A public int iPub=" + super.iPub);
        super.setIPriv(100);
        System.out.println("A private int iPriv=" + super.getIPriv());
        System.out.println("A protected int iProt=" + super.iProt);
        System.out.println("An int i=" + super.i);
    }
}