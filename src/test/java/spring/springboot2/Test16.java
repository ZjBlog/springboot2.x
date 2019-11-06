package spring.springboot2;

import org.junit.Test;

import java.util.HashMap;

public class Test16 {

    @Test
    public void test(){
        HashMap map=new HashMap();
        map.put("key",123);
        map.put("key1",1234);
        map.put("key",123);
    }
}
