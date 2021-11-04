package java1;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

/**
 * @author CJYong
 * @create 2021-06-18 10:17
 */
/*
一、集合框架概述

1.集合、数组都是对多个数据进行存储操作的结构，检查java容器
  说明：此时的存储、主要指的是内存层面的存储。不涉及到持久化的存储（.txt,.jap,.avi）

2.数组在存储多个数据方面的特点：
  > 一旦初始化后其长度便确定了，无法修改。且定义好后其元素类型也就确定了。
  > 数组中提供的方法非常有限，对于添加、删除、插入数据等操作，非常不便且效率不高
  > 获取数组中实际元素的个数的需求，数组没有现成的属性或方法可用
  > 数组存储数据的特点：有序、重复。对于无序、不可重复的需求无法满足

二、集合框架
1.collection接口：单列集合，用来存储一个一个的对象

1.1  list接口：有序、可重复的数据           “动态数组”
     ArrayList、LinkList、Vector

1.2  set接口： 存储无序的、不可重复的数据    高中讲的“集合”
     HashSet、LinkedHashSet、TreeSet

2.map接口：双列集合，用来存储一对一对的数据（key - value）   高中函数：y = f(x)
           HashMap、LinkedHashMap、TreeMap、Hashtable、Properties

三、collection中的API



 */
public class CollectionTest {
    @Test
    public void test1(){
        Collection coll = new ArrayList();
        //add(object e)
        coll.add("aa");
        coll.add("bb");
        coll.add("cc");
        coll.add(123);  //自动装箱
        coll.add(new Date());

        //size()
        System.out.println(coll.size());

        //addAll(); 将coll集合中的元素添加到当前集合
        Collection coll2 = new ArrayList();
        coll2.add(456);
        coll2.add("zhangsan");
        coll.addAll(coll2);
        System.out.println(coll.size());
        System.out.println(coll);

        //clear();清空集合元素
        coll.clear();

        //isEmpty(); 判断当前集合是否为空
        System.out.println(coll.isEmpty());

    }

}
