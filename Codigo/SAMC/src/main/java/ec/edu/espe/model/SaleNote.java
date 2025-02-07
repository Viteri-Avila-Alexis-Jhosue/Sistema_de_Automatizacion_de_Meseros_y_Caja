package ec.edu.espe.model;

import java.util.Map;

public class SaleNote extends TransactionReceipt {

    public SaleNote(Customer customer, Map<String, Integer> order, float total) {
        super(customer, order, total);
    }

    @Override
    public String toString() {
        StringBuilder note = new StringBuilder();
        note.append("----- Nota de Venta -----\n");

        for (Map.Entry<String, Integer> entry : getOrder().entrySet()) {
            note.append(" - Plato: ").append(entry.getKey())
                    .append(", Cantidad: ").append(entry.getValue()).append("\n");
        }

        note.append("----- Total -----\n");
        note.append("Total: $").append(String.format("%.2f", getTotal())).append("\n");
        return note.toString();
    }
}
