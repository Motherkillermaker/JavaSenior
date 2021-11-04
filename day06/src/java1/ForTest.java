package java1;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @author CJYong
 * @create 2021-06-19 13:18
 */
/*

foreach  方法

 */
public class ForTest {
    @Test
    public void test1() {
        Collection co = new ArrayList();
        co.add(123);
        co.add(456);
        co.add(789);
        co.add("lisi");
        co.add("wangwu");

        //for(集合中元素的类型 局部变量 ：集合对象)
        for(Object obj: co){
            System.out.println(obj);
        }

    }
}
