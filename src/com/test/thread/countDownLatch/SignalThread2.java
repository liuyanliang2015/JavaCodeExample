package com.test.thread.countDownLatch;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public class SignalThread2 {
	private volatile static List<String> list = new ArrayList<String>();
    public void add() {
        list.add("hello");
    }
    public int size() {
        return list.size();
    }
    public static void main(String[] args) {
        final SignalThread2 st = new SignalThread2();
        //参数表示：必须发送几次通知，才会收到通信
        final CountDownLatch countDownLatch = new CountDownLatch(1);
         
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                        for (int i = 0; i < 10; i++) {
                            st.add();
                            System.out.println(Thread.currentThread().getName()+ "添加了一个元素......");
                            Thread.sleep(500);
                            if(st.size() == 5){
                                System.out.println("发送通知");
                                countDownLatch.countDown();
                                //countDownLatch.countDown();//可多次执行
                            }
                             
                        }
                     
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, "t1");
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                    if(st.size() != 5){
                        try {
                            countDownLatch.await();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                     
                System.out.println(Thread.currentThread().getName()+" 收到通知线程停止......");
                throw new RuntimeException();
            }
        }, "t2");
        //这里先启动线程t2
        //如果t1先执行，t1先拿到锁，不会释放锁。t2不会拿到锁，不会执行wait
        //当t1执行完毕，size=10，t2永远不会=5，永远阻塞在那里
        t2.start();
        t1.start();
         
         
    }
}
