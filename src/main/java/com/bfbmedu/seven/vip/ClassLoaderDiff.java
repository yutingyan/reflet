package com.bfbmedu.seven.vip;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

/**
 * Every oak must be an acorn ...
 * 巴分巴秒官方交流QQ群 : 750555573
 * Author : Seven
 * Create Date : 2019/8/3
 */
public class ClassLoaderDiff {

////    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
//        Class c=ClassLoaderDiff.class.getClassLoader().loadClass("com.bfbmedu.seven.vip.App");
////        c.newInstance();
////        Class c2= Class.forName("com.bfbmedu.seven.vip.App");
//
//
////        Class.forName("com.mysql.jdbc.Driver");
////        int [] its={};
////        its[5]=1;
////        System.out.println(its.length);
//
//        ArrayList arrayList =new ArrayList();
//
//        //我们的方式
//        Iterator iterable = arrayList.iterator();
//        while(iterable.hasNext()){
//            Object obj = iterable.next();
//            //TODO
//        }
//
//        //更优雅的方式
//        for (Iterator tempIterator = arrayList.iterator();tempIterator.hasNext();){
//            tempIterator.next();
//            //TODO
//        }
////
////
////        Class c3 = App.class;
////        c3.newInstance();
//    }

    public static void main(String[] args) {
        List list = new ArrayList();
        for (int i=0; i<10000000; i++)
            list.add(i);
        //isRandomAccessSupported(list);
        iteratorThroughRandomAccess(list) ;
        iteratorThroughIterator(list) ;
        iteratorThroughFor2(list) ;

    }

    private static void isRandomAccessSupported(List list) {
        if (list instanceof RandomAccess) {
            System.out.println("RandomAccess implemented!");
        } else {
            System.out.println("RandomAccess not implemented!");
        }

    }

    public static void iteratorThroughRandomAccess(List list) {

        long startTime;
        long endTime;
        startTime = System.currentTimeMillis();
        for (int i=0; i<list.size(); i++) {
            list.get(i);
        }
        endTime = System.currentTimeMillis();
        long interval = endTime - startTime;
        System.out.println("iteratorThroughRandomAccess：" + interval+" ms");
    }

    public static void iteratorThroughIterator(List list) {

        long startTime;
        long endTime;
        startTime = System.currentTimeMillis();
        for(Iterator iter = list.iterator(); iter.hasNext(); ) {
            iter.next();
        }
        endTime = System.currentTimeMillis();
        long interval = endTime - startTime;
        System.out.println("iteratorThroughIterator：" + interval+" ms");
    }


    public static void iteratorThroughFor2(List list) {

        long startTime;
        long endTime;
        startTime = System.currentTimeMillis();
        for(Object obj:list)
            ;
        endTime = System.currentTimeMillis();
        long interval = endTime - startTime;
        System.out.println("iteratorThroughFor2：" + interval+" ms");
    }
}
