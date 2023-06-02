package Fabric.Interface.Arrival;

import Fabric.Dao.ArrivalDao;

import javax.swing.*;

public class DeleteArrivalDialog extends JDialog {
    private JTextField arrivalCodeField;

    public DeleteArrivalDialog(JFrame parent) {
        super(parent, "Удалить поступление", true);

        arrivalCodeField = new JTextField(20);

        JButton okButton = new JButton("OK");
        okButton.addActionListener(e -> {
            int arrivalCode = Integer.parseInt(arrivalCodeField.getText());
            //TODO: probably fix
            ArrivalDao arrivalDao = new ArrivalDao();
            try {
                arrivalDao.deleteArrival(arrivalCode);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(DeleteArrivalDialog.this, ex.getMessage(), "Ошибка", JOptionPane.ERROR_MESSAGE);
            }
            dispose();
        });
    }

}
