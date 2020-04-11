package cn.xpbootcamp.gilded_rose;

import cn.xpbootcamp.gilded_rose.entity.Bag;
import cn.xpbootcamp.gilded_rose.entity.Ticket;
import cn.xpbootcamp.gilded_rose.exception.LockerException;
import cn.xpbootcamp.gilded_rose.manager.SmartLockerRobot;
import cn.xpbootcamp.gilded_rose.storage.Locker;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;


class SmartLockerRobotTest {

    @Test
    void should_return_ticket_when_robot_save_bag_given_2_lockers_with_2_free_space() {
        Bag bag = new Bag();
        Locker locker1 = new Locker(2);
        Locker locker2 = new Locker(2);
        SmartLockerRobot smartLockerRobot = new SmartLockerRobot(new ArrayList<>(Arrays.asList(locker1, locker2)));
        Ticket ticket = smartLockerRobot.store(bag);
        assertNotNull(ticket);
    }

    @Test
    void should_return_ticket_when_robot_save_bag_given_locker1_with_2_free_space_and_locker2_with_1_free_space() {
        Bag bag = new Bag();
        Locker locker1 = new Locker(1);
        Locker locker2 = new Locker(2);
        SmartLockerRobot smartLockerRobot = new SmartLockerRobot(new ArrayList<>(Arrays.asList(locker1, locker2)));
        Ticket ticket = smartLockerRobot.store(bag);
        assertNotNull(ticket);
        assertEquals(1, locker2.getCapacity());
    }

    @Test
    void should_save_bag_fail_when_robot_save_bag_given_2_locker_with_0_free_space() {
        Bag bag = new Bag();
        Bag bag2 = new Bag();
        Locker locker1 = new Locker(1);
        Locker locker2 = new Locker(1);
        SmartLockerRobot smartLockerRobot = new SmartLockerRobot(new ArrayList<>(Arrays.asList(locker1, locker2)));
        smartLockerRobot.store(bag);
        smartLockerRobot.store(bag2);

        LockerException lockerException = assertThrows(LockerException.class, () -> smartLockerRobot.store(new Bag()));
        assertEquals("not have free space", lockerException.getMessage());
    }

    @Test
    void should_get_bag_when_robot_save_bag_given_2_lockers_with_2_free_space_1_valid_ticket() {
        Bag bag = new Bag();
        Locker locker1 = new Locker(2);
        Locker locker2 = new Locker(2);
        SmartLockerRobot smartLockerRobot = new SmartLockerRobot(new ArrayList<>(Arrays.asList(locker1, locker2)));
        Ticket ticket = smartLockerRobot.store(bag);
        Bag bag1 = smartLockerRobot.get(ticket);
        assertNotNull(ticket);
        assertEquals(bag, bag1);
    }

    @Test
    void should_get_bag_fail_when_robot_save_bag_given_2_lockers_with_2_free_space_1_not_valid_ticket() {
        Bag bag = new Bag();
        Locker locker1 = new Locker(2);
        Locker locker2 = new Locker(2);
        SmartLockerRobot smartLockerRobot = new SmartLockerRobot(new ArrayList<>(Arrays.asList(locker1, locker2)));
        Ticket expectTicket = smartLockerRobot.store(bag);

        LockerException lockerException = assertThrows(LockerException.class, () -> smartLockerRobot.get(new Ticket()));
        assertEquals("invalid ticket", lockerException.getMessage());
    }
}
