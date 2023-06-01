package Fabric.Interface;

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

            System.out.println("------AddModelDialog------");
            System.out.println("Model code: " + modelCode);
            System.out.println("Model name: " + modelName);
            System.out.println("Product code: " + productCode);
            System.out.println("Model price: " + modelPrice);


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

