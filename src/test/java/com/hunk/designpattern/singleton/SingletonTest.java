package com.hunk.designpattern.singleton;

import org.junit.Test;

import java.lang.reflect.Constructor;

/**
 * 单例模式测试用例
 * @author zh0809
 * @date 2021/2/6 10:45
 **/
public class SingletonTest {

    /**
     * 懒汉式单例模式，没加锁和加锁两种情况的并发问题
     */
    @Test
    public void lazySingletonTest01() {
        Thread t1 = new Thread(new LazySingletonThread());
        Thread t2 = new Thread(new LazySingletonThread());
        t1.start();
        t2.start();
        System.out.println("End");
    }

    /**
     * 静态内部类单例模式，反射会出现线程安全问题
     */
    @Test
    public void staticInnerClassSingletonTest() {
        try {
            Class<?> singletonClass = StaticInnerClassSingleton.class;
            Constructor<?> c = singletonClass.getDeclaredConstructor(null);
            // 强制访问
            c.setAccessible(true);

            Object instance1 = c.newInstance();
            Object instance2 = c.newInstance();

            System.out.println(instance1 == instance2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void enumSingletonTest() {

    }
}
