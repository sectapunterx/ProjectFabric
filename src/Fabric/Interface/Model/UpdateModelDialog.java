package Fabric.Interface.Model;

import Fabric.Dao.ModelDao;
import Fabric.Model;

import javax.swing.*;
import java.sql.SQLException;

public class UpdateModelDialog extends JDialog {
    private JTextField modelCodeField;
    private JTextField modelNameField;
    private JTextField productCodeField;
    private JTextField modelPriceField;

    public UpdateModelDialog(JFrame parent) {
        super(parent, "Обновить модель", true);
        // TODO: Добавьте ваш код здесь для инициализации текстовых полей

        JButton okButton = new JButton("OK");
        okButton.addActionListener(e -> {
            int modelCode = Integer.parseInt(modelCodeField.getText());
            String modelName = modelNameField.getText();
            int productCode = Integer.parseInt(productCodeField.getText());
            double modelPrice = Double.parseDouble(modelPriceField.getText());

            Model model = new Model(modelCode, modelName, productCode, modelPrice);
            ModelDao modelDao = new ModelDao();
            try {
                modelDao.updateModel(model);
                // TODO: Добавьте ваш код здесь для уведомления пользователя об успешном обновлении
            } catch (SQLException ex) {
                // TODO: Добавьте ваш код здесь для обработки ошибки обновления
            }

            dispose();
        });

        // TODO: Добавьте ваш код здесь для создания и настройки макета диалогового окна
    }
}