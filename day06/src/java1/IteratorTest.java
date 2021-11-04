package java1;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * @author CJYong
 * @create 2021-06-19 12:44
 */

/*
集合元素遍历操作，使用Iterator接口  (迭代器)

内部方法：  hasNext() 和 next()
 */
public class IteratorTest {
    @Test
    public void test1() {
        Collection co = new ArrayList();
        co.add(123);
        co.add(456);
        co.add(789);
        co.add("lisi");
        co.add("wangwu");
        System.out.println(co);

        Iterator iterator = co.iterator();

//        //方式一
//        System.out.println(iterator.next());
//        System.out.println(iterator.next());
//        System.out.println(iterator.next());
//        System.out.println(iterator.next());
//        System.out.println(iterator.next());
//
//        //方式二：不推荐
//        for (int i = 0; i < co.size(); i++) {
//            System.out.println(iterator.next());
//
//        }
          //方式三： 推荐
          while (iterator.hasNext()){
              System.out.println(iterator.next());
          }


    }
}
