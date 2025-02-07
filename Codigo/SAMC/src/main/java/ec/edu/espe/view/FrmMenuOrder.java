/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ec.edu.espe.view;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import ec.edu.espe.controller.MongoDBManager;
import ec.edu.espe.model.Counter;
import ec.edu.espe.model.MenuItem;
import ec.edu.espe.model.Order;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.bson.Document;

public class FrmMenuOrder extends javax.swing.JFrame {

    /**
     * Creates new form FrmMenuPedido
     */
    private Order order;
    FindIterable<Document> documents;
    List<MenuItem> menuItems = new ArrayList<>();
    Map<String, Integer> orderedItems = new HashMap<>();

    public FrmMenuOrder() {
        initComponents();
        this.setLocationRelativeTo(null);
        loadDataMongoDB();
        loadNamesInComboBox();
        order = new Order(new HashMap<>());
    }

    //CARGAR DATOS DE MONGO
    private void loadDataMongoDB() {
        MongoClient client = MongoDBManager.getMongoClient();
        if (client == null) {
            JOptionPane.showMessageDialog(this, "No se pudo conectar a MongoDB", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        MongoDatabase database = client.getDatabase("SAMC");
        MongoCollection<Document> collection = database.getCollection("comida");
        
        documents = collection.find();
        
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID");
        model.addColumn("Nombre");
        model.addColumn("Descripción");
        model.addColumn("Precio");
        model.addColumn("Inventario");
        
        for (Document doc : documents) {
            Object[] row = new Object[5];
            row[0] = doc.getInteger("ID");
            row[1] = doc.getString("Nombre");
            row[2] = doc.getString("Descripcion");
            Number price = doc.get("Precio", Number.class);
            row[3] = price != null ? price.doubleValue() : null;
            row[4] = doc.getInteger("Inventario");
            model.addRow(row);
            
            int id = doc.getInteger("ID");
            String name = doc.getString("Nombre");
            String descrition = doc.getString("Descripcion");
            float priceFloat = price != null ? price.floatValue() : 0f;
            int inventory = doc.getInteger("Inventario");
            MenuItem menuItem = new MenuItem(id, name, descrition, priceFloat, inventory);
            menuItems.add(menuItem);
        }
        tblContent.setModel(model);
    }

    //CARGAR NOMBRES DE PLATILLOS EN COMBO BOX
    private void loadNamesInComboBox() {
        MongoClient client = MongoDBManager.getMongoClient();
        
        if (client == null) {
            JOptionPane.showMessageDialog(this, "No se pudo conectar a MongoDB", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        MongoDatabase database = client.getDatabase("SAMC");
        MongoCollection<Document> collection = database.getCollection("comida");
        
        FindIterable<Document> documents = collection.find();
        
        cbDish.removeAllItems();
        
        for (Document doc : documents) {
            String nombre = doc.getString("Nombre");
            if (nombre != null) {
                cbDish.addItem(nombre);
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnGoBack = new javax.swing.JToggleButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblContent = new javax.swing.JTable();
        cbDish = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        spQuantity = new javax.swing.JSpinner();
        jLabel2 = new javax.swing.JLabel();
        btnAdd = new javax.swing.JToggleButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        txtIdCard = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        txtPhoneNumber = new javax.swing.JTextField();
        txtAddress = new javax.swing.JTextField();
        btnOrder = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));

        btnGoBack.setText("Atras");
        btnGoBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGoBackActionPerformed(evt);
            }
        });

        tblContent.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(tblContent);

        cbDish.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Platillo");

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Cantidad");

        btnAdd.setText("Añadir");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Nombre");

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Cedula");

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Correo electronico");

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Telefono");

        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Direccion");

        txtName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNameActionPerformed(evt);
            }
        });

        txtIdCard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdCardActionPerformed(evt);
            }
        });

        txtAddress.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAddressActionPerformed(evt);
            }
        });

        btnOrder.setText("Ordenar");
        btnOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOrderActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 540, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel7)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cbDish, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(spQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(btnAdd, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtName)
                            .addComponent(txtEmail)
                            .addComponent(txtPhoneNumber)
                            .addComponent(txtAddress)
                            .addComponent(txtIdCard)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnGoBack, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnOrder)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbDish, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(spQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAdd)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtIdCard, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPhoneNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 376, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGoBack)
                    .addComponent(btnOrder))
                .addGap(0, 7, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //ANIADE LOS PRODUCTOS A LA LISTA
    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        String dishName = (String) cbDish.getSelectedItem();
        int quantity = (int) spQuantity.getValue();

        if (dishName != null && quantity > 0) {
            MongoDatabase database = MongoDBManager.getDatabase();

            if (database == null) {
                JOptionPane.showMessageDialog(this, "Error al conectar con la base de datos", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            MongoCollection<Document> foodCollection = database.getCollection("comida");
            Document food = foodCollection.find(new Document("Nombre", dishName)).first();

            if (food != null) {
                int currentInventory = food.getInteger("Inventario");

                if (currentInventory >= quantity) {

                    if (orderedItems.containsKey(dishName)) {
                        int currentQuantity = orderedItems.get(dishName);
                        orderedItems.put(dishName, currentQuantity + quantity);
                    } else {
                        orderedItems.put(dishName, quantity);
                    }

                    StringBuilder listStringBuilder = new StringBuilder();
                    for (Map.Entry<String, Integer> entry : orderedItems.entrySet()) {
                        listStringBuilder.append("Plato: ").append(entry.getKey()).append(", Cantidad: ").append(entry.getValue()).append("\n");
                    }
                    String listString = listStringBuilder.toString();

                    JOptionPane.showMessageDialog(this, "Platillo añadido a la orden: \n" + listString, "Información", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(this, "No hay suficiente inventario para el plato seleccionado", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Plato no encontrado en la base de datos", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Selecciona un plato y una cantidad válida", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void txtNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNameActionPerformed

    //REVISA LOS DATOS DEL CLIENTE, AÑADE TODOS LOS PEDIDOS AL CLIENTE, GENERA LA ORDEN Y RESTA EL INVENTARIO, ACTUALIZA EL MONGO
    private void btnOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOrderActionPerformed

        String customerName = txtName.getText().trim();
        String customerId = txtIdCard.getText().trim();
        String customerEmail = txtEmail.getText().trim();
        String customerContactNumber = txtPhoneNumber.getText().trim();
        String customerAddress = txtAddress.getText().trim();

        if (customerName.isEmpty() || customerId.isEmpty() || customerEmail.isEmpty() || customerContactNumber.isEmpty() || customerAddress.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Completa todos los campos del cliente", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (!customerName.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]+")) {
            JOptionPane.showMessageDialog(this, "El nombre solo puede contener letras y espacios", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (!customerId.matches("\\d{10}")) {
            JOptionPane.showMessageDialog(this, "La cédula debe tener 10 dígitos", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (!customerEmail.matches("^[^@\\s]+@[^@\\s]+\\.[^@\\s]+$")) {
            JOptionPane.showMessageDialog(this, "El correo electrónico no es válido", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (!customerContactNumber.matches("\\d{10}")) {
            JOptionPane.showMessageDialog(this, "El teléfono debe tener 10 dígitos", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            if (order == null) {
                order = new Order();
            }

            for (Map.Entry<String, Integer> entry : orderedItems.entrySet()) {
                String dishName = entry.getKey();
                int quantity = entry.getValue();

                MongoDatabase database = MongoDBManager.getDatabase();
                if (database == null) {
                    JOptionPane.showMessageDialog(this, "Error al conectar con la base de datos", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                MongoCollection<Document> foodCollection = database.getCollection("comida");
                Document food = foodCollection.find(new Document("Nombre", dishName)).first();

                if (food != null) {
                    int currentInventory = food.getInteger("Inventario");

                    if (currentInventory >= quantity) {
                        foodCollection.updateOne(
                                new Document("Nombre", dishName),
                                new Document("$inc", new Document("Inventario", -quantity))
                        );
                    } else {
                        JOptionPane.showMessageDialog(this, "Inventario insuficiente para " + dishName, "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Plato no encontrado en la base de datos", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }

            float total = new Counter().calculateTotal(orderedItems, menuItems);

            MongoClient client = MongoDBManager.getMongoClient();
            if (client == null) {
                JOptionPane.showMessageDialog(this, "No se pudo conectar a MongoDB", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (client == null) {
                JOptionPane.showMessageDialog(this, "No se pudo conectar a MongoDB", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            MongoDatabase database = client.getDatabase("SAMC");
            MongoCollection<Document> collection = database.getCollection("ordenes");

            Document ordenDoc = new Document();
            ordenDoc.put("nombreCliente", customerName);
            ordenDoc.put("cedulaCliente", customerId);
            ordenDoc.put("correoCliente", customerEmail);
            ordenDoc.put("telefonoCliente", customerContactNumber);
            ordenDoc.put("direccionCliente", customerAddress);

            List<Document> platillosDocs = new ArrayList<>();
            for (Map.Entry<String, Integer> entry : orderedItems.entrySet()) {
                Document platilloDoc = new Document();
                platilloDoc.put("nombre", entry.getKey());
                platilloDoc.put("cantidad", entry.getValue());
                platillosDocs.add(platilloDoc);
            }
            ordenDoc.put("platos", platillosDocs);

            System.out.println("Guardando orden: " + ordenDoc.toJson());

            try {
                collection.insertOne(ordenDoc);
                int selectedOption = JOptionPane.showOptionDialog(
                        null,
                        "Pedido realizado con éxito. Total: $" + total + "\nElija su metodo de pago:",
                        "Terminar Orden",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        new Object[]{"Pago en efectivo", "Pago por transferencia"},
                        "Pago en efectivo");

                if (selectedOption == JOptionPane.YES_OPTION) {
                    JOptionPane.showMessageDialog(this, "Acerquese a caja para pagar su orden \nGracias por su compra", "Pago en efectivo", JOptionPane.INFORMATION_MESSAGE);
                    new FrmMainMenu().setVisible(true);
                    dispose();
                } else if (selectedOption == JOptionPane.NO_OPTION) {
                    new FrmBankDetails().setVisible(true);
                    dispose();
                }
            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Error al guardar la orden: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }

            txtName.setText("");
            txtIdCard.setText("");
            txtEmail.setText("");
            txtPhoneNumber.setText("");
            txtAddress.setText("");
            cbDish.setSelectedIndex(0);
            spQuantity.setValue(0);
            orderedItems.clear();

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "El ID del cliente debe ser un número válido", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error inesperado: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnOrderActionPerformed

    private void btnGoBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGoBackActionPerformed
        new FrmMainMenu().setVisible(true);
        dispose();
    }//GEN-LAST:event_btnGoBackActionPerformed

    private void txtIdCardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdCardActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdCardActionPerformed

    private void txtAddressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAddressActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAddressActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmMenuOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmMenuOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmMenuOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmMenuOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmMenuOrder().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton btnAdd;
    private javax.swing.JToggleButton btnGoBack;
    private javax.swing.JToggleButton btnOrder;
    private javax.swing.JComboBox<String> cbDish;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSpinner spQuantity;
    private javax.swing.JTable tblContent;
    private javax.swing.JTextField txtAddress;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtIdCard;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtPhoneNumber;
    // End of variables declaration//GEN-END:variables
}
