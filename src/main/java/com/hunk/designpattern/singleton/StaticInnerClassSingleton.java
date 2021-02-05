package com.hunk.designpattern.singleton;

/**
 * 静态内部类单例
 * @author zh0809
 * @date 2021/2/5 17:39
 **/
public class StaticInnerClassSingleton {

    /**
     * 私有的构造函数，保证外部无法通过构造函数创建对象
     * 使用 StaticInnerClassSingleton 时，默认会初始化内部类 SingletonHolder
     * 如果不使用，就不加载内部类
     */
    private StaticInnerClassSingleton() {}

    /** static 为了单例模式的空间共享，保证方法不会被重写、重载 */
    public static StaticInnerClassSingleton getInstance() {
        return SingletonHolder.INSTANCE;
    }

    /** 静态内部类 */
    private static class SingletonHolder {
        private static final StaticInnerClassSingleton INSTANCE = new StaticInnerClassSingleton();
    }
}
