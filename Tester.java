import java.lang.reflect.InvocationTargetException;

import java.lang.reflect.Method;

import java.util.Map;
import java.util.TreeMap;

public class Tester {
    public static void start(Class clazz) {
        final int minPriority = 1;
        final int maxPriority = 10;
        Map<Integer, Method> map = new TreeMap<>();

        for (Method method : clazz.getDeclaredMethods()) {
            if (method.getAnnotation(BeforeSuite.class) != null) {
                map.put(minPriority - 1, method);
            }
            if (method.getAnnotation(AfterSuite.class) != null) {
                map.put(maxPriority + 1, method);
            }
            if (method.getAnnotation(Test.class) != null) {
                Test test = method.getAnnotation(Test.class);
                map.put(test.priority(), method);
            }
        }

        try {
            Object testCase = new Cases();
            for (Integer key : map.keySet()) {
                map.get(key).invoke(testCase);
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        start(Cases.class);
    }
}
