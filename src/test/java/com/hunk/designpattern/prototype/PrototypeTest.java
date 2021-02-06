package com.hunk.designpattern.prototype;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 原型模式测试用例
 * @author zh0809
 * @date 2021/2/6 15:39
 **/
public class PrototypeTest {

    /**
     * 浅拷贝 - 只包含基本类型属性
     */
    @Test
    public void shallowCopyTest() {
        // 原始对象
        ConcretePrototype prototype = new ConcretePrototype("original");
        System.out.println("原型对象：" + prototype);
        // 浅拷贝对象
        ConcretePrototype clone = prototype.clone();
        clone.setDesc("clone");
        System.out.println("拷贝对象：" + clone);
    }

    /**
     * 浅拷贝 - 有对象属性
     */
    @Test
    public void deepCopyTest() {
        ConcretePrototype2 prototype2 = new ConcretePrototype2();
        prototype2.setName("original");
        List<String> hobbies = new ArrayList<>();
        hobbies.add("足球");
        prototype2.setHobbies(hobbies);
        System.out.println("原型对象：" + prototype2);

        ConcretePrototype2 clone = prototype2.clone();
        clone.getHobbies().add("唱歌");
        System.out.println("拷贝对象：" + clone);
        // 重新打印一下原始对象，发现内容变了
        // 证明对于对象属性来说，浅拷贝只是复制了引用地址
        System.out.println("原始对象：" + prototype2);
    }

    /**
     * 深拷贝
     */
    @Test
    public void deepPrototypeTest() {
        ConcretePrototype2 prototype2 = new ConcretePrototype2();
        prototype2.setName("original");
        List<String> hobbies = new ArrayList<>();
        hobbies.add("足球");
        prototype2.setHobbies(hobbies);
        System.out.println("原型对象：" + prototype2);

        ConcretePrototype2 clone = prototype2.deepClone();
        clone.getHobbies().add("唱歌");
        System.out.println("拷贝对象：" + clone);
        // 重新打印一下原始对象，原始对象没有发生变化
        System.out.println("原始对象：" + prototype2);

    }
}
