package com.hunk.designpattern.builder.poolconfig;

import cn.hutool.core.util.StrUtil;
import lombok.Data;

/**
 * 将必填项放入构造函数，通过set()方式来动态设置可选参数，解决了第一种方法中的过长参数列表
 * @author zh0809
 * @date 2021/2/7 11:21
 **/
@Data
public class ResourcePoolConfig1 {

    /** 资源池名称 */
    private String name;
    /** 资源池最大资源数 */
    private int maxTotal = 8;
    /** 最大空闲资源数 */
    private int maxIdle = 8;
    /** 最小空闲资源数 */
    private int minIdle = 0;

    /** name是必填项，将它放入构造函数 */
    public ResourcePoolConfig1(String name) {
        if(StrUtil.isBlank(name)) {
            throw new IllegalArgumentException("name should not be empty.");
        }
        this.name = name;
    }

    public void setMaxTotal(int maxTotal) {
        if(maxTotal <= 0) {
            throw new IllegalArgumentException("maxTotal should be positive.");
        }
        this.maxTotal = maxTotal;
    }

    public void setMaxIdle(int maxIdle) {
        if(maxIdle < 0) {
            throw new IllegalArgumentException("maxIdle should not be negative.");
        }
        this.maxIdle = maxIdle;
    }

    public void setMinIdle(int minIdle) {
        if(minIdle < 0) {
            throw new IllegalArgumentException("maxIdle should not be negative.");
        }
        this.minIdle = minIdle;
    }
}
