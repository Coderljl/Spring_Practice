package com.allen.factory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * 创建Bean对象工厂
 *
 * Bean：在计算机英语中有重用组件含义
 *
 * JavaBean > 实体类
 * 他就是创建我们的ervice和dao
 * 第一个：需要我们的配置文件来配置我们的service和dao
 *         配置内容：唯一标示=全限定类名
 * 第二个：需要读取配置文件中的配置内容，反射创建对象
 *
 * 配置文件可以是xml也可以是properties
 */
public class BeanFactory {
    //定义一个Properties对象
    private  static Properties props;
    public static Map<String,Object> beans;

    //使用静态代码块为Properties对象赋值
    static {
        try { //实例化对象
            props = new Properties();
            //获取Properties文件流对象
            InputStream in =BeanFactory.class.getClassLoader().getResourceAsStream("bean.properties");
            props.load(in);
            //实例化容器
            beans = new HashMap<String, Object>();
            //取出配置文件所有的key
            Enumeration keys = props.keys();
            //遍历枚举
            while(keys.hasMoreElements()){
                String key =  keys.nextElement().toString();
                //根据key获取value
                String beanpath = props.getProperty(key);
                //反射创建对象
                Object value =Class.forName(beanpath).newInstance();
                beans.put(key,value);

            }
        } catch (Exception e) {
            throw new ExceptionInInitializerError("初始化properties失败");
        }
    }

    /**
     * 根据bean名称获取bean对象
     * @return
     */
    public static Object getBean(String beanName){

         return beans.get(beanName);
    }
//    public static Object getBean(String beanName) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
//        Object bean=null;
//        String beanPath = props.getProperty(beanName);
////        System.out.println(beanPath);
//        bean=Class.forName(beanPath).newInstance();
//        return bean;
//    }


}
