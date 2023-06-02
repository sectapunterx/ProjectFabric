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
        DeleteArrivalButton = new JButton("Удалить товар");
        DeleteArrivalButton.addActionListener(e -> {
            DeleteProductDialog dialog = new DeleteProductDialog(this);
            dialog.setVisible(true);
        });
        /*UpdateProductButton = new JButton("Обновить товар");
        UpdateProductButton.addActionListener(e -> {
            UpdateProductDialog dialog = new UpdateProductDialog(this);
            dialog.setVisible(true);
        });
        GetProductButton = new JButton("Получить товар");
        GetProductButton.addActionListener(e -> {
            GetProductDialog dialog = new GetProductDialog(this);
            dialog.setVisible(true);
        });*/

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
        //TODO:fix errors
        /*add(DeleteProductButton);
        add(DeleteModelButton);
        add(DeleteArrivalButton);
        add(UpdateProductButton);
        add(UpdateModelButton);
        add(UpdateArrivalButton);
        add(GetProductButton);
        add(GetModelButton);
        add(GetArrivalButton);*/

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MainWindow window = new MainWindow();
            window.setVisible(true);
        });
    }
}