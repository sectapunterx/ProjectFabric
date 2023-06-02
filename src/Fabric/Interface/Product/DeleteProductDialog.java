package Fabric.Interface.Product;

import Fabric.Dao.ProductDao;

import javax.swing.*;
import java.sql.SQLException;

public class DeleteProductDialog extends JDialog {
    private JTextField productCodeField;

    public DeleteProductDialog(JFrame parent) {
        super(parent, "Удалить товар", true);

        productCodeField = new JTextField(20);

        JButton okButton = new JButton("OK");
        okButton.addActionListener(e -> {
            int productCode = Integer.parseInt(productCodeField.getText());

            ProductDao productDao = new ProductDao();
            try {
                productDao.deleteProduct(productCode);
                // TODO: Добавьте ваш код здесь для уведомления пользователя об успешном удалении
            } catch (SQLException ex) {
                // TODO: Добавьте ваш код здесь для обработки ошибки удаления
            }

            dispose();
        });

        // TODO: Добавьте ваш код здесь для создания и настройки макета диалогового окна
    }
}