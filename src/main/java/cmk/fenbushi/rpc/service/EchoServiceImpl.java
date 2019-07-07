package cmk.fenbushi.rpc.service;

import org.apache.commons.lang3.StringUtils;

import java.lang.*;

/**
 * @auther changmk
 * @date 2019/7/7 下午1:48
 */
public class EchoServiceImpl implements EchoService {

    public String echo(String ping) {
        return StringUtils.isEmpty(ping) ? ping + "--> I am OK." : " I am not Ok";
    }
}
