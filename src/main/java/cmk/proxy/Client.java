package cmk.proxy;

import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 *
 * 动态代理类测试
 * @auther changmk
 * @date 2019/7/23 下午9:48
 */
public class Client {

    public static void main(String[] args) {

        final Actor actor = new Actor();

        IActor proxyInstance = (IActor) Proxy.newProxyInstance(
                Actor.class.getClassLoader(),
                Actor.class.getInterfaces(),
                new InvocationHandler(){

                    /**
                     * 执行代理对象的任何方法都会经过此方法，该方法有拦截的作用
                     *
                     * @param proxy     代理对象的引用，不一定每次都会有
                     * @param method    当前执行的方法
                     * @param args      当前执行方法需要的参数
                     * @return      当前执行方法的返回值
                     * @throws Throwable
                     */
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        Object rValue = proxy;
                        Integer money = (Integer) args[0];

                        //在不改变原来类方法的基础上，通过判断增强此方法的作用
                        if (StringUtils.equals("normalAct", method.getName())) {
                            if (money > 100) {
                                rValue = method.invoke(actor, money);
                            }
                        }
                        if (StringUtils.equals("specialAct", method.getName())) {
                            if (money > 200) {
                                rValue = method.invoke(actor, money);
                            }
                        }

                        return rValue;
                    }
                });

        proxyInstance.normalAct(22);
        proxyInstance.specialAct(222);


    }
}
