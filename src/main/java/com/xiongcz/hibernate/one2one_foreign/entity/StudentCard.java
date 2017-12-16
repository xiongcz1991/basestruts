package com.xiongcz.hibernate.one2one_foreign.entity;

public class StudentCard {
    private int id ;
    private float money;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getMoney() {
        return money;
    }

    public void setMoney(float money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "StudentCard{" +
                "id=" + id +
                ", money=" + money +
                '}';
    }
}
