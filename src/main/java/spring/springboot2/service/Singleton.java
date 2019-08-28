package spring.springboot2.service;

/**
 * @author : ZJ
 * @date : 19-8-28 下午4:40
 */
public enum Singleton {
    INSTANCE;
    private SingletonClass instance;

    Singleton() {
        System.out.println("枚举类构造函数");
        this.instance = new SingletonClass();
    }

    public SingletonClass getInstance() {
        return this.instance;
    }

}

class SingletonClass {
    int i = 0;

    public SingletonClass() {
        System.out.println("SingletonClass被初始化 " + ++i + " 次");
    }
}

class SingletonTest {
    public static void main(String[] args) {
        SingletonClass instance1 = Singleton.INSTANCE.getInstance();
        SingletonClass instance2 = Singleton.INSTANCE.getInstance();
        System.out.println("instance1 == instance2: " + (instance1 == instance2));
    }
}
