package com.sakura.Test4case1;

import java.util.Random;

public class MyThread extends Thread {
    static double money = 100;
    static int counter = 3;
    //最小中奖金额0.1
    static final double MIN = 0.1;

    public void run() {
        synchronized (MyThread.class) {
            if (counter == 0) {
                System.out.println(getName() + " 没有抢到红包");

            } else {

                double prize = 0;
                if (counter == 1) {
                    prize = money;
                } else {
                    Random rand = new Random();
                    double bounds = money - MIN * (counter - 1);
                    prize = rand.nextDouble(bounds);
                    if (prize < MIN) {
                        prize = MIN;
                    }
                }
                counter--;
                money = money - prize;
                System.out.println(getName() + "抢到了" + prize + "元红包");
            }

        }
    }
}
