package spring.springboot2.Test;

/**
 * @author : ZJ
 * @date : 19-9-12 上午11:09
 */
public class Test16 {

    public int add(){
        int a=10;
        int b=10;
        return (a+b)*10;
    }

    public static void main(String[] args) {
        Test16 test16=new Test16();
        int add = test16.add();
        System.out.println(add);
    }
}
