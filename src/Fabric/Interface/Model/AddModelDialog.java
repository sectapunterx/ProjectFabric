package Fabric.Interface.Model;

import Fabric.Dao.ModelDao;
import Fabric.Model;

import javax.swing.*;

public class AddModelDialog extends JDialog {
    private JTextField modelCodeField;
    private JTextField modelNameField;
    private JTextField productCodeField;
    private JTextField modelPriceField;

    public AddModelDialog(JFrame parent) {
        super(parent, "Добавить модель", true);

        modelCodeField = new JTextField(20);
        modelNameField = new JTextField(20);
        productCodeField = new JTextField(20);
        modelPriceField = new JTextField(20);

        JButton okButton = new JButton("OK");
        okButton.addActionListener(e -> {
            String modelCode = modelCodeField.getText();
            String modelName = modelNameField.getText();
            String productCode = productCodeField.getText();
            String modelPrice = modelPriceField.getText();

            int modelCodeInt = Integer.parseInt(modelCode);
            int productCodeInt = Integer.parseInt(productCode);
            double modelPriceDouble = Double.parseDouble(modelPrice);

            Model model = new Model(modelCodeInt, modelName, productCodeInt, modelPriceDouble);
            ModelDao modelDao = new ModelDao();
            try {
                modelDao.addModel(model);
                JOptionPane.showMessageDialog(this, "Модель успешно добавлена!\n" +
                        "Model code: " + modelCode + "\n" +
                        "Model name: " + modelName + "\n" +
                        "Product code: " + productCode + "\n" +
                        "Model price: " + modelPrice, "Успех", JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Ошибка при добавлении модели: " + ex.getMessage(), "Ошибка", JOptionPane.ERROR_MESSAGE);
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

