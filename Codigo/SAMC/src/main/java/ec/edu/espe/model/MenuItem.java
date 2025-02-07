package ec.edu.espe.model;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import ec.edu.espe.controller.MongoDBManager;
import java.util.ArrayList;
import java.util.List;
import org.bson.Document;

public class MenuItem {

    public static List<MenuItem> loadMenuItems() {
        List<MenuItem> menuItems = new ArrayList<>();
        MongoClient client = MongoDBManager.getMongoClient();
        if (client == null) {
            return menuItems;
        }
        MongoDatabase database = client.getDatabase("SAMC");
        MongoCollection<Document> collection = database.getCollection("comida");
        FindIterable<Document> documents = collection.find();
        for (Document doc : documents) {
            int id = doc.getInteger("ID");
            String name = doc.getString("Nombre");
            String descrition = doc.getString("Descripcion");
            Number price = doc.get("Precio", Number.class);
            float priceFloat = price != null ? price.floatValue() : 0.0F;
            int inventory = doc.getInteger("Inventario");
            MenuItem menuItem = new MenuItem(id, name, descrition, priceFloat, inventory);
            menuItems.add(menuItem);
        }
        return menuItems;
    }

    private String name;
    private String description;
    private float price;
    private int id;
    private int inventory;

    public MenuItem(int id, String name, String description, float price, int inventory) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.inventory = inventory;
    }

    public static MenuItem getMenuItemById(int id, List<MenuItem> menuItems) {
        for (MenuItem item : menuItems) {
            if (item.id == id) {
                return item;
            }
        }
        return null;
    }

    public static MenuItem getMenuItemByName(String name, List<MenuItem> menuItems) {
        for (MenuItem item : menuItems) {
            if (item.getName().equalsIgnoreCase(name)) {
                return item;
            }
        }
        return null;
    }
    
    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public float getPrice() {
        return price;
    }

    public int getInventory() {
        return inventory;
    }

    public int getId() {
        return id;
    }
}
