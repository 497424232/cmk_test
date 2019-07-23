package cmk.spring.factory;

import cmk.spring.service.impl.UserServiceImpl;

/**
 * @auther changmk
 * @date 2019/7/23 下午3:41
 */
public class StaticBeanFactory {

    public static UserServiceImpl getUserService() {

        return new UserServiceImpl();
    }
}
