package Fabric.Interface;

import Fabric.Interface.Arrival.AddSupplyDialog;
import Fabric.Interface.Arrival.DeleteArrivalDialog;
import Fabric.Interface.Arrival.GetArrivalDialog;
import Fabric.Interface.Arrival.UpdateArrivalDialog;
import Fabric.Interface.Model.AddModelDialog;
import Fabric.Interface.Model.DeleteModelDialog;
import Fabric.Interface.Model.GetModelDialog;
import Fabric.Interface.Model.UpdateModelDialog;
import Fabric.Interface.Product.AddProductDialog;
import Fabric.Interface.Product.DeleteProductDialog;
import Fabric.Interface.Product.GetProductDialog;
import Fabric.Interface.Product.UpdateProductDialog;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {
    private JButton addProductButton;
    private JButton addModelButton;
    private JButton addSupplyButton;
    private JButton DeleteProductButton;
    private JButton DeleteModelButton;
    private JButton DeleteArrivalButton;
    private JButton UpdateProductButton;
    private JButton UpdateModelButton;
    private JButton UpdateArrivalButton;
    private JButton GetProductButton;
    private JButton GetModelButton;
    private JButton GetArrivalButton;

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
        DeleteProductButton = new JButton("Удалить товар");
        DeleteProductButton.addActionListener(e -> {
            DeleteProductDialog dialog = new DeleteProductDialog(this);
            dialog.setVisible(true);
        });
        UpdateProductButton = new JButton("Обновить товар");
        UpdateProductButton.addActionListener(e -> {
            UpdateProductDialog dialog = new UpdateProductDialog(this);
            dialog.setVisible(true);
        });
        GetProductButton = new JButton("Получить товар");
        GetProductButton.addActionListener(e -> {
            GetProductDialog dialog = new GetProductDialog(this);
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

        JPanel productButtonPanel = new JPanel(new FlowLayout());
        productButtonPanel.add(addProductButton);
        productButtonPanel.add(DeleteProductButton);
        productButtonPanel.add(UpdateProductButton);
        productButtonPanel.add(GetProductButton);

        JPanel modelButtonPanel = new JPanel(new FlowLayout());
        modelButtonPanel.add(addModelButton);
        //modelButtonPanel.add(DeleteModelButton);
        //modelButtonPanel.add(UpdateModelButton);
        //modelButtonPanel.add(GetModelButton);

        JPanel supplyButtonPanel = new JPanel(new FlowLayout());
        supplyButtonPanel.add(addSupplyButton);
        //supplyButtonPanel.add(DeleteArrivalButton);
        //supplyButtonPanel.add(UpdateArrivalButton);
        //supplyButtonPanel.add(GetArrivalButton);

        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        add(productButtonPanel);
        add(modelButtonPanel);
        add(supplyButtonPanel);
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MainWindow window = new MainWindow();
            window.setVisible(true);
        });
    }
}