package cmk.suanfa.digui_huisu;


import org.apache.commons.lang3.StringUtils;

/**
 * @auther changmk
 * @date 2019/7/3 上午11:30
 */
public class HuisuTest {
    String[] A = new String[10];
    public static void main(String[] args) {
        HuisuTest test = new HuisuTest();
        test.method1(4);
    }

    public void method1(int n) {
        if (n < 1) {
            System.out.println(StringUtils.join(A, ","));
        } else {
            A[n-1] = "0";
            method1(n-1);
            A[n-1] = "1";
            method1(n-1);
        }
    }
}
