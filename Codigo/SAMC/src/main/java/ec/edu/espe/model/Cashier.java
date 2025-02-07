package ec.edu.espe.model;

import java.util.Map;

public class Cashier {

    public void updateInventory(Map<String, Integer> order, Map<String, Integer> inventory) {
        for (Map.Entry<String, Integer> entry : order.entrySet()) {
            String item = entry.getKey();
            int quantity = entry.getValue();
            if (inventory.containsKey(item)) {
                inventory.put(item, inventory.get(item) - quantity);
            }
        }
    }

}
