package com.allen.cjlib;

import com.allen.proxy.IProducer;

/**
 * 一个生产者
 */
public class Producer  {
     public void saleProduct(float money){
         System.out.println("销售成功，已收："+money);
     }
     public void afterService(float money){
         System.out.println("提供售后服务，并拿到钱"+money);
     }
}
