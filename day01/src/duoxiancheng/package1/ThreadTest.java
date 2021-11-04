package duoxiancheng.package1;

/**
 * @author CJYong
 * @create 2021-06-07 13:58
 */

/*
方式一：  继承于Thread类的子类
1. 创建一个继承于Thread 类的子类的对象
2. 重写Thread类的run( )   --  将此线程执行的操作声明在run() 中
3. 创建Thread类的子类的对象
4. 通过此对象调用start( )

举例： 遍历100以内的所有偶数    (1. 创建继承Thread类的子类 2. 重写run方法 3. 创建该子类的对象 4. 通过该对象调用start（）方法 )
 */

    //1. 创建一个继承于Thread 类的子类的对象
class MyThread extends Thread{
    @Override
    // 2. 重写Thread类的run( )   --  将此线程执行的操作声明在run() 中
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0){
                System.out.println(Thread.currentThread().getName() + ":" + i );
            }
        }
    }
}


public class ThreadTest {
    public static void main(String[] args) {
        //3. 创建Thread类的子类的对象
        MyThread t1 = new MyThread();

        //4. 通过此对象调用start( )
        // 作用1： 启动当前线程     作用2 ：调用当前线程的run()
        t1.start();

        // 注: 不能直接通过调用run()的方式启动线程
        //     不可以让已经start() 的线程去执行。会报异常，需新创建一个子类的对象重新调用start()方法
        MyThread t2 = new MyThread();
        t2.start();

        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0){
                System.out.println(Thread.currentThread().getName() + ":" + i + "*****main()*****");
            }
        }
    }
}
