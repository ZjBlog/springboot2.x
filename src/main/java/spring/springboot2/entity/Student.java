package spring.springboot2.entity;

/**
 * 1. 被复制的类需要实现Clonenable接口（不实现的话在调用clone方法会抛出CloneNotSupportedException异常)， 该接口为标记接口(不含任何方法)
 *
 * 2. 覆盖clone()方法，访问修饰符设为public。方法中调用super.clone()方法得到需要的复制对象。（native为本地方法)
 */

/**
 * 1、浅克隆
 * 在浅克隆中，如果原型对象的成员变量是值类型，将复制一份给克隆对象；
 * 如果原型对象的成员变量是引用类型，则将引用对象的地址复制一份给克隆对象，
 * 也就是说原型对象和克隆对象的成员变量指向相同的内存地址。
 *
 * 简单来说，在浅克隆中，当对象被复制时只复制它本身和其中包含的值类型的成员变量，而引用类型的成员对象并没有复制。
 */

/**
 * 在深克隆中，无论原型对象的成员变量是值类型还是引用类型，都将复制一份给克隆对象，
 * 深克隆将原型对象的所有引用对象也复制一份给克隆对象。
 *
 * 简单来说，在深克隆中，除了对象本身被复制外，对象所包含的所有成员变量也将复制。
 */
public class Student implements Cloneable{

    private String name;

    private Integer age;

    private Address address;

    @Override
    public Object clone() {
        Student stu = null;
        try{
            stu = (Student)super.clone();
        }catch(CloneNotSupportedException e) {
            e.printStackTrace();
        }
        stu.address = (Address)address.clone();   //深度复制
        return stu;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
