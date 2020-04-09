package cn.xpbootcamp.gilded_rose.entity;

public class Box {
    private Bag bag;

    public Box(Bag bag) {
        this.bag = bag;
    }

    public Bag getBag() {
        return bag;
    }
}
