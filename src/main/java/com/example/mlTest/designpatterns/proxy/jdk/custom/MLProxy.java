package com.example.mlTest.designpatterns.proxy.jdk.custom;

import javax.tools.JavaCompiler;
import javax.tools.JavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Objects;

/**
 * @author miaoliang
 * @since 6/22/21 4:22 PM
 *
 * 生成代理对象的代码
 */
public class MLProxy {

    private static String ln = "\r";

    public static Object newProxyInstance(MLClassLoader loader, Class<?>[] interfaces, MLInvocationHandler h) {
        FileWriter fileWriter = null;
        StandardJavaFileManager manager = null;
        try {
            // 1. 生成源代码
            String proxySrc = generateSrc(interfaces[0]);
            // 2. 将生成的源代码输出到磁盘，保存为java文件  （生成的代码暂时还不能通过编译，后期有时间可以完善一下，暂时先跳过）
            String filePath = MLProxy.class.getResource("").getPath();
            File file = new File(filePath+"$Proxy0.java");
            fileWriter = new FileWriter(file);
            fileWriter.write(proxySrc);
            fileWriter.flush();
            // 3. 编译源代码，并且生成 .class文件
            JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
            manager = compiler.getStandardFileManager(null, null, null);
            Iterable<? extends JavaFileObject> itrable = manager.getJavaFileObjects(file);
            JavaCompiler.CompilationTask task = compiler.getTask(null, manager, null, null, null, itrable);
            task.call();

            // 4. 将class文件中的内容，动态加载到 JVM 中来
            Class<?> proxyClass = loader.findClass("$Proxy0");
            // 5. 返回被代理后的代理对象
            Constructor<?> constructor = proxyClass.getConstructor(MLInvocationHandler.class);
            file.delete();
            return constructor.newInstance(h);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                manager.close();
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    private static String generateSrc(Class<?> interfaces){
        StringBuffer src = new StringBuffer();
        src.append("package com.example.mlTest.designpatterns.proxy.jdk.custom;"+ ln);
        src.append("import java.lang.reflect.Method;"+ln);
        src.append("public final class $Proxy0 implements "+interfaces.getName()+" {"+ln);
        src.append("public $Proxy0(InvocationHandler h) throws  {" +ln);
        src.append("MLInvocationHandler h;" + ln);
        src.append("this.h = h;" + ln);
        for (Method method : interfaces.getMethods()) {
            src.append("public " + method.getReturnType().getName()+" "+method.getName() +" throws Throwable {"+ ln);
            src.append("Method method = "+ interfaces.getName()+".class.getMethod(\""+method.getName()+"\",new Class[]{});"+ln);
            src.append("this.h.invoke(this,method,null);"+ln);
            src.append("}" + ln);
        }

        src.append("}"+ln);
        src.append("}");
        return src.toString();
    }

}
