package com.hunk.designpattern.factory.abstractFactory;

/**
 * java课程视频
 * @author zh0809
 * @date 2021/2/4 15:17
 **/
public class JavaVideo implements IVideo {
    @Override
    public void record() {
        System.out.println("=== 录制Java课程视频 ===");
    }
}
