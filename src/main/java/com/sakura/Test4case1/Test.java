package com.sakura.Test4case1;

public class Test {
    public static void main(String[] args) {
            MyThread t1 = new MyThread();
            MyThread t2 = new MyThread();
            MyThread t3 = new MyThread();
            MyThread t4 = new MyThread();
            MyThread t5 = new MyThread();
            t1.setName("花花");
            t2.setName("妈妈");
            t3.setName("萝卜");
            t4.setName("爸爸");
            t5.setName("神秘人士");
            t1.start();
            t2.start();
            t3.start();
            t4.start();
            t5.start();
    }
}
