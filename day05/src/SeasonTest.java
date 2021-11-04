/**
 * @author CJYong
 * @create 2021-06-17 14:43
 */
/*
1. 枚举类的使用
当一个类的对象为有限个、确定的。我们称此类为枚举类

当需要定义一组常量时，强烈使用枚举类

如果枚举类中只有一个对象，则可以作为一种单例模式的实现方式

2. 如何定义枚举类

方式一： 5.0 之前   自定义枚举类

方式一： 5.0        可以使用enum关键字定义枚举类

3. enum中的常用方法
values(): 返回枚举类型的对象数组
valueOf( String str ): 把一个字符串转为对应的枚举类对象
toString(): 返回当前枚举类对象常量的名称

4. 使用enum关键字定义的枚举类实现接口的情况
    情况1：实现接口，在enmu类中实现抽象方法
    情况2：让枚举类的对象分别实现接口中的抽样方法



 */
public class SeasonTest {
    public static void main(String[] args) {
        Season name1 = Season.AUTUMN;
        System.out.println(name1.toString());
        System.out.println("********************");

        //values(): 返回枚举类型的对象数组
        Season1[] values = Season1.values();
        for (int i = 0; i < values.length; i++) {
            System.out.println(values[i]);
        }
        System.out.println("**************************");

        // valueOf( String str ): 根据name返回枚举类中相应的对象
        Season1 winter = Season1.valueOf("WINTER");
        System.out.println(winter);


    }

}

//  自定义枚举类
class Season{
    //1.声明Season对象的属性
    private final String seasonName;
    private final String seasonDesc;

    //2.私有化类的构造器,并给对象属性赋值
    private Season(String seasonName,String seasonDesc){
        this.seasonName = seasonName;
        this.seasonDesc = seasonDesc;
    }

    //3.提供当前枚举类的多个对象: 声明为 public static final 的
    public static final Season SPRING = new Season("春天","春暖花开");
    public static final Season SUMMER = new Season("夏天","夏日炎炎");
    public static final Season AUTUMN = new Season("秋天","秋高气爽");
    public static final Season WINTER = new Season("冬天","冰天雪地");

    //其他诉求： 获取枚举类对象的属性 \ 提供toString()  方法

    public String getSeasonName() {
        return seasonName;
    }

    public String getSeasonDesc() {
        return seasonDesc;
    }

    @Override
    public String toString() {
        return "Season{" +
                "seasonName='" + seasonName + '\'' +
                ", seasonDesc='" + seasonDesc + '\'' +
                '}';
    }
}
