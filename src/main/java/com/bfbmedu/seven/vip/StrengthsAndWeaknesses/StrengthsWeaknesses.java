package com.bfbmedu.seven.vip.StrengthsAndWeaknesses;

/**
 * Every oak must be an acorn ...
 * 巴分巴秒官方交流QQ群 : 750555573
 * Author : Seven
 * Create Date : 2019/8/4
 */
public class StrengthsWeaknesses {

    public static void main(String[] args) {
        String key = "Word" ;

//        Office office = getInstanceByKey(key);
//
//        Office office =getInstanceReflectByKey(key);

        long startTime= System.currentTimeMillis();

        for(int i= 0;i < 1000000;i++){
            Office office = getInstanceReflectByKey(key);
        }

        long endTime= System.currentTimeMillis();

        System.out.println("总计花费时间:"+(endTime-startTime));
    }

    /**
     * 通过传入key 创建不同的对象
     * @param key
     * @return
     */
    public static Office getInstanceByKey(String key){
        if("Word".equals(key)){
            return new Word();
        }

        if("Excel".equals(key)){
            return new Excel();
        }

        return null;
    }



    /**
     * 通过反射机制动态的创建
     * @param key
     * @return
     */
    public static Office getInstanceReflectByKey (String key){
        String packageName = "com.bfbmedu.seven.vip.StrengthsAndWeaknesses";
        Office office = null;
        try {
            Class clazz = Class.forName(packageName+"."+key);
            office = (Office)clazz.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return office;
    }
}

