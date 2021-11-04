package java1;

import org.junit.Test;

/**
 * @author CJYong
 * @create 2021-06-10 19:53
 */
public class StringTest {
    /*
    1.
    string 声明为final，无法继承。
    2.
    实现了serializable接口：表示字符串是支持序列化的（可排序）
    实现了comparable接口，表示string可比较大小
    3.
    string内部定义了final char [] value 用于存储字符数据
    4.
    string 代表了不可变的字符序列。 简称： 不可变性
    体现1 ： 当对字符串重写赋值时，需重写指定内存区域赋值，不能使用原有的value进行赋值
    体现2 :  当对现有的字符串进行连接操作时，也需要重新指定内存区域赋值，不能使用原有的value赋值
    体现3 ： 当调用string的replace（）方法修改指定的字符或字符串时，也需要重新指定内存区域赋值，不能使用原有的value赋值
    5.
    通过字面量的方式（区别去new的方式）给一个字符串赋值，
    此时的字符串值声明在字符串常量池中。
    6.
    字符串常量池中是不会存储相同内容的字符串的
     */

    @Test
    public void test1(){
        String s1 = "abc";
        String s2 = "abc";
//        s1 = "hello";

        System.out.println( s1 == s2);

        System.out.println("*************************");

        System.out.println(s1);
        System.out.println(s2);

        String s3 = "abc";

        s3 += "def";
        System.out.println(s3);
        System.out.println(s2);
    }

    /*
    string的实例化方式
    方式一： 通过字面量定义的方式
    方式二： 通过new + 构造器的方式
    */
    @Test
    public void test2(){
        // S1 和 S2  声明在方法区的字符串常量池当中
        String s1 = "javaEE";
        String s2 = "javaEE";
        //通过new + 构造器的方式: 此时s3和s4保存的地址值，是数据在堆空间中开辟空间后对应的地址值
        String s3 = new String("javaEE");
        String s4 = new String("javaEE");

        System.out.println( s1 == s2);
        System.out.println( s1 == s3);
        System.out.println( s1 == s4);
        System.out.println( s3 == s4);

    }

}
