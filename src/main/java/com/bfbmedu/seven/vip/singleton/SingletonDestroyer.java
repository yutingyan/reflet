package com.bfbmedu.seven.vip.singleton;

import java.lang.reflect.Constructor;

/**
 * Every oak must be an acorn ...
 * 巴分巴秒官方交流QQ群 : 750555573
 * Author : Seven
 * Create Date : 2019/8/3
 */
public class SingletonDestroyer {

    public static void main(String[] args) throws Exception {

        //懒汉式为例,看看反射如何破坏单例模式
        Lazy lazyInstance = Lazy.getInstance();


        Constructor constructor= Lazy.class.getDeclaredConstructor(null);

        constructor.setAccessible(true);    //设置私有的构造器 强制访问

        Lazy lazyInstancereflect = (Lazy)constructor.newInstance();

        System.out.println(lazyInstance == lazyInstancereflect);

        // ---->  false

    }

}
