package com.sakura;

import java.util.Random;
import java.util.Scanner;

public class test1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        int b = 600;
//        int a = sc.nextInt();
//        if(a < b) {
//            System.out.println("No");
//        } else {
//            System.out.println("Yes");
//        }
//        System.out.println("请输入票号");
//        int piaohao = sc.nextInt();
//        if(piaohao>=0&&piaohao  <= 100 ){
//            if(piaohao %2==0) {
//            System.out.println("RIGHT");
//        }else {
//            System.out.println("LEFT");
//        }}
//        System.out.println("请输入成绩");
//        int grade = sc.nextInt();
//        if(grade >= 95 && grade <= 100) {
//            System.out.println("A");
//        }else if(grade >= 90 && grade <= 94) {
//            System.out.println("B");
//        }else if(grade >= 80 && grade <= 89) {
//            System.out.println("C");
//        }else if(grade >= 70 && grade <= 79) {
//            System.out.println("D");
//        }else{
//            System.out.println("揍一顿");
//        }
        Random rand = new Random();
        //2-90随机数

//        for(int b=0;b<89;b++){
//            int a = rand.nextInt(89)+2;
//            System.out.println(a);
//        }
//猜数字小游戏
//        int a = rand.nextInt(101);
//        System.out.println("请输入你猜的数字(0-100)");
//        int guess = sc.nextInt();
//        while (guess != a) {
//            if(guess > a) {
//            System.out.println("很遗憾，你猜大了");
//                System.out.println("请重新输入");
//                guess = sc.nextInt();
//            } else if (guess < a) {
//            System.out.println("很遗憾，你猜小了");
//                System.out.println("请重新输入");
//                guess = sc.nextInt();
//            }
//        }
//
//            System.out.println("恭喜你猜对了，数字是"+a);

        //数字解密小游戏
    /*    System.out.println("请输入数组长度");
        int n = sc.nextInt();
        int[] arr =new int[n];
        System.out.println("请输入数组元素");
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        System.out.println("数组元素为");
        for(int i=0;i<n;i++){
            if(i==n-1){
                System.out.println(arr[i]);
            }else{
                System.out.print(arr[i]+" ");
            }
        }

        for(int i=0,j=n-1;i<j;i++,j--){
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }System.out.println("数组元素反转后");
        for(int i=0;i<n;i++){
            if(i==n-1){
                System.out.println(arr[i]);
            }else{
                System.out.print(arr[i]+" ");
            }
        }
        System.out.println("数组元素取余逆运算后");
        //对10取余逆运算 0-9+5->5-14, 5,6,7,8,9,10,11,12,13，14对10取余->5，6,7,8，9， 0，1，2，3，4
        for(int i=0;i<n;i++){
            if(arr[i]>=5 &&arr[i]<=9){
                arr[i] -= 5;
                System.out.print(arr[i]+" ");
            } else if (arr[i]>=0&&arr[i]<5) {
                arr[i] += 5;
                System.out.print(arr[i]+" ");
            }
        }
*/
        //抢红包
        /*
        System.out.println("请输入红包个数");
        int num = sc.nextInt();
        System.out.println("请输入红包金额");
        int[] money=new int[num];
        for(int i=0;i<num;i++){
            money[i] = sc.nextInt();
        }
        System.out.println("红包金额为");
        for (int i=0;i<num;i++){
            if(i==num-1){
                System.out.println(money[i]);
            }else {
                System.out.print(money[i] + " ");
            }
        }


        System.out.println("你要抢几个红包");
        int cnt = sc.nextInt();
        if(cnt>num){
            System.out.println("你抢的红包数不能大于红包个数");
            return;
        }
      //洗牌
        for(int i = 0;i<num;i++){
            int j = rand.nextInt(num);
            int temp = money[i];
            money[i] = money[j];
            money[j] = temp;
        }
        System.out.println("你抢的红包为");
        for(int i=0;i<cnt;i++){
            System.out.print(money[i]+" ");
        }

         */
        //用户登陆

        String rightUsername = "admin";
        String rightPassword = "123456";
        for (int i = 0; i < 3; i++) {
            System.out.println("请输入用户名");
            String username = sc.next();
            System.out.println("请输入密码");
            String password = sc.next();
            if (username.equals(rightUsername) && password.equals(rightPassword)) {
                System.out.println("登录成功");
            } else {
                System.out.println("登录失败");
            }


        }
        return;
    }
}
