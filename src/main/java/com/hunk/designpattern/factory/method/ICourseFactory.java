package com.hunk.designpattern.factory.method;

import com.hunk.designpattern.factory.ICourse;

/**
 * 课程工厂接口
 * @author zh0809
 * @date 2021/2/4 14:09
 **/
public interface ICourseFactory {

    /** 创建课程 */
    ICourse create();
}
