package test.designepattern.command;

/**
 * @author XXX
 * @site www.muddywater.com
 * @company muddywater .corp
 * @create 2020-12-16 2:00
 */
public class SellStockOrder implements Order {

    private Stock abcStock;

    public SellStockOrder(Stock abcStock) {
        this.abcStock = abcStock;
    }

    @Override
    public void execute() {
        abcStock.sell();
    }

}