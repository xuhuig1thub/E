package test.dynamicproxy;

/**
 * @author XXX
 * @site www.muddywater.com
 * @company muddywater .corp
 * @create 2020-12-12 21:54
 */
public class Hello implements HelloInterface{
    @CustomizedAnno
    @Override
    public void sayHello() {
        System.out.println("Hello zhanghao!");
    }
}