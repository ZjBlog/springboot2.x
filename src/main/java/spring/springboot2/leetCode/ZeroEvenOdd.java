package spring.springboot2.leetCode;

/**
 * @author : ZJ
 * @date : 19-8-22 下午2:51
 */
public class ZeroEvenOdd {

    private int n;


    private volatile boolean flag=true;

    private volatile boolean flag1=false;

    private volatile boolean flag2=false;


    public ZeroEvenOdd(int n) {
        this.n = n;
    }

    public void zero() {

        for(int i=0;i<n;i++){
            while (!flag){
                Thread.yield();
            }
            System.out.print(0);
            this.flag=false;
            if(i%2==0){
                this.flag1=true;
            }else{
                this.flag2=true;
            }

        }

    }

    public void even()  {
        for(Integer i=1;i<=n;i+=2){
            while (!flag1){
                Thread.yield();
            }
            System.out.print(i);
            this.flag1=false;
            this.flag=true;

        }
    }

    public void odd(){
        for(Integer i=2;i<=n;i+=2){
            while (!flag2){
                Thread.yield();
            }
            System.out.print(i);
            this.flag2=false;
            this.flag=true;
        }
    }
}
