package spring.springboot2.x.until;

import spring.springboot2.x.domain.UserInfo;

public class LoginUntil {

    /**
     * 用于保存到threadLocal的 LoginInfo
     */
    private static final ThreadLocal<UserInfo> LOGIN_INFO = new ThreadLocal<>();

    /**
     * 获取 LoginInfo
     */
    public static UserInfo getLoginInfo() {
        return LOGIN_INFO.get();
    }

    /**
     * 获取pin
     */
    public static String getPin() {
        if (getLoginInfo() == null) {
            throw new RuntimeException("获取客户pin失败");
        }
        return getLoginInfo().getName();
    }

    /**
     * 清理 LoginInfo
     */
    static void clean() {
        LOGIN_INFO.remove();
    }

}
