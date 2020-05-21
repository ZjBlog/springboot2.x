package spring.springboot2.reactorHandler;

import org.springframework.stereotype.Component;
import reactor.event.Event;
import reactor.spring.annotation.Selector;

/**
 * @author zhangjun486
 * @version 1.0
 * @date 2020/5/21 15:32
 */
@Component
public class UserInfoRectorHandler {

    /**
     * 具体执行异步操作的方法，注意方法上的注解value中的名字要和一会调用这个方法的key一至
     * reactor中的则是指定刚才的库名，你也可以指定其他的但是前提得先创建
     *
     * @param e
     * @throws InterruptedException
     */
    @Selector(value = "getUserMessage", reactor = "@reactor")
    public void getUserMessage(Event<String> e) throws InterruptedException {
        /*
         * 获取传入的参数-可以是：String,Integer,Map及model层实体类，目前我只实验了这些
         * 下面的就好理解了，我就不多说了
         */
        Thread.sleep(2000);
        System.out.println(">>>>>>>>>>>>>>>邮件已成功发送" + e.getData());

    }

    @Selector(value = "resultMessage", reactor = "@reactor2")
    public void resultInt(Event<Integer> e) throws InterruptedException {
        for (int i = 0; i < e.getData(); i++) {
            Thread.sleep(1000);
            System.out.println(i + "打印时间：" + i);
        }
    }

}
