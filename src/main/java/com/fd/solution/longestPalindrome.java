package com.fd.solution;

import java.util.Objects;

/**
 * 5. 最长回文子串
 *
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 *
 * 示例 1：
 *
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * 示例 2：
 *
 * 输入: "cbbd"
 * 输出: "bb"
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-palindromic-substring
 */
public class longestPalindrome {

    public static void main(String[] args) {
        String[] s = {"babad","cbbd"};

        for (String s1 : s) {
            System.out.println(longestPalindrome(s1));
        }
    }

    /**
     * 中心扩展:
     *  1. 以中心一点向两端扩展 "babad"
     *  2. 以中心两点向两端扩展 "cbbd"
     *
     *  start : 表示回文字串的开始下标
     *  end   ：表示回文子串的 结束下表 + 1
     *
     *  end - start : 表示回文字串的长度（结束下表 - 开始下表 + 1 ）
     *
     * @param s
     * @return
     */
    public static String longestPalindrome(String s) {

        if (s == null || s.equals("")) return null;

        if ((s.length() == 1) || (s.length() == 2 && s.charAt(0) == s.charAt(1))) return s;
        if (s.length() == 2 )  return s.substring(0,1);

        char[] chars = s.toCharArray();
        int length = chars.length;

        int start = 0;
        int end = 0;

        for (int i = 0; i < chars.length-1; i++) {
            int i1 = extend(s, i, i, length);
            int i2 = extend(s, i, i+1, length);
            i1 = Math.max(i1,i2);

            if (i1 > (end - start)){
                start = i - (i1-1)/2;
                end = i + i1/2 +1;
            }
        }
        return s.substring(start,end);
    }


    /**
     * @param s
     * @param start
     * @param end
     * @param length
     * @return  回文字串的长度
     */
    public static int extend(String s,int start,int end,int length){
        while (start > -1 && end < length && Objects.equals(s.charAt(start),s.charAt(end))){
            start--;
            end++;
        }
        return end-start-1;
    }

}
