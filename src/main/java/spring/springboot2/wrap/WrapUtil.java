/*
 * @(#)WrapUtil.java 1.0 2020年8月17日
 *
 * Copyright (c) 2019 JDD. All rights reserved.
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package spring.springboot2.wrap;

import spring.springboot2.Until.SpringContextUtil;

import java.util.Map;

/**
 * 包装工具类
 *
 * @author liyuliang5
 * @version 1.0
 * @since 1.0
 */

public class WrapUtil {

    public static <T> T getRealBeanOfType(Class<T> clazz) {
        Map<String, T> map = SpringContextUtil.getBeansOfType(clazz);
        for (T o : map.values()) {
            if (!o.getClass().getName().endsWith("Wrapper")) {
                return o;
            }
        }
        return null;

    }
}
