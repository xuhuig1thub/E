package test.juc;

/**
 * @author XXX
 * @site www.muddywater.com
 * @company muddywater .corp
 * @create 2020-12-15 15:05
 */
public class ClassMate {
    String s;
    String name;

    public ClassMate(String name) {
        this.name = name;
    }

    public ClassMate(String s, String name) {
        this.s = s;
        this.name = name;
    }

    public String getS() {
        return s;
    }

    public void setS(String s) {
        this.s = s;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "ClassMate{" +
                "s='" + s + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
