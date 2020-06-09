package com.fd.solution;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 *
 * 示例:
 *
 * 给定 nums = [2, 7, 11, 15], target = 9
 *
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 *
 */
public class SumOfTwoNumbers {


    public static void main(String[] args) {

//        int[]  nums = new  int[]{3,2,4};
//        int[] ints = twoSum(nums, 6);
//
//        System.out.println(Arrays.toString(ints));
        System.out.println("asdhflajsdfkljadsffasdfasdfasdfadsfasdfasghrhtrgh".hashCode());
    }

    /**
     * 83 ms
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum(int[] nums, int target) {

        int firstIndex = 0;
        int secondIndex;

        while (firstIndex < nums.length-1)
        {
            secondIndex = nums.length-1;
            while (secondIndex > firstIndex){
                if(nums[firstIndex] + nums[secondIndex--] == target) return new int[]{firstIndex,secondIndex+1};
            }
            firstIndex++;

        }
        return null;
    }

    /**
     * 	2 ms
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSumVersion2(int[] nums, int target) {

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }


}
