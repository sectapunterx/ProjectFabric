package Fabric.Interface.Model;

import Fabric.Dao.ModelDao;

import javax.swing.*;

public class DeleteModelDialog extends JDialog {
    private JTextField modelCodeField;

    public DeleteModelDialog(JFrame parent) {
        super(parent, "Удалить модель", true);

        modelCodeField = new JTextField(20);

        JButton okButton = new JButton("OK");
        okButton.addActionListener(e -> {
            int modelCode = Integer.parseInt(modelCodeField.getText());
            //TODO: probably fix
            ModelDao modelDao = new ModelDao();
            try {
                modelDao.deleteModel(modelCode);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(DeleteModelDialog.this, ex.getMessage(), "Ошибка", JOptionPane.ERROR_MESSAGE);
            }
            dispose();
        });
    }
}