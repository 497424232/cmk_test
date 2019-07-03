package cmk.suanfa.start;

/**
 * @auther changmk
 * @date 2019/7/3 上午11:02
 */
public class Ofunction1 {

    public static void main(String[] args) {
        method1(8);
    }

    public static void method1(int n) {
        int i,j,k,count = 0;
        for (i=n/2; i<= n; i++) {
            for (j=1; j+n/2 <= n; j ++) {
                for (k = 1; k <= n ;k= k+2) {
                    count++;
                }
            }
        }
        System.out.print(count);
    }
}
