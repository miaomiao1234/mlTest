package com.example.mlTest.thread.queue;

import org.springframework.boot.convert.DurationStyle;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author miaoliang
 * @since 4/28/22 10:42 PM
 */
public class QueueDemo extends Thread {

    public static void main(String[] args) throws InterruptedException {
        LinkedBlockingDeque<String> queue = new LinkedBlockingDeque<>(10);
        ProducerThread producerThread = new ProducerThread(queue);
        ProducerThread producerThread1 = new ProducerThread(queue);
        ConsumerThread consumerThread = new ConsumerThread(queue);
        producerThread.start();
        producerThread1.start();
        consumerThread.start();
        // 执行10s
        Thread.sleep(10 * 1000);
        producerThread.stopThread();
        producerThread1.stopThread();
    }

}
class ProducerThread extends Thread {

    private BlockingQueue queue;

    private volatile Boolean flag = true;

    private static AtomicInteger count = new AtomicInteger();

    ProducerThread(BlockingQueue blockingQueue){
        this.queue = blockingQueue;
    }

    @Override
    public void run() {
        System.out.println("生产者线程启动。。。");
        try {
            while (flag) {
                String data = count.incrementAndGet() + "";
                // 添加队列
                boolean offer = queue.offer(data);
                if (offer) {
                    System.out.println("生产者添加队列:"+data+":成功");
                } else {
                    System.out.println("生产者添加队列:"+data+":失败");
                }
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println("生产者线程停止");
        }
    }

    public void stopThread() {
        this.flag = false;
    }
}

class ConsumerThread extends Thread {

    private BlockingQueue queue;

    private volatile Boolean flag = true;

    ConsumerThread(BlockingQueue blockingQueue) {
        this.queue = blockingQueue;
    }

    @Override
    public void run() {
        System.out.println("消费者线程启动");
        try {
            while (flag) {
                // 获取完后，队列会删除
                String data = (String) queue.poll(2, TimeUnit.SECONDS);
                if (null != data) {
                    System.out.println("消费者获取data："+data+" 成功");
                    System.out.println(data);
                } else {
                    System.out.println("消费者获取data："+data+" 失败");
                    this.flag = false;
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println("消费者线程停止");
        }
    }

}
