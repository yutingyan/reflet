package com.bfbmedu.seven.vip.ioc_di;

/**
 * Every oak must be an acorn ...
 * 巴分巴秒官方交流QQ群 : 750555573
 * Author : Seven
 * Create Date : 2019/8/3
 */
public class D {

    private A a;

    private B b;

    public D() {
        System.out.println("D whitout parameters Constructor invoke!");
    }

    public D(A a, B b) {
        System.out.println("D constructor whit parameters invoke!");
        this.a = a;
        this.b = b;
    }
}
