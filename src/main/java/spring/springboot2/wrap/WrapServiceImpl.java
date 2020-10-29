/*
 * @(#)WrapServiceImpl.java 1.0 2020年8月17日
 *
 * Copyright (c) 2019 JDD. All rights reserved.
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package spring.springboot2.wrap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.springboot2.wrap.dto.QueryWrapDataDTO;
import spring.springboot2.wrap.dto.WrapDataDTO;
import spring.springboot2.wrap.dto.WrapRuleDTO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 包装服务
 *
 * @author liyuliang5
 * @version 1.0
 * @since 1.0
 */
@Service
public class WrapServiceImpl implements WrapService {

    private static final String WRAP_FLAG_KEY = "WRAP_FLAG";

    private static final String WRAP_RULE_PREFIX = "WRAP_RULE-";

    private static final String WRAP_DATA_PREFIX = "WRAP_DATA-";

    @Autowired
    private ConfigService configService;

    @Override
    public boolean isGlobalWrap() {
        return Boolean.TRUE.toString().equals(configService.getConfigValue(WRAP_FLAG_KEY));
    }

    @Override
    public WrapRuleDTO queryRuleConf(String key) {
        //根据key查询配置信息
        //调用config 查看配置
//        String info = configService.getConfigValue(WRAP_RULE_PREFIX + key);
//        return JSON.parseObject(info, WrapRuleDTO.class);
        WrapRuleDTO rule = new WrapRuleDTO();
        rule.setWrap(true);
        Map<String, Object> map = new HashMap<>();
        map.put("type", "code");
        rule.setMatchRule(map);
        return rule;
    }

    /**
     * 查询数据
     */
    @Override
    public List<WrapDataDTO> queryData(QueryWrapDataDTO query) {
//        Map<String, String> map = null;
//        if (query.getId() != null) {
//            String key = WRAP_DATA_PREFIX + query.getDataType() + "-" + query.getId();
//            String record = configService.getConfigValue(key);
//            if (record == null) {
//                return new ArrayList<WrapDataDTO>();
//            }
//            map = new HashMap<String, String>();
//            map.put(key, record);
//        } else {
//            map = configService.getConfigValueStartWith(WRAP_DATA_PREFIX + query.getDataType());
//        }
//        List<WrapDataDTO> list = new ArrayList<WrapDataDTO>();
//        for (Entry<String, String> entry : map.entrySet()) {
//            String key = entry.getKey();
//            Map<String, Object> valueMap = JSON.parseObject(entry.getValue(), Map.class);
//            boolean match = true;
//            for (Entry<String, Object> conditionEntry : query.getConditions().entrySet()) {
//                if (!Objects.equal(conditionEntry.getValue(), valueMap.get(conditionEntry.getKey()))) {
//                    match = false;
//                    break;
//                }
//            }
//            if (match) {
//                WrapDataDTO wrapData = new WrapDataDTO();
//                String[] info = key.split("-");
//                wrapData.setDataType(query.getDataType());
//                wrapData.setId(info[2]);
//                wrapData.setData(valueMap);
//                list.add(wrapData);
//            }
//        }
        return null;
    }

    /**
     * 更新数据.
     */
    @Override
    public void updateData(WrapDataDTO dto) {
        String key = WRAP_DATA_PREFIX + dto.getDataType() + dto.getId();
//        ConfigDTO config = configService.getConfig(key);
//        config.setCfgValue(JSON.toJSONString(dto.getData()));
//        configService.updateConfig(config);
    }

}
