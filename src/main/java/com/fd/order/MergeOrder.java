package com.fd.order;

import java.util.Arrays;

/**
 * 归并排序：
 *      1.拆： 拆解=左拆+右拆
 *      2.合： 合并并排序
 *
 *      缺点： 需要在存储器中存在一个与被排序数组数据项数目相同的数组--空间换时间
 *      优点： 时间复杂度相对于简单排序O（n^2）,归并排序的时间复杂度是 O（N*LogN）
 *
 */
public class MergeOrder {

    public static final InsertOrder.Order DEFAULT_ORDER = InsertOrder.Order.DESC;

    private int[] element;
    private int count;

    private InsertOrder.Order order;

    public MergeOrder(int maxSize) {
        this(maxSize,DEFAULT_ORDER);
    }

    public MergeOrder(int maxSize , InsertOrder.Order order) {
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

        int length = this.element.length;
        int[] sortArray = new int[length];

        final InsertOrder.Order toOrder = this.order;
        if (toOrder == null ) throw new RuntimeException(" order is full");

        recMergeSort(sortArray,0,length-1);

    }

    /**
     * 1. 拆 = 左拆 + 右拆
     * 2. 合并
     * @param sortArray 第三方临时存储空间
     * @param lower     待拆解数组的左临界
     * @param higher    待拆解数组的右临界
     */
    private void recMergeSort(int[] sortArray,int lower,int higher){

        if (lower == higher) return;

        int mid = (lower+higher)/2;

        recMergeSort(sortArray,lower,mid);              // 拆解左边
        recMergeSort(sortArray,mid+1,higher);      // 拆解右边

        merge(sortArray,lower,mid,higher);

    }

    /**
     * 合并两个有序队列，并排序
     * @param sortArray     第三方临时存储空间
     * @param lower         左数组的左临界下标
     * @param mid           左数组的右临界下标（mid +1 右数组的左临界下标）
     * @param higher        右数组的右临界下标
     */
    private void merge(int[] sortArray, int lower, int mid, int higher) {

        int i= 0;                   // 临时存储空间的下标
        int item = higher-lower+1;  // 待合并两数组的个数
        int lowerPoint = lower;     // 左数组的指针
        int highPoint = mid+1;      // 右数组的指针


        while (lowerPoint<=mid && highPoint <= higher){             // 任意一个数组遍历完成之前比较两数组指针对应的数据，并填充
            if (isAsc(element[lowerPoint],element[highPoint])){
                sortArray[i++] = element[lowerPoint++];
            }else {
                sortArray[i++] = element[highPoint++];
            }
        }

        while (lowerPoint <= mid){                  // 左数组未便利完成全部填充
            sortArray[i++] = element[lowerPoint++];
        }

        while (highPoint<=higher){                  // 右数组未便利完成全部填充
            sortArray[i++] = element[highPoint++];
        }

        for (int j = 0; j < item; j++) {            // 把临时空间数据搬回对应下标的数组中（已排序好）
            element[lower+j] = sortArray[j];
        }
    }


    public void setOrder(InsertOrder.Order order) {
        this.order = order;
    }

    private boolean isAsc(int el ,int er){
        return order == InsertOrder.Order.ASC ? el<er:el>er;
    }

    public void display(){
        Arrays.stream(element).forEach(element-> System.out.print(element+"\t"));
        System.out.println("");
        System.out.println("-===================================-");
    }



    public static void main(String[] args) {

        MergeOrder order = new MergeOrder(10, InsertOrder.Order.DESC);

        for (int i = 0; i < 10; i++) {
            order.insert((int)(Math.random()*1000));
        }
        order.display();

        order.doOrder();

        order.display();

    }






}
