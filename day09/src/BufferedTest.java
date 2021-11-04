import org.junit.Test;

import java.io.*;

/**
 * @author CJYong
 * @create 2021-06-24 15:59
 */

/*
缓冲流的使用

作用： 提高流的读取、写入速度

 */
public class BufferedTest {
    @Test
    //实现非文本文件的复制
        //1.造文件
    public void test()  {
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            File srcFile = new File("666.png");
            File desFile = new File("6662.png");
            //2..造流
            //2.造结点流
            FileInputStream fis = new FileInputStream(srcFile);
            FileOutputStream fos = new FileOutputStream(desFile);
            //2.造缓冲流
            bis = new BufferedInputStream(fis);
            bos = new BufferedOutputStream(fos);

            //3.复制的细节： 读取和写入的过程
            byte[] buffer = new byte[10];
            int len;
            while ((len = bis.read(buffer)) != -1){
                bos.write(buffer,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.资源关闭 (先关闭外层的流、再关闭内层的流） 类似穿衣服
            try {
                if (bos != null)
                    bos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                if (bis != null)
                    bis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            //说明：关闭外层流的同时，内层流也会自动关闭。内层流的关闭我们可以省略
//        fos.close();
//        fis.close();
        }


    }


}
