package com.allen.ui;


import com.allen.service.IAccountService;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

import javax.annotation.Resource;


public class Client {
    /**
     * @param args
     */
    public static void main(String[] args) {
        //1.获取核心容器对象
//        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //2.根据id获取bean对象
//        IAccountService as = (IAccountService) ac.getBean("accountService");
//        IAccountService as = (IAccountService) ac.getBean("accountService2");
        IAccountService as = (IAccountService) ac.getBean("accountService3");
         as.saveAccout();
         ac.close();


    }
}
