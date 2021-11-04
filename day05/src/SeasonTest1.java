/**
 * @author CJYong
 * @create 2021-06-17 15:08
 */

/*
使用enum 关键字定义枚举类

说明 ： 定义的枚举类默认继承于 class java.lang.Enum 类
 */
public class SeasonTest1 {
    public static void main(String[] args) {
        Season1 name1 = Season1.AUTUMN;
        System.out.println(name1);

        System.out.println(Season1.class.getSuperclass());
    }

}

//  使用enum关键字来定义枚举类
enum Season1{
    //1.提供当前枚举类的对象，多个对象之间用 , 隔开，末尾用 ; 结束
    SUMMER("夏天","夏日炎炎"),
    AUTUMN("秋天","秋高气爽"),
    WINTER("冬天","冰天雪地"),
    SPRING("春天","春暖花开");

    //2.私有化类的构造器,并给对象属性赋值;
    private final String seasonName;
    private final String seasonDesc;


    private Season1(String seasonName,String seasonDesc){
        this.seasonName = seasonName;
        this.seasonDesc = seasonDesc;
    }

    //其他诉求： 获取枚举类对象的属性 \ 提供toString()  方法

    public String getSeasonName() {
        return seasonName;
    }

    public String getSeasonDesc() {
        return seasonDesc;
    }

//    @Override
//    public String toString() {
//        return "Season1{" +
//                "seasonName='" + seasonName + '\'' +
//                ", seasonDesc='" + seasonDesc + '\'' +
//                '}';
//    }
}

