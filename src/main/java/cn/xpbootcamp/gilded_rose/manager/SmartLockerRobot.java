package cn.xpbootcamp.gilded_rose.manager;


import cn.xpbootcamp.gilded_rose.exception.LockerException;
import cn.xpbootcamp.gilded_rose.storage.Locker;
import cn.xpbootcamp.gilded_rose.entity.Bag;
import cn.xpbootcamp.gilded_rose.entity.Ticket;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * @author shuang.kou
 */
public class SmartLockerRobot {
    private ArrayList<Locker> lockers;

    public SmartLockerRobot(ArrayList<Locker> lockers) {
        this.lockers = lockers;
    }

    public Ticket store(Bag bag) {
        return this.getLockerWithMaxFreeSpace().save(bag);
    }

    public Bag get(Ticket ticket) {
        for (Locker locker : lockers) {
            if (locker.getTicketToBagMap().containsKey(ticket)) {
                return locker.get(ticket);
            }
        }
        throw new LockerException("invalid ticket");
    }

    private Locker getLockerWithMaxFreeSpace() {
        return this.lockers.stream().max(Comparator.comparing(Locker::getCapacity)).get();
    }
}
