package lab3;

public class Vehicle {
    double tank_volume;
    double petrol_amount;
    boolean isOnBase;

    public Vehicle(double petrol_amount, double tank_volume) {
        this.tank_volume = tank_volume;
        this.petrol_amount = petrol_amount;
        this.isOnBase = false;
    }

    double getTankVolume() {
        return tank_volume;
    }

    double getPetrolAmount() {
        return petrol_amount;
    }

    public void arrive() {
        Base.people_on_base += 1;// повернувся водій
        Base.vehicles_on_base += 1;// приїхало авто
        isOnBase = true;
    }

    public boolean leave() {
        if (Base.people_on_base == 0 || Base.vehicles_on_base == 0
                || Base.petrol_on_base < tank_volume - petrol_amount) { // якщо немає людей або(та) трансопрту, немає
            // пального, виїхати ми не зможемо
            return false;
        } else {
            Base.petrol_on_base -= (tank_volume - petrol_amount);// залили повний бак
            petrol_amount = tank_volume; // залили повний бак
            Base.people_on_base -= 1; // взяли 1 водія
            Base.vehicles_on_base -= 1;// взяли 1 тз
            isOnBase = false; // покинули базу
            return true;
        }
    }

    boolean isOnBase() {
        return isOnBase;
    }
}
