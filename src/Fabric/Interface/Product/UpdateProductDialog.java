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

        JButton okButton = new JButton("OK");
        okButton.addActionListener(e -> {
            int productCode = Integer.parseInt(productCodeField.getText());
            String productName = productNameField.getText();

            Product product = new Product(productCode, productName);
            ProductDao productDao = new ProductDao();
            try {
                productDao.updateProduct(product);
                // TODO: Добавьте ваш код здесь для уведомления пользователя об успешном обновлении
            } catch (SQLException ex) {
                // TODO: Добавьте ваш код здесь для обработки ошибки обновления
            }

            dispose();
        });

        // TODO: Добавьте ваш код здесь для создания и настройки макета диалогового окна
    }
}