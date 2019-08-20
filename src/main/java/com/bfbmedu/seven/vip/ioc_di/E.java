package com.bfbmedu.seven.vip.ioc_di;

/**
 * Every oak must be an acorn ...
 * 巴分巴秒官方交流QQ群 : 750555573
 * Author : Seven
 * Create Date : 2019/8/3
 */
public class E {

    private A a;
    private B b;


    public void setA(A a) {
        System.out.println("E setA() invoke!");
        this.a = a;
    }

    public void setB(B b) {
        System.out.println("E setB() invoke!");
        this.b = b;
    }

}
