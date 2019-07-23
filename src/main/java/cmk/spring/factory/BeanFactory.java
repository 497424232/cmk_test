package cmk.spring.factory;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

/**
 * 手写spring 的beanFactory
 * 简化写出来，理解spring的factory工厂
 * @auther changmk
 * @date 2019/7/23 下午3:04
 */
public class BeanFactory {

    //只用于读取properties文件，别的文件读不了
    //只能读取，不能写入
    //只能读取类路径下的，非类路径下的读不了
    //路径按"包名.类名"方式写的，不能加文件后缀。
    //和spring使用的获取配置文件的方法一致。
    private static ResourceBundle resourceBundle = ResourceBundle.getBundle("bean");

    private static Map<String, Object> beanMap = new HashMap<String, Object>();

    static {
        try {
            //遍历配置文件中的key
            Enumeration<String> keys = resourceBundle.getKeys();

            while (keys.hasMoreElements()) {

                String key = keys.nextElement();

                String beanPath = resourceBundle.getString(key);

                Object object = Class.forName(beanPath).newInstance();

                beanMap.put(key, object);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new ExceptionInInitializerError("创建容器异常");
        }
    }

    /**
     * 获取bean 对象
     * @param beanName
     * @return
     */
    public Object getBean(String beanName) {
        return beanMap.get(beanName);
    }


}
