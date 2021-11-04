/**
 * @author CJYong
 * @create 2021-06-29 12:48
 */

interface ClothFactory{
    //接口中的抽象方法
    void produceCloth();
}

//代理类

class ProxyClothFactory implements ClothFactory{

    private ClothFactory factory; // 用被代理类进行实例化

    public ProxyClothFactory(ClothFactory factor){
        this.factory = factor;
    }

    @Override
    public void produceCloth() {
        System.out.println("代理工厂做一些准备工作");

        factory.produceCloth();

        System.out.println("代理工厂做一些后续的收尾工作");
    }
}

//被代类
class NikeClothFactory implements ClothFactory{

    @Override
    public void produceCloth() {
        System.out.println("Nike工厂生产一批运动服");
    }
}

public class StaticProxyTest {
    public static void main(String[] args) {
        //创建被代类的对象
        NikeClothFactory nike = new NikeClothFactory();
        //创建代理类对象
        ProxyClothFactory proxyClothFactor = new ProxyClothFactory(nike);

        proxyClothFactor.produceCloth();
    }
}
