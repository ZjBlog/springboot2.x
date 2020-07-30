package spring.springboot2.entity;

/**
 * @author zhangjun486
 * @version 1.0
 * @date 2020/6/24 17:36
 * @Description
 */
public enum TestEnum {
    TEST1("test", "999"),
    TEST("test", "999");

    private String code;
    private String desc;

    TestEnum(String code, String name) {
        this.code = code;
        this.desc = name;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return desc;
    }

    public static void main(String[] args) {
        System.out.println(TestEnum.TEST.name());
    }
}
