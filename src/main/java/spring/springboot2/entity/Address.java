package spring.springboot2.entity;

/**
 *
 */
public class Address implements Cloneable {
    /**
     * 4
     */
    private String add;

    public String getAdd() {
        return add;
    }

    public void setAdd(String add) {
        this.add = add;
    }

    @Override
    public Object clone() {
        Address stu = null;
        try {
            stu = (Address)super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return stu;
    }
}
