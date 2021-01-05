package test.designepattern.state;

/**
 * @author XXX
 * @site www.muddywater.com
 * @company muddywater .corp
 * @create 2020-12-16 1:54
 * 在状态模式（State Pattern）中，类的行为是基于它的状态改变的。这种类型的设计模式属于行为型模式。
 * 在状态模式中，我们创建表示各种状态的对象和一个行为随着状态对象改变而改变的 context 对象。
 * 介绍
 * 主要解决：对象的行为依赖于它的状态（属性），并且可以根据它的状态改变而改变它的相关行为。
 * 何时使用：代码中包含大量与对象状态有关的条件语句。
 * 如何解决：将各种具体的状态类抽象出来。
 * 关键代码：通常命令模式的接口中只有一个方法。而状态模式的接口中有一个或者多个方法。而且，状态模式的实现类的方法，
 * 一般返回值，或者是改变实例变量的值。也就是说，状态模式一般和对象的状态有关。实现类的方法有不同的功能，覆盖接口中的方法。
 * 状态模式和命令模式一样，也可以用于消除 if…else 等条件选择语句。
 */
public class Context {

    private State state;

    public Context() {
        state = null;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }
    public static void main(String[] args) {
        Context context = new Context();

        StartState startState = new StartState();
        startState.doAction(context);

        System.out.println(context.getState().toString());
        System.out.println();

        StopState stopState = new StopState();
        stopState.doAction(context);

        System.out.println(context.getState().toString());
    }

}