package Java;

/**使用同步机制将单例模式中的懒汉式改写为线程安全的
 * @author CJYong
 * @create 2021-06-08 15:40
 */
public class BankTest {
}


// 复习  -  单例模式（懒汉式）
class Bank {

    private Bank() {

    }

    private static Bank Instance = null;

    public static Bank getInstance() { //  锁： Bank.class   静态的同步方法的锁是 当前类本身
        // 方式一 ：效率稍差
//        synchronized (Bank.class) {
//            if (Instance == null){
//
//                Instance = new Bank();
//            }
//            return Instance;
//        }

        // 方式二：效率更高 （ 面试写线程安全的懒汉式 或者 饿汉式 ）
        if (Instance == null) {

            synchronized (Bank.class) {
                if (Instance == null) {

                    Instance = new Bank();
                }

            }
        }
        return Instance;
    }
}

