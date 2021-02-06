package com.hunk.designpattern.prototype;

/**
 * @author zh0809
 * @date 2021/2/6 15:31
 **/
public class ConcretePrototype implements Cloneable {

    private String desc;

    public ConcretePrototype(String  desc) {
        this.desc = desc;
    }

    @Override
    public ConcretePrototype clone() {
        ConcretePrototype prototype = null;
        try {
            prototype = (ConcretePrototype) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return prototype;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "ConcretePrototype{" +
                "desc='" + desc + '\'' +
                '}';
    }
}
