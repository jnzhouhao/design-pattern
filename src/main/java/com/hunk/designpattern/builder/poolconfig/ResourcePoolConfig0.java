package com.hunk.designpattern.builder.poolconfig;

import cn.hutool.core.util.StrUtil;
import lombok.Data;

/**
 * 最简单的方式创建配置类，不使用设计模式
 * 利用全参构造函数创建对象
 * 缺点：
 * 1、当参数过多的时候，构造函数列表变得很长，代码的可读性可易用性都会变差；
 * 2、在使用构造函数的时候，参数过多，就容易搞错参数顺序，尤其是会有多个相同类型的参数时，有可能导致出现很隐蔽的bug
 *
 * @author zh0809
 * @date 2021/2/7 10:45
 **/
@Data
public class ResourcePoolConfig0 {

    /** 资源池名称 */
    private String name;
    /** 资源池最大资源数 */
    private int maxTotal = 8;
    /** 最大空闲资源数 */
    private int maxIdle = 8;
    /** 最小空闲资源数 */
    private int minIdle = 0;

    public ResourcePoolConfig0(String name, Integer maxTotal, Integer maxIdle, Integer minIdle) {
        if (StrUtil.isBlank(name)) {
            throw new IllegalArgumentException("name should not be empty.");
        }
        this.name = name;

        if (maxTotal != null) {
            if(maxTotal <= 0) {
                throw new IllegalArgumentException("maxTotal should be positive.");
            }
            this.maxTotal = maxTotal;
        }

        if (maxIdle != null) {
            if(maxIdle < 0) {
                throw new IllegalArgumentException("maxIdle should not be negative.");
            }
            this.maxIdle = maxIdle;
        }

        if(minIdle != null) {
            if(minIdle < 0) {
                throw new IllegalArgumentException("maxIdle should not be negative.");
            }
            this.minIdle = minIdle;
        }
    }
}
