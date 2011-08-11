package edu.sun.struts.action;

import com.opensymphony.xwork2.ActionSupport;

/**
 * Created by IntelliJ IDEA.
 * User: sunqipeng
 * Date: 11-8-11
 * Time: 上午10:57
 * To change this template use File | Settings | File Templates.
 */
public class Hello extends ActionSupport {
    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    String message;

    public String hello() {
        if (name == null || name.trim().length() == 0
                )
            this.addFieldError("name", "姓名不能为空");
        message = String.valueOf(System.currentTimeMillis());
        name = name + message;
        return "index";
    }
}
