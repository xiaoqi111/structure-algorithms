package com.fd.solution;

/**
 * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
 *
 * 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
 *
 * L   C   I   R
 * E T O E S I I G
 * E   D   H   N
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
 *
 * 请你实现这个将字符串进行指定行数变换的函数：
 *
 * string convert(string s, int numRows);
 * 示例 1:
 *
 * 输入: s = "LEETCODEISHIRING", numRows = 3
 * 输出: "LCIRETOESIIGEDHN"
 * 示例 2:
 *
 * 输入: s = "LEETCODEISHIRING", numRows = 4
 * 输出: "LDREOEIIECIHNTSG"
 * 解释:
 *
 * L     D     R
 * E   O E   I I
 * E C   I H   N
 * T     S     G
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zigzag-conversion
 */
public class ConvertApp {

    public static void main(String[] args) {

        String[] s = {"LEETCODEISHIRING","LEETCODEISHIRING"};
        int[] i = {3,4};

        for (int i1 = 0; i1 < s.length; i1++) {

            System.out.println(convert(s[i1], i[i1]));

        }
    }


    public static String convert(String s, int numRows) {

        int length = s.length();
        if (numRows < 3) throw new IllegalArgumentException("numRows 不得小于3");
        if (s == null || length <= numRows ) return s;

        StringBuilder stringBuilder = new StringBuilder();

        int interval = 2*numRows-2;
        int index = 0;
        for (int j = 1; j <= numRows; j++) {        // 当前的行数

            index = (interval << (j-1))+(j-1) - interval;

            while (index < length){
                stringBuilder.append(s.charAt(index));
                index +=interval<<1;

            }


        }








        return null;
    }


}
