/*
 * @(#)ContextUtil.java 1.0 2020年6月14日
 *
 * Copyright (c) 2019 JDD. All rights reserved.
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package spring.springboot2.Until;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;

/**
 * TODO
 *
 * @version 1.0
 * @since 1.0
 */

public class ContextUtil implements ApplicationContextAware {

    private static volatile ApplicationContext context;

    public static void load(String... locations) {
        context = new ClassPathXmlApplicationContext(locations);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        doSetApplicationContext(applicationContext);
        SpelHelper.setApplicationContext(applicationContext);
    }

    public static ApplicationContext getApplicationContext() {
        return context;
    }

    @SuppressWarnings("unchecked")
    public static <T> T getBean(String name) {
        return (T) context.getBean(name);
    }

    @SuppressWarnings("unchecked")
    public static <T> T getBean(Class clazz) {
        return (T) context.getBean(clazz);
    }

    public static <T> Map<String, T> getBeansOfType(Class<T> clazz) {
        return context.getBeansOfType(clazz);
    }

    private synchronized static void doSetApplicationContext(ApplicationContext applicationContext) {
        context = applicationContext;
    }
}

