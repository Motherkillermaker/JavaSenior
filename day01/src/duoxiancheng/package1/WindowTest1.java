package duoxiancheng.package1;

/**
 * @author CJYong
 * @create 2021-06-07 17:03
 */
/*
例子：
    创建三个窗口卖票，总票数为100张 （使用实现runnable接口的方式）

    存在线程安全问题。可能有人同时买到同一张票（待解决）
 */

    //接口实现类
class Window1 implements Runnable{

    private int ticket = 100;  //  三个线程共用一个ticket

    @Override
    public void run() {
        while (true){
            if (ticket > 0){
                System.out.println(Thread.currentThread().getName() + ":卖票，票号为：" + ticket);
                ticket--;
            }else {
                break;
            }
        }
    }
}


public class WindowTest1 {
    public static void main(String[] args) {
        // 只创建了一个对象
        Window1 w = new Window1();

        // 将接口实现类的对象作为形参，创建thread对象
        Thread t1 = new Thread(w);
        Thread t2 = new Thread(w);
        Thread t3 = new Thread(w);

        t1.setName("线程一");
        t2.setName("线程二");
        t3.setName("线程三");

        t1.start();
        t2.start();
        t3.start();
    }
}
