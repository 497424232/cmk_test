package cmk.spring.factory;

import cmk.spring.service.UserService;
import cmk.spring.service.impl.UserServiceImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 动态代理工厂获取service对象
 * @auther changmk
 * @date 2019/7/23 下午11:13
 */
public class ServiceBeanFactory {


    public static UserService getProxyInstance() {
        final UserService userService = new UserServiceImpl();

        UserService proxyUserService = (UserService) Proxy.newProxyInstance(
                userService.getClass().getClassLoader(),
                userService.getClass().getInterfaces(),
                new InvocationHandler() {
                    /**
                     *
                     * @param proxy
                     * @param method
                     * @param args
                     * @return
                     * @throws Throwable
                     */
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        Object reValue = null;
                        try {
                            //开启事务
//                            TransactionManager.begin();
                            //执行操作
                            reValue = method.invoke(userService, args);
                            //提交事务
//                            TransactionManager.commit();

                        } catch (Exception ex) {
                            //回滚事务

                            //处理异常
                        } finally {
                            //关闭连接，如果有需要
                        }
                        return reValue;
                    }
                });

        return proxyUserService;
    }

}
