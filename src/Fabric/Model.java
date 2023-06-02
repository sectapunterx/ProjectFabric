package Fabric;

import java.util.List;

public class Model {
    private int codeModel;
    private String nameModel;
    private int codeProduct;
    private double priceModel;
    private List<Arrival> arrivals;

    public Model(int codeModel, String nameModel, int codeProduct, double priceModel) {
        this.codeModel = codeModel;
        this.nameModel = nameModel;
        this.codeProduct = codeProduct;
        this.priceModel = priceModel;
    }

    public int getCodeModel() {
        return codeModel;
    }

    public void setCodeModel(int codeModel) {
        this.codeModel = codeModel;
    }

    public String getNameModel() {
        return nameModel;
    }

    public void setNameModel(String nameModel) {
        this.nameModel = nameModel;
    }

    public int getCodeProduct() {
        return codeProduct;
    }

    public void setCodeProduct(int codeProduct) {
        this.codeProduct = codeProduct;
    }

    public double getPriceModel() {
        return priceModel;
    }

    public void setPriceModel(double priceModel) {
        this.priceModel = priceModel;
    }

    public List<Arrival> getReceipts() {
        return arrivals;
    }

    public void setReceipts(List<Arrival> receipts) {
        this.arrivals = receipts;
    }

    public void addArrival(Arrival arrival) {
        arrivals.add(arrival);
    }

    public void removeArrival(Arrival arrival) {
        arrivals.remove(arrival);
    }

    @Override
    public String toString() {
        return "Model code: " + codeModel + "\n" +
                "Model name: " + nameModel + "\n" +
                "Product code: " + codeProduct + "\n" +
                "Price: " + priceModel;
    }
}
