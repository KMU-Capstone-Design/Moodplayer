package org.techtown.realproject;

import java.util.ArrayList;

public class Parent {
    private String tv_parent;
    public ArrayList<Child> child;

    public Parent(String tv_parent) {
        this.tv_parent = tv_parent;
        child = new ArrayList<>();
    }

    public String getTv_parent() {
        return this.tv_parent;
    }

    public void setTv_parent(String tv_parent) {
        this.tv_parent = tv_parent;
    }
}
