package java1;

import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * 实现TCP的网络编程
 * 例题2：客户端发送文件给服务端，服务端将文件保存在本地。
 *
 * @author shkstart
 * @create 2019 下午 3:53
 */
public class TCPTest2 {

    /*
    这里涉及到的异常，应该使用try-catch-finally处理
     */
    @Test
    public void client() throws IOException {
        //1.造socket
        Socket socket = new Socket(InetAddress.getByName("10.3.33.115"),9090);
        //2.获取输出流
        OutputStream os = socket.getOutputStream();
        //3.创建输入流，获取数据
        FileInputStream fis = new FileInputStream(new File("test_picture.png"));
        //4.写出的过程
        byte[] buffer = new byte[1024];
        int len;
        while((len = fis.read(buffer)) != -1){
            os.write(buffer,0,len);
        }
        //5.
        fis.close();
        os.close();
        socket.close();
    }

    /*
    这里涉及到的异常，应该使用try-catch-finally处理
     */
    @Test
    public void server() throws IOException {
        //1.创建ServerSocket
        ServerSocket ss = new ServerSocket(9090);
        //2.接收客户端的socket
        Socket socket = ss.accept();
        //3.读入数据，创建输入流
        InputStream is = socket.getInputStream();
        //4.创建读入数据的保存路径
        FileOutputStream fos = new FileOutputStream(new File("test_picture_1.png"));
        //5.读写的过程
        byte[] buffer = new byte[1024];
        int len;
        while((len = is.read(buffer)) != -1){
            fos.write(buffer,0,len);
        }
        //6.资源的关闭
        fos.close();
        is.close();
        socket.close();
        ss.close();

    }
}
