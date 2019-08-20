package com.bfbmedu.seven.vip.reflect_detail;

/**
 * Every oak must be an acorn ...
 * 巴分巴秒官方交流QQ群 : 750555573
 * Author : Seven
 * Create Date : 2019/8/4
 */
public class Boy extends Person {

    public static String description;

    public int height;

    private String likeDesc;

    public Boy() {}

    public Boy(String likeDesc) {
        this.likeDesc = likeDesc;
    }

    private Boy(String likeDesc, String name) {
        this.name = name;
        this.likeDesc = likeDesc;
    }

    public static void playBall() {
        System.out.println("we are boy !so we can play ball!");
    }

    private void pickUpGirls() {
        System.out.println("I discovered a new way to pick up girls");
    }

}
