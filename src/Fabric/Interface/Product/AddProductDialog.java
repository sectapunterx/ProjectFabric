package Fabric.Interface.Product;

import Fabric.Dao.ProductDao;
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

            int productCodeInt = Integer.parseInt(productCode);

            Product product = new Product(productCodeInt, productName);
            ProductDao productDao = new ProductDao();

            try {
                productDao.addProduct(product);
                JOptionPane.showMessageDialog(this, "Товар успешно добавлен!\n" +
                        "Product code: " + productCode + "\n" +
                        "Product name: " + productName, "Успех", JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Ошибка при добавлении товара: " + ex.getMessage(), "Ошибка", JOptionPane.ERROR_MESSAGE);
            }

            dispose();
        });

        setLayout(new BoxLayout(getContentPane(), BoxLayout.X_AXIS));
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
