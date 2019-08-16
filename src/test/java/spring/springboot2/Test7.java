package spring.springboot2;

import java.io.File;
import java.util.concurrent.*;

/**
 * @author : ZJ
 * @date : 19-8-16 下午2:44
 */
public class Test7 {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        ThreadPoolExecutor executor = new ThreadPoolExecutor(10, 10, 1000, TimeUnit.SECONDS, new LinkedBlockingQueue(100));


//        File file = new File("/home/zj/zj/node/html");
//        Long len = getLen(file, 0l);
//        System.out.println(len);
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
