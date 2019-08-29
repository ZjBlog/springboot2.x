package spring.springboot2;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Test15 {


    public static void main1(String[] args) {
        Stack<Integer> stack=new Stack<>();
        // 栈后进先出
        //向栈内压入一个成员
        stack.push(12);
        stack.push(13);
        stack.push(14);
        System.out.println(stack);

        //取出栈顶元素，不删除 null 报错
        Integer peek = stack.peek();
        System.out.println(peek);
        //取出栈顶元素并删除 null 报错
        Integer pop = stack.pop();
        System.out.println(pop);



        System.out.println(stack);

    }

    @Test
    public void test(){
        Queue<String> queue = new LinkedList<String>();
        queue.add("22");
        queue.offer("44");

        queue.remove();

        queue.remove();

        String element1 = queue.peek();
        System.out.println(element1);

        System.out.println(queue);
    }
}
