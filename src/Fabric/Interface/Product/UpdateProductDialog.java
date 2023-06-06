package Fabric.Interface.Product;

import Fabric.Dao.ProductDao;
import Fabric.Product;

import javax.swing.*;
import java.sql.SQLException;

public class UpdateProductDialog extends JDialog {
    private JTextField productCodeField;
    private JTextField productNameField;

    public UpdateProductDialog(JFrame parent) {
        super(parent, "Обновить товар", true);

        productCodeField = new JTextField(20);
        productNameField = new JTextField(20);

        JButton okButton = new JButton("Обновить товар");
        okButton.addActionListener(e -> {
            int productCode = Integer.parseInt(productCodeField.getText());
            String productName = productNameField.getText();

            ProductDao productDao = new ProductDao();
            try {
                Product oldProduct = productDao.getProduct(productCode);
                if (oldProduct != null) {
                    String oldProductName = oldProduct.getName();

                    Product newProduct = new Product(productCode, productName);
                    productDao.updateProduct(newProduct);

                    if (!oldProductName.equals(productName)) {
                        JOptionPane.showMessageDialog(this, "Product name: " + oldProductName + " -> Product name: " + productName, "Product Updated", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(this, "No changes were made to the product.", "Product Updated", JOptionPane.INFORMATION_MESSAGE);
                    }
                } else {
                    // TODO: Обработка ситуации, когда продукт с данным кодом не найден
                }
            } catch (SQLException ex) {
                // TODO: Обработка ошибки работы с базой данных
            }

            dispose();
        });

        // TODO: Добавьте ваш код здесь для создания и настройки макета диалогового окна

        setLayout(new BoxLayout(getContentPane(), BoxLayout.X_AXIS));
        add(new JLabel("Код товара:"));
        add(productCodeField);
        add(new JLabel("Наименование товара:"));
        add(productNameField);
        add(okButton);

        setSize(300, 200); // Задаём размер окна
        setLocationRelativeTo(parent); // Располагаем окно по центру относительно родительского
        this.setResizable(false); // Запрещаем изменение размеров окна
        pack();
    }
}