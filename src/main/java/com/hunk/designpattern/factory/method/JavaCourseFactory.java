package com.hunk.designpattern.factory.method;

import com.hunk.designpattern.factory.ICourse;
import com.hunk.designpattern.factory.JavaCourse;

/**
 * Java课程生产工厂类
 * @author zh0809
 * @date 2021/2/4 14:10
 **/
public class JavaCourseFactory implements ICourseFactory {
    @Override
    public ICourse create() {
        return new JavaCourse();
    }
}
