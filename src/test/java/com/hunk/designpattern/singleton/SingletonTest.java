package com.hunk.designpattern.singleton;

import org.junit.Test;

/**
 * 单例模式测试用例
 * @author zh0809
 * @date 2021/2/6 10:45
 **/
public class SingletonTest {

    /**
     * 懒汉式单例模式，没加锁
     */
    @Test
    public void lazySingletonTest01() {
        Thread t1 = new Thread(new LazySingletonThread());
        Thread t2 = new Thread(new LazySingletonThread());
        t1.start();
        t2.start();
        System.out.println("End");
    }

    @Test
    public void enumSingletonTest() {

    }
}
