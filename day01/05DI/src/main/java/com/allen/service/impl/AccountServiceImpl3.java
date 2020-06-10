package com.allen.service.impl;


import com.allen.service.IAccountService;

import java.util.*;

/**
 * 账户的业务层实现类
 */
public class AccountServiceImpl3 implements IAccountService {
    private String[] strs;
    private List<String> myList;
    private Set<String> mySet;
    private Map<String,String> myMap;
    private Properties MyProps;

    public void setStrs(String[] strs) {
        this.strs = strs;
    }

    public void setMyList(List<String> myList) {
        this.myList = myList;
    }

    public void setMySet(Set<String> mySet) {
        this.mySet = mySet;
    }

    public void setMyMap(Map<String, String> myMap) {
        this.myMap = myMap;
    }

    public void setMYProps(Properties MyProps) {
        this.MyProps = MyProps;
    }

    public void saveAccout() {
        System.out.println(Arrays.toString(strs));
        System.out.println(myList);
        System.out.println(mySet);
        System.out.println(myMap);
        System.out.println(MyProps);
    }
}
