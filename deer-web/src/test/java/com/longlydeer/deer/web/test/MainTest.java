package com.longlydeer.deer.web.test;

import org.junit.Test;

/**
 * Created by Administrator on 2016/5/30.
 */
public class MainTest {
    @Test
    public void testName() throws Exception {
        System.out.println(Runtime.getRuntime().maxMemory()/1000/1000);
        synchronized (MainTest.class) {
            MainTest.class.wait();
        }
    }

    public static void main(String[] args) {
        System.out.println();

    }
}
