package com.hunk.designpattern.singleton;

/**
 * 懒汉式，未加锁时会发生并发问题
 * @author zh0809
 * @date 2021/2/5 16:56
 **/
public class LazySingleton01 {

    private static LazySingleton01 instance;

    /** 私有的构造函数，保证外部无法通过构造函数创建对象 */
    private LazySingleton01() {}

    public static LazySingleton01 getInstance() {
        if (instance == null) {
            instance = new LazySingleton01();
        }
        return instance;
    }
}
