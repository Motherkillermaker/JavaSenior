import org.junit.Test;

import java.io.*;

/**
 * @author CJYong
 * @create 2021-06-24 13:18
 */
public class FileReaderWriterTest {

    @Test
    public void test1() {
        FileReader fr = null;
        try {
            //1.实例化file类的对象，指明要操作的文件
            File file = new File("hello.txt"); //当前Model的相对路径
            System.out.println(file.getAbsolutePath());
            //2.提供具体的流  （提供管道）
            fr = new FileReader(file);

            //3.数据的读入过程
            //返回读入的一个字符，如果达到文件末尾则返回-1
            //方式一：
//        int data = fr.read();
//        while (data != -1){
//            System.out.print((char) data);
//            data = fr.read();
//        }
            //方式二：语法上的修改
            int data;
            while ((data = fr.read()) != -1) {
                System.out.print((char) data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                //4.流的关闭
                if (fr != null)
                    fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
    //对read（）操作升级： 使用read（）重载的方法
    @Test
    public void test2() {
        FileReader fr = null;
        try {
            //1.file类的实例化
            File file = new File("hello.txt");

            //2.fileread流的实例化
            fr = new FileReader(file);

            //3.读入的操作
            //read(char[] cbuf): 返回每次读入cbuf数组中的字符个数。达到文件末尾则返回-1
            char[] cbuf = new char[5];
            int len;
            while ((len = fr.read(cbuf)) != -1) {
                //读进去几个就遍历几个字符
                for (int i = 0; i < len; i++) {
                    System.out.print(cbuf[i]);
                }
            }
            //方式二：
//            String str = new String(cbuf,0,len);
//            System.out.println(str);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.资源的关闭
            if (fr != null)
                try {
                    fr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }

    }

    @Test
    /*
    数据的写出，从内存中写出数据到硬盘里
     */
    public void test3() throws IOException {
        //1.file类的实例化，指明写出到的文件
        File file = new File("hello1.txt");

        //2.提供fileWriter的对象，用于数据的写出(false为覆盖， true为添加)
        FileWriter fw = new FileWriter(file, false);

        //3.写出的具体操作
        fw.write("I have a dream !\n");
        fw.write("you have a dream !\n");

        //4.流资源的关闭
        fw.close();
    }

    @Test
    /*
    读取数据 + 写入数据
     */
    public void test4()  {
        FileReader fr = null;
        FileWriter fw = null;
        try {
            //1.file类的实例化，指明写出到的文件和读入的文件
            File srcFile = new File("hello.txt");
            File desFile = new File("hello2.txt");

            //2.创建输入和输出流的对象
            fr = new FileReader(srcFile);
            fw = new FileWriter(desFile);

            //3.数据读入和写出的具体操作
            char[] cbuf = new char[5];
            int len;   //记录每次读入到cbuf数组中的字符的个数
            while ((len = fr.read(cbuf)) != -1){
                //每次写出len个字符
                fw.write(cbuf,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.流资源的关闭
            try {
                if (fw != null)
                    fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                if (fr != null)
                    fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

}

