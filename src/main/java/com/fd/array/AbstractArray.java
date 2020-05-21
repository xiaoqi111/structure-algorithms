package com.fd.array;

import lombok.Data;

import java.util.Arrays;

@Data
public abstract class AbstractArray implements IArray {

    private int count;

    private Object[] elementData ;

    private int length;

    public AbstractArray(int length) {
        elementData = new Object[length];
        this.length = length;
    }

    @Override
    public boolean isEmpty() {
        return this.count == 0;
    }

    @Override
    public int size() {
        return this.count;
    }

    @Override
    public boolean exits(Object obj) {
        boolean exits = Arrays.stream(elementData).anyMatch(element -> element == obj);
        if (!exits) {
            System.err.print("不存在元素 ： "+obj);
        }
        return exits;
    }

    /**
     * 获取第一次比较发现的元素的下标
     * @param obj
     * @return
     */
    protected int getFirstIndex(Object obj){
        int index = -1;
        for (int i = 0; i < elementData.length; i++) {
            if (elementData[i] == obj) index = i;
        }
        if (index == -1) throw new IllegalArgumentException(" no such element : "+obj);
        return index;
    }

    /**
     * 检查下标是否合法
     * @param index
     */
    protected void checkIndex(int index){
        if (index <0 || index>this.length-1) {
            throw new ArrayIndexOutOfBoundsException("current index "+ index);
        }
    }

    /**
     * 通过下标获取元素
     * @param index
     * @return
     */
    protected Object getElement(int index){
        checkIndex(index);
        return elementData[index];
    }

    /**
     * 替换对应 {@code index } 下标的元素
     * @param index
     * @param obj
     */
    @Override
    public void update(int index,Object obj) {
        checkIndex(index);
        elementData[index] = obj;
    }

    @Override
    public void insert(int index, Object obj) {
        moveBack(index);
        update(index,obj);
    }

    @Override
    public void insert(Object obj) {
        this.insert(count,obj);
    }

    /**
     * 从下标 {@code index } 开始向前移动一位
     * @param index
     * @return
     */
    protected boolean moveForward(int index){
        boolean flag = false;
        checkIndex(index);
        if (index == 0) return flag;

        Object[] temp = this.elementData;

        for (int i = index; i < this.length; i++) {
            elementData[i-1] = elementData[i];
        }
        count--;
        return !flag;
    }

    /**
     * 从下标 {@code index } 开始向后移动一位
     * @param index
     * @return
     */
    protected void moveBack(int index){
        checkIndex(index);
        if (count == this.length) throw new IndexOutOfBoundsException("数组已满");

        Object[] temp = this.elementData;

        for (int i = elementData.length - 2; i >= index; i--) {
            elementData[i+1] =  elementData[i];
        }
        count++;
    }

    @Override
    public void display() {
        Arrays.stream(elementData).forEach(element-> System.out.println("元素"+element));
    }
}
