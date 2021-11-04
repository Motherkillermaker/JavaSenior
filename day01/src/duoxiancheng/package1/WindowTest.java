package duoxiancheng.package1;

/**
 * @author CJYong
 * @create 2021-06-07 16:05
 */
/*
例子：
    创建三个窗口卖票，总票数为100张 （使用继承thread类的方式）

    存在线程安全问题。可能有人同时买到同一张票（待解决）
 */
public class WindowTest {
    public static void main(String[] args) {
        Window t1 = new Window();
        Window t2 = new Window();
        Window t3 = new Window();

        t1.setName("窗口一");
        t2.setName("窗口二");
        t3.setName("窗口三");

        t1.start();
        t2.start();
        t3.start();
    }
}


class Window extends Thread{

    private static int ticket = 100;

    @Override
    public void run() {
        while (true) {

            if (ticket > 0){
                System.out.println(getName() + ": 卖票，票号为：" + ticket );
                ticket --;
            }else {
                break;
                }
            }
        }
    }

