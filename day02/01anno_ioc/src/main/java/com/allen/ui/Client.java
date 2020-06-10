package com.allen.ui;

import com.allen.dao.IAccountDao;
import com.allen.service.IAccountService;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

import javax.annotation.Resource;


public class Client {
    /**
     * 获取Ioc核心容器，并根据ID获取对象
     * ApplicationContext的三个常用实现类
     * ClassPathXmlApplicationContext          可以加载类路径下配置文件，要求配置文件必须在类路径下。
     * FileSystemXmlApplicationContext         可以加载磁盘任意路径下配置文件（必须有访问权限）
     * AnnotationConfigApplicationContext      读取注解创建容器
     * 核心对象两个接口引发的问题
     * ApplicetionContext
     * 它在构建核心容器时，创建对象采取的策略是采用立即加载的方式，只要读取完配置马上就创建配置文件中的配置的对象。
     * BeanFactory
     * 它在构建核心容器时，创建对象采取的策略是采用延时加载的方式，根据id获取对象时候才创建对象。
     *
     * @param args
     */
    public static void main(String[] args) {
        //1.获取核心容器对象
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //2.根据id获取bean对象
        IAccountService as = (IAccountService) ac.getBean("accountService");
//        IAccountService as2 = (IAccountService) ac.getBean("accountService");
//        System.out.println(as==as2);
        as.saveAccout();
        ac.close();

    }
}
