package spring.springboot2.leetCode;

/**
 * @author : ZJ
 * @date : 19-8-22 下午2:20
 */
public class FooBar {

    private int n;
    //private volatile boolean finish=false;

    private volatile Integer lock=0;
    public FooBar(int n) {
        this.n = n;
        this.lock=2*n;
    }

    public void foo() {

        for (int i = 0; i < n; i++) {

            // printFoo.run() outputs "foo". Do not change or remove this line.
            // printFoo.run();
//            while(finish){
//                Thread.yield();
//            }

            while(this.lock%2 == 1){

            }
            System.out.print("foo");
            this.lock--;
//            finish=true;
        }
    }

    public void bar() {

        for (int i = 0; i < n; i++) {
//            while (!finish){
//                Thread.yield();
//            }

            while(this.lock%2 == 0){

            }
            System.out.print("bar");
            this.lock--;
            // finish=false;
            // printBar.run() outputs "bar". Do not change or remove this line.
            // printBar.run();
        }
    }
}
