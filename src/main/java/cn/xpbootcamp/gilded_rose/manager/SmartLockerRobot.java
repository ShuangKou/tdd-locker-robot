package cn.xpbootcamp.gilded_rose;


import cn.xpbootcamp.gilded_rose.entity.Bag;
import cn.xpbootcamp.gilded_rose.entity.Ticket;

import java.util.ArrayList;
import java.util.Comparator;

public class SmartLockerRobot {
    private ArrayList<Locker> lockers;

    public SmartLockerRobot(ArrayList<Locker> lockers) {
        this.lockers = lockers;
    }

    public Ticket store(Bag bag) {
        return this.getLockerWithMaxFreeSpace().save(bag);
    }

    public Package get(Ticket ticket) {
        return null;
    }

    private Locker getLockerWithMaxFreeSpace() {
        return this.lockers.stream().max(Comparator.comparing(Locker::getCapacity)).get();
    }
}
