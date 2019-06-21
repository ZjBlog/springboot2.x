package spring.springboot2.entity;

import lombok.Data;

/**
 * @author : ZJ
 * @date : 19-6-21 下午4:30
 */

/**
 * 枚举类型的每一个值都映射到protected Enum(String name,int ordinal)构造函数中，
 * 在这里，每个值的名称都转换成一个字符串，并且序数设置表示了此设置被创建的顺序。 从0开始
 */
public enum Color {
    RED,GREEN,BLUE;
}
