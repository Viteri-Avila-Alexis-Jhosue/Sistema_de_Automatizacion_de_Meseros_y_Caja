package ec.edu.espe.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Order {

    private List<MenuItem> orderedItems;

    public Order() {

        this.orderedItems = new ArrayList<>();
    }

    public Order(Map<String, Integer> items) {
        
        this.orderedItems = new ArrayList<>();
    }    

    public Map<String, Integer> getItems() {
        Map<String, Integer> itemsMap = new HashMap<>();
        for (MenuItem item : getOrderedItems()) {
            itemsMap.put(item.getName(), 1);
        }
        return itemsMap;
    }

    
    

    public List<MenuItem> getOrderedItems() {
        return orderedItems;
    }

    public void setOrderedItems(List<MenuItem> orderedItems) {
        this.orderedItems = orderedItems;
    }

    @Override
    public String toString() {
        StringBuilder itemsDetails = new StringBuilder();
        for (MenuItem item : getOrderedItems()) {
            itemsDetails.append(item.getName()).append("\n");
        }
        return "Order{" +
                ", orderedItems=\n" + itemsDetails +
                '}';
    }
}