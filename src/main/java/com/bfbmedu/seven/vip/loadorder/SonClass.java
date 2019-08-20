package com.bfbmedu.seven.vip.loadorder;

/**
 * Every oak must be an acorn ...
 * 巴分巴秒官方交流QQ群 : 750555573
 * Author : Seven
 * Create Date : 2019/8/3
 */
public class SonClass extends FatherClass  {

    public static int b = 3333;

    static {
        a=2222;
        System.out.println(b);

    }

    static {
        b=4444;
        System.out.println(a);
    }
}
