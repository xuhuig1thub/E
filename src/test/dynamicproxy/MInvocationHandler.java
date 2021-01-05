package test.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 * @author XXX
 * @site www.muddywater.com
 * @company muddywater .corp
 * @create 2020-12-12 21:24
 */
public class MInvocationHandler  implements InvocationHandler
{
    private Object obj;

    public MInvocationHandler(Object tar) {
        this.obj = tar;
    }


    public Object invoke(Object proxy , Method method , Object[] args)throws Throwable
    {
        Object result ;
        System.out.println("Arrays.asList(method.getDeclaredAnnotations()) = " + Arrays.asList(method.getDeclaredAnnotations()));
        if(method.isAnnotationPresent(CustomizedAnno.class)){
            System.out.println("hasAnnotation"); return "";}
        //这里就可以进行所谓的AOP编程了
        //在调用具体函数方法前，执行功能处理
        System.out.println("before");
        if(args!=null) {
            System.out.println(Arrays.asList(args));
            if (args[0].equals("AOF"))
                args[0] = "HAHA-" + args[0];
            if (args[0].equals("RDB"))
                args[0] = "XIXI-" + args[0];
            if (args[0].equals("bgsave"))
                args[0] = "HEHE-" + args[0];
        }else{
//            args=new String[1];
//            args[0]="balabala";
            //Exception in thread "main" java.lang.IllegalArgumentException: wrong number of arguments
        }


        result = method.invoke(obj,args);
        System.out.println("after");
        //在调用具体函数方法后，执行功能处理
        return result;
    }

    public static void main(String args[])
    {
        Subject sub=new RealSubject();
        MInvocationHandler subInvocationHandler = new MInvocationHandler(sub);
        //绑定该类实现的所有接口
        Subject subproxy = (Subject) Proxy.newProxyInstance(RealSubject.class.getClassLoader(),
                RealSubject.class.getInterfaces(),
                subInvocationHandler);
        subproxy.doSomething("AOF");
        subproxy.doAnother("RDB");
        subproxy.doSecond("bgsave");
        System.out.println("---------------");
        MInvocationHandler helloInvocationHandler = new MInvocationHandler(new Hello());
        MInvocationHandler byeInvocationHandler = new MInvocationHandler(new Bye());
        HelloInterface helloProxy = (HelloInterface) Proxy.newProxyInstance(Hello.class.getClassLoader(),
                Hello.class.getInterfaces(), helloInvocationHandler);

        ByeInterface byeProxy = (ByeInterface) Proxy.newProxyInstance(Bye.class.getClassLoader(),
                Bye.class.getInterfaces(), byeInvocationHandler);
        helloProxy.sayHello();
        byeProxy.sayBye();
    }
}