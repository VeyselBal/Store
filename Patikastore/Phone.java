package Patikastore;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class Phone extends Products {

    private int battery;
    private String color;
    private int camera;
    public static LinkedHashMap<Integer, Phone> phonelist = new LinkedHashMap<>();
    private int phoneNumber = 0;
    private static HashSet<Integer> phoneID = new HashSet<>();
    private final Scanner inp = new Scanner(System.in);

    public Phone(int id, int price, int discountRate, int stok, String productName, String brand, int ram, int capacity, double display, int battery, String color, int camera) {
        super(id, price, discountRate, stok, productName, brand, ram, capacity, display);
        this.battery = battery;
        this.color = color;
        this.camera = camera;
    }

    public Phone() {
        super();
    }

    @Override
    public void menu() {
        System.out.println("1 - Cep telefonalarý listele" + "\n" +
                "2 - Cep telefonu ekle" + "\n" +
                "3 - Cep telefonu sil" + "\n" +
                "4 - Cep telefonu ID ye göre filtreleme");
        int number = inp.nextInt();
        switch (number) {
            case 1 -> show();
            case 2 -> addProducts();
            case 3 -> delete();
            case 4 -> search();
        }
    }

    @Override
    public void search() {
        System.out.println("Arayacaðýnýz ID girin");
        int number = inp.nextInt();
        if (phoneID.contains(number)) {
            System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
            System.out.println("| ID | Ürün Adý                  | Fiyatý          | Markasý         | Stoðu        | Ýndirim Oraný      | RAM    | Ekran Boyutu      | Hafýzasý   | Pil Kapasitesi  | Renk           | Kamera    |");
            System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");

            System.out.printf("| %-2s | %-25s | %-15s | %-15s | %-12s | %-18s | %-6s | %-17s | %-10s | %-15s | %-14s | %-9s | \n",
                    phonelist.get(number).getId(),
                    phonelist.get(number).getProductName(),
                    phonelist.get(number).getPrice(),
                    phonelist.get(number).getBrand(),
                    phonelist.get(number).getStok(),
                    phonelist.get(number).getDiscountRate(),
                    phonelist.get(number).getRam(),
                    phonelist.get(number).getDisplay(),
                    phonelist.get(number).getCapacity(),
                    phonelist.get(number).getBattery(),
                    phonelist.get(number).getColor(),
                    phonelist.get(number).getCamera());
            System.out.println();
        }else{
            System.out.println("Böyle bir ID de ürün yoktur.");
        }
    }

    @Override
    public void show() {
        System.out.println("Cep telefonu listesi");
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("| ID | Ürün Adý                  | Fiyatý          | Markasý         | Stoðu        | Ýndirim Oraný      | RAM    | Ekran Boyutu      | Hafýzasý   | Pil Kapasitesi  | Renk           | Kamera    |");
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");

        for (Phone phone : phonelist.values()) {
            System.out.printf("| %-2s | %-25s | %-15s | %-15s | %-12s | %-18s | %-6s | %-17s | %-10s | %-15s | %-14s | %-9s | \n",
                    phone.getId(),
                    phone.getProductName(),
                    phone.getPrice(),
                    phone.getBrand(),
                    phone.getStok(),
                    phone.getDiscountRate(),
                    phone.getRam(),
                    phone.getDisplay(),
                    phone.getCapacity(),
                    phone.getBattery(),
                    phone.getColor(),
                    phone.getCamera());

        }
        System.out.println();
    }

    @Override
    public void delete() {
        System.out.println("Hangi ürünü silecekseniz ID sini giriniz: ");
        int number = inp.nextInt();
        phonelist.remove(number);
        phoneID.remove(number);
        show();
    }

    @Override
    public void addProducts() {

        System.out.print("Ürünün id'sini giriniz: ");
        int number = inp.nextInt();
        control(number);

        System.out.print("Ürünün fiyatýný giriniz: ");
        int price = inp.nextInt();

        System.out.print("Ürünün indirim oranýný giriniz: ");
        int discountRate = inp.nextInt();

        System.out.print("Ürünün stoðunu giriniz: ");
        int stok = inp.nextInt();

        System.out.print("Ürünün ismini giriniz: ");
        String productName = inp.nextLine();
        productName = inp.nextLine();

        System.out.println("Ürünün Markasýný seçiniz");
        for (Brand brand : Brand.brands) {
            System.out.print(brand.getName() + " ");
        }
        System.out.println();
        String brand = inp.nextLine();

        System.out.print("Ürünün ramini giriniz: ");
        int ram = inp.nextInt();

        System.out.print("Ürünün depolama alanýný giriniz: ");
        int capacity = inp.nextInt();

        System.out.print("Ürünün ekran boyutunu giriniz: ");
        double display = inp.nextDouble();

        System.out.print("Ürünün batarya kapasitesini giriniz: ");
        int battery = inp.nextInt();

        System.out.print("Ürünün kamerasýný giriniz: ");
        int camera = inp.nextInt();

        System.out.println("Ürünün Rengini giriniz");
        String color = inp.nextLine();
        color = inp.nextLine();

        phoneNumber = number;
        phonelist.put(phoneNumber, new Phone(number, price, discountRate, stok, productName, brand, ram, capacity, display, battery, color, camera));
    }

    private void control(int control) {
        while (phoneID.contains(control)) {
            System.out.print("Bu ID zaten kullanýlmýþ. Lütefen tekrar ID girin : ");
            control = inp.nextInt();
        }
        phoneID.add(control);
    }

    public int getBattery() {
        return battery;
    }

    public void setBattery(int battery) {
        this.battery = battery;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getCamera() {
        return camera;
    }

    public void setCamera(int camera) {
        this.camera = camera;
    }
}

