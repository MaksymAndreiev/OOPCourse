
public class Main {
    public static void main(String[] args) {

        Stakan[] mas = new Stakan[5];
        String[] str = new String[5];

        mas[0] = new Stakan();
        mas[1] = new Stakan(40, 150, 137);
        mas[2] = new Stakan(20, 200, 50);
        mas[3] = new Stakan(200, 250, 200);
        mas[4] = new Stakan(150, 50, 50);

        for (int i = 0; i < 5; i++) {
            str[i] = mas[i].toString();
            System.out.println(str[i]);
        }
        System.out.printf("\n");

        mas[2].setMass(-5);
        mas[3].setVolume(-50);
        mas[4].setContent(100, 50);

        for (int i = 0; i < 5; i++) {
            str[i] = mas[i].toString();
            System.out.println(str[i]);

        }
    }
}

class Stakan {
    private double mass;
    private double volume;
    private double content;

    public Stakan() {
        mass = 30;
        volume = 200;
        content = 0;
    }

    public Stakan(double m, double v, double c) {
        mass = m;
        volume = v;
        content = c;
    }

    public double getMass() {
        return mass;
    }

    public double getVolume() {
        return volume;
    }

    public double getContent() {
        return content;

    }

    public boolean setMass(double m) {
        if (m <= 0) {
            mass = new Stakan().mass;
            return false;
        }
        mass = m;
        return true;
    }

    public boolean setVolume(double v) {
        if (v <= 0) {
            volume = new Stakan().volume;
            return false;
        }
        volume = v;
        return true;

    }

    public boolean setContent(double c, double v) {
        if ((c < 0) || (c > v)) {
            content = new Stakan().content;
            return false;
        }
        content = c;
        return true;
    }

    public String toString() {
        return "Mass: " + mass + "g, Volume: " + volume + "ml, Content: " + content + " m1";
    }
}