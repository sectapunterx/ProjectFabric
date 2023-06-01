package Fabric.Interface;

import javax.swing.*;

public class AddSupplyDialog extends JDialog {
    private JTextField supplyCodeField;
    private JTextField modelCodeField;
    private JTextField supplyDateField;
    private JTextField supplyQuantityField;
    private JTextField supplyAcceptedByField;

    public AddSupplyDialog(JFrame parent) {
        super(parent, "Добавить поставку", true);

        supplyCodeField = new JTextField(20);
        modelCodeField = new JTextField(20);
        supplyDateField = new JTextField(20);
        supplyQuantityField = new JTextField(20);
        supplyAcceptedByField = new JTextField(20);

        JButton okButton = new JButton("OK");
        okButton.addActionListener(e -> {
            String supplyCode = supplyCodeField.getText();
            String modelCode = modelCodeField.getText();
            String supplyDate = supplyDateField.getText();
            String supplyQuantity = supplyQuantityField.getText();
            String supplyAcceptedBy = supplyAcceptedByField.getText();

            System.out.println("------AddSupplyDialog------");
            System.out.println("Supply code: " + supplyCode);
            System.out.println("Model code: " + modelCode);
            System.out.println("Supply date: " + supplyDate);
            System.out.println("Supply quantity: " + supplyQuantity);
            System.out.println("Supply accepted by: " + supplyAcceptedBy);


            dispose();
        });

        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        add(new JLabel("Код поставки:"));
        add(supplyCodeField);
        add(new JLabel("Код модели:"));
        add(modelCodeField);
        add(new JLabel("Дата поставки:"));
        add(supplyDateField);
        add(new JLabel("Количество:"));
        add(supplyQuantityField);
        add(new JLabel("Принято:"));
        add(supplyAcceptedByField);
        add(okButton);

        setSize(300, 200); // Задаём размер окна
        setLocationRelativeTo(parent); // Располагаем окно по центру относительно родительского
        pack();
    }
}

