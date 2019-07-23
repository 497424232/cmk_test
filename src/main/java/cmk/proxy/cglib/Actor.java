package cmk.proxy.cglib;

import cmk.proxy.IActor;

/**
 * @auther changmk
 * @date 2019/7/23 下午9:38
 */
public class Actor {
    public void normalAct(int money) {
        System.out.println("cglib正常表演，拿到钱" + money);
    }

    public void specialAct(int money) {
        System.out.println("cglib特殊表演，拿到钱" + money);
    }
}
