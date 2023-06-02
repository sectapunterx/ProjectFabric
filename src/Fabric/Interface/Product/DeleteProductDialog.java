package Fabric.Interface.Product;

import Fabric.Dao.ProductDao;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;

public class DeleteProductDialog extends JDialog {
    private JTextField productCodeField;

    public DeleteProductDialog(JFrame parent) {
        super(parent, "Удалить товар", true);

        productCodeField = new JTextField(20);

        JButton delButton = new JButton("Delete");
        delButton.addActionListener(e -> {
            int productCode = Integer.parseInt(productCodeField.getText());

            ProductDao productDao = new ProductDao();
            try {
                productDao.deleteProduct(productCode);
                // TODO: Добавьте ваш код здесь для уведомления пользователя об успешном удалении
                JOptionPane.showMessageDialog(this, "Товар удален", "Товар удален", JOptionPane.INFORMATION_MESSAGE);
            } catch (SQLException ex) {
                // TODO: Добавьте ваш код здесь для обработки ошибки удаления
                JOptionPane.showMessageDialog(this, "Ошибка при удалении товара: " + ex.getMessage(), "Ошибка", JOptionPane.ERROR_MESSAGE);
            }

            dispose();
        });

        // TODO: Добавьте ваш код здесь для создания и настройки макета диалогового окна
        setLayout(new BoxLayout(getContentPane(), BoxLayout.X_AXIS));
        add(new JLabel("Код товара:"));
        add(productCodeField);
        add(delButton);

        setSize(300, 200); // Задаём размер окна
        setLocationRelativeTo(parent); // Располагаем окно по центру относительно родительского
        pack();
    }
}