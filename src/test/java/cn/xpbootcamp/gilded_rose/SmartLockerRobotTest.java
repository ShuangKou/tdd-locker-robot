package cn.xpbootcamp.gilded_rose;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertNotNull;


class SmartLockerRobotTest {

    @Test
    void should_return_ticket_when_robot_save_bag_given_2_lockers_whith_2_free_space() {
        Bag bag = new Bag();
        Locker locker1 = new Locker(2);
        Locker locker2 = new Locker(2);
        SmartLockerRobot smartLockerRobot = new SmartLockerRobot(new ArrayList<>(Arrays.asList(locker1, locker2)));
        Ticket ticket = smartLockerRobot.store(bag);
        assertNotNull(ticket);
    }
}
