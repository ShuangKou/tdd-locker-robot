package cn.xpbootcamp.gilded_rose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class LockerTest {

    @Test
    void should_get_unique_credential_code_when_store_bag_given_1_bag_and_locker_with_1_free_space() {
        //given
        Bag bag = new Bag();
        Locker locker = new Locker(1);
        //when
        CredentialCode credentialCode = locker.save(bag);
        //then
        assertNotNull(credentialCode);
    }

    @Test
    void should_throw_save_bag_fail_exception_when_store_bag_given_1_bag_and_locker_with_0_free_space() {
        //given
        Bag bag = new Bag();
        Locker locker = new Locker(0);
        //when ant then
        assertThrows(SaveBagFailException.class, () -> locker.save(bag));
    }
}
