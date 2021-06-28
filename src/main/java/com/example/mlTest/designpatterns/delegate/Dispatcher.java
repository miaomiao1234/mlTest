package com.example.mlTest.designpatterns.delegate;

/**
 * @author miaoliang
 * @since 6/25/21 10:00 AM
 */
public class Dispatcher implements MLDelegate {

    private MLDelegate delegate;

    public Dispatcher(MLDelegate delegate){
        this.delegate = delegate;
    }

    // 分配者虽然也有 执行方法，但是工作职责是分配任务
    @Override
    public void doing() {
        System.out.println("开始分配任务");
        delegate.doing();
    }
}

