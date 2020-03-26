package cn.xpbootcamp.gilded_rose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

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
}
