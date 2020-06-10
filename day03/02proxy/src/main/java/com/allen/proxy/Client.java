package com.allen.proxy;

import com.sun.codemodel.internal.JInvocation;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Client  {
    public static void main(String[] args) {
        final Producer producer = new Producer();
        producer.saleProduct(10000);

        IProducer proxyProduct = (IProducer) Proxy.newProxyInstance(producer.getClass().getClassLoader(),
                producer.getClass().getInterfaces(), new InvocationHandler() {
                    /**
                     * 作用：执行被代理对象的任何接口方法都会经过该方法
                     * @param proxy 代理对象引用
                     * @param method 当前执行的方法
                     * @param args   当前执行的方法所需要参数
                     * @return       和被代理对象有相同的返回值
                     * @throws Throwable
                     */
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        //提供增强的方法
                        Object returnValue = null;
                        //1.获取方法执行的参数
                        Float money = (Float) args[0];
                        //2.判断当前方法是不是销售
                        if ("saleProduct".equals(method.getName())){
                            returnValue = method.invoke(producer,money*0.8f);
                        }
                        return returnValue ;
                    }
                });
         proxyProduct.saleProduct(1000f);
    }
}
