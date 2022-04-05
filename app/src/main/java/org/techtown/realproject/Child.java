package org.techtown.realproject;

public class Child {
    private String tv_child;
    private String url;

    public Child(String tv_child, String url) {
        this.tv_child = tv_child;
        this.url = url;
    }

    public String getTv_child() {
        return this.tv_child;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setTv_child(String tv_child) {
        this.tv_child = tv_child;
    }
}
