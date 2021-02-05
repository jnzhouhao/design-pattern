package com.hunk.designpattern.factory.abstractFactory;

/**
 * @author zh0809
 * @date 2021/2/4 15:30
 **/
public class JavaCourseFactory extends AbstractCourseFactory {
    @Override
    public IVideo createVideo() {
        return new JavaVideo();
    }

    @Override
    public INote createNote() {
        return new JavaNote();
    }
}
