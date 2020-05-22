package com.fd.recursion;

import java.util.Arrays;

/**
 * 变位字
 *  cat 全排： 3*2*1 = 6 种方式
 *
 *  不重复的字符能够组成的单词个数
 *
 *
 */
public class AnagramApp {


    static char[] chars;
    static int size;

    // 1. 全排列 n-1
    // 2. 循环 n 次
    // 3. 轮换
    public static void main(String[] args) {

        String input = "abcd";
        size = input.length();
        chars = new char[size];

        for (int i = 0; i < size; i++) {
            chars[i] = input.charAt(i);
        }
        doAnagram(size);
    }

    /**
     * 对 {@code newsize } 个字符进行全排
     * 1. 向左循环 {@code newsize} 次
     * 2. 对 {@code newsize-1 } 个字符进行全排
     * @param newsize
     */
    public static void doAnagram(int newsize){
        if (newsize == 1){
            System.out.println(Arrays.toString(chars)+"\t");
            return;
        }

        for (int i = 0; i < newsize; i++) {     // 指定循环移动的次数
            doAnagram(newsize-1);       // 循环移动位置一次就要进行一次全排
            rotate(newsize);                    // 对 newsize 个字符进行移动位置
        }
    }

    /**
     * 从下标为 {@code size - newsize} 的地方开始，
     * 将右侧的数据（下标大于 size - newsize 的数据），向左移动一位。
     * 下标为 {@code size - newsize} 移动至队尾
     * @param newsize
     */
    private static void rotate(int newsize) {
        int index = size - newsize;
        char temp = chars[index];
        while (index < size-1){
            chars[index++] = chars[index];
        }
        chars[size-1] = temp;
    }


}
