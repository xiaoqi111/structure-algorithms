package com.fd.sort;

import java.util.Arrays;

/**
 * 快速排序：
 *  1. 指定左右两个指针，分别代表左右两个数组的指定的位置
 *  2. 数据分区，指定一个值，分成小于当前数值的左边区域和大于当前数值的右边区域
 *  3. 迭代数据分区，直到 leftPtr >= rightPtr
 */
public class QuickSort {


    public static final InsertSort.Order DEFAULT_ORDER = InsertSort.Order.DESC;

    private int[] element;
    private int count;

    private InsertSort.Order order;

    public QuickSort(int maxSize) {
        this(maxSize,DEFAULT_ORDER);
    }

    public QuickSort(int maxSize , InsertSort.Order order) {
        element = new int[maxSize];
        this.order = order;
    }

    public boolean isFull(){
        return count >= this.element.length;
    }

    public void insert(int num){
        if (isFull()) throw new RuntimeException(" element is full ");
        element[count] = num;
        count++;
    }

    public void doOrder(){



    }

    /**
     * 数组以 {@param pivot} 为中心值进行分区
     * @param left  待分区数组的左下标
     * @param right 待分区数组的右下标
     * @param pivot 待分区数组的中心标准
     * @return
     */
    public int partitionArray(int left,int right ,int pivot){

        int leftPtr = left - 1;
        int rightPtr = right + 1;

        while (leftPtr <= rightPtr)
        {
            while (element[++leftPtr] > pivot);
            while (element[--rightPtr] < pivot);
            if (leftPtr <= rightPtr){
                int temp = element[leftPtr];
                element[leftPtr] = element[rightPtr];
                element[rightPtr] = temp;
            }
        }
        return leftPtr;
    }




    public void setOrder(InsertSort.Order order) {
        this.order = order;
    }

    private boolean isAsc(int el ,int er){
        return order == InsertSort.Order.ASC ? el<er:el>er;
    }

    public void display(){
        Arrays.stream(element).forEach(element-> System.out.print(element+"\t"));
        System.out.println("");
        System.out.println("-===================================-");
    }



    public static void main(String[] args) {

        QuickSort order = new QuickSort(10, InsertSort.Order.DESC);

        for (int i = 0; i < 10; i++) {
            order.insert((int)(Math.random()*1000));
        }
        order.display();

        order.doOrder();

        order.display();

    }


}
