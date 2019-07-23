package cmk.spring.test;

import cmk.spring.config.SpringConfig;
import cmk.spring.entity.User;
import cmk.spring.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @auther changmk
 * @date 2019/7/23 下午3:45
 */
public class Test {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");

        //三种创建bean方式
        //构造函数创建
//        UserService userService = (UserService)context.getBean("userService");
        //静态工厂创建
//        UserService userService1 = (UserService)context.getBean("staticUserService");
        //实例工厂创建
//        UserService userService2 = (UserService)context.getBean("userServiceImpl");
//        userService.print();

        //构造方法注入
        User user1 = (User) context.getBean("user1");
        System.out.println(user1.toString());
        //set方法注入
        User user2 = (User) context.getBean("user2");
        System.out.println(user2.toString());

        System.out.println(user1 == user2);
        System.out.println(user1.getClass() == user2.getClass());

//        context.close();

    }

    public void loadConfig(){
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);


    }
}
