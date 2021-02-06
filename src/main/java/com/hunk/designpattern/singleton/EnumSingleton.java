package com.hunk.designpattern.singleton;

/**
 * 枚举
 * @author zh0809
 * @date 2021/2/5 17:51
 **/
public enum EnumSingleton {
    /** 定义实例 */
    INSTANCE;

    private Object data;

    /** 获取实例 */
    public static EnumSingleton getInstance() {
        return INSTANCE;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
