package Fabric.Interface;

<<<<<<< Updated upstream
=======
import Fabric.Arrival;
import Fabric.Dao.ArrivalDao;
import Fabric.Dao.ModelDao;
import Fabric.Dao.ProductDao;
>>>>>>> Stashed changes
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
<<<<<<< Updated upstream
=======
import Fabric.Model;
import Fabric.Product;
>>>>>>> Stashed changes

import javax.swing.*;

public class MainWindow extends JFrame {
    private JButton addProductButton;
<<<<<<< Updated upstream
=======
    private JButton allProductButton;
    private JButton allModelButton;
    private JButton allArrivalButton;
>>>>>>> Stashed changes
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

<<<<<<< Updated upstream
=======
        //------------------------------PRODUCT---------------------------------------

        allProductButton = new JButton("Получить все товары");
        allProductButton.addActionListener(e -> {
            ProductDao productDao = new ProductDao();
            try {
                List<Product> productList = productDao.getAllProducts();

                // Создаем модель таблицы и добавляем ее в JTable
                DefaultTableModel model = getTableProduct(productList);
                JTable table = new JTable(model);

                // Создаем JScrollPane и добавляем в него JTable
                JScrollPane scrollPane = new JScrollPane(table);

                // Отображаем JScrollPane в диалоговом окне
                JOptionPane.showMessageDialog(this, scrollPane);
            } catch (SQLException ex) {
                // TODO: Обработка ошибки работы с базой данных
            }
        });

>>>>>>> Stashed changes
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
<<<<<<< Updated upstream
        });*/
=======
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

                // Создаем JScrollPane и добавляем в него JTable
                JScrollPane scrollPane = new JScrollPane(table);

                // Отображаем JScrollPane в диалоговом окне
                JOptionPane.showMessageDialog(this, scrollPane);
            } catch (SQLException ex) {

            }
        });
>>>>>>> Stashed changes

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

        //------------------------------ARRIVAL (SUPPLY)---------------------------------------
        allArrivalButton = new JButton("Получить все поставки");
        allArrivalButton.addActionListener(e -> {
            ArrivalDao arrivalDao = new ArrivalDao();
            try {
                List<Arrival> arrivalList = arrivalDao.getAllArrivals();

                // Создаем модель таблицы и добавляем ее в JTable
                DefaultTableModel model = getTableArrival(arrivalList);
                JTable table = new JTable(model);

                // Создаем JScrollPane и добавляем в него JTable
                JScrollPane scrollPane = new JScrollPane(table);

                // Отображаем JScrollPane в диалоговом окне
                JOptionPane.showMessageDialog(this, scrollPane);
            } catch (SQLException ex) {

            }
        });

        addSupplyButton = new JButton("Добавить поставку");
        addSupplyButton.addActionListener(e -> {
            AddSupplyDialog dialog = new AddSupplyDialog(this); // AddSupplyDialog предполагается реализованным аналогично AddProductDialog
            dialog.setVisible(true);
        });

<<<<<<< Updated upstream
=======
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
        //modelButtonPanel.add(GetModelButton);


        JPanel supplyButtonPanel = new JPanel(new FlowLayout());
        supplyButtonPanel.add(allArrivalButton);
        supplyButtonPanel.add(addSupplyButton);
        //supplyButtonPanel.add(DeleteArrivalButton);
        //supplyButtonPanel.add(UpdateArrivalButton);
        //supplyButtonPanel.add(GetArrivalButton);

>>>>>>> Stashed changes
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
<<<<<<< Updated upstream
=======

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
            o[0] = models.getCodeModel();
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
            o[0] = arrival.getCodeReceipt();
            o[1] = arrival.getCodeModel();
            o[2] = arrival.getDateReceipt();
            o[3] = arrival.getQuantityReceipt();
            o[4] = arrival.getAcceptReceipt();
            model.addRow(o);
        }

        return model;
    }
>>>>>>> Stashed changes
}