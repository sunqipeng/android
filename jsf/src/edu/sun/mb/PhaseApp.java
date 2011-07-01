package edu.sun.mb;

import javax.faces.event.PhaseEvent;

/**
 * Created by IntelliJ IDEA.
 * User: sunqipeng
 * Date: 11-7-1
 * Time: 下午1:13
 * To change this template use File | Settings | File Templates.
 */
public class PhaseApp {

    public void process(PhaseEvent ee) {
        System.out.println("这里是一个测试");
    }
}
