package com.fd.solution;

public class Solution {

    public static void main(String[] args) {

//        System.out.println(Integer.MAX_VALUE +1);
        // byte -128 ~ 127
        byte b = 127;

        System.out.println(((byte) (b + 1)));


    }

    public static int myAtoi(String str) {
        int result = 0;
        int length;
        if(str == null || (length = str.length()) ==0){
            return result;
        }

        char[] chars = str.toCharArray();

        char first = chars[0];

        if ((first<'0' || first >'9') && first != '+' && first != '-')return result;


        int sum = 0;
        switch(first){
            case '+':
                for(int i=1;i<length;i++)
                {
                    int num = chars[i]-48;
                    if(num<0 || num>9) break;
                    sum*=10;
                    sum+=num;
                    if ((sum & Integer.MAX_VALUE) != sum) break ;
                    result = sum;
                }
                break;
            case '-':
                for(int i=1;i<length;i++)
                {
                    if (sum+1 > (2^31)) break;
                    int num = chars[i]-48;
                    if(num<0 || num>9) break;
                    sum*=10;
                    sum+=num;
                    result = 0-sum;
                }
                break;
            default:
                for(int i=0;i<length;i++)
                {
                    if (sum > (2^31-1)) break;
                    int num = chars[i]-48;
                    if(num<0 || num>9) break;
                    sum*=10;
                    sum+=num;
                    result = sum;
                }
        }

        return result;
    }
}
