package Patikastore;

import java.util.Comparator;
import java.util.TreeSet;

public class Brand {
    private int id;
    private String name;
    public static TreeSet<Brand> brands = new TreeSet<>(new Comparator<Brand>() {
        @Override
        public int compare(Brand o1, Brand o2) {
            return o1.getName().compareTo(o2.getName());
        }
    });

    public Brand(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Brand() {

    }

    static {
        brands.add(new Brand(1, "Samsung"));
        brands.add(new Brand(2, "Lenovo"));
        brands.add(new Brand(3, "Apple"));
        brands.add(new Brand(4, "Huawei"));
        brands.add(new Brand(5, "Casper"));
        brands.add(new Brand(6, "Asus"));
        brands.add(new Brand(7, "HP"));
        brands.add(new Brand(8, "Xiaomi"));
        brands.add(new Brand(9, "Monster"));
    }

    public void showBrands() {
        System.out.println("Markalarýmýz");
        System.out.println("--------------------");
        for (Brand brand : brands) {
            System.out.println(" - " + brand.getName());
        }
        System.out.println();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
