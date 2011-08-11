package com.example;

/**
 * Created by IntelliJ IDEA.
 * User: sunqipeng
 * Date: 11-8-10
 * Time: 下午7:00
 * To change this template use File | Settings | File Templates.
 */
public class Test {


    public static void main(String[] args) {
        System.out.println((new Test()).getReplyString());
        ;
    }

    public String getReplyString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("前缀:");
        stringBuilder.append("requst_location:");
        stringBuilder.append("111111111");
        stringBuilder.append(":");
        stringBuilder.append("22222222");
        return stringBuilder.toString();
    }
}
