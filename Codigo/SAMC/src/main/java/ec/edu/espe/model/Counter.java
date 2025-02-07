package ec.edu.espe.model;

import java.util.List;
import java.util.Map;

public class Counter {

    public float calculateTotal(Map<String, Integer> order, List<MenuItem> menuItems) {
        float total = 0.0f;
        for (Map.Entry<String, Integer> entry : order.entrySet()) {
            MenuItem item = MenuItem.getMenuItemByName(entry.getKey(), menuItems);
            if (item != null) {
                total += item.getPrice() * entry.getValue();
            }
        }
        return total;
    }
}
