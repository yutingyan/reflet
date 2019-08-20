package com.bfbmedu.seven.vip.singleton;

/**
 * Every oak must be an acorn ...
 * 巴分巴秒官方交流QQ群 : 750555573
 * Author : Seven
 * Create Date : 2019/8/3
 */
public class Lazy {

    private static Lazy instance;

    private Lazy(){}

    public static Lazy getInstance(){
        if (instance == null){
            synchronized (Lazy.class){
                if (instance == null) {
                    instance = new Lazy();
                }
            }
        }
        return instance;
    }

}
