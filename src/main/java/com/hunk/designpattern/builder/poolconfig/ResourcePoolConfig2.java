package com.hunk.designpattern.builder.poolconfig;

import cn.hutool.core.util.StrUtil;
import lombok.Data;

/**
 * 基于前面两种方式，我们通过构造函数设置必填项，通过 set() 方法设置可选配置项，就能实现我们的设计需求。
 * 在此基础上加几个需求：
 * 1）把必填项放入构造函数中，如果必填参数过多，就又会出现参数列表过长问题；
 *   如果把必填项也通过set()方式设置，那必填校验的逻辑就无处安放了。
 * 2）如果参数之间有一定的依赖关系或约束关系，参数之间的逻辑校验也无处安放。
 *   比如 maxIdle和 minIdle 要小于等于 maxTotal，通过set() 就没法校验了
 *
 * 通过建造者模式重新设计
 *
 * @author zh0809
 * @date 2021/2/7 11:40
 **/
@Data
public class ResourcePoolConfig2 {
    /** 资源池名称 */
    private String name;
    /** 资源池最大资源数 */
    private int maxTotal;
    /** 最大空闲资源数 */
    private int maxIdle;
    /** 最小空闲资源数 */
    private int minIdle;

    private ResourcePoolConfig2(Builder builder) {
        this.name = builder.name;
        this.maxTotal = builder.maxTotal;
        this.maxIdle = builder.maxIdle;
        this.minIdle = builder.minIdle;
    }

    public static class Builder {
        private String name;
        /** 资源池最大资源数 */
        private int maxTotal = 8;
        /** 最大空闲资源数 */
        private int maxIdle = 8;
        /** 最小空闲资源数 */
        private int minIdle = 0;

        public ResourcePoolConfig2 build() {
            // 添加各种校验
            if(StrUtil.isBlank(name)) {
                throw new IllegalArgumentException("name should not be empty.");
            }
            // 添加约束校验
            if (maxIdle > maxTotal) {
                throw new IllegalArgumentException("maxIdle should be less than maxTotal.");
            }
            if (minIdle > maxTotal || minIdle > maxIdle) {
                throw new IllegalArgumentException("maxIdle should be less than maxTotal/maxIdle.");
            }
            return new ResourcePoolConfig2(this);
        }

        public Builder setName(String name) {
            if(StrUtil.isBlank(name)) {
                throw new IllegalArgumentException("name should not be empty.");
            }
            this.name = name;
            return this;
        }

        public Builder setMaxTotal(int maxTotal) {
            if(maxTotal <= 0) {
                throw new IllegalArgumentException("maxTotal should be positive.");
            }
            this.maxTotal = maxTotal;
            return this;
        }

        public Builder setMaxIdle(int maxIdle) {
            if(maxIdle < 0) {
                throw new IllegalArgumentException("maxIdle should not be negative.");
            }
            this.maxIdle = maxIdle;
            return this;
        }

        public Builder setMinIdle(int minIdle) {
            if(minIdle < 0) {
                throw new IllegalArgumentException("maxIdle should not be negative.");
            }
            this.minIdle = minIdle;
            return this;
        }
    }
}
