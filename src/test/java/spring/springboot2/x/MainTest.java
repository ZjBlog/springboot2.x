package spring.springboot2.x;

/**
 * @author zhangjun486
 * @version 1.0
 * @date 2020/9/30 15:46
 * @Description 使用位运算计算
 * IM(1, "IM消息"),
 * SYSTEM(2, "系统提醒"),
 * MAIL(3, "邮箱"),
 * SMS(4, "短信");
 * <p>
 * 使用位运算计算
 * IM(1, "IM消息"),
 * SYSTEM(2, "系统提醒"),
 * MAIL(3, "邮箱"),
 * SMS(4, "短信");
 * <p>
 * 使用位运算计算
 * IM(1, "IM消息"),
 * SYSTEM(2, "系统提醒"),
 * MAIL(3, "邮箱"),
 * SMS(4, "短信");
 * <p>
 * 使用位运算计算
 * IM(1, "IM消息"),
 * SYSTEM(2, "系统提醒"),
 * MAIL(3, "邮箱"),
 * SMS(4, "短信");
 * <p>
 * 使用位运算计算
 * IM(1, "IM消息"),
 * SYSTEM(2, "系统提醒"),
 * MAIL(3, "邮箱"),
 * SMS(4, "短信");
 * <p>
 * 使用位运算计算
 * IM(1, "IM消息"),
 * SYSTEM(2, "系统提醒"),
 * MAIL(3, "邮箱"),
 * SMS(4, "短信");
 * <p>
 * 使用位运算计算
 * IM(1, "IM消息"),
 * SYSTEM(2, "系统提醒"),
 * MAIL(3, "邮箱"),
 * SMS(4, "短信");
 * <p>
 * 使用位运算计算
 * IM(1, "IM消息"),
 * SYSTEM(2, "系统提醒"),
 * MAIL(3, "邮箱"),
 * SMS(4, "短信");
 */

/**
 * 使用位运算计算
 * IM(1, "IM消息"),
 * SYSTEM(2, "系统提醒"),
 * MAIL(3, "邮箱"),
 * SMS(4, "短信");
 */

/**
 *  1     1     1         1
 *  短信  邮箱   系统提醒   IM消息
 */
public class MainTest {
    public static void main(String[] args) {

        System.out.println(hasMark(7, 8));
    }

    /**
     * 判断
     * &  都是1才为1
     * @param mod   用户当前值
     * @param value 需要判断值
     * @return 是否存在
     */
    public static boolean hasMark(long mod, long value) {
        return (mod & value) == value;
    }

    /**
     * 增加
     * 有一个1就是1
     * @param mod   已有值
     * @param value 需要添加值
     * @return 新的状态值
     */
    public static long addMark(long mod, long value) {
        if (hasMark(mod, value)) {
            return mod;
        }
        return (mod | value);
    }

    /**
     * 删除
     *相同的为0，不同的为1
     * @param mod   已有值
     * @param value 需要删除值
     * @return 新值
     */
    public static long removeMark(long mod, long value) {
        if (!hasMark(mod, value)) {
            return mod;
        }
        return mod ^ value;
    }
}
