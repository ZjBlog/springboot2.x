package spring.springboot2;

/**
 * @author zhangjun486
 * @version 1.0
 * @date 2020/5/8 16:15
 */
public class Test3 {

    public static void main(String[] args) {
        System.out.println(test1());

        System.out.println(test2());

        System.out.println(test3());

        System.out.println(test4());
    }

    private static int test1() {

        int i = 1;
        try {
            return i;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            i = 0;
        }

        return i;

    }

    //不能再finally中使用return
    //执行完finally中的return 方法结束 不会再这些try中的
    private static int test2() {

        int i = 1;
        try {
            return i;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            i = 0;
            return i;
        }

    }

    private static User test3() {

        User user = new User("u1");
        try {
            return user;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            user = new User("u2");
        }

        return null;

    }

    private static User test4() {

        User user = new User("u1");
        try {
            return user;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            user.setName("u2");
        }

        return null;

    }
}

class User {
    public User(String name) {
        this.name = name;
    }

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

}
