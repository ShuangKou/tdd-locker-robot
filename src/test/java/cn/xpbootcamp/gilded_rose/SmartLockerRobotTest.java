package cn.xpbootcamp.gilded_rose;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;


class SmartLockerRobotTest {

    @Test
    void should_return_ticket_when_robot_save_bag_given_2_lockers_whth_2_free_space() {
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

}
