package Fabric.Interface.Model;

import Fabric.Dao.ModelDao;

import javax.swing.*;

public class DeleteModelDialog extends JDialog {
    private JTextField modelCodeField;

    public DeleteModelDialog(JFrame parent) {
        super(parent, "Удалить модель", true);

        modelCodeField = new JTextField(20);

        JButton okButton = new JButton("Удалить модель");
        okButton.addActionListener(e -> {
            int modelCode = Integer.parseInt(modelCodeField.getText());
            //TODO: probably fix
            ModelDao modelDao = new ModelDao();
            try {
                modelDao.deleteModel(modelCode);
                JOptionPane.showMessageDialog(this, "Модель удалена", "Модель удалена", JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(DeleteModelDialog.this, ex.getMessage(), "Ошибка", JOptionPane.ERROR_MESSAGE);
            }
            dispose();
        });

        setLayout(new BoxLayout(getContentPane(), BoxLayout.X_AXIS));
        add(new JLabel("Код модели:"));
        add(modelCodeField);
        add(okButton);


        setSize(300, 200); // Задаём размер окна
        setLocationRelativeTo(parent); // Располагаем окно по центру относительно родительского
        pack();
    }
}