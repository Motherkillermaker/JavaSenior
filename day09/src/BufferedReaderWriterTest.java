import jdk.nashorn.internal.ir.WhileNode;
import org.junit.Test;

import java.io.*;

/**
 * @author CJYong
 * @create 2021-06-24 16:32
 */
public class BufferedReaderWriterTest {
    @Test
    public void test1()  {
        BufferedReader br = null;
        BufferedWriter bw = null;
        try {
            //造文件
            br = new BufferedReader(new FileReader(new File("D:\\桌面\\Jupyter快捷键.txt")));
            bw = new BufferedWriter(new FileWriter(new File("D:\\桌面\\Jupyter快捷键1.txt")));

            //读写操作
            char[] cbuf = new char[1024];
            int len;
            while((len = br.read(cbuf)) != -1){
                bw.write(cbuf,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //关闭资源
            if (bw != null){
                try {
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (br != null){
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }

}
