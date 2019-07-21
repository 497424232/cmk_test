package cmk.io;

import jdk.jfr.events.SocketReadEvent;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @auther changmk
 * @date 2019/7/20 上午10:33
 */
public class ThreadPoolClient {

    public static void main(String[] args) {
        ServerSocket serverSocket = null;

        ExecutorService executorService = Executors.newFixedThreadPool(60);

        try {
            serverSocket = new ServerSocket(8000);

            System.out.println("启动8000端口服务");

            while (true) {
                Socket socket = serverSocket.accept();
                //使用线程池中的线程执行每个任务
//                executorService.execute();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
