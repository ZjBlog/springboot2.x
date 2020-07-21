package spring.springboot2.Until;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.springboot2.service.ProductService;

import java.util.concurrent.TimeUnit;

/**
 * @author zhangjun486
 * @version 1.0
 * @date 2020/7/21 20:48
 * @Description 缓存服务
 */
@Service
@Slf4j
public class CacheService {


    @Autowired
    private ProductService productService;

    /**
     * @param <T>
     * @param <R>
     * @author
     * @date 2019-09-30
     * 带异常的函数式接口
     */
    @FunctionalInterface
    interface ExceptionFunction<T, R> {
        /**
         * Applies this function to the given argument
         */
        R apply(T t) throws Exception;
    }

    /**
     * 创建guava缓存
     *
     * @param timeoutSecond 超时时间,单位为秒
     * @param function      创建方法
     * @param <K>           key的类型
     * @param <V>           value的类型
     * @return 缓存对象
     */
    private static <K, V> LoadingCache<K, V> create(int timeoutSecond, ExceptionFunction<K, V> function) {
        return CacheBuilder
                .newBuilder()
                .expireAfterAccess(timeoutSecond, TimeUnit.SECONDS)
                .build(new CacheLoader<K, V>() {
                    @Override
                    public V load(K key) throws Exception {
                        return function.apply(key);
                    }
                });
    }


    public final LoadingCache<String, String> productCache = create(
            60,
            key -> productService.get(key));


}
