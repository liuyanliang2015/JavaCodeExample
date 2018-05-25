package com.test.thread.countDownLatch;

import java.util.ArrayList;
import java.util.List;

public class SignalThread {
	private volatile static List<String> list = new ArrayList<String>();
    public void add() {
        list.add("hello");
    }
    public int size() {
        return list.size();
    }
    public static void main(String[] args) {
        final SignalThread st = new SignalThread();
        //全局自定义对象锁
        final Object lock = new Object();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    synchronized (lock) {
                        for (int i = 0; i < 10; i++) {
                            st.add();
                            System.out.println(Thread.currentThread().getName()+ "添加了一个元素......");
                            Thread.sleep(500);
                            if(st.size() == 5){
                                System.out.println("发送通知");
                                lock.notify();
                                //唤醒线程，不释放锁。
                                //t2不会马上收到通知，当线程执行完成才释放锁。t2才能拿到锁
                            }
                             
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
                synchronized (lock) {
                    if(st.size() != 5){
                        try {
                            lock.wait();//释放锁
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
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
