package com.example;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: sunqipeng
 * Date: 11-8-10
 * Time: 下午4:52
 * To change this template use File | Settings | File Templates.
 */
public class OptionMenu {


    public static List<String> getMenuContent() {
        return menuContent;
    }

    public static void setMenuContent(List<String> menuContent) {
        OptionMenu.menuContent = menuContent;
    }

    private static List<String> menuContent = new ArrayList<String>();

    public static int getIndex(String menu) {
        return menuContent.indexOf(menu);
    }
}
