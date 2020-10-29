/*
 * @(#)WrapMethodExecutor.java 1.0 2020年8月18日
 *
 * Copyright (c) 2019 JDD. All rights reserved.
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package spring.springboot2.wrap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import spring.springboot2.wrap.dto.WrapRuleDTO;

/**
 * @version 1.0
 * @since 1.0
 */

public class WrapMethodHelper {

    public static final Logger logger = LoggerFactory.getLogger(WrapMethodHelper.class);

    public static <T> T invoke(String wrapMethod, String ruleKey, WrapService wrapService, WrapTemplate template) {
        logger.info("wrap " + wrapMethod);
        // 全局开关未开启-透传
        if (!wrapService.isGlobalWrap()) {
            logger.info("全局wrap开关关闭");
            return (T) template.callReal();
        }
        // 接口开关未开启-透传
        WrapRuleDTO rule = wrapService.queryRuleConf(ruleKey);
        if (rule == null || !rule.isWrap()) {
            logger.info("本wrap开关未开启");
            return (T) template.callReal();
        }
        // 代码匹配规则
        if (rule.getMatchRule() != null && WrapConstants.RULE_TYPE_CODE.equals(rule.getMatchRule().get("type"))) {
            logger.info("根据代码匹配");
            Object result = template.matchByCode();
            if (result != null) {
                if (WrapConstants.RETURN_RESULT.equals(result)) {
                    return null;
                } else {
                    return (T) result;
                }
            }
            // 配置中匹配规则
        } else if (rule.getMatchRule() != null
                && WrapConstants.NO_RULE_TYPE_CONF.equals(rule.getMatchRule().get("type"))) {
            logger.info("根据配置匹配");
            Object result = template.matchByConf();
            if (result != null) {
                if (WrapConstants.RETURN_RESULT.equals(result)) {
                    return null;
                } else {
                    return (T) result;
                }
            }
        }

        // 未找到规则-代码处理
        if (rule.getNoMatchRule() != null
                && WrapConstants.NO_RULE_TYPE_CODE.equals(rule.getNoMatchRule().get("type"))) {
            logger.info("未找到规则-代码固定返回");
            Object result = template.noMatchByCode();
            if (WrapConstants.RETURN_RESULT.equals(result)) {
                return null;
            }
            return (T) result;
            // 未找到规则-配置处理
        } else if (rule.getNoMatchRule() != null
                && WrapConstants.NO_RULE_TYPE_CONF.equals(rule.getNoMatchRule().get("type"))) {
            logger.info("未找到规则-配置固定返回");
            Object result = template.noMatchByConf();
            if (WrapConstants.RETURN_RESULT.equals(result)) {
                return null;
            }
            return (T) result;
        } else {
            // 未找到规则-透传
            logger.info("未找到规则-透传");
            return (T) template.callReal();
        }
    }

}
