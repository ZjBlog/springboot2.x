package spring.springboot2.zj;

/**
 * @author zhangjun486
 * @version 1.0
 * @date 2021/2/22 20:32
 * @Description
 */
public enum FlowStatusEnum {
    INIT {
        @Override
        public FlowOptEnum nextFlowOpt(boolean pass) {
            return pass ? FlowOptEnum.FIRST_PASS : FlowOptEnum.FIRST_REJECT;
        }
    },
    FIRST_PASS {
        @Override
        public FlowOptEnum nextFlowOpt(boolean pass) {
            return pass ? FlowOptEnum.SECOND_PASS : FlowOptEnum.SECOND_REJECT;
        }
    };

    public abstract FlowOptEnum nextFlowOpt(boolean pass);
}