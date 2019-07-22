package spring.springboot2.leetCode;

import java.util.Stack;

/**
 * @author : ZJ
 * @date : 19-7-16 下午2:56
 */
public class MinStack {

    private Stack<Integer> stack;
    private Stack<Integer> minStack;

    public MinStack() {
        stack = new Stack<Integer>();
        minStack = new Stack<Integer>();
    }

    public void push(int number) {
        stack.push(number);
        if(minStack.isEmpty() || minStack.peek()>=number){
            minStack.push(number);
        }
    }
    public int pop() {
        if (stack.peek().equals(minStack.peek()) ){
            minStack.pop();
        }
        return stack.pop();
    }
    public int top(){
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
