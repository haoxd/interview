package com.bread.coalquality.mvc.controller.philosopher.dining;

/**
 * @Description: 哲学家
 * @Author: haoxd
 * @Version: 1.0
 */
public class Philosopher extends Thread {

    private Chopsticks left;
    private Chopsticks rigtht;
    private Integer index;

    public Philosopher(String name,Integer index,Chopsticks left,Chopsticks right){
        super.setName(name);
        this.index=index;
        this.left=left;
        this.rigtht=right;
    }


    @Override
    public void run() {
        boolean flag = index/2 ==0;

        if(flag){

            synchronized (left){
                synchronized (rigtht){
                    System.out.println(super.getName()+"吃完了");
                }
            }

        }else{

            synchronized (rigtht){
                synchronized (left){
                    System.out.println(super.getName()+"吃完了");
                }
            }
        }
    }
}
