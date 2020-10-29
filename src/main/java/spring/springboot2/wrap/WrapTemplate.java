/*
 * @(#)WrapProcessTemplate.java 1.0 2020年8月18日
 *
 * Copyright (c) 2019 JDD. All rights reserved.
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package spring.springboot2.wrap;

/**
 * 包装处理模板
 *
 * @version 1.0
 * @since 1.0
 */

public interface WrapTemplate {

    public Object callReal();

    default Object matchByCode() {
        return null;
    }

    default Object matchByConf() {
        throw new UnsupportedOperationException();
    }

    default Object noMatchByCode() {
        return null;
    }

    default Object noMatchByConf() {
        throw new UnsupportedOperationException();
    }
}
