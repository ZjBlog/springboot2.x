package spring.springboot2.exercise.zeren;

/**
 * @author : ZJ
 * @date : 19-5-30 下午4:37
 */

/**
 * 实现此接口的所有类,在注入此接口的时候  都会注入
 */
public interface Filter {
    /**
     * 用于对各个任务节点进行过滤
     */
    boolean filter(Integer task);
}
