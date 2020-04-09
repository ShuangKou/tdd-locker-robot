package cn.xpbootcamp.gilded_rose;

import cn.xpbootcamp.gilded_rose.entity.Bag;
import cn.xpbootcamp.gilded_rose.entity.Box;
import cn.xpbootcamp.gilded_rose.entity.Ticket;
import cn.xpbootcamp.gilded_rose.exceptions.LockerException;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Locker {
    private final Queue<Box> usedBoxes;
    private final Map<Ticket, Box> ticketToBagMap;
    private int capacity;

    public int getCapacity() {
        return capacity;
    }

    public Locker(Integer size) {
        this.capacity = size;
        ticketToBagMap = new HashMap<>();
        usedBoxes = new LinkedList<>();
    }

    public Ticket save(Bag bag) {
        if (capacity <= 0) {
            throw new LockerException("not have free space");
        }
        Ticket ticket = new Ticket();
        Box box = new Box(bag);
        usedBoxes.add(box);
        ticketToBagMap.put(ticket, box);
        capacity--;
        return ticket;
    }

    public Bag get(Ticket ticket) {
        Box box = ticketToBagMap.get(ticket);
        if (box == null) {
            throw new LockerException("invalid ticket");
        }
        capacity++;
        return box.getBag();
    }
}

