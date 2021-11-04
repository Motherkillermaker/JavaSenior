package exer1;

import org.junit.Test;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * @author CJYong
 * @create 2021-06-20 15:58
 */
public class MainTest {

    @Test
    public void test1() {
        TreeSet set = new TreeSet();
        Employee e1 = new Employee("zhangsan", 22, new MyDate(2003, 8, 20));
        Employee e2 = new Employee("lisi", 18, new MyDate(1998, 6, 15));
        Employee e3 = new Employee("wangwu", 32, new MyDate(1989, 11, 8));
        Employee e4 = new Employee("zhaoliu", 44, new MyDate(2010, 12, 29));
        Employee e5 = new Employee("huangqi", 28, new MyDate(2018, 3, 11));

        set.add(e1);
        set.add(e2);
        set.add(e3);
        set.add(e4);
        set.add(e5);

        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    @Test
    public void test2() {

        TreeSet set = new TreeSet(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof Employee && o2 instanceof Employee){
                    Employee e1 = (Employee) o1;
                    Employee e2 = (Employee) o2;

                    MyDate b1 = e1.getBirthday();
                    MyDate b2 = e2.getBirthday();
                    //比较年
                    int year = b1.getYear() - b2.getYear();
                    if (year != 0){
                        return year;
                    }
                    //比较月
                    int month = b1.getMonth() - b2.getMonth();
                    if (month != 0){
                        return month;
                    }
                    //比较日
                    return b1.getDay() - b2.getDay();


                }
//                return 0;
                throw new RuntimeException("输入的数据类型不匹配 ！");
            }
        });

        Employee e1 = new Employee("zhangsan", 22, new MyDate(2003, 8, 20));
        Employee e2 = new Employee("lisi", 18, new MyDate(1998, 6, 15));
        Employee e3 = new Employee("wangwu", 32, new MyDate(1989, 11, 8));
        Employee e4 = new Employee("zhaoliu", 44, new MyDate(2010, 12, 29));
        Employee e5 = new Employee("huangqi", 28, new MyDate(2018, 3, 11));

        set.add(e1);
        set.add(e2);
        set.add(e3);
        set.add(e4);
        set.add(e5);

        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    }

