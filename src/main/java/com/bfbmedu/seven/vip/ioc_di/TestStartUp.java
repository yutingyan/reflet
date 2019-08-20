package com.bfbmedu.seven.vip.ioc_di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Every oak must be an acorn ...
 * 巴分巴秒官方交流QQ群 : 750555573
 * Author : Seven
 * Create Date : 2019/8/3
 */
public class TestStartUp {
    public static void main(String[] args) {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("spring-di.xml");

        //IOC 测试
//        A a = context.getBean("a",A.class);
//        B b = context.getBean("b",B.class);
//        C c = context.getBean("c",C.class);

        //DI 测试
        D d = context.getBean("d",D.class);
        E e = context.getBean("e",E.class);
    }
}
