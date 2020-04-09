package cn.xpbootcamp.gilded_rose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LockerTest {

    @Test
    void should_get_unique_credential_code_when_store_bag_given_1_bag_and_locker_with_1_free_space() {
        //given
        Bag bag = new Bag();
        Locker locker = new Locker(1);
        //when
        Ticket credentialCode = locker.save(bag);
        //then
        assertNotNull(credentialCode);
    }

    @Test
    void should_throw_save_bag_fail_exception_when_store_bag_given_1_bag_and_locker_with_0_free_space() {
        //given
        Bag bag = new Bag();
        Locker locker = new Locker(0);
        //when ant then
        assertThrows(LockerException.class, () -> locker.save(bag));
    }

    @Test
    void should_get_bag_and_update_locker_size_when_get_bag_given_1_correct_unique_credential_code_and_locker_with_1_bag() {
        //given
        Locker locker = new Locker(1);
        Bag expected = new Bag();
        Ticket credentialCode = locker.save(expected);
        assertEquals(0, locker.getCapacity());
        //when
        Bag actual = locker.get(credentialCode);
        //then
        assertEquals(expected, actual);
        assertEquals(1, locker.getCapacity());
    }

    @Test
    void should_get_bag_fail_when_get_bag_given_1_correct_unique_credential_code_and_locker_with_1_bag() {
        //given
        Locker locker = new Locker(1);
        Bag bag = new Bag();
        Ticket expectTicket = locker.save(bag);
        assertEquals(0, locker.getCapacity());
        //when
        Ticket actualTicket = new Ticket();
        LockerException lockerException = assertThrows(LockerException.class, () -> locker.get(actualTicket));
        assertEquals("invalid ticket",lockerException.getMessage());
        // then
        assertNotEquals(expectTicket, actualTicket);
        assertEquals(0, locker.getCapacity());
    }

}
