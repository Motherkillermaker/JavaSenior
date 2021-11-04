package java1;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @author CJYong
 * @create 2021-06-19 12:11
 */

/*
collection 接口中声明的方法测试

//  结论：
        向collection接口的实现类的对象中添加数据obj时，要求obj所在类要重写equals()方法
 */
public class CollectTest1 {

    @Test
    public void test1(){
        Collection co = new ArrayList();
        co.add(123);
        co.add(456);
        co.add(789);
        co.add("lisi");
        co.add("wangwu");
        System.out.println(co);

        //contains()
        boolean b = co.contains(456);
        System.out.println(b);

        //containsAll
        //remove
        //removeAll
        //retainAll       求取交集
        //equals

        //hashCode()
        //toArray()
        //asList()
        //iterator()   返回Iterator接口的实例，用于遍历集合元素
    }


}
