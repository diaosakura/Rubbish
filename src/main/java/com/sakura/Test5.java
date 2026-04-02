package com.sakura;

import java.util.Scanner;

public class Test5 {
    //遍历字符串中的每个字符
    public static void main(String[] args) {
        //键盘录入字符串
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个字符串");
        String str = sc.nextLine();
//        char[] c = str.toCharArray();
//        for(char cc : c){
//            System.out.println(cc);
//        }
        for(int i=0;i<str.length();i++){
            char c =str.charAt(i);
            System.out.println(c);

        }
    }



}
