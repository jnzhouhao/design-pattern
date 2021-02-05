package com.hunk.designpattern.singleton;

/**
 * 饿汉式
 * @author zh0809
 * @date 2021/2/5 16:41
 **/
public class HungrySingleton {

    /** 类加载时初始化实例 */
    private static final HungrySingleton INSTANCE = new HungrySingleton();

    /** 私有的构造函数，保证外部无法通过构造函数创建对象 */
    private HungrySingleton() {}

    /** 获取实例方法 */
    public static HungrySingleton getInstance() {
        return INSTANCE;
    }
}
