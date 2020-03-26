package cn.xpbootcamp.gilded_rose;

import java.util.HashMap;
import java.util.Map;

public class Locker {
    private Map<CredentialCode, Bag> bags;

    public Locker(Integer size) {
        bags = new HashMap<>(size);
    }

    public CredentialCode save(Bag bag) {
        CredentialCode credentialCode = new CredentialCode();
        bags.put(credentialCode, bag);
        return credentialCode;
    }
}
