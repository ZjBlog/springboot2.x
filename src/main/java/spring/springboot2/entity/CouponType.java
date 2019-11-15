package spring.springboot2.entity;

/**
 * @author zhangjun486
 * @version 1.0
 * @date 2019/11/15 17:01
 */
public enum CouponType {

    LADDER(1024, "阶梯优惠"),
    FINANCE(2048, "融资优惠"),
    REDUCTION(4096, "减免优惠"),
    ACTIVITY(3072, "活动优惠");

    private Integer type;
    private String name;

    private CouponType(Integer type, String name) {
        this.name = name;
        this.type = type;
    }


    public static CouponType getByType(Integer type) {

        for (CouponType couponType : CouponType.values()) {
            if (couponType.getType().equals(type)) {
                return couponType;
            }
        }

        return null;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
