package test.designepattern.command;

/**
 * @author XXX
 * @site www.muddywater.com
 * @company muddywater .corp
 * @create 2020-12-16 2:00
 */
public class Stock {

    private String name = "ABC";
    private int quantity = 10;

    public void buy() {
        System.out.println("Stock [ Name: " + name + ", Quantity:" + quantity + " ]bought ");
    }

    public void sell() {
        System.out.println("Stock [ Name: " + name + ", Quantity:" + quantity + " ]sold ");
    }

}
