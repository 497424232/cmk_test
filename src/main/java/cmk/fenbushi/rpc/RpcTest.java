package cmk.fenbushi.rpc;

import cmk.fenbushi.rpc.service.EchoService;
import cmk.fenbushi.rpc.service.EchoServiceImpl;
import cmk.fenbushi.rpc.service.RpcExporter;
import cmk.fenbushi.rpc.service.RpcImporter;

import java.net.InetSocketAddress;

/**
 * @auther changmk
 * @date 2019/7/7 下午2:30
 */
public class RpcTest {
    public static void main(String[] args) {
        new Thread(new Runnable() {
            public void run() {
                try {
                    RpcExporter.exporter("localhost", 8080);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();

        RpcImporter<EchoService> importer = new RpcImporter<EchoService>();
        EchoService echo = importer.importer(EchoServiceImpl.class, new InetSocketAddress("localhost", 8080));
        System.out.println(echo.echo("Are you ok ?"));
    }
}
