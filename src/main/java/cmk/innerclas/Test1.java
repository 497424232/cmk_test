package cmk.innerclas;

/**
 * @auther changmk
 * @date 2019/7/22 下午6:24
 */
public class Test1 {

    public int id;

    public void say(){
        String name = "xx";
        class InnerClass{
            public void hello() {
                System.out.println("hello");
            }
        }
        InnerClass innerClass = new InnerClass();
        innerClass.hello();

        System.out.println("内部类方法包含");
    }

    public static void main(String[] args) {
        Test1 test1 = new Test1();

        test1.say();

        MyInterface myInterface = new MyInterface(){
            public void hello() {
                System.out.println("diaoyon ");
            }
        };
        myInterface.hello();
    }
}

interface MyInterface{
    void hello();
}

class MyClass implements MyInterface {
    public void hello() {
        System.out.println("my class hello");
    }
}