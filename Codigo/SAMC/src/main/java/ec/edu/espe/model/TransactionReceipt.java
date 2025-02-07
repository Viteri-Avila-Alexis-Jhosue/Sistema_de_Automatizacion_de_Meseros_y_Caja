package ec.edu.espe.model;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

public abstract class TransactionReceipt {
    protected Customer customer;
    protected Map<String, Integer> order;
    protected float total;
    protected String date;

    public TransactionReceipt(Customer customer, Map<String, Integer> order, float total) {
        this.customer = customer;
        this.order = order;
        this.total = total;
        this.date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
    }

    public Customer getCustomer() {
        return customer;
    }

    public Map<String, Integer> getOrder() {
        return order;
    }

    public float getTotal() {
        return total;
    }

    public String getDate() {
        return date;
    }
    private int getMenuItemIdByName(String name) {
        return -1;
    }

    @Override
    public abstract String toString();
}