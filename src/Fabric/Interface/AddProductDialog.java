package Fabric.Interface;

import Fabric.Database.ProductDao;
import Fabric.Product;

import javax.swing.*;
import java.sql.SQLException;

public class AddProductDialog extends JDialog {
    private JTextField productCodeField;
    private JTextField productNameField;

    public AddProductDialog(JFrame parent) {
        super(parent, "Добавить товар", true);

        productCodeField = new JTextField(20);
        productNameField = new JTextField(20);

        JButton okButton = new JButton("OK");
        okButton.addActionListener(e -> {
            String productCode = productCodeField.getText();
            String productName = productNameField.getText();

            int productcodeint = Integer.parseInt(productCode);

            Product product = new Product(productcodeint, productName);
            ProductDao productDao = new ProductDao();
            try {
                productDao.addProduct(product);
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            dispose();
        });

        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        add(new JLabel("Код товара:"));
        add(productCodeField);
        add(new JLabel("Наименование товара:"));
        add(productNameField);
        add(okButton);

        setSize(300, 200); // Задаём размер окна
        setLocationRelativeTo(parent); // Располагаем окно по центру относительно родительского
        pack();
    }
}
