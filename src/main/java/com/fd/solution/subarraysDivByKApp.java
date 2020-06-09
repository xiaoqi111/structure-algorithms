package com.fd.solution;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * 子前缀和、同余定理
 *
 * 给定一个整数数组 A，返回其中元素之和可被 K 整除的（连续、非空）子数组的数目。
 *
 * 输入：A = [4,5,0,-2,-3,1], K = 5
 * 输出：7
 * 解释：
 * 有 7 个子数组满足其元素之和可被 K = 5 整除：
 * [4, 5, 0, -2, -3, 1], [5], [5, 0], [5, 0, -2, -3], [0], [0, -2, -3], [-2, -3]
 *
 * https://leetcode-cn.com/problems/subarray-sums-divisible-by-k/
 */
public class subarraysDivByKApp {

    public static void main(String[] args) {

        int A[] = {4,5,0,-2,-3,1};

        int i = subarraysDivByK(A, 5);

        System.out.println(i);


    }


    /**
     * 4,5,0,-2,-3,1
     * 4,4,4, 2, 4,0   ----> 前缀和的余数
     * @param A
     * @param K
     * @return
     */
    public static int subarraysDivByK(int[] A, int K) {

        HashMap<Integer, Integer> recoreds = new HashMap<>();
        recoreds.put(0,1);      // 保证自身拥有记录

        int module;
        int sum = 0;    // 子前缀和
        int result = 0;
        for (int i : A) {
            sum+=i;
            module = (sum % K + K) % K;
            Integer record = recoreds.getOrDefault(module, 0);
            result+=record;
            recoreds.put(module,record+1);
        }
        return result;
    }

}
