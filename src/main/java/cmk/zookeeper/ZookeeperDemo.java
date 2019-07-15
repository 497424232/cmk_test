package cmk.zookeeper;

import java.util.concurrent.CountDownLatch;
import org.apache.*;

/**
 * @auther changmk
 * @date 2019/7/11 下午8:23
 */
public class ZookeeperDemo {
    private static final String CONNECTION_STRING = "127.0.0.1:2181";
    private static final int SESSION_TIMEOUT = 5000;

    private static CountDownLatch latch = new CountDownLatch(1);

    public static void main(String[] args) {
        //连接Zookeeper
//        ZooKeeper zk
    }
}
