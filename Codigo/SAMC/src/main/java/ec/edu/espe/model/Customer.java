package ec.edu.espe.model;
import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String name;
    private String idCard;
    private String email;
    private String address;
    private String phoneNumber;
    private List<Order> orders;

    public Customer(String name, String idCard, String email, String address, String phoneNumbern ) {
        this.name = name;
        this.idCard = idCard;
        this.email = email;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.orders = new ArrayList<>();
    }
    @Override
    public String toString() {
        return "Customer{" + "name=" + name + ", idCard=" + idCard + ", email=" + email + ", address=" + address + ", phoneNumber=" + phoneNumber + ", orders=" + orders + '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }  
}