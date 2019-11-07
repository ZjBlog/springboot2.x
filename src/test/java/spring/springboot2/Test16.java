package spring.springboot2;

<<<<<<< HEAD
import org.junit.Test;

import java.util.HashMap;

public class Test16 {

    @Test
    public void test(){
        HashMap map=new HashMap();
        map.put("key",123);
        map.put("key1",1234);
        map.put("key",123);
=======
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
>>>>>>> 936ebd606abff0b484e2c3b93445fa73f59cab22
    }
}
