package cmk.proxy.cglib;

import cmk.proxy.IActor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.cglib.proxy.Callback;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

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

        Actor cglibActor = (Actor) Enhancer.create(Actor.class,
                new MethodInterceptor() {
                    /**
                     *
                     * @param o             代理对象的引用，不一定每次都会有
                     * @param method        当前执行的方法
                     * @param objects       当前执行方法需要的参数
                     * @param methodProxy   当前执行方法的代理对象，一般不用
                     * @return
                     * @throws Throwable
                     */
                    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {

                        Integer money = (Integer) objects[0];

                        Object rValue = null;
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

        cglibActor.normalAct(122);
        cglibActor.specialAct(222);


    }
}
