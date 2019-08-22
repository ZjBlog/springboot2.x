package spring.springboot2.leetCode;

/**
 * @author : ZJ
 * @date : 19-8-22 下午2:51
 */
public class ZeroEvenOdd1 {

    private int n;


    private Boolean flagOne = true;
    private Boolean flagTwo = true;


    public ZeroEvenOdd1(int n) {
        this.n = n;
    }

    public synchronized void zero() throws InterruptedException {

        for(int i=0;i<n;i++){
            while (!flagOne || !flagTwo) {
                this.wait();
            }
            System.out.print(0);
            if(i%2==0){
                flagOne = false;
            }else{
                flagTwo = false;
            }
            this.notifyAll();

        }

    }

    public synchronized void even() throws InterruptedException {
        for(Integer i=1;i<=n;i+=2){
            while (!flagOne || flagTwo) {
                this.wait();
            }
            System.out.print(i);
            flagTwo = true;
            this.notifyAll();

        }
    }

    public synchronized void odd() throws InterruptedException {
        for(Integer i=2;i<=n;i+=2){
            while (flagOne || !flagTwo) {
                this.wait();
            }
            System.out.print(i);
            flagOne = true;
            this.notifyAll();
        }
    }
}
