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
                JOptionPane.showMessageDialog(DeleteArrivalDialog.this, "Поступление удалено", "Поступление удалено", JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(DeleteArrivalDialog.this, ex.getMessage(), "Ошибка", JOptionPane.ERROR_MESSAGE);
            }
            dispose();
        });

        setLayout(new BoxLayout(getContentPane(), BoxLayout.X_AXIS));
        add(new JLabel("Код поступления:"));
        add(arrivalCodeField);
        add(okButton);

        setSize(300, 200); // Задаём размер окна
        setLocationRelativeTo(parent); // Располагаем окно по центру относительно родительского
        this.setResizable(false); // Запрещаем изменение размеров окна
        pack();
    }

}
