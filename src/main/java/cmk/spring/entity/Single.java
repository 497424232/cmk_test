package cmk.spring.entity;

/**
 * @auther changmk
 * @date 2019/7/23 下午4:44
 */
public class Single {
    private static Single ourInstance = new Single();

    public static Single getInstance() {
        return ourInstance;
    }

    private Single() {
    }
}
