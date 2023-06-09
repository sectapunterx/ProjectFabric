package Fabric.Interface.Arrival;

import Fabric.Arrival;
import Fabric.Dao.ArrivalDao;

import javax.swing.*;

public class GetArrivalDialog extends JDialog {
    private JTextField arrivalCodeField;

    public GetArrivalDialog(JFrame parent) {
        super(parent, "Получить приход", true);

        arrivalCodeField = new JTextField(20);

        JButton okButton = new JButton("OK");
        okButton.addActionListener(e -> {
            int arrivalCode = Integer.parseInt(arrivalCodeField.getText());

            //probably fix
            ArrivalDao arrivalDao = new ArrivalDao();
            try {
                Arrival arrival = arrivalDao.getArrival(arrivalCode);
                JOptionPane.showMessageDialog(parent, arrival.toString(), "Информация о поступлении", JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(parent, ex.getMessage(), "Ошибка", JOptionPane.ERROR_MESSAGE);
            }
            dispose();
        });

        setLayout(new BoxLayout(getContentPane(), BoxLayout.X_AXIS));
        add(new JLabel("Код поступления:"));
        add(arrivalCodeField);
        add(okButton);

        setSize(300, 200);
        setLocationRelativeTo(parent);
        pack();
    }
}
