package HW21;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class TestRunner {

    public static void start(Class<?> classe) throws Exception {
        Object instance = classe.getDeclaredConstructor().newInstance();

        Method[] methods = classe.getDeclaredMethods();
        List<Method> beforeSuiteMethods = new ArrayList<>();
        List<Method> testMethods = new ArrayList<>();
        List<Method> afterSuiteMethods = new ArrayList<>();

        for (Method method : methods) {
            if (method.isAnnotationPresent(BeforeSuite.class)) {
                beforeSuiteMethods.add(method);
            } else if (method.isAnnotationPresent(Test.class)) {
                testMethods.add(method);
            } else if (method.isAnnotationPresent(AfterSuite.class)) {
                afterSuiteMethods.add(method);
            }
        }

        if (beforeSuiteMethods.size() > 1) {
            throw new RuntimeException("BeforeSuite method should be declared only once in a class");
        }

        if (afterSuiteMethods.size() > 1) {
            throw new RuntimeException("AfterSuite method should be declared only once in a class");
        }

        beforeSuiteMethods.sort(Comparator.comparingInt(m -> m.getAnnotation(BeforeSuite.class).priority()));
        afterSuiteMethods.sort(Comparator.comparingInt(m -> m.getAnnotation(AfterSuite.class).priority()));

        for (Method method : beforeSuiteMethods) {
            method.invoke(instance);
        }

        testMethods.sort(Comparator.comparingInt(m -> m.getAnnotation(Test.class).priority()));

        for (Method method : testMethods) {
            method.invoke(instance);
        }

        for (Method method : afterSuiteMethods) {
            method.invoke(instance);
        }
    }
}
