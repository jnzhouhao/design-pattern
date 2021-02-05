package com.hunk.designpattern.factory.abstractFactory;

/**
 * @author zh0809
 * @date 2021/2/4 15:18
 **/
public class JavaNote implements INote {
    @Override
    public void edit() {
        System.out.println("=== 编写Java课堂笔记 ===");
    }
}
