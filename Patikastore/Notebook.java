package Patikastore;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class Notebook extends Products {

    public static LinkedHashMap<Integer, Notebook> notebooklist = new LinkedHashMap<>();
    private int notebookNumber = 0;
    private static HashSet<Integer> notebookID = new HashSet<>();
    private Scanner inp = new Scanner(System.in);

    public Notebook(int id, int price, int stok, int discountRate, String productName, String brand, int ram, int capacity, double display) {
        super(id, price, discountRate, stok, productName, brand, ram, capacity, display);
    }

    public Notebook() {
    }

    @Override
    public void menu() {
        System.out.println("1 - Notebooklarý listele" + "\n" +
                "2 - Notebook ekle" + "\n" +
                "3 - Notebook sil" + "\n" +
                "4 - Notebooklarý ID ye göre filtreleme");
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
        if (notebookID.contains(number)) {
            System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------");
            System.out.println("| ID | Ürün Adý                  | Fiyatý          | Markasý         | Stoðu        | Ýndirim Oraný      | RAM    | Ekran Boyutu      | Hafýzasý   |");
            System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------");

            System.out.printf("| %-2s | %-25s | %-15s | %-15s | %-12s | %-18s | %-6s | %-17s | %-10s | \n",
                    notebooklist.get(number).getId(),
                    notebooklist.get(number).getProductName(),
                    notebooklist.get(number).getPrice(),
                    notebooklist.get(number).getBrand(),
                    notebooklist.get(number).getStok(),
                    notebooklist.get(number).getDiscountRate(),
                    notebooklist.get(number).getRam(),
                    notebooklist.get(number).getDisplay(),
                    notebooklist.get(number).getCapacity());
        } else {
            System.out.println("Böyle bir ID de ürün yoktur.");
        }
    }

    @Override
    public void show() {
        System.out.println("Notebook listesi");
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("| ID | Ürün Adý                  | Fiyatý          | Markasý         | Stoðu        | Ýndirim Oraný      | RAM    | Ekran Boyutu      | Hafýzasý   |");
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------");

        for (Notebook notebook : notebooklist.values()) {
            System.out.printf("| %-2s | %-25s | %-15s | %-15s | %-12s | %-18s | %-6s | %-17s | %-10s | \n",
                    +notebook.getId(),
                    notebook.getProductName(),
                    notebook.getPrice(),
                    notebook.getBrand(),
                    notebook.getStok(),
                    notebook.getDiscountRate(),
                    notebook.getRam(),
                    notebook.getDisplay(),
                    notebook.getCapacity());
        }
        System.out.println();
    }

    @Override
    public void delete() {
        System.out.println("Hangi ürünü silecekseniz ID sini giriniz: ");
        int number = inp.nextInt();
        notebooklist.remove(number);
        notebookID.remove(number);
        show();
    }

    @Override
    public void addProducts() {

        System.out.print("Ürünün id'sini giriniz: ");
        int numbers = inp.nextInt();
        control(numbers);

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
        String brand = inp.nextLine();

        System.out.print("Ürünün ramini giriniz: ");
        int ram = inp.nextInt();

        System.out.print("Ürünün depolama alanýný giriniz: ");
        int capacity = inp.nextInt();

        System.out.print("Ürünün ekran boyutunu giriniz: ");
        double n = inp.nextDouble();

        notebookNumber = numbers;
        notebooklist.put(notebookNumber, new Notebook(numbers, price, stok, discountRate, productName, brand, ram, capacity, n));
    }

    private void control(int control) {
        while (notebookID.contains(control)) {
            System.out.print("Bu ID zaten kullanýlmýþ. Lütefen tekrar ID girin : ");
            control = inp.nextInt();
        }
        notebookID.add(control);
    }
}
