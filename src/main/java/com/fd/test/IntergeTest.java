package com.fd.test;

public class IntergeTest {

    public static void main(String[] args) {
        Integer s1 = new Integer(128);
        Integer s2 = new Integer(128);

        Integer s3 = new Integer(127);
        Integer s4 = new Integer(127);
        Integer s5 = 127;
        int s6 = 127;


        int s7 = 128;
        Integer s8 = 128;
        Integer s9 = 128;
        Integer s10 = 127;
        //第一种情况：Integer类型的和new Integer（）类型的进行比较永远都是false
        System.out.println(s5 == s4);//false
        //第二种情况：如果一个是Integer类型的，一个是int类型的只要是这两个类型进行比较，只要是数值相等就肯定相等
        System.out.println(s5 == s6); //true
        System.out.println(s7 == s8); //true
        //第三种情况：只要是两个Integer对象都是new出来的Integer对象，比较一律俺对象进行处理
        System.out.println(s3 == s4); //false
        System.out.println(s1 == s2); //false
        System.out.println(s3.equals(s4)); //true
        System.out.println(s1.equals(s2));//true
        //第四种情况：也就是最关键的，如果两个都是Inter类型的进行比较的话，那么会先把【-128,127】的都当成一个int常量进行比较
        //            如果两个Integer类型的数超过这个范围，其实就相当于是还需要按照对象进行比较
        System.out.println(s8 == s9);//false
        System.out.println(s5 == s10);//true

    }

}
