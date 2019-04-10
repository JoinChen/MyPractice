package com.bksx.changxindian.mypractice;

public class Count {
    private String name;
    private float trans;
    private int image;

    public Count(String name, float trans, int image) {
        this.name = name;
        this.trans = trans;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getTrans() {
        return trans;
    }

    public void setTrans(float trans) {
        this.trans = trans;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
