package packB;

public class B {
    public static int iPub = 1;
    private int iPriv = 2;
    protected static int iProt = 3;
    int i = 4;

    public void setIPriv(int i) {
        iPriv = i;
    }

    public int getIPriv() {
        return iPriv;
    }

    public void setI(int i) {
        this.i = i;
    }

    public int getI() {
        return i;
    }

    public static void setIProt(int i) {
        iProt = i;
    }

    public static int getIProt() {
        return iProt;
    }
}
