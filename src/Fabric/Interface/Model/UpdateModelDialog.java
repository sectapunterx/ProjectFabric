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

        modelCodeField = new JTextField(20);
        modelNameField = new JTextField(20);
        productCodeField = new JTextField(20);
        modelPriceField = new JTextField(20);

        JButton okButton = new JButton("Обновить модель");
        okButton.addActionListener(e -> {
            int modelCode = Integer.parseInt(modelCodeField.getText());
            String modelName = modelNameField.getText();
            int productCode = Integer.parseInt(productCodeField.getText());
            double modelPrice = Double.parseDouble(modelPriceField.getText());

            Model model = new Model(modelCode, modelName, productCode, modelPrice);
            ModelDao modelDao = new ModelDao();
            try {
                Model previousModel = modelDao.getModel(modelCode);
                modelDao.updateModel(model);
                // Информирование пользователя об успешном обновлении
                JOptionPane.showMessageDialog(this, "Model code: " + previousModel.getCodeModel() + " -> Model code: " + model.getCodeModel()
                        + "\nModel name: " + previousModel.getNameModel() + " -> Model name: " + model.getNameModel()
                        + "\nProduct code: " + previousModel.getCodeProduct() + " -> Product code: " + model.getCodeProduct()
                        + "\nModel price: " + previousModel.getPriceModel() + " -> Model price: " + model.getPriceModel());

            } catch (SQLException ex) {
                // Обработка ошибки обновления
                JOptionPane.showMessageDialog(this, "Ошибка обновления модели", "Ошибка", JOptionPane.ERROR_MESSAGE);
                //Вывести в чем именно ошибка
                ex.printStackTrace();
            }

            dispose();
        });

        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        add(new JLabel("Код модели:"));
        add(modelCodeField);
        add(new JLabel("Наименование модели:"));
        add(modelNameField);
        add(new JLabel("Код товара:"));
        add(productCodeField);
        add(new JLabel("Цена модели:"));
        add(modelPriceField);
        add(okButton);

        setSize(300, 200); // Задаём размер окна
        setLocationRelativeTo(parent); // Располагаем окно по центру относительно родительского
        pack();
    }
}