package com.fd.order;

import java.util.Arrays;

/**
 * 插入排序:
 *
 *  保证左边的序列是有序的，依次把右边的数据拿过来进行比较并移位
 *
 */
public class InsertOrder {

    public static final Order DEFAULT_ORDER = Order.DESC;

    private int[] element;
    private int count;

    private Order order;

    public InsertOrder(int maxSize) {
       this(maxSize,DEFAULT_ORDER);
    }

    public InsertOrder(int maxSize , Order order) {
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

        final Order toOrder = this.order;
        if (toOrder == null ) throw new RuntimeException(" order is full");

        int temp,in;
        switch (toOrder){
            case ASC:
                for (int out = 1; out < length; out++) {
                    in = out;
                    temp = element[out];
                    while (in > 0 && temp<element[in-1]){
                        element[in] = element[in-1];
                        in--;
                    }
                    insert(in,temp);
                }
                break;
            case DESC:
                for (int out = 1; out < length; out++) {
                    in = out;
                    temp = element[out];
                    while (in > 0 && temp>element[in-1]){
                        element[in] = element[in-1];
                        in--;
                    }
                    insert(in,temp);
                }
        }
    }


    public void setOrder(Order order) {
        this.order = order;
    }

    private void swap(int from , int to){
        int temp = element[from];
        element[from] = element[to];
        element[to] = temp;
    }

    private void insert(int index , int num){
       element[index] = num;
    }


    public void display(){
        Arrays.stream(element).forEach(element-> System.out.print(element+"\t"));
        System.out.println("");
        System.out.println("-===================================-");
    }

    enum Order{
        ASC,    // 升序
        DESC;   // 降序
    }


    public static void main(String[] args) {
        InsertOrder insertOrder = new InsertOrder(10, Order.ASC);

        for (int i = 0; i < 10; i++) {
            insertOrder.insert((int)(Math.random()*1000));
        }
        insertOrder.display();

        insertOrder.doOrder();

        insertOrder.display();
    }
}
