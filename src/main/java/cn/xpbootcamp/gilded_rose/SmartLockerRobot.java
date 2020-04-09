package cn.xpbootcamp.gilded_rose;


import java.util.ArrayList;

public class SmartLockerRobot {
    private ArrayList<Locker> lockers;

    public SmartLockerRobot(ArrayList<Locker> lockers) {
        this.lockers = lockers;
    }

    public Ticket store(Bag bag) {
       return lockers.get(0).save(bag);
    }

    public Package get(Ticket ticket) {
        return null;
    }
}
