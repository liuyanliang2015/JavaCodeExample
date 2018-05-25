package com.test.thread.queue;

import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicInteger;


/**
 * 使用多线程模拟序列queue
 *
 */
public class MyQueue {
	//1需要一个装元素的集合
    private final LinkedList<Object> list = new LinkedList<Object>();
    //2需要一个计数器，统计元素的个数
    private AtomicInteger count = new AtomicInteger(0);
    //3需要指定上限和下限
    private final int minsize = 0;
    private final int maxSize;
 
    //4构造方法，初始化容器的上限
    public MyQueue(int size){
        this.maxSize = size;
    }
 
    //=>使用wait和notify集合synchronized实现put和take方法
    //5 初始化一个对象，用于加锁
    private final Object lock = new Object();
    //put
    public void put(Object obj){
        synchronized (lock) {
            while(count.get() == this.maxSize){
                try {
                    System.out.println("容器已满,请等待......");
                    lock.wait();
 
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            //加入元素
            list.add(obj);
            //计数器累加
            count.incrementAndGet();
            System.out.println("新加入的元素："+obj);
            //唤醒其他等待线程(如果有别的线程take的时候，没有元素，正在阻塞，通知对方别等待了)
            lock.notify();
 
        }
 
    }
 
    //take
    public Object take(){
        synchronized (lock) {
            while(count.get() == this.minsize){
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
 
            }
            //移除元素
            Object result = list.removeFirst();
            System.out.println("移除元素："+result);
            //计数器递减
            count.decrementAndGet();
            //唤醒其他等待线程(如果别的线程在put的时候，如果容器已经满了，就会阻塞，通知其他线程别等待了，可以put了)
            lock.notify();
            return result;
        }
    }
 
    public int getSize(){
        return this.count.get();
    }
 
    public static void main(String[] args) {
        final MyQueue mq = new MyQueue(5);
        mq.put("a");
        mq.put("b");
        mq.put("c");
        mq.put("d");
        mq.put("e");
        System.out.println("当前容器长度:"+mq.getSize());
 
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                mq.put("f");
                mq.put("g");
            }
        },"t1");
 
        t1.start();
 
 
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                Object obj1 = mq.take();
                System.out.println("take : "+ obj1);
                Object obj2 = mq.take();
                System.out.println("take : "+ obj2);
            }
        },"t2");
 
        t2.start();
    }
}
