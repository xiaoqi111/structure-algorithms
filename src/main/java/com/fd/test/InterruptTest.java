package com.fd.test;

/**
 * java.lang.Thread#interrupt()
 *  1. 处于阻塞状态的线程被中断，会清空中断标志位并抛出异常
 *  2. 正常运行状态的线程中断会被设置中断标志
 */
public class InterruptTest {
    static int i = 0;
    public static void main(String[] args) throws InterruptedException {
        MyThread my1 = new MyThread("my1");
        MyThread my2 = new MyThread("my2");
        Thread thread1 = new Thread(my1,my1.getName());
        Thread thread2 = new Thread(my2,my2.getName());
        thread1.start();
        thread2.start();
        Thread.sleep(1000);
        thread1.interrupt();
        thread2.interrupt();
        Thread.sleep(10*1000);
    }

    static class MyThread implements Runnable{
        private String name ;
        public MyThread(String name) {
            this.name = name;
        }
        @Override
        public void run() {
            Thread myThread__ = Thread.currentThread();

            if (this.name.equals("my1")){
                while (!myThread__.isInterrupted()){    // 设置中断标志 myThread__.isInterrupted() = true
                    i++;
                }
            }else {
                try {
                    Thread.sleep(100000);
                } catch (InterruptedException e) {          // 中断标志清空 myThread__.isInterrupted() = false
                    System.out.println(name+"出现中断异常");
                }
            }
            String name = myThread__.getName();
            System.out.println(name+" stop i = " + i);
            System.out.println(name+" interrupt flag = " + myThread__.isInterrupted());
        }

        public String getName() {
            return name;
        }
    }
}
