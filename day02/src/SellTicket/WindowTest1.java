package SellTicket;

/**使用同步代码块解决实现Runnable接口的线程安全问题
 * @author CJYong
 * @create 2021-06-07 17:03
 */
/*
例子：
    创建三个窗口卖票，总票数为100张 （使用实现runnable接口的方式）

    存在线程安全问题。可能有人同时买到同一张票（待解决）

    1.卖票过程中出现了重票、错票 -- 出现线程安全问题
    2.出现原因：某个线程操作车票的过程中，尚未完成操作，其他线程参与进来也操作数据
    3.如何解决：当一个线程在操作票时，其他线程不能参与进来，直到该线程完成。
      即使该线程出现阻塞也不能被改变
    4.在Java中通过同步机制来解决线程安全问题

    方式一： 同步代码块

    synchronized(同步监视器){

    //  需要被同步的代码： 操作共享数据的代码      --   包住的代码不能多也不能少
               共享数据： 多个线程共同操作的变量。如ticket就是共享数据
             同步监视器：  俗称 ‘ 锁 ’。 任何一个类的对象都可以充当锁
                   要求：  多个线程必须要共同用一把锁

                   补充：  在实现runnable接口创建多线程的方式中，可以考虑使用this充当同步监视器
    }

    方式二： 同步方法
        如果操作共享数据的代码完整声明在一个方法中，我们不妨将此方法声明为同步的。


    5.同步代码块内为单线程，效率较低


 */

    //接口实现类
class Window1 implements Runnable {
    private int ticket = 200;  //  三个线程共用一个ticket
    Object obj = new Object();  //  同步监视器 （ 锁 ）

    @Override
    public void run() {
        while (true) {
            synchronized (obj) {
                if (ticket > 0) {

                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println(Thread.currentThread().getName() + ":卖票，票号为：" + ticket);
                    ticket--;
                } else {
                    break;
                }
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

            t1.setName("窗口一");
            t2.setName("窗口二");
            t3.setName("窗口三");

            t1.start();
            t2.start();
            t3.start();
        }
    }


