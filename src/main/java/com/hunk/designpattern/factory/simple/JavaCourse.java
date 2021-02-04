package com.hunk.designpattern.factory.simple;

/**
 * Java课程
 * @author zh0809
 * @date 2021/2/4 11:08
 **/
public class JavaCourse implements ICourse {

    @Override
    public void live() {
        System.out.println("=== Java课程开播啦 ===");
    }
}
