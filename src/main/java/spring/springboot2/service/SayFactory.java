package spring.springboot2.service;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author zhangjun486
 * @version 1.0
 * @date 2020/10/31 20:15
 * @Description 单例模式
 * say工场 say的实现是单例
 */
public class SayFactory {

    private static final ConcurrentHashMap<Class<?>, Say> INSTANCES = new ConcurrentHashMap<Class<?>, Say>();

    public static <T extends Say> Say getInstance(Class<T> clz) {
        if (clz == null) {
            throw new NullPointerException();
        }
        if (INSTANCES.containsKey(clz)) {
            return INSTANCES.get(clz);
        } else {
            synchronized (INSTANCES) {
                if (INSTANCES.containsKey(clz)) {
                    return INSTANCES.get(clz);
                } else {
                    Say ins;
                    try {
                        ins = clz.newInstance();
                        INSTANCES.put(clz, ins);
                        return ins;
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
    }

}
