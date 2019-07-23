package cmk.proxy;

/**
 * @auther changmk
 * @date 2019/7/23 下午9:38
 */
public class Actor implements IActor {
    public void normalAct(int money) {
        System.out.println("正常表演，拿到钱" + money);
    }

    public void specialAct(int money) {
        System.out.println("特殊表演，拿到钱" + money);
    }
}
