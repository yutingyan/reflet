package com.bfbmedu.seven.vip.customer_ioc;

import java.util.HashMap;

/**
 * Every oak must be an acorn ...
 * 巴分巴秒官方交流QQ群 : 750555573
 * Author : Seven
 * Create Date : 2019/8/4
 */
public  class  IOCContainer {

    private static HashMap container = new HashMap();

    public static void putBean(String id,Object object){
        container.put(id,object);
    }

    public static Object getBean(String id){
        return container.get(id);
    }

    public static <T> T getBean(String id,Class<T> clazz){
        return (T)container.get(id);
    }

    public static HashMap getContainer() {
        return container;
    }

    public static void setContainer(HashMap container) {
        IOCContainer.container = container;
    }
}
