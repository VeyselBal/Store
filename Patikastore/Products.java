package Patikastore;

public abstract class Products {

    private int id;
    private int price;
    private int discountRate;
    private int stok;
    private String productName;
    private String brand;
    private int ram;
    private int capacity;
    private double display;

    public Products(int id, int price, int discountRate, int stok, String productName, String brand, int ram, int capacity, double display) {
        this.id = id;
        this.price = price;
        this.discountRate = discountRate;
        this.stok = stok;
        this.productName = productName;
        this.brand = brand;
        this.ram = ram;
        this.capacity = capacity;
        this.display = display;
    }

    public Products() {}

    public abstract void show();
    public abstract void addProducts();
    public abstract void delete();
    public abstract void menu();
    public abstract void search();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id=id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getDiscountRate() {
        return discountRate;
    }

    public void setDiscountRate(int discountRate) {
        this.discountRate = discountRate;
    }

    public int getStok() {
        return stok;
    }

    public void setStok(int stok) {
        this.stok = stok;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public double getDisplay() {
        return display;
    }

    public void setDisplay(double display) {
        this.display = display;
    }
}
