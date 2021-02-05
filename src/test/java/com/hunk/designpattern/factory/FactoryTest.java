package com.hunk.designpattern.factory;

import com.hunk.designpattern.factory.abstractFactory.AbstractCourseFactory;
import com.hunk.designpattern.factory.method.ICourseFactory;
import com.hunk.designpattern.factory.method.JavaCourseFactory;
import com.hunk.designpattern.factory.method.PhpCourseFactory;
import com.hunk.designpattern.factory.simple.CourseFactory;
import org.junit.Test;

/**
 * @author zh0809
 * @date 2021/2/4 14:07
 **/
public class FactoryTest {

    /**
     * 简单工厂
     */
    @Test
    public void simpleFactoryTest() {
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

    /**
     * 工厂方法
     */
    @Test
    public void factoryMethodTest() {
        // 工厂方法模式
        ICourseFactory javaCourseFactory = new JavaCourseFactory();
        ICourse javaCourse = javaCourseFactory.create();
        javaCourse.live();

        ICourseFactory phpCourseFactory = new PhpCourseFactory();
        ICourse phpCourse = phpCourseFactory.create();
        phpCourse.live();
    }

    @Test
    public void abstractFactoryTest() {
        com.hunk.designpattern.factory.abstractFactory.JavaCourseFactory courseFactory = new com.hunk.designpattern.factory.abstractFactory.JavaCourseFactory();
        courseFactory.createVideo().record();
        courseFactory.createNote().edit();
    }
}
