package lab3;

class Truck extends Vehicle {
    double max_load;
    double load;

    public Truck(double load, double max_load, double petrol_amount, double tank_volume) {
        super(petrol_amount, tank_volume);
        this.load = load;
        this.max_load = max_load;
    }

    public double getCurrentLoad() {
        return load;
    }

    public double getMaxLoad() {
        return max_load;
    }

    public void arrive() {
        super.arrive();
        Base.goods_on_base += load;
        this.load = 0;
    }

    public boolean leave() {
        if (super.leave() == true) {
            // "при від'їзду з бази машина бере максимально можливу кількість вантажу"
            if (Base.goods_on_base < this.max_load) {
                this.load = Base.goods_on_base;
            } else {
                load = max_load;
            }
            Base.goods_on_base -= load;
            super.isOnBase = false; // покинули базу
            return true;
        } else
            return false;
    }

    public boolean set(double newload, double newpetrol_amount) {
        if (super.isOnBase() == false) {
            if (newload < 0 || newload > max_load) {
                return false;
            } else if (newpetrol_amount < 0 || newpetrol_amount > tank_volume) {
                return false;
            } else {
                this.load = newload;
                this.petrol_amount = newpetrol_amount;
                return true;
            }
        } else {
            return false;
        }
    }
}
