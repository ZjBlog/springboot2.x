package spring.springboot2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spring.springboot2.entity.Color;
import spring.springboot2.entity.UserBot;
import spring.springboot2.repository.UserBotRepository;


/**
 * @Transactional事务使用总结：
 *
 * 1、异常在A方法内抛出，则A方法就得加注解
 *
 * 2、多个方法嵌套调用，如果都有 @Transactional 注解，则产生事务传递，默认 Propagation.REQUIRED
 *
 * 3、如果注解上只写 @Transactional  默认只对 RuntimeException 回滚,非RuntimeException异常不回回滚
 * 如果要对 checked Exceptions 进行回滚，则需要 @Transactional(rollbackFor = Exception.class)
 * 空指针属于运行时异常
 * 加不加rollbackFor = Exception.class 都会对RuntimeException回滚
 *
/**
 * @author : ZJ
 * @date : 19-6-21 下午5:35
 */
@Service
public class TransactionalService {

    @Autowired
    private UserBotRepository userBotRepository;


    /**
     * 没有回滚
     * @throws Exception
     */
    @Transactional
    public void testSysConfig() throws Exception {
        UserBot userBot=new UserBot();
        userBot.setColor(Color.BLUE);
        userBot.setReadIs("99");
        userBotRepository.save(userBot);
        throw new Exception("sysconfig error");
    }


    /**
     * 回滚了
     * @throws Exception
     */
    @Transactional(rollbackFor = Exception.class)
    public void testSysConfig1() throws Exception {
        UserBot userBot=new UserBot();
        userBot.setColor(Color.BLUE);
        userBot.setReadIs("9999");
        userBotRepository.save(userBot);
        throw new Exception("sysconfig error");
    }

    /**
     * 回滚了
     * @throws Exception
     */
    //@Transactional
    @Transactional(rollbackFor = Exception.class)
    public void testSysConfig2() throws Exception {
        UserBot userBot=new UserBot();
        userBot.setColor(Color.BLUE);
        userBot.setReadIs("999911");
        userBotRepository.save(userBot);
        throw new RuntimeException("sysconfig error");

    }

    /**
     * 回滚了
     * @throws Exception
     */
    @Transactional
    public void testSysConfig4() throws Exception {
        UserBot userBot=new UserBot();
        userBot.setColor(Color.BLUE);
        userBot.setReadIs("999911999999");
        userBotRepository.save(userBot);
        if(userBot!=null) {
            Integer ii=null;
            int i = ii;
        }
    }
}
