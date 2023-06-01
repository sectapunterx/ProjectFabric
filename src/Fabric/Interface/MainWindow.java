package Fabric.Interface;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;

public class MainWindow extends JFrame {
    private JButton addProductButton;
    private JButton addModelButton;
    private JButton addSupplyButton;

    public MainWindow() {
        setTitle("Учет продукции");
        setSize(500, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);  // Располагаем окно по центру экрана

        addProductButton = new JButton("Добавить товар");
        addProductButton.addActionListener(e -> {
            AddProductDialog dialog = new AddProductDialog(this);
            dialog.setVisible(true);
        });

        addModelButton = new JButton("Добавить модель");
        addModelButton.addActionListener(e -> {
            AddModelDialog dialog = new AddModelDialog(this); // AddModelDialog предполагается реализованным аналогично AddProductDialog
            dialog.setVisible(true);
        });

        addSupplyButton = new JButton("Добавить поставку");
        addSupplyButton.addActionListener(e -> {
            AddSupplyDialog dialog = new AddSupplyDialog(this); // AddSupplyDialog предполагается реализованным аналогично AddProductDialog
            dialog.setVisible(true);
        });

        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        add(addProductButton);
        add(addModelButton);
        add(addSupplyButton);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MainWindow window = new MainWindow();
            window.setVisible(true);
        });
    }
}