package cmk.proxy.reason;

import javax.tools.JavaCompiler;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.FileWriter;
import java.net.URL;
import java.net.URLClassLoader;

/**
 * @auther changmk
 * @date 2019/7/25 下午9:44
 */
public class MyProxy {
    public static void main(String[] args) throws Exception{

        String string = "package cmk.proxy.reason;\n" +
                "\n" +
                "public class MyTest {\n" +
                "    public void test() {\n" +
                "        System.out.println(\"MyClassProxy\");\n" +
                "    }\n" +
                "}\n";

        String fileName = "/Users/cmk/Downloads/src/com/MyTest.java";

        System.out.println(fileName);

        File file = new File(fileName);

        FileWriter fileWriter = new FileWriter(file);

        fileWriter.write(string);
        fileWriter.flush();
        fileWriter.close();


        //编译类文件
        JavaCompiler javaCompiler = ToolProvider.getSystemJavaCompiler();

        StandardJavaFileManager fileManager = javaCompiler.getStandardFileManager(null, null, null);

        Iterable units = fileManager.getJavaFileObjects(fileName);

        JavaCompiler.CompilationTask compilationTask = javaCompiler.getTask(null, fileManager, null, null, null, units);

        compilationTask.call();

        fileManager.close();

        //加载到内存，并生成新对象
        URL[] urls = new URL[]{new URL("file:" + "/Users/cmk/Downloads/")};
        URLClassLoader urlClassLoader = new URLClassLoader(urls);

        Class cls = urlClassLoader.loadClass("com.MyTest");
        System.out.println(cls);



    }
}
