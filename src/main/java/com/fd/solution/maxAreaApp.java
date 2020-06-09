package com.fd.solution;

/**
 * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。
 * 在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，
 * 使得它们与 x 轴共同构成的容器可以容纳最多的水。
 *
 * 说明：你不能倾斜容器，且 n 的值至少为 2。
 *
 *
 *  https://leetcode-cn.com/problems/container-with-most-water/
 */
public class maxAreaApp {

    public static void main(String[] args) {

        int[] height = {1,8,6,2,5,4,8,3,7};
        int area = maxAreaVersion2(height);
        System.out.println("max area = "+area);

    }


    public static int maxArea(int[] height) {

        int maxArea = -1;
        int l,h,temp;
        for (int i = 0; i < height.length-1; i++) {
            for (int j = i+1; j < height.length; j++) {
                h = height[i]>height[j]?height[j]:height[i];
                l = j-i;
                temp = h*l;
                if (maxArea < temp){
                    maxArea = temp;
                }
            }
        }
        return maxArea;
    }

    /**
     * 定义两根指针，不是左指针右移，就是右指针左移
     * @param height
     * @return
     */
    public static int maxAreaVersion2(int[] height) {

        int leftPtr = 0;
        int rightPtr = height.length-1;
        int result = -1;
        int temp;
        while (leftPtr<rightPtr){
            temp = Math.min(height[leftPtr],height[rightPtr]) * (rightPtr - leftPtr);
            if (temp>result){
                result = temp;
            }
            if (height[leftPtr] > height[rightPtr]){    // 指针移动的判断
                rightPtr--;
            }else {
                leftPtr++;
            }
        }
        return result;
    }

}
