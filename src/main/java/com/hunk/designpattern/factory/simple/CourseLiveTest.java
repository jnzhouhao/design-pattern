package com.hunk.designpattern.factory.simple;

import org.junit.Test;

/**
 * @author zh0809
 * @date 2021/2/4 11:11
 **/
public class CourseLiveTest {

    @Test
    public void liveTest() {
        // 最普通的简单工厂模式，缺点就是：每新增一个课程就需要改动工厂类代码，不符合开闭原则
        ICourse course = CourseFactory.createSimple("java");
        assert course != null;
        course.live();

        // 优化后的方法：通过反射机制创建实例，再有新课程也无需修改工厂类代码，客户端直接使用所需课程即可
        ICourse javaCourse = CourseFactory.createCourse(JavaCourse.class);
        javaCourse.live();
        ICourse phpCourse = CourseFactory.createCourse(PhpCourse.class);
        phpCourse.live();
    }
}