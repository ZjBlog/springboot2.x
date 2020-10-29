package spring.springboot2.wrap;

import spring.springboot2.wrap.dto.QueryWrapDataDTO;
import spring.springboot2.wrap.dto.WrapDataDTO;
import spring.springboot2.wrap.dto.WrapRuleDTO;

import java.util.List;

/**
 * @author zhangjun486
 * @version 1.0
 * @date 2020/10/29 20:25
 * @Description
 */
public interface WrapService {
    /**
     * 是否是全局包装
     *
     * @return
     */
    public boolean isGlobalWrap();

    public WrapRuleDTO queryRuleConf(String key);

    /**
     * 查询包装数据
     *
     * @param query
     * @return
     */
    public List<WrapDataDTO> queryData(QueryWrapDataDTO query);

    /**
     * 更新包装数据
     *
     * @param dto
     */
    public void updateData(WrapDataDTO dto);
}
