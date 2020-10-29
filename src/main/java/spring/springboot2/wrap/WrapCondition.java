/*
 * @(#)WrapperCondition.java 1.0 2020年8月17日
 *
 * Copyright (c) 2019 JDD. All rights reserved.
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package spring.springboot2.wrap;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;
import org.springframework.core.type.ClassMetadata;

/**
 * 包装条件
 *
 * @version 1.0
 * @since 1.0
 */

public class WrapCondition implements Condition {

    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        ClassMetadata classMetadata = (ClassMetadata) metadata;
        Wrapper wrapper;
        try {
            wrapper = Class.forName(classMetadata.getClassName()).getAnnotation(Wrapper.class);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        //配置文件中是否打开
        return "true".equals(context.getEnvironment().getProperty(wrapper.switchProperty()));
    }

}
