package com.fd.recursion;

/**
 *  汉诺塔问题
 */
public class Hanoi {

    static int count;

    public static void main(String[] args) {

        int nDisk = 64;

        doTowers(nDisk,"a","b","c");

        System.out.println("count = " + count);

    }

    /**
     * 移动一棵子树
     * 子树： {@code from} 中盘子个数 {@code nDisk-1} ，除最底层以外的盘子
     * @param nDisk
     * @param from      待移动的子树所处的柱子
     * @param inner     中间的柱子
     * @param to        目的地的柱子
     */
    public static void doTowers(int nDisk, String from ,String inner ,String to){

        if (nDisk == 1){
            System.out.println("nDisk = "+nDisk+"\t"+"from = "+from+"\t"+"to = "+to);
            count++;
            return;
        }

        doTowers(nDisk-1,from,to,inner);      // 把子树移动从开始的 a --> b

        print(nDisk,from,to);                       // 把最底层的盘子移动到目的地

        doTowers(nDisk-1,inner,from,to);      // 再把子树移动  b --> c

    }

    public static void print(int nDisk, String from ,String to){
        System.out.println(String.format("nDisk = %s\tfrom = %s\tto = %s",nDisk,from,to));
        count++;
    }

}
