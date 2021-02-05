package com.hunk.designpattern.factory.abstractFactory;

/**
 * 抽象工厂类
 * @author zh0809
 * @date 2021/2/4 15:15
 **/
public abstract class AbstractCourseFactory {

    protected abstract IVideo createVideo();

    protected abstract INote createNote();
}
