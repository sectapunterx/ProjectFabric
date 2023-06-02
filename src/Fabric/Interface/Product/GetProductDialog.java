package Fabric.Interface.Product;

import Fabric.Dao.ProductDao;
import Fabric.Product;

import javax.swing.*;
import java.sql.SQLException;

public class GetProductDialog extends JDialog {
    private JTextField productCodeField;

    public GetProductDialog(JFrame parent) {
        super(parent, "Получить товар", true);

        productCodeField = new JTextField(20);

        JButton okButton = new JButton("OK");
        okButton.addActionListener(e -> {
            int productCode = Integer.parseInt(productCodeField.getText());

            ProductDao productDao = new ProductDao();
            try {
                Product product = productDao.getProduct(productCode);
                // TODO: Добавьте ваш код здесь для отображения информации о полученном товаре
            } catch (SQLException ex) {
                // TODO: Добавьте ваш код здесь для обработки ошибки получения товара
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Ошибка", JOptionPane.ERROR_MESSAGE);
            }
            dispose();
        });

        // TODO: Добавьте ваш код здесь для создания и настройки макета диалогового окна
    }
}