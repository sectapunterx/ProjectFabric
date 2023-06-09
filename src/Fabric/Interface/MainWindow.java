package Fabric.Interface;

import Fabric.Arrival;
import Fabric.Dao.ArrivalDao;
import Fabric.Dao.ModelDao;
import Fabric.Dao.ProductDao;
import Fabric.Database.DatabaseConnection;
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
import Fabric.Model;
import Fabric.Product;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.SQLException;
import java.util.List;

public class MainWindow extends JFrame {
    private JButton addProductButton;
    private JButton allProductButton;
    private JButton allModelButton;
    private JButton allArrivalButton;
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
        this.setResizable(false); // Запрещаем изменение размеров окна

        //------------------------------PRODUCT---------------------------------------

        allProductButton = new JButton("Получить все товары");
        allProductButton.addActionListener(e -> {
            ProductDao productDao = new ProductDao();
            try {
                List<Product> productList = productDao.getAllProducts();

                // Создаем модель таблицы и добавляем ее в JTable
                DefaultTableModel model = getTableProduct(productList);
                JTable table = new JTable(model);
                table.setAutoCreateRowSorter(true); // Эта строка включает сортировку

                // Создаем JScrollPane и добавляем в него JTable
                JScrollPane scrollPane = new JScrollPane(table);

                // Отображаем JScrollPane в диалоговом окне
                JOptionPane.showMessageDialog(this, scrollPane);
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Ошибка при работе с базой данных\n" + ex.getMessage());
            }
        });

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

        //------------------------------MODEL---------------------------------------
        allModelButton = new JButton("Получить все модели");
        allModelButton.addActionListener(e -> {
            ModelDao modelDao = new ModelDao();
            try {
                List<Model> modelList = modelDao.getAllModels();

                // Создаем модель таблицы и добавляем ее в JTable
                DefaultTableModel model = getTableModel(modelList);
                JTable table = new JTable(model);
                table.setAutoCreateRowSorter(true); // Эта строка включает сортировку

                // Создаем JScrollPane и добавляем в него JTable
                JScrollPane scrollPane = new JScrollPane(table);

                // Отображаем JScrollPane в диалоговом окне
                JOptionPane.showMessageDialog(this, scrollPane);
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Ошибка при работе с базой данных\n" + ex.getMessage());
            }
        });

        addModelButton = new JButton("Добавить модель");
        addModelButton.addActionListener(e -> {
            AddModelDialog dialog = new AddModelDialog(this); // AddModelDialog предполагается реализованным аналогично AddProductDialog
            dialog.setVisible(true);
        });
        DeleteModelButton = new JButton("Удалить модель");
        DeleteModelButton.addActionListener(e -> {
            DeleteModelDialog dialog = new DeleteModelDialog(this);
            dialog.setVisible(true);
        });
        UpdateModelButton = new JButton("Обновить модель");
        UpdateModelButton.addActionListener(e -> {
            UpdateModelDialog dialog = new UpdateModelDialog(this);
            dialog.setVisible(true);
        });
        GetModelButton = new JButton("Получить модель");
        GetModelButton.addActionListener(e -> {
            GetModelDialog dialog = new GetModelDialog(this);
            dialog.setVisible(true);
        });

        //------------------------------ARRIVAL (SUPPLY)---------------------------------------
        allArrivalButton = new JButton("Получить все поставки");
        allArrivalButton.addActionListener(e -> {
            ArrivalDao arrivalDao = new ArrivalDao();
            try {
                List<Arrival> arrivalList = arrivalDao.getAllArrivals();

                // Создаем модель таблицы и добавляем ее в JTable
                DefaultTableModel model = getTableArrival(arrivalList);
                JTable table = new JTable(model);
                table.setAutoCreateRowSorter(true); // Эта строка включает сортировку

                // Создаем JScrollPane и добавляем в него JTable
                JScrollPane scrollPane = new JScrollPane(table);

                // Отображаем JScrollPane в диалоговом окне
                JOptionPane.showMessageDialog(this, scrollPane);
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Ошибка при работе с базой данных\n" + ex.getMessage());
            }
        });

        addSupplyButton = new JButton("Добавить поставку");
        addSupplyButton.addActionListener(e -> {
            AddSupplyDialog dialog = new AddSupplyDialog(this); // AddSupplyDialog предполагается реализованным аналогично AddProductDialog
            dialog.setVisible(true);
        });
        DeleteArrivalButton = new JButton("Удалить поставку");
        DeleteArrivalButton.addActionListener(e -> {
            DeleteArrivalDialog dialog = new DeleteArrivalDialog(this);
            dialog.setVisible(true);
        });
        UpdateArrivalButton = new JButton("Обновить поставку");
        UpdateArrivalButton.addActionListener(e -> {
            UpdateArrivalDialog dialog = new UpdateArrivalDialog(this);
            dialog.setVisible(true);
        });
        GetArrivalButton = new JButton("Получить поставку");
        GetArrivalButton.addActionListener(e -> {
            GetArrivalDialog dialog = new GetArrivalDialog(this);
            dialog.setVisible(true);
        });

        //-------------------------------ADD BUTTONS--------------------------

        //ADD BUTTONS
        JPanel productButtonPanel = new JPanel(new FlowLayout());
        productButtonPanel.add(allProductButton);
        productButtonPanel.add(addProductButton);
        productButtonPanel.add(DeleteProductButton);
        productButtonPanel.add(UpdateProductButton);
        productButtonPanel.add(GetProductButton);

        JPanel modelButtonPanel = new JPanel(new FlowLayout());
        modelButtonPanel.add(allModelButton);
        modelButtonPanel.add(addModelButton);
        modelButtonPanel.add(DeleteModelButton);
        modelButtonPanel.add(UpdateModelButton);
        modelButtonPanel.add(GetModelButton);


        JPanel supplyButtonPanel = new JPanel(new FlowLayout());
        supplyButtonPanel.add(allArrivalButton);
        supplyButtonPanel.add(addSupplyButton);
        supplyButtonPanel.add(DeleteArrivalButton);
        supplyButtonPanel.add(UpdateArrivalButton);
        supplyButtonPanel.add(GetArrivalButton);

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

    //PRODUCTS
    public DefaultTableModel getTableProduct(List<Product> productList) {
        String[] columnNames = {"Код товара", "Наименование товара"};

        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(columnNames);

        for (Product product : productList) {
            Object[] o = new Object[2];
            o[0] = product.getCode();
            o[1] = product.getName();
            model.addRow(o);
        }

        return model;
    }

    //MODEL
    public DefaultTableModel getTableModel(List<Model> modelList) {
        String[] columnNames = {"Код модели", "Наименование модели", "Код товара", "Цена"};

        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(columnNames);

        for (Model models : modelList) {
            Object[] o = new Object[4];
            o[0] = models.getCode();
            o[1] = models.getNameModel();
            o[2] = models.getCodeProduct();
            o[3] = models.getPriceModel();
            model.addRow(o);
        }

        return model;
    }

    //ARRIVAL
    public DefaultTableModel getTableArrival(List<Arrival> arrivalList) {
        String[] columnNames = {"Код поставки", "Код модели", "Дата поставки", "Количество поставки", "Принято"};

        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(columnNames);

        for (Arrival arrival : arrivalList) {
            Object[] o = new Object[5];
            o[0] = arrival.getCode();
            o[1] = arrival.getCodeModel();
            o[2] = arrival.getDateReceipt();
            o[3] = arrival.getQuantityReceipt();
            o[4] = arrival.getAcceptReceipt();
            model.addRow(o);
        }

        return model;
    }
}