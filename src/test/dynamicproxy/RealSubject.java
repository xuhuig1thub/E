package test.dynamicproxy;

/**
 * @author XXX
 * @site www.muddywater.com
 * @company muddywater .corp
 * @create 2020-12-12 21:23
 */
public class RealSubject implements Subject,SecondSub
{
    public void doSomething(String str)
    {
        System.out.println( "do ->"+str );
    }
    public void doAnother(String str){
        System.out.println("do Another ->"+str);

    }
    public void doSecond(String str){
        System.out.println("do doSecond ->"+str);

    }
}
