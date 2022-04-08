package cn.tangt.com.JunitStudy;

import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * @author : tgt
 * @version : 1.0
 * @class : ReflectTest
 * @description : reflect
 * @date : 2022/2/23
 */
public class ReflectTest {
    public static void main(String[] args) throws Exception {
        Properties properties = new Properties();
        ClassLoader classLoader = ReflectTest.class.getClassLoader();
        InputStream resourceAsStream = classLoader.getResourceAsStream("pro.properties");
        System.out.println(resourceAsStream);
        properties.load(resourceAsStream);
        String className = properties.getProperty("className");
        String methodName = properties.getProperty("methodName");
        Class<?> aClass = Class.forName(className);
        Object o = aClass.newInstance();
        Method method = aClass.getMethod(methodName);
        method.invoke(o);

    }
}
