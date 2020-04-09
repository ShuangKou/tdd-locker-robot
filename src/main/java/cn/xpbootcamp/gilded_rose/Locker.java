package cn.xpbootcamp.gilded_rose;

import java.util.HashMap;
import java.util.Map;

public class Locker {
    private final Map<CredentialCode, Bag> bags;
    private int capacity;

    public int getCapacity() {
        return capacity;
    }

    public Locker(Integer size) {
        this.capacity = size;
        bags = new HashMap<>(size);
    }

    public CredentialCode saveBag(Bag bag) {
        if (capacity <= 0) {
            throw new SaveBagFailException();
        }
        CredentialCode credentialCode = new CredentialCode();
        bags.put(credentialCode, bag);
        capacity--;
        return credentialCode;
    }

    public Bag getBag(CredentialCode credentialCode) {
        Bag bag = bags.get(credentialCode);
        if (bag != null) {
            capacity++;
        }
        return bag;
    }
}

