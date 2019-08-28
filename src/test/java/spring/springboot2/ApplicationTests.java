package spring.springboot2;

import org.assertj.core.util.Lists;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

//@RunWith(SpringRunner.class)
//@SpringBootTest
public class ApplicationTests {
    /**
     * 不被序列化
     */
    protected transient int modCount = 0;
    //@Test
    public void contextLoads() {
        int totalSecs = 12000;
        int hours = totalSecs / 3600;
        int minutes = (totalSecs % 3600) / 60;
        int seconds = totalSecs % 60;
        String timeString = "";
        if (hours > 0) {
            timeString = String.format("%02d:%02d:%02d", hours, minutes, seconds);
        } else {
            timeString = String.format("%02d:%02d", minutes, seconds);
        }
        System.out.println(timeString);
    }

   // @Test
    public void test() {
        List<String> stringList = new ArrayList<>();


        List<Integer> integerList = new ArrayList<>();

        stringList.add("a");
        stringList.add("b");
        stringList.add("c");
        stringList.add("d");
        stringList.add("e");

        integerList.add(2);
        integerList.add(4);
/**
 * remove()这个方法是一个重载方法，即remove(int position)
 * 和remove(object object)，唯一的区别是参数类型
 * 其实i是Integer对象，而由于Java系统中如果找不到准确的对象，
 * 会自动向上升级，而(int < Integer < Object)，所以在调用stringList.remove(i)时，
 * 其实使用的remove(object object)，而很明显stringList不存在Integer对象，
 * 自然会移除失败（0.0），Java也不会因此报错。
 * 如果我们想使用remove(int position)方法，只能降低对象等级，即修改代码；
 */

        for (Integer i : integerList) {
            stringList.remove(i);
        }

        for (Integer i : integerList) {
            int a = i;
            stringList.remove(a);
        }


        for (String s : stringList) {
            System.out.println(s);
        }


    }

    /**
     * java.util.ConcurrentModificationException
     * ArrayList的父类AbstarctList中有一个域modCount，
     * 每次对集合进行修改（增添元素，删除元素……）时都会modCount++
     * 而foreach的背后实现原理其实就是Iterator
     * （关于Iterator可以看Java Design Pattern: Iterator），
     * 等同于注释部分代码。在这里，
     * 迭代ArrayList的Iterator中有一个变量expectedModCount，
     * 该变量会初始化和modCount相等，
     * 但如果接下来如果集合进行修改modCount改变，
     * 就会造成expectedModCount!=modCount，
     * 此时就会抛出java.util.ConcurrentModificationException异常
     *https://www.jianshu.com/p/c5b52927a61a
     */
   // @Test
    public void test1() {
        List<String> list = Lists.newArrayList("1", "12", "13", "14", "15", "0");

        List<String> list1 =new ArrayList<>();

//        Collection<String> strings = Collections.synchronizedCollection(list1);
        list1.add("d");
        list1.add("c");
        list1.add("e");
        for (String s : list1) {
            list1.removeIf("d"::equals);

        }

/**
 * 应该用iterator 去删除  iterator 里的remove方法会重置xpectedModCount = modCount;
 * 保证了不会抛出java.util.ConcurrentModificationException异常。
 */

//        System.out.println(list.size());
//        for (String s : list) {
//            list.removeIf("1"::equals);
//        }

    }

  //  @Test
    public void testRemove2(){
        List<Integer> integers = new ArrayList<>(5);

        integers.add(1);
        integers.add(2);
        integers.add(2);
        integers.add(4);
        integers.add(5);

        for (int i = 0; i < integers.size(); i++) {

            if (integers.get(i)%2==0){
                System.out.println(i);
                integers.remove(i);
                System.out.println(integers.toString());
            }

        }

        System.out.println(integers);
    }

    @Test
    public void testRemove5(){
        List<String> strings = new ArrayList<>();
        strings.add("a");
        strings.add("b");
        strings.add("c");
        strings.add("d");

        int size = strings.size();
        for (int i = 0; i < strings.size(); i++) {
            System.out.println(i);
            strings.remove(i);
        }
        System.out.println(strings);

    }

}
