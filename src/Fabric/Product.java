package Fabric;

import java.util.List;

public class Product {
    private int code;
    private String name;
    private List<Model> models;

    public Product(int code, String name) {
        this.code = code;
        this.name = name;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getProductCode() {
        return String.valueOf(code);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Model> getModels() {
        return models;
    }

    public void setModels(List<Model> models) {
        this.models = models;
    }

    public void addModel(Model model) {
        models.add(model);
    }

    public void removeModel(Model model) {
        models.remove(model);
    }

    @Override
    public String toString() {
        return "Product code: " + code + "\n" +
                "Product name: " + name;
    }


}
