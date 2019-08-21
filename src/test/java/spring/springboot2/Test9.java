package spring.springboot2;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import spring.springboot2.service.MyService;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author : ZJ
 * @date : 19-8-21 下午3:01
 */
public class Test9 {

    private ThreadLocal<Integer> threadLocal = ThreadLocal.withInitial(() -> 0);

/**
 * 1）使用new关键字
 *
 * 2）利用反射，调用Class对象的newInstance()方法
 *
 * 3）调用clone()方法，对现有实例的拷贝
 *
 * 4）利用反序列化，通过ObjectInputStream的readObject()方法反序列化类
 */
    /**
     * 反射实例化对象
     *
     * @throws ClassNotFoundException
     * @throws IllegalAccessException
     * @throws InstantiationException
     * @throws NoSuchMethodException
     * @throws InvocationTargetException
     */
    @Test
    public void test() throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {

        Class<MyService> aClass = (Class<MyService>) Class.forName("spring.springboot2.service.MyService");

        System.out.println(aClass);


//        Constructor<?> constructor = aClass.getConstructor();
//        MyService o = (MyService) constructor.newInstance();

        char[] chars = aClass.getSimpleName().toCharArray();
        chars[0] += 32;
        System.out.println(String.valueOf(chars));

        //判断当前类是否实现了接口
        Class<?>[] interfaces = aClass.getInterfaces();


        //获取当前类对象的所有声明的字段
        Map<String, Object> instanceMap = new ConcurrentHashMap<>();

        Field[] fields = aClass.getDeclaredFields();
        //循环遍历所有字段
        Object instance = aClass.newInstance();
        Object o = null;
        for (Field field : fields) {
            //判断字段是否含有@Autowired注解
            if (field.isAnnotationPresent(Autowired.class)) {
                String name = field.getType().getName();
                o = instanceMap.get(name);
            }
            // 通过反射注入到该属性中
            field.setAccessible(true);
            try {
                field.set(instance, o);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

}
