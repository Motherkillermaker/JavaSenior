package duoxiancheng.package1;

/**
 * @author CJYong
 * @create 2021-06-07 16:40
 */
/*
实现多线程的方式二：
    实现Runnable 接口的方式
    1. 创建了实现了Runnable接口的类
    2. 实现类去实现Runnable中的抽象方法：run()
    3. 创建实现类的对象
    4. 将此对象作为参数传递到Thread类的构造器中，创建thread类的对象
    5. 通过thread类的对象调用start()

    比较两种创建线程的方式
    开发中有优先使用runnable接口的方式
    1. 实现的方式没有类的单继承性的局限性
    2. 实现的方式更适合来处理多个线程共享数据的情况

    联系：
    两种方式都重写了run()方法，将线程要执行的逻辑声明在run()中


 */

    // 1. 创建了实现了Runnable接口的类
class MThread implements Runnable{
    @Override
    // 2. 实现类去实现Runnable中的抽象方法：run()
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 ==0){
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
        }
    }
}

public class ThreadTest1 {
    public static void main(String[] args) {
        // 3. 创建实现类的对象
        MThread mThread = new MThread();
        // 4. 将此对象作为参数传递到Thread类的构造器中，创建thread类的对象  (多态性 )
        Thread t1 = new Thread(mThread);
        t1.setName("线程1");
        // 5. 通过thread类的对象调用start()
        //    调用了Runnable 类型的target的run方法
        t1.start();

        // 再启动一个线程，遍历100以内的偶数
        Thread t2 = new Thread(mThread);
        t2.setName("线程2");
        t2.start();
    }
}
