package cn.xpbootcamp.gilded_rose;

import java.util.HashMap;
import java.util.Map;

public class Locker {
    private final Map<CredentialCode, Bag> bags;
    private int size;

    public int getSize() {
        return size;
    }

    public Locker(Integer size) {
        this.size = size;
        bags = new HashMap<>(size);
    }

    public CredentialCode save(Bag bag) {
        if (size <= 0) {
            throw new SaveBagFailException();
        }
        CredentialCode credentialCode = new CredentialCode();
        bags.put(credentialCode, bag);
        size--;
        return credentialCode;
    }

    public Bag getByCredentialCode(CredentialCode credentialCode) {
        Bag bag = bags.get(credentialCode);
        if (bag != null) {
            size++;
        }
        return bag;
    }
}

