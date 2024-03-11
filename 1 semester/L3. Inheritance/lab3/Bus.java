package lab3;

class Bus extends Vehicle {
    int max_people;
    int people;

    public Bus(int people, int max_people, double petrol_amount, double tank_volume) {
        super(petrol_amount, tank_volume);
        this.people = people;
        this.max_people = max_people;
    }

    public int getPeopleCount() {
        return people;
    }

    public int getMaxPeople() {
        return max_people;
    }

    public void arrive() {
        super.arrive();
        Base.people_on_base += people;// повернувся водій з пасажирами
        people = 0;
    }

    public boolean leave() {
        if (super.leave() == true) {
            // if()
            // "при від'їзду з бази автобус бере масимально можливу кількість пасажирів"
            if (this.max_people < Base.people_on_base) {
                this.people = this.max_people;
            } else {
                this.people = Base.people_on_base;
            }
            Base.people_on_base -= people; // пасажири
            return true;
        } else
            return false;
    }

    public boolean set(int newpeople, double newpetrol_amount) {
        if (super.isOnBase() == false) {
            if (newpeople < 0 || newpeople > max_people) {
                return false;
            } else if (newpetrol_amount < 0 || newpetrol_amount > tank_volume) {
                return false;
            } else {
                this.people = newpeople;
                this.petrol_amount = newpetrol_amount;
                return true;
            }
        } else {
            return false;
        }
    }
}
