package com.longlydeer.deer.test;

/**
 * Created by Administrator on 2016/4/28.
 */
public class SingleObject {

    private  static class  UnsafeObject {
        private static UnsafeObject instance;

        private  UnsafeObject(){}

        public static UnsafeObject newInstance() {
            if (instance == null) {
                instance = new UnsafeObject();//指令重排序，非原子性
            }
            return instance;
        }

    }

    public static void main(String[] args) {
        Runnable run = new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + ":" + UnsafeObject.newInstance());
            }
        };

        new Thread(run, "A").start();
        new Thread(run, "B").start();
    }
}
