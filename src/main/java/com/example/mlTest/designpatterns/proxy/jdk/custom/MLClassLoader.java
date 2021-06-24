package com.example.mlTest.designpatterns.proxy.jdk.custom;

import java.io.*;

/**
 * @author miaoliang
 * @since 6/22/21 4:43 PM
 */
public class MLClassLoader extends ClassLoader {

    private File baseDir;

    public MLClassLoader(){
        String basePath = MLClassLoader.class.getResource("").getPath();
        this.baseDir = new File(basePath);
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        String className = MLClassLoader.class.getPackage().getName() + "." + name;
        if (baseDir != null) {
            File file = new File(baseDir, name.replaceAll("\\.", "/"));
            if (file.exists()){
                FileInputStream in = null;
                ByteArrayOutputStream out = null;
                try {
                    in = new FileInputStream(file);
                    out = new ByteArrayOutputStream();
                    byte[] buff = new byte[1024];
                    int len;
                    while((len = in.read(buff)) != -1){
                        out.write(buff,0,len);
                    }
                    return defineClass(className,out.toByteArray(),0,out.size());
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    if (null != in) {
                        try {
                            if ( out!= null) {
                                out.close();
                            }
                            in.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    file.delete();
                }
            }
        }
        return super.findClass(name);
    }
}
