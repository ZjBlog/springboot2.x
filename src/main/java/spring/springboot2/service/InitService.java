package spring.springboot2.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * 在IOC的容器的启动过程，当所有的bean都已经处理完成之后，spring ioc容器会有一个发布事件的动作。
 * 从 AbstractApplicationContext 的源码中就可以看出
 * 当ioc容器加载处理完相应的bean之后，也给我们提供了一个机会（先有InitializingBean，
 * 后有ApplicationListener<ContextRefreshedEvent>），可以去做一些自己想做的事。其实这也就是spring ioc容器给提供的一个扩展的地方。我们可以这样使用这个扩展机制。
 *
 */

/**
 * 一个最简单的方式就是，让我们的bean实现ApplicationListener接口，
 * 这样当发布事件时，[spring]的ioc容器就会以容器的实例对象作为事件源类，
 * 并从中找到事件的监听者，此时ApplicationListener接口实例中的onApplicationEvent(E event)方法就会被调用，
 * 我们的逻辑代码就会写在此处。这样我们的目的就达到了
 *
 */
@Component
public class InitService implements ApplicationListener<ContextRefreshedEvent> {

    private static final Logger log= LoggerFactory.getLogger(InitService.class);

    /**
     * 系统会存在两个容器，一个是root application context ,另一个就是我们自己的
     * projectName-servlet context（作为root application context的子容器） web环境才会有
     * 这种情况下，就会造成onApplicationEvent方法被执行两次
     * 。为了避免上面提到的问题，
     * 我们可以只在root application context初始化完成后调用逻辑代码，其他的容器的初始化完成，则不做任何处理
     * @param contextRefreshedEvent
     */
    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        log.info("=============init");
        //root application context 没有parent
        if (contextRefreshedEvent.getApplicationContext().getParent() == null) {
            log.info("==========register computer to zookeeper");
        }
    }
}
