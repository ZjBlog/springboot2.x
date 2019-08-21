package spring.springboot2;

import org.junit.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author : ZJ
 * @date : 19-8-16 下午2:44
 */
public class Test7 {

    @Test
    public void test() throws InterruptedException, ExecutionException {

        Executor executor = Executors.newFixedThreadPool(10);

        CompletionService<String> service = new ExecutorCompletionService<>(executor);

        for (int i = 0 ; i < 50 ;i++) {
            int seqNo = i;
            service.submit(new Callable<String>() {
                @Override
                public String call() throws Exception {
                    return "HelloWorld-" + seqNo + "-" + Thread.currentThread().getName();
                }
            });
        }
        for (int j = 0 ; j < 50; j++) {
            System.out.println(service.take().get());
        }
    }

   // @Test
    public void test7(){
        /**
         * 单线程化的线程池
         */
        ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 10; i++) {
            final int index = i;
            singleThreadExecutor.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println("=======================");
                    Thread.currentThread().setName("Thread i = " + index);
                    System.out.println(Thread.currentThread().getName() + " index = " + index);
                }
            });
        }
     //   singleThreadExecutor.shutdown();
        System.out.println("on the main thread...");

    }

    public static void main1(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(10);


        ThreadPoolExecutor executor = new ThreadPoolExecutor(10, 10, 1000, TimeUnit.SECONDS, new LinkedBlockingQueue(100), new ThreadPoolExecutor.DiscardPolicy());

        List<Future<Integer>> resultList = new ArrayList<Future<Integer>>();

        // 创建10个任务并执行
        for (int i = 0; i < 11; i++) {
            // 使用ExecutorService执行Callable类型的任务，并将结果保存在future变量中
            Future<Integer> future = executor.submit(new TaskWithResult());
            // 将任务执行结果存储到List中
            resultList.add(future);


            Future<Integer> submit = executor.submit(() -> 1);
            resultList.add(submit);
        }
        //executor.shutdown();


        for (Future<Integer> fs : resultList) {
            try {
                System.out.println(fs.get()); // 打印各个线程（任务）执行的结果
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                executorService.shutdownNow();
                e.printStackTrace();
            }
        }


        for (Integer i = 0; i < 100; i++) {
            executor.execute(() -> System.out.println(Thread.currentThread().getName()+"===="));
        }


System.out.println("========");
//        File file = new File("/home/zj/zj/node/html");
//        Long len = getLen(file, 0l);
//        System.out.println(len);

        executor.shutdown();
    }

    private static Long getLen(File file, Long len) {

        if (file.isDirectory()) {
            File[] files = file.listFiles();
            for (File file1 : files) {
                len += getLen(file1, len);
            }
            return len;
        } else {
            return file.length() + len;
        }
    }
}
