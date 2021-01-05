package test.designepattern.Builder;

import java.util.ArrayList;
import java.util.List;

/**
 * @author XXX
 * @site www.muddywater.com
 * @company muddywater .corp
 * @create 2020-12-16 0:39
 */
public class Meal {

    private List<Item> items = new ArrayList<>();

    public void addItem(Item item) {
        items.add(item);
    }

    public float getCost() {
        float cost = 0.0f;

        for (Item item : items) {
            cost += item.price();
        }

        return cost;
    }

    public void showItems() {
        for (Item item : items) {
            System.out.print("Item : " + item.name());
            System.out.print(", Packing : " + item.packing().pack());
            System.out.println(", Price : " + item.price());
        }
    }

}
