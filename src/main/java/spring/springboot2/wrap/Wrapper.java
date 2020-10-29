/*
 * @(#)Wrapper.java 1.0 2020年8月17日
 *
 * Copyright (c) 2019 JDD. All rights reserved.
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package spring.springboot2.wrap;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * TODO
 * 使用挡板时需要首先确保开发人员已开发对应接口的挡板及提供的挡板配置方式。一个挡板的真正启用需要四层开关满足才生效：
 * <p>
 * 代码开关、全局开关、接口级开关、规则集是否匹配。
 *
 * @version 1.0
 * @since 1.0
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Wrapper {

    String switchProperty();
}
