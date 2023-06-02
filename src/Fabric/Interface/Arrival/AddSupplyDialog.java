package Fabric.Interface.Arrival;

import Fabric.Arrival;
import Fabric.Dao.ArrivalDao;

import javax.swing.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

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

            // Convert the string input to the appropriate data types.
            int supplyCodeInt = Integer.parseInt(supplyCode);
            int modelCodeInt = Integer.parseInt(modelCode);
            int supplyQuantityInt = Integer.parseInt(supplyQuantity);

            // Assume the date is in the format yyyy-mm-dd.
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date parsed = null;
            try {
                parsed = format.parse(supplyDate);
            } catch (ParseException ex) {
                ex.printStackTrace();
            }
            java.sql.Date supplyDateSql = new java.sql.Date(parsed.getTime());

            // Create a new Arrival and add it using ArrivalDao.
            Arrival arrival = new Arrival(supplyCodeInt, modelCodeInt, supplyDateSql, supplyQuantityInt, supplyAcceptedBy);
            ArrivalDao arrivalDao = new ArrivalDao();
            try {
                arrivalDao.addArrival(arrival);
                JOptionPane.showMessageDialog(this, "Поставка успешно добавлена!\n" +
                        "Supply code: " + supplyCode + "\n" +
                        "Model code: " + modelCode + "\n" +
                        "Supply date: " + supplyDate + "\n" +
                        "Supply quantity: " + supplyQuantity + "\n" +
                        "Supply accepted by: " + supplyAcceptedBy, "Успех", JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Ошибка при добавлении поставки: " + ex.getMessage(), "Ошибка", JOptionPane.ERROR_MESSAGE);
            }

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

