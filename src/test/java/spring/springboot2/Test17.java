package spring.springboot2;

public class Test17 {

    private static int x = 100;

    public static void main(String[] args) {

        for(Short  i =0;i<100;i++){

        }

    }

}

class Base {
    void test() {
        System.out.println("00");
    }

    public float getNum(){
        return 3f;
    };
}

class Child extends Base {

    void test() {
        System.out.println(6 + 6 + "dd");


        String aStr = " One ";
        String bStr = aStr;
        String s = aStr.toUpperCase();
        aStr.trim();
        System.out.println("[" + aStr + "," + bStr + "]");
    aStr.indexOf('d');

        int[] d = new int[25];
        System.out.println(d[24]);
    }
}

class C1 extends Base{
   protected   void test(){}
}