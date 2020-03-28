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
        CredentialCode credentialCode = locker.saveBag(bag);
        //then
        assertNotNull(credentialCode);
    }

    @Test
    void should_throw_save_bag_fail_exception_when_store_bag_given_1_bag_and_locker_with_0_free_space() {
        //given
        Bag bag = new Bag();
        Locker locker = new Locker(0);
        //when ant then
        assertThrows(SaveBagFailException.class, () -> locker.saveBag(bag));
    }

    @Test
    void should_get_bag_and_update_locker_size_when_get_bag_given_1_correct_unique_credential_code_and_locker_with_1_bag() {
        //given
        Locker locker = new Locker(1);
        Bag expected = new Bag();
        CredentialCode credentialCode = locker.saveBag(expected);
        assertEquals(0,locker.getSize());
        //when
        Bag actual = locker.getBagByCredentialCode(credentialCode);
        //then
        assertEquals(expected, actual);
        assertEquals(1,locker.getSize());
    }

    @Test
    void should_get_bag_fail_when_get_bag_given_1_correct_unique_credential_code_and_locker_with_1_bag() {
        //given
        Locker locker = new Locker(1);
        Bag bag = new Bag();
        CredentialCode expectCredentialCode = locker.saveBag(bag);
        assertEquals(0,locker.getSize());
        //when
        CredentialCode actualCredentialCode = new CredentialCode();
        Bag actual = locker.getBagByCredentialCode(actualCredentialCode);
        // then
        assertNotEquals(expectCredentialCode, actualCredentialCode);
        assertNull(actual);
        assertEquals(0,locker.getSize());
    }
}
