package com.hunk.designpattern.singleton;

/**
 * 双重检测机制
 * @author zh0809
 * @date 2021/2/5 17:12
 **/
public class DoubleCheckSingleton {

    /** 添加 volatile 防止指令重排问题 */
    private volatile static DoubleCheckSingleton instance;

    /** 私有的构造函数，保证外部无法通过构造函数创建对象 */
    private DoubleCheckSingleton() {}

    public static DoubleCheckSingleton getInstance() {
        if (instance == null) {
            synchronized (DoubleCheckSingleton.class) {
                if (instance == null) {
                    instance = new DoubleCheckSingleton();
                }
            }
        }
        return instance;
    }
}
