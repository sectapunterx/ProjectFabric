package Fabric.Interface.Model;

import Fabric.Dao.ModelDao;
import Fabric.Model;

import javax.swing.*;

public class GetModelDialog extends JDialog{
    private JTextField modelCodeField;

    public GetModelDialog(JFrame parent){
        super(parent, "Получить модель", true);

        modelCodeField = new JTextField(20);

        JButton okButton = new JButton("OK");
        okButton.addActionListener(e -> {
            int modelCode = Integer.parseInt(modelCodeField.getText());

            //probably fix
            ModelDao modelDao = new ModelDao();
            try {
                Model model = modelDao.getModel(modelCode);
                JOptionPane.showMessageDialog(parent, model.toString(), "Информация о модели", JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(parent, ex.getMessage(), "Ошибка", JOptionPane.ERROR_MESSAGE);
            }
            dispose();
        });

        setLayout(new BoxLayout(getContentPane(), BoxLayout.X_AXIS));
        add(new JLabel("Код модели:"));
        add(modelCodeField);
        add(okButton);

        setSize(300, 200);
        setLocationRelativeTo(parent);
        pack();
    }
}
