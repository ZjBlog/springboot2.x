package spring.springboot2.Test;

/**
 * @author : ZJ
 * @date : 19-8-8 上午10:48
 */
public class Example {
    String str=new String("good");
    char[] ch={'a','b','c'};


    public static void main(String[] args) {
        Example example=new Example();
        example.change(example.str,example.ch);

        System.out.println(example.str);
        System.out.println(example.ch);
    }

    public void change(String str,char ch[]){
        str="test ok";
        ch[0]='g';
    }
}
