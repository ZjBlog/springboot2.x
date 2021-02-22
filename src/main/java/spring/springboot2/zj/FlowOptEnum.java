package spring.springboot2.zj;

/**
 * @author zhangjun486
 * @version 1.0
 * @date 2021/2/22 20:35
 * @Description
 */
public enum FlowOptEnum {

    FIRST_PASS("1"),

    FIRST_REJECT("1"), SECOND_PASS("2"), SECOND_REJECT("2");

    private String desc;

    FlowOptEnum(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }
}
