package Fabric;

import java.util.List;

public class Model {
    private int code;
    private String nameModel;
    private int codeProduct;
    private double priceModel;
    private List<Arrival> arrivals;

    public Model(int code, String nameModel, int codeProduct, double priceModel) {
        this.code = code;
        this.nameModel = nameModel;
        this.codeProduct = codeProduct;
        this.priceModel = priceModel;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
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
        return "Model code: " + code + "\n" +
                "Model name: " + nameModel + "\n" +
                "Product code: " + codeProduct + "\n" +
                "Price: " + priceModel;
    }
}
