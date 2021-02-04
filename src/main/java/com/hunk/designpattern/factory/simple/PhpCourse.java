package com.hunk.designpattern.factory.simple;

/**
 * php课程
 * @author zh0809
 * @date 2021/2/4 11:10
 **/
public class PhpCourse implements ICourse {

    @Override
    public void live() {
        System.out.println("=== PHP课程开播啦 ===");
    }
}
