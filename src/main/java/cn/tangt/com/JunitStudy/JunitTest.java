package cn.tangt.com.JunitStudy;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * @author : tgt
 * @version : 1.0
 * @class : Test
 * @description : Test
 * @date : 2022/2/23
 */
public class JunitTest {

    @Before
    public void beforeTest() {
        System.out.println("before");
    }

    @After
    public void afterTest() {
        System.out.println("after");
    }

    @Test
    public void junitTest() throws NoSuchFieldException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Junit junit = new Junit();
        Class<? extends Junit> junitClass = junit.getClass();
        Field[] fields = junitClass.getFields();
        Field[] declaredFields = junitClass.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            System.out.println(declaredField);
        }
        System.out.println("===================");
        Field ds = junitClass.getDeclaredField("d");
        ds.setAccessible(true);
        Object o = ds.get(junit);
        System.out.println(o);
//        Constructor<? extends Junit> constructor = junitClass.getConstructor();
//        Junit junit2 = constructor.newInstance();
//        Junit junit1 = junitClass.newInstance();
        Method[] declaredMethods = junitClass.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            System.out.println(declaredMethod);
        }
        System.out.println("============");
        Method[] methods = junitClass.getMethods();
        for (Method method : methods) {
            System.out.println(method);
        }
    }

    @Test
    public void stringTest() {
    }

}
