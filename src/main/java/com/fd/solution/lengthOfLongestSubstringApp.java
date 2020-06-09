package com.fd.solution;

import java.util.HashSet;
import java.util.Set;

/**
 * 无重复字符的最长子串
 *
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 *
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 *
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 *
 *
 */
public class lengthOfLongestSubstringApp {

    public static void main(String[] args) {

        String[] tests = {"abcabcbb","bbbbb","pwwkew","tmmzuxt"};

        for (int i = 0; i < tests.length; i++) {
            System.out.println(lengthOfLongestSubstring(tests[i]));
        }
    }

    /**
     *  右指针往前移动的前提条件是：右指针 到 左指针的子串不包含重复的字符
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring(String s){
        if (s == null || s.equals("")) return 0;
        char[] chars = s.toCharArray();
        HashSet<Character> records = new HashSet<>();
        int maxLength = 1;
        int lPtr = 0;
        char cur;
        for (int i = 0; i < chars.length; i++) {        // 表示右指针的移动
            cur = chars[i];
            boolean containsKey = records.contains(cur);
            boolean firstCompare = true;
            while (lPtr <= i && containsKey ){          // 表示左指针的移动
                if (firstCompare) {
                    maxLength = Math.max(maxLength,i-lPtr);
                    firstCompare = false;
                }
                if (chars[lPtr++] == cur) break;
                records.remove(chars[lPtr-1]);          // 必须要移除先前的记录
            }
            records.add(cur);
        }
        return Math.max(maxLength,chars.length-lPtr);
    }

    public static int test(String s){
        // 哈希集合，记录每个字符是否出现过
        Set<Character> occ = new HashSet<Character>();
        int n = s.length();
        // 右指针，初始值为 -1，相当于我们在字符串的左边界的左侧，还没有开始移动
        int rk = -1, ans = 0;
        for (int i = 0; i < n; ++i) {
            if (i != 0) {
                // 左指针向右移动一格，移除一个字符
                occ.remove(s.charAt(i - 1));
            }
            while (rk + 1 < n && !occ.contains(s.charAt(rk + 1))) {
                // 不断地移动右指针
                occ.add(s.charAt(rk + 1));
                ++rk;
            }
            // 第 i 到 rk 个字符是一个极长的无重复字符子串
            ans = Math.max(ans, rk - i + 1);
        }
        return ans;
    }
}
