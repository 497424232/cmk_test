package cmk.spring.service.impl;

import cmk.jvm.entity.User;
import cmk.spring.service.UserService;

/**
 * @auther changmk
 * @date 2019/7/23 下午3:43
 */
public class UserServiceImpl implements UserService {

    public UserServiceImpl() {
        System.out.println("----构造方法UserServiceImpl");
    }

    public void print() {
        System.out.println("调用了print方法");
    }

    public String getName() {
        return "name";
    }


    public void init() {
        System.out.println("对象创建");
    }

    public void destory() {
        System.out.println("对象销毁");
    }
}
