package com.bfbmedu.seven.vip.customer_ioc;

import com.bfbmedu.seven.vip.customer_di.ConstructorArg;
import com.bfbmedu.seven.vip.customer_di.Property;
import com.bfbmedu.seven.vip.ioc_di.*;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * Every oak must be an acorn ...
 * 巴分巴秒官方交流QQ群 : 750555573
 * Author : Seven
 * Create Date : 2019/8/4
 */
public class Init {

    public static void main(String[] args) throws Exception {

        //  模拟解析xml   拿到 beanConfigs
        List<BeanConfig> beanConfigs = parseXmltoBeanConfig();

        //循环
        for (BeanConfig tmpconfig : beanConfigs) {


            if (null != tmpconfig.getClazz()) {

                //拿到clazz
                Class clazz = Class.forName(tmpconfig.getClazz());


                if (null != tmpconfig.getFactoryMethod())
                {

                    //基于Class对象获取method对象
                    Method method = clazz.getDeclaredMethod(tmpconfig.getFactoryMethod());


                    IOCContainer.putBean(tmpconfig.getId(), method.invoke(null));

                } else {
                    //SO EASY
                    IOCContainer.putBean(tmpconfig.getId(), clazz.newInstance());
                }

            } else if(null != tmpconfig.getFactoryBean()) {

                //从容器中拿到实体bean
                Object obj = IOCContainer.getBean( tmpconfig.getFactoryBean());


                Method method = obj.getClass().getDeclaredMethod(tmpconfig.getFactoryMethod());


                IOCContainer.putBean(tmpconfig.getId(),  method.invoke(obj));

            }else{
                System.out.println("不知道在搞什么鬼.2个核心的配置都没有!");
            }


            //判断是构造器还是setter
            if (tmpconfig.getConstructorArgs()!=null){//构造器
                Object obj = IOCContainer.getBean(tmpconfig.getId());
                List<ConstructorArg> constructorArgs = tmpconfig.getConstructorArgs();
                Class<?>[] paramTypes = new Class[constructorArgs.size()];
                Object[] objects = new Object[constructorArgs.size()];
                for(int i= 0;i<constructorArgs.size();i++) {
                    Object obj1 = IOCContainer.getBean(constructorArgs.get(i).getRef());
                    paramTypes[i] = obj1.getClass();
                    objects[i] = obj1;
                }
                Constructor con= obj.getClass().getDeclaredConstructor(paramTypes);
                IOCContainer.putBean(tmpconfig.getId(),  con.newInstance(objects));

            }
            if (tmpconfig.getProperties()!=null){//set
                for(Property property:tmpconfig.getProperties()) {
                    Object obj = IOCContainer.getBean(tmpconfig.getId());
                    Field field = obj.getClass().getDeclaredField(property.getName());
                    Object o = IOCContainer.getBean(property.getRef());
                    field.setAccessible(true);
                    Method[] methods = obj.getClass().getDeclaredMethods();
                    for(Method m :methods){
                        String  s="set"+field.getName().substring(0,1).toUpperCase()+field.getName().substring(1);
                        if(m.getName().equals(s)){
                            m.invoke(obj,o);
                        }
                    }
                    IOCContainer.putBean(tmpconfig.getId(),obj);
                }
            }
        }

/*        //IOC 测试
        A a = IOCContainer.getBean("a",A.class);
        B b = IOCContainer.getBean("b",B.class);
        C c = IOCContainer.getBean("c",C.class);
        D d = IOCContainer.getBean("d",D.class);
        E e = IOCContainer.getBean("e",E.class);*/
    }




    /**
     * 模拟一个解析XML过程
     *
     * @return
     */
    private static List<BeanConfig> parseXmltoBeanConfig() {

        //TODO
        List<BeanConfig> beanConfigs = new ArrayList<BeanConfig>();
        BeanConfig beanConfig1 = new BeanConfig();
        beanConfig1.setClazz("com.bfbmedu.seven.vip.ioc_di.A");
        beanConfig1.setId("a");
        beanConfigs.add(beanConfig1);


        BeanConfig beanConfig2 = new BeanConfig();
        beanConfig2.setClazz("com.bfbmedu.seven.vip.ioc_di.A");
        beanConfig2.setId("b");
        beanConfig2.setFactoryMethod("createBObj");
        beanConfigs.add(beanConfig2);


        BeanConfig beanConfig3 = new BeanConfig();
        beanConfig3.setId("c");
        beanConfig3.setFactoryBean("a");
        beanConfig3.setFactoryMethod("createCObj");
        beanConfigs.add(beanConfig3);

        BeanConfig beanConfig4 = new BeanConfig();
        beanConfig4.setClazz("com.bfbmedu.seven.vip.ioc_di.D");
        beanConfig4.setId("d");
        List<ConstructorArg> constructorArgs=new ArrayList<>();
        constructorArgs.add(new ConstructorArg("a"));
        constructorArgs.add(new ConstructorArg("b"));
        beanConfig4.setConstructorArgs(constructorArgs);
        beanConfigs.add(beanConfig4);


        BeanConfig beanConfig5 = new BeanConfig();
        beanConfig5.setClazz("com.bfbmedu.seven.vip.ioc_di.E");
        beanConfig5.setId("e");
        List<Property> properties=new ArrayList<>();
        properties.add(new Property("a","a"));
        properties.add(new Property("b","b"));
        beanConfig5.setProperties(properties);
        beanConfigs.add(beanConfig5);

        return beanConfigs;
    }
}
