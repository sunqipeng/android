package com.example;

import android.net.Uri;

import java.io.File;

/**
 * Created by IntelliJ IDEA.
 * User: sunqipeng
 * Date: 11-8-13
 * Time: 下午6:01
 * To change this template use File | Settings | File Templates.
 */
public class Test {
    public static void main(String[] args) {
        File filew = new File("~/Document");
        System.out.print(Uri.fromFile(filew));
    }
}
