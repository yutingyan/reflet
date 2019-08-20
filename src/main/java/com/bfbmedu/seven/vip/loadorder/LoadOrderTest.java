package com.bfbmedu.seven.vip.loadorder;

/**
 * Every oak must be an acorn ...
 * 巴分巴秒官方交流QQ群 : 750555573
 * Author : Seven
 * Create Date : 2019/8/3
 */
public class LoadOrderTest {

    public static void main(String[] args) {
        Class c=SonClass.class;  //没有触发class的初始化
//        int a=SonClass.b;
        new SonClass();
        //打印什么?

//        Class.forName("jdbc")
    }
}
