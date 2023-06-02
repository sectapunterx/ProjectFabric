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
                //вывод на экран сообщением информации о товаре
                JOptionPane.showMessageDialog(this, "Информация о товаре: \n" + product.toString(), "Информация о товаре", JOptionPane.INFORMATION_MESSAGE);
            } catch (SQLException ex) {
                // TODO: Добавьте ваш код здесь для обработки ошибки получения товара
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Ошибка", JOptionPane.ERROR_MESSAGE);
            }
            dispose();
        });

        // TODO: Добавьте ваш код здесь для создания и настройки макета диалогового окна

        setLayout(new BoxLayout(getContentPane(), BoxLayout.X_AXIS));
        add(new JLabel("Код товара:"));
        add(productCodeField);
        add(okButton);

        setSize(300, 200); // Задаём размер окна
        setLocationRelativeTo(parent); // Располагаем окно по центру относительно родительского
        pack();
    }
}