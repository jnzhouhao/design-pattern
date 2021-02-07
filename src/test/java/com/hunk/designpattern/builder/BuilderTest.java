package com.hunk.designpattern.builder;

import com.hunk.designpattern.builder.poolconfig.ResourcePoolConfig0;
import com.hunk.designpattern.builder.poolconfig.ResourcePoolConfig1;
import com.hunk.designpattern.builder.poolconfig.ResourcePoolConfig2;
import org.junit.Test;

/**
 * 建造者模式测试用例
 * @author zh0809
 * @date 2021/2/7 11:11
 **/
public class BuilderTest {

    /**
     * 使用全参构造函数来创建对象方式
     */
    @Test
    public void resourcePoolConfig0Test() {
        ResourcePoolConfig0 config = new ResourcePoolConfig0("DBConnectionPool", 8, 8, 0);
        System.out.println("资源池名称：" + config.getName());
    }

    /**
     * 通过 set() 方法来动态设置参数，避免了第一种方式的参数过长问题
     * 可读性和易用性相对提高了很多
     */
    @Test
    public void resourcePoolConfig1Test() {
        ResourcePoolConfig1 config1 = new ResourcePoolConfig1("DBConnectionPool2");
        config1.setMaxTotal(8);
        config1.setMaxIdle(8);
        config1.setMinIdle(0);
        System.out.println("资源池名称：" + config1.getName());
    }

    @Test
    public void resourcePoolConfig2Test() {
        ResourcePoolConfig2 config2 = new ResourcePoolConfig2.Builder()
                .setName("DBConnectionPool3")
                .setMaxTotal(8)
                .setMaxIdle(8)
                .setMinIdle(0)
                .build();
        System.out.println("资源池名称：" + config2.getName());
    }
}
