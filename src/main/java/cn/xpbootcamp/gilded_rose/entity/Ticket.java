package cn.xpbootcamp.gilded_rose.entity;

/**
 * @author shuang.kou
 */
public class Ticket {
    private Integer boxId;

    public Ticket(Integer boxId) {
        this.boxId = boxId;
    }

    public Ticket() {
    }

    public Integer getBoxId() {
        return boxId;
    }
}
