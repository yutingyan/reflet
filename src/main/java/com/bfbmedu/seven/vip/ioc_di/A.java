package com.bfbmedu.seven.vip.ioc_di;


/**
 * Every oak must be an acorn ...
 * 巴分巴秒官方交流QQ群 : 750555573
 * Author : Seven
 * Create Date : 2019/8/3
 */
public class A {

    public A() {
        System.out.println("A whitout parameters Constructor invoke!");
    }

    public static B createBObj() {
        System.out.println("A static function createBObj() invoke!");
        return new B();
    }

    public C createCObj() {
        System.out.println("a's createCObj() invoke!");
        return new C();
    }

}
