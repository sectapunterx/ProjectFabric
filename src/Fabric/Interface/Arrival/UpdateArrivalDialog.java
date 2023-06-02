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
                // TODO: Добавьте ваш код здесь для уведомления пользователя об успешном обновлении
            } catch (SQLException ex) {
                // TODO: Добавьте ваш код здесь для обработки ошибки обновления
            }

            dispose();
        });

        // TODO: Добавьте ваш код здесь для создания и настройки макета диалогового окна
    }
}