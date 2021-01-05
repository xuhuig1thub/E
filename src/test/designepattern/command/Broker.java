package test.designepattern.command;

import java.util.ArrayList;
import java.util.List;

/**
 * @author XXX
 * @site www.muddywater.com
 * @company muddywater .corp
 * @create 2020-12-16 1:59
 * 命令模式（Command Pattern）是一种数据驱动的设计模式，它属于行为型模式。请求以命令的形式包裹在对象中，并传给调用对象。
 * 调用对象寻找可以处理该命令的合适的对象，并把该命令传给相应的对象，该对象执行命令。
 * 意图：将一个请求封装成一个对象，用不同的请求对客户行为进行参数化。
 * 主要解决：在软件系统中，行为请求者与行为实现者通常是一种紧耦合的关系，但某些场合，比如需要对行为进行记录、撤销或重做、
 * 事务等处理时，这种无法抵御变化的紧耦合的设计就不太合适。
 *在这种情况下，如何将"行为请求者"与"行为实现者"解耦 将一组行为抽象为对象，可以实现二者之间的松耦合。
 * 如何解决：通过调用者调用接受者执行命令，顺序：调用者→接受者→命令。
 */
public class Broker {

    private List<Order> orderList = new ArrayList<>();

    public void addOrder(Order order) {
        orderList.add(order);
    }

    public void executeOrders() {
        for (Order order : orderList) {
            order.execute();
        }
        orderList.clear();
    }
    public static void main(String[] args) {
        Stock stock = new Stock();

        BuyStockOrder buyStockOrder = new BuyStockOrder(stock);
        SellStockOrder sellStock = new SellStockOrder(stock);

        Broker broker = new Broker();
        broker.addOrder(buyStockOrder);
        broker.addOrder(sellStock);

        broker.executeOrders();
    }
}
