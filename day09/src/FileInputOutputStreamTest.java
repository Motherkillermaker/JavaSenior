import org.junit.Test;

import java.io.*;
import java.util.Spliterator;

/**
 * @author CJYong
 * @create 2021-06-24 15:13
 */

/*

测试FileInputStream 和 FileOutStream的使用

1.对于文本文件（.txt, .java,.c,.cpp），使用字符流处理
2.对于非文本文件(.jpg,.mp3,.mp4,.avi,.doc,.ppt,....)，使用字节流处理
3.

 */
public class FileInputOutputStreamTest {
    @Test
    public void test1()  {
        FileInputStream fis = null;
        try {
            File file = new File("hello.txt");
            fis = new FileInputStream(file);

            byte[] buffer = new byte[5];
            int len;
            while ((len = fis.read(buffer)) != -1){
                String str  = new String(buffer,0,len);
                System.out.print(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null)
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
    }

    @Test
    /*
    实现对图片的复制
     */
    public void test2()  {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            File srcFile = new File("666.png");
            File desFile = new File("6661.png");

            fis = new FileInputStream(srcFile);
            fos = new FileOutputStream(desFile);

            byte[] buffer = new byte[5];
            int len;
            while ((len = fis.read(buffer)) != -1){
                fos.write(buffer,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fos != null);
            try {
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            if (fis != null)
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
    }

    //指定路径下文件的复制
    public void coyyFile(String scrPath,String desPath){
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            File srcFile = new File(scrPath);
            File desFile = new File(desPath);

            fis = new FileInputStream(srcFile);
            fos = new FileOutputStream(desFile);

            byte[] buffer = new byte[1024];
            int len;
            while ((len = fis.read(buffer)) != -1){
                fos.write(buffer,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fos != null);
            try {
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            if (fis != null)
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
    }

    @Test
    public void test3(){
        long start = System.currentTimeMillis();

        String scrPath = "D:\\桌面\\01-test.ts";
        String desPath = "D:\\桌面\\02-test.ts";

//        String scrPath = "hello.txt";
//        String desPath = "hello3.txt";

        coyyFile(scrPath,desPath);

        long end = System.currentTimeMillis();

        long time = end - start;
        System.out.println("复制操作的时间为：" + time); //500
    }

}
