public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        /*CREATE TABLE products (
    code SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL
);

CREATE TABLE models (
    codeModel SERIAL PRIMARY KEY,
    nameModel VARCHAR(100) NOT NULL,
    codeProduct INTEGER NOT NULL,
    priceModel DECIMAL(10,2) NOT NULL,
    FOREIGN KEY (codeProduct) REFERENCES products(code) ON DELETE CASCADE
);

CREATE TABLE arrivals (
    codeReceipt SERIAL PRIMARY KEY,
    codeModel INTEGER NOT NULL,
    dateReceipt DATE NOT NULL,
    quantityReceipt INTEGER NOT NULL,
    acceptReceipt VARCHAR(100) NOT NULL,
    FOREIGN KEY (codeModel) REFERENCES models(codeModel) ON DELETE CASCADE
);*/
    }
}
