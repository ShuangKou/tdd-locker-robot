package cn.xpbootcamp.gilded_rose.storage;

import cn.xpbootcamp.gilded_rose.entity.Bag;
import cn.xpbootcamp.gilded_rose.entity.Box;
import cn.xpbootcamp.gilded_rose.entity.Ticket;
import cn.xpbootcamp.gilded_rose.exceptions.LockerException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author shuang.kou
 */
public class Locker {
    private final List<Box> usedBoxes;
    private final Map<Ticket, Box> ticketToBagMap;
    private int capacity;

    public Map<Ticket, Box> getTicketToBagMap() {
        return ticketToBagMap;
    }

    public int getCapacity() {
        return capacity;
    }

    public Locker(Integer size) {
        this.capacity = size;
        ticketToBagMap = new HashMap<>();
        usedBoxes = new ArrayList<>();
    }

    public Ticket save(Bag bag) {
        if (capacity <= 0) {
            throw new LockerException("not have free space");
        }
        Box box = new Box(bag);
        usedBoxes.add(box);
        int boxId = 8 - capacity;
        Ticket ticket = new Ticket(boxId);
        ticketToBagMap.put(ticket, box);
        capacity--;
        return ticket;
    }

    public Bag get(Ticket ticket) {
        Box box = ticketToBagMap.get(ticket);
        if (box == null) {
            throw new LockerException("invalid ticket");
        }
        Bag bag = box.getBag();
        usedBoxes.remove(ticket.getBoxId().intValue());
        capacity++;
        return bag;
    }
}

