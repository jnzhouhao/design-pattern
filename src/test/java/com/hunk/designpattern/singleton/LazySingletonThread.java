package com.hunk.designpattern.singleton;

/**
 * 懒汉式单例 未加锁情况下的并发模拟线程
 * @author zh0809
 * @date 2021/2/6 10:59
 **/
public class LazySingletonThread implements Runnable {
    @Override
    public void run() {
        LazySingleton lazySingleton = LazySingleton.getInstance();
        System.out.println(Thread.currentThread().getName() + ":" + lazySingleton);
    }
}
