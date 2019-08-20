package com.bfbmedu.seven.vip.reflect_detail;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Every oak must be an acorn ...
 * 巴分巴秒官方交流QQ群 : 750555573
 * Author : Seven
 * Create Date : 2019/8/4
 */
public class ReflectTest {

    public static void main(String[] args) throws Exception {

        //4中获取Class对象的方法
        Class clazz1 = Boy.class;
        Class clazz2 = ReflectTest.class.getClassLoader().loadClass("com.bfbmedu.seven.vip.reflect_detail.Boy");
        Class clazz3 = Class.forName("com.bfbmedu.seven.vip.reflect_detail.Boy");
        Boy boy= new Boy();
        Class clazz4 = boy.getClass();



        basicOper(clazz1);


//
        Boy tmpBoy= new Boy();

//        fieldOper(tmpBoy);


//        methodOper(tmpBoy);
        ConstructorOper(tmpBoy);



        //class.newInstance()的本质是????

    }

    /**
     *Class 类中 包 类  修饰 等
     */
    private static void basicOper(Class clazz)throws Exception {

        //获取修饰符 , 特征符
        int modifier = clazz.getModifiers();
        System.out.println("class 的 修饰符: " + modifier);

//        //获取包对象
        Package personPackage = clazz.getPackage();
        System.out.println("class 的 Package: " + personPackage.getName());
//
//        //类名
        String fullClassName = clazz.getName();
        String simpleClassname = clazz.getSimpleName();
        System.out.println("class 的 fullClassName: " + fullClassName);
        System.out.println("class 的 simpleClassname: " + simpleClassname);
//
//        //获取类加载器
        ClassLoader classLoader = clazz.getClassLoader();
        System.out.println("class 的 classLoader: " + classLoader);
//
//        //获取当前类实现的接口列表
        Class[] cs = clazz.getInterfaces();
//
//        //父类
        Class fc= clazz.getSuperclass();
//        System.out.println("class 的 Superclass: "+fc.getSimpleName());

    }


    /**
     * 属性操作
     * @param boy
     * @throws Exception
     */
    private static void fieldOper(Boy boy)throws Exception {

        //获取对象的类字节码对象
        Class clazz = boy.getClass();

        //获取所有公有的属性,包含继承
        Field[] fields = clazz.getFields();
        System.out.println("public 修饰的属性有 "+fields.length+" 个");

        //获取指定名字的属性对象
        Field nameField=clazz.getField("name");
        Field heightField=clazz.getField("height");
        Field descriptionField = clazz.getField("description");

        //操作属性
        nameField.set(boy,"小皮皮");
        heightField.set(boy,180);
        descriptionField.set(null,"没有结婚的都是男孩!");

        System.out.println("boy的名字设置 :" + boy.name);
        System.out.println("boy的height设置 :" + boy.height);
        System.out.println("静态变量description设置:" + Boy.description);

        //类中属性获取及操作 (本类中定义,不管什么修饰都能获取)
        Field[] declaredFields=clazz.getDeclaredFields();
        System.out.println("Boy 类中定义了"+declaredFields.length+"个属性!");

        //获取指定的属性..
        Field likeDescField=clazz.getDeclaredField("likeDesc");

        int modifersFiled =  likeDescField.getModifiers();

        System.out.println("likeDesc 属性的修饰符:" + modifersFiled);


        //likeDesc 设置属性强制访问(强吻)
        //likeDescField.isAccessible();
        likeDescField.setAccessible(true);
        likeDescField.set(boy,"肤白,貌美,大长腿!");
    }


    /**
     * 方法的操作
     * @param boy
     * @throws Exception
     */
    private static void methodOper(Boy boy)throws Exception {

        //获取对象的类字节码对象
        Class clazz = boy.getClass();

        //获取所有公有的方法,包含继承
        Method[] methods = clazz.getMethods();
        System.out.println("public 修饰的 method 有 "+methods.length+" 个");

        //获取类中定义的指定名称的公有方法
        Method talkMethod = clazz.getMethod("talk", String.class);

        Method playBallMethod = clazz.getMethod("playBall");

        Method toStringMethod = clazz.getMethod("toString");

        //Method对象方法详解
        int modifers = playBallMethod.getModifiers();       //获取方法定义的修饰
        System.out.println("playBallMethod 的修饰符:" + modifers);
//
        Class returnClazz = talkMethod.getReturnType();
        System.out.println("talkMethod 返回值:"+ returnClazz);
//
//        //方法的参数列表
        Class[] parameterClazzs = talkMethod.getParameterTypes();
//
//        //方法的抛出的异常列表
        Class[] exceptionClazzs = talkMethod.getExceptionTypes();

//      //方法调用
        talkMethod.invoke(boy,"I LOVE SEVEN");
        //静态方法调用
        playBallMethod.invoke(null);
//
//
        //获取本类中定义的方式(不管修饰符统统获取)
        Method[] declaredMethods = clazz.getDeclaredMethods();
        System.out.println("Boy 类中定义了 "+declaredMethods.length+"个函数");

        //获取指定名称的本类定义的方法
        Method pickUpGirlsMethod = clazz.getDeclaredMethod("pickUpGirls");

        //pickUpGirlsMethod  私有方法   强吻
        pickUpGirlsMethod.setAccessible(true);

        pickUpGirlsMethod.invoke(boy);

    }


    /**
     * 方法的操作
     * @param boy
     * @throws Exception
     */
    private static void ConstructorOper(Boy boy)throws Exception {

        //获取对象的类字节码对象
        Class clazz = boy.getClass();

        //获取类中定义的所有的构造方法(包含公有,私有)
        Constructor[] constructors = clazz.getDeclaredConstructors();
        System.out.println("Boy 类中定义了"+constructors.length+"个构造函数");

        //获取无参构造函数
        Constructor constructorWithOutParam=  clazz.getDeclaredConstructor();

        //constructor操作

        //获取构造函数的修饰符
        int modifiers =constructorWithOutParam.getModifiers();

        System.out.println("Boy 的 constructorWithOutParam 修饰符:"+modifiers);

        //获取参数列表类型
        Class[] paramClazzs=constructorWithOutParam.getParameterTypes();

        //获取异常列表类型
        Class[] exceptionClazzs = constructorWithOutParam.getExceptionTypes();

        //构造器调用
        Boy boyReflect = (Boy) constructorWithOutParam.newInstance();
        boyReflect.talk("hello world!");


        //带参私有构造使用案例
        Constructor constructorWithParamAndPrivate=  clazz.getDeclaredConstructor(String.class,String.class);

        int constructorWithParamAndPrivateModifiers = constructorWithParamAndPrivate.getModifiers();

        System.out.println("constructorWithParamAndPrivateModifiers : "+constructorWithParamAndPrivateModifiers);

        //强吻
        constructorWithParamAndPrivate.setAccessible(true);


        boyReflect = (Boy)constructorWithParamAndPrivate.newInstance("亭亭玉立,秀色可餐","小蛋蛋");


        System.out.println("通过私有构造构造的boy对象name属性:"+boyReflect.name);
    }



}
