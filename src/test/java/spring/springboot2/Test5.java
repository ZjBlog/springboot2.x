package spring.springboot2;

public class Test5 {

    private static int dosomething(Integer i){
        try {

            i++;
            if(i/0>0){
                i++;
            }

        }catch (Exception e){
            i++;
        }
        i++;

        return  i++;
    }

    public static void main(String[] args) {
        System.out.print( dosomething(10));
    }

}
