package duoxiancheng.exer;

/**
 * @author CJYong
 * @create 2021-06-07 15:17
 */

/*
创建两个分线程
一个遍历100以内的偶数
另一个遍历100以内的奇数
 */
public class ThreadDemo  {
    public static void main(String[] args) {
//        MyThred1 m1 = new MyThred1();
//        MyThred2 m2 = new MyThred2();
//
//        m1.start();
//        m2.start();
        // 创建匿名子类方式
        new Thread(){
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    if (i % 2 == 0) {
                        System.out.println(Thread.currentThread().getName() + ":" + i);
                    }
                }
            }
        }.start();

        new Thread(){
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    if (i % 2 != 0) {
                        System.out.println(Thread.currentThread().getName() + ":" + i);
                    }
                }
            }
        }.start();

    }
}

class MyThred1 extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
        }
    }
}

class MyThred2 extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 != 0) {
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
        }
    }
}
