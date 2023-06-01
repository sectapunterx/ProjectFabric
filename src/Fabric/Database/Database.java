package Fabric.Database;

import Fabric.Arrival;
import Fabric.Model;
import Fabric.Product;

import java.util.ArrayList;
import java.util.List;

public class Database {
    private List<Product> products;
    private List<Arrival> arrivals;
    private  List<Model> models;

    public Database() {
        this.products = new ArrayList<>();
    }

    // методы для Product
    public void addProduct(Product product) {
        products.add(product);
    }

    public void removeProduct(Product product) {
        products.remove(product);
    }

    public Product getProduct(int code) {
        for (Product product : products) {
            if (product.getCode() == code) {
                return product;
            }
        }
        return null;
    }

    // методы для Arrival
    public void addArrival(Arrival arrival) {
        arrivals.add(arrival);
    }
    public void removeArrival(Arrival arrival) {
        arrivals.remove(arrival);
    }
    public Arrival getArrival(int codeReceipt) {
        for (Arrival arrival : arrivals) {
            if (arrival.getCodeReceipt() == codeReceipt) {
                return arrival;
            }
        }
        return null;
    }

    // методы для Model
    public void addModel(Model model) {
        models.add(model);
    }
    public void removeModel(Model model) {
        models.remove(model);
    }
    public Model getModel(int codeModel) {
        for (Model model : models) {
            if (model.getCodeModel() == codeModel) {
                return model;
            }
        }
        return null;
    }



}
