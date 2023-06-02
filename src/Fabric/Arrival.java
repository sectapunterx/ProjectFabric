package Fabric;

import java.util.Date;

public class Arrival {

    private int codeReceipt;
    private int codeModel;
    private Date dateReceipt;
    private int quantityReceipt;
    private String acceptReceipt;

    public Arrival(int codeReceipt, int codeModel, Date dateReceipt, int quantityReceipt, String acceptReceipt) {
        this.codeReceipt = codeReceipt;
        this.codeModel = codeModel;
        this.dateReceipt = dateReceipt;
        this.quantityReceipt = quantityReceipt;
        this.acceptReceipt = acceptReceipt;
    }

    public int getCodeReceipt() {
        return codeReceipt;
    }

    public void setCodeReceipt(int codeReceipt) {
        this.codeReceipt = codeReceipt;
    }

    public int getCodeModel() {
        return codeModel;
    }

    public void setCodeModel(int codeModel) {
        this.codeModel = codeModel;
    }

    public Date getDateReceipt() {
        return dateReceipt;
    }

    public void setDateReceipt(Date dateReceipt) {
        this.dateReceipt = dateReceipt;
    }

    public int getQuantityReceipt() {
        return quantityReceipt;
    }

    public void setQuantityReceipt(int quantityReceipt) {
        this.quantityReceipt = quantityReceipt;
    }

    public String getAcceptReceipt() {
        return acceptReceipt;
    }

    public void setAcceptReceipt(String acceptReceipt) {
        this.acceptReceipt = acceptReceipt;
    }
}
