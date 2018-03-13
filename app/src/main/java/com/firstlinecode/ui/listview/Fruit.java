package com.firstlinecode.ui.listview;

/**
 * Created by chensc on 2018/3/2.
 */

public class Fruit {
    private String name;
    private int id;
    public Fruit(String name,int id){
        this.name=name;
        this.id=id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
