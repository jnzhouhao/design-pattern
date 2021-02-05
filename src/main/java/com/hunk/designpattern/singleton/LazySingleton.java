package com.hunk.designpattern.singleton;

/**
 * 懒汉式
 * @author zh0809
 * @date 2021/2/5 16:56
 **/
public class LazySingleton {

    private static LazySingleton instance;

    /** 私有的构造函数，保证外部无法通过构造函数创建对象 */
    private LazySingleton() {}

    /** 在方法上加 synchronized，防止多线程下会多次实例化对象 */
    public synchronized static LazySingleton getInstance() {
        if (instance == null) {
            instance = new LazySingleton();
        }
        return instance;
    }
}
