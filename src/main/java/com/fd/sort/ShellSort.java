package com.fd.sort;

import java.util.Arrays;

/**
 * 希尔排序基于插入排序，使用了一种特殊的插入比较间隔
 *
 *  插入间隔： h = 3*h + 1
 *  1. 保证间隔为 h 的数据序列有序
 *  2. 最后间隔为 1 进行数据排序
 *
 */
public class ShellSort {

    public static final InsertSort.Order DEFAULT_ORDER = InsertSort.Order.DESC;

    private int[] element;
    private int count;

    private InsertSort.Order order;

    public ShellSort(int maxSize) {
        this(maxSize,DEFAULT_ORDER);
    }

    public ShellSort(int maxSize , InsertSort.Order order) {
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
        final InsertSort.Order toOrder = this.order;
        if (toOrder == null ) throw new RuntimeException(" sort is full");

        int h = 1;
        while (h < length/3){   // 初始化最大的间隔
            h = 3*h+1;
        }

        int inner,outer;
        int temp;

        while (h>0){

            for (outer = 0;outer<h;outer++) {
                temp = element[outer];
                inner = outer;

                while (inner<length && temp > element[inner+h]){

                    element[inner] = element[inner+h];
                    element[inner+=h] = temp;
                }





            }




            h = (h-1)/3;
        }









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

        ShellSort order = new ShellSort(10, InsertSort.Order.DESC);

        for (int i = 0; i < 10; i++) {
            order.insert((int)(Math.random()*1000));
        }
        order.display();

        order.doOrder();

        order.display();

    }

}
