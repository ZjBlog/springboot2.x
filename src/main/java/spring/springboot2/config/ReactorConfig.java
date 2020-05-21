package spring.springboot2.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.core.Environment;
import reactor.core.Reactor;
import reactor.core.spec.Reactors;
import reactor.event.selector.Selectors;
import reactor.spring.context.config.EnableReactor;

/**
 * @author zhangjun486
 * @version 1.0
 * @date 2020/5/20 20:09
 */
@Configuration
@EnableReactor
public class ReactorConfig {

    @Bean
    Environment env() {
        return new Environment();
    }

    /**
     * 创建一个异步执行库，其中可以有多个异步的方法
     * 这些会在Handler.class中看到
     *
     * @param env-固定格式
     * @return
     */
    @Bean(name = "reactor")
    public Reactor pathReactor(Environment env) {
        return Reactors.reactor().env(env).dispatcher(Environment.RING_BUFFER).get();
    }


    @Bean(name = "reactor2")
    public Reactor pathReactor2(Environment env) {
        Reactor reactor = Reactors.reactor().env(env).dispatcher(Environment.RING_BUFFER).get();
        reactor.on(Selectors.object("event"), event -> {
            //
            System.out.println(event.getData() + "event");
        });
        return reactor;
    }
}
