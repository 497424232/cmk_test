package cmk.fenbushi.rpc.service;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Method;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * @auther changmk
 * @date 2019/7/7 下午1:51
 */
public class RpcExporter {

    static Executor executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

    public static void exporter(String hostname, int port) throws Exception {
        ServerSocket serverSocket = new ServerSocket();
        serverSocket.bind(new InetSocketAddress(hostname, port));
        try {
            while (true) {
                executor.execute(new ExportTask(serverSocket.accept()));
            }
        } finally {
            serverSocket.close();
        }
    }

    private static class ExportTask implements Runnable {
        Socket client = null;
        public ExportTask(Socket client) {
            this.client = client;
        }

        public void run () {
            ObjectInputStream input = null;
            ObjectOutputStream output = null;

            try {
                input = new ObjectInputStream(client.getInputStream());
                String interfaceName = input.readUTF();
                Class<?> service = Class.forName(interfaceName);
                String methodName = input.readUTF();
                Class<?>[] parameterTypes = (Class<?>[])input.readObject();
                Object arguments = (Object[])input.readObject();
                Method method = service.getMethod(methodName, parameterTypes);
                //todo 解析方法出错
                Object result = method.invoke(service.newInstance(), arguments);
                output = new ObjectOutputStream(client.getOutputStream());
                output.writeObject(result);

            } catch(Exception e) {
                e.printStackTrace();
            } finally {
                if (output != null) {
                    try {
                        output.close();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
                if (input != null) {
                    try{
                        input.close();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
                if (client != null) {
                    try{
                        client.close();
                    } catch(IOException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        }
    }
}
