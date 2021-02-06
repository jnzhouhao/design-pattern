package com.hunk.designpattern.prototype;

import lombok.Data;

import java.io.*;
import java.util.List;

/**
 * 有对象属性
 * @author zh0809
 * @date 2021/2/6 15:47
 **/
@Data
public class ConcretePrototype2 implements Cloneable, Serializable {

    private String name;

    private List<String> hobbies;

    @Override
    protected ConcretePrototype2 clone() {
        ConcretePrototype2 prototype2 = null;
        try {
            prototype2 = (ConcretePrototype2) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return prototype2;
    }

    public ConcretePrototype2 deepClone() {
        try {
            // 将对象写到磁盘
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(bos);
            oos.writeObject(this);

            // 从磁盘读取对象到内存中
            ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
            ObjectInputStream ois = new ObjectInputStream(bis);

            return (ConcretePrototype2) ois.readObject();

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public String toString() {
        return "ConcretePrototype2{" +
                "name='" + name + '\'' +
                ", hobbies=" + hobbies +
                '}';
    }
}
