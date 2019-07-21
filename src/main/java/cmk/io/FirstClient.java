package cmk.io;


import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @auther changmk
 * @date 2019/7/20 上午10:14
 */
public class FirstClient {
    public static void main(String[] args) {

        try {

            ServerSocket serverSocket = new ServerSocket(8000);
            System.out.println("服务端接口为8000");

            while (true) {
                Socket socket = serverSocket.accept();

                InputStream inputStream = socket.getInputStream();

                byte[] buffer = new byte[1024];
                int len = 0;
                while ((len = inputStream.read()) > 0) {
                    System.out.println(new String(buffer, 0, len));
                }

                OutputStream outputStream = socket.getOutputStream();

                outputStream.write(buffer);

            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }
}
