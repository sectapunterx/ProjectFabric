package Fabric.Interface.Arrival;

import Fabric.Arrival;
import Fabric.Dao.ArrivalDao;

import javax.swing.*;
import java.sql.SQLException;
import java.util.Date;

public class UpdateArrivalDialog extends JDialog {
    private JTextField arrivalCodeField;
    private JTextField modelCodeField;
    private JTextField arrivalDateField;
    private JTextField quantityReceiptField;
    private JTextField acceptReceiptField;



    public UpdateArrivalDialog(JFrame parent) {
        super(parent, "Обновить прибытие", true);
        // TODO: Добавьте ваш код здесь для инициализации текстовых полей
        arrivalCodeField = new JTextField(20);
        modelCodeField = new JTextField(20);
        arrivalDateField = new JTextField(20);
        quantityReceiptField = new JTextField(20);
        acceptReceiptField = new JTextField(20);

        JButton okButton = new JButton("OK");
        okButton.addActionListener(e -> {
            int arrivalCode = Integer.parseInt(arrivalCodeField.getText());
            int modelCode = Integer.parseInt(modelCodeField.getText());
            Date arrivalDate = java.sql.Date.valueOf(arrivalDateField.getText());  // Предполагая формат даты как 'yyyy-mm-dd'
            int quantityReceipt = Integer.parseInt(quantityReceiptField.getText());
            String acceptReceipt = acceptReceiptField.getText();

            Arrival arrival = new Arrival(arrivalCode, modelCode, arrivalDate, quantityReceipt, acceptReceipt);
            ArrivalDao arrivalDao = new ArrivalDao();
            try {
                arrivalDao.updateArrival(arrival);
                JOptionPane.showMessageDialog(this, "Arrival code: " + arrivalCode + " -> Arrival code: " + arrival.getCodeReceipt()
                        + "\nModel code: " + modelCode + " -> Model code: " + arrival.getCodeModel()
                        + "\nArrival date: " + arrivalDate + " -> Arrival date: " + arrival.getDateReceipt()
                        + "\nQuantity receipt: " + quantityReceipt + " -> Quantity receipt: " + arrival.getQuantityReceipt()
                        + "\nAccept receipt: " + acceptReceipt + " -> Accept receipt: " + arrival.getAcceptReceipt());
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Ошибка обновления прибытия", "Ошибка", JOptionPane.ERROR_MESSAGE);
            }

            dispose();
        });

        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        add(new JLabel("Код прибытия:"));
        add(arrivalCodeField);
        add(new JLabel("Код модели:"));
        add(modelCodeField);
        add(new JLabel("Дата прибытия:"));
        add(arrivalDateField);
        add(new JLabel("Количество поставки:"));
        add(quantityReceiptField);
        add(new JLabel("Принято:"));
        add(acceptReceiptField);
        add(okButton);

        setSize(300, 200); // Задаём размер окна
        setLocationRelativeTo(parent); // Располагаем окно по центру относительно родительского
        pack();
    }
}