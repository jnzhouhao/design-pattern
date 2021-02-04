package com.hunk.designpattern.factory.simple;

/**
 * 课程简单工厂
 * @author zh0809
 * @date 2021/2/4 11:14
 **/
public class CourseFactory {

    public static ICourse createSimple(String type) {
        if("java".equalsIgnoreCase(type)) {
            return new JavaCourse();
        } else if("php".equalsIgnoreCase(type)) {
            return new PhpCourse();
        }
        return null;
    }

    /**
     * 利用反射创建实例对象，这样再添加新课程的话也不需要修改工厂类代码
     */
    public static ICourse createCourse(Class<? extends ICourse> clazz) {
        if(clazz != null) {
            try {
                return clazz.newInstance();
            } catch (InstantiationException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

}
