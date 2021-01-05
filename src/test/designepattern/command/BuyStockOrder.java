package test.designepattern.command;

/**
 * @author XXX
 * @site www.muddywater.com
 * @company muddywater .corp
 * @create 2020-12-16 2:00
 */
public class BuyStockOrder implements Order {

    private Stock stock;

    public BuyStockOrder(Stock abcStock) {
        this.stock = abcStock;
    }

    @Override
    public void execute() {
        stock.buy();
    }
}
