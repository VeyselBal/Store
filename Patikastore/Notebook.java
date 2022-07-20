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
        System.out.println("1 - Notebooklar� listele" + "\n" +
                "2 - Notebook ekle" + "\n" +
                "3 - Notebook sil" + "\n" +
                "4 - Notebooklar� ID ye g�re filtreleme");
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
        System.out.println("Arayaca��n�z ID girin");
        int number = inp.nextInt();
        if (notebookID.contains(number)) {
            System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------");
            System.out.println("| ID | �r�n Ad�                  | Fiyat�          | Markas�         | Sto�u        | �ndirim Oran�      | RAM    | Ekran Boyutu      | Haf�zas�   |");
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
            System.out.println("B�yle bir ID de �r�n yoktur.");
        }
    }

    @Override
    public void show() {
        System.out.println("Notebook listesi");
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("| ID | �r�n Ad�                  | Fiyat�          | Markas�         | Sto�u        | �ndirim Oran�      | RAM    | Ekran Boyutu      | Haf�zas�   |");
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
        System.out.println("Hangi �r�n� silecekseniz ID sini giriniz: ");
        int number = inp.nextInt();
        notebooklist.remove(number);
        notebookID.remove(number);
        show();
    }

    @Override
    public void addProducts() {

        System.out.print("�r�n�n id'sini giriniz: ");
        int numbers = inp.nextInt();
        control(numbers);

        System.out.print("�r�n�n fiyat�n� giriniz: ");
        int price = inp.nextInt();

        System.out.print("�r�n�n indirim oran�n� giriniz: ");
        int discountRate = inp.nextInt();

        System.out.print("�r�n�n sto�unu giriniz: ");
        int stok = inp.nextInt();

        System.out.print("�r�n�n ismini giriniz: ");
        String productName = inp.nextLine();
        productName = inp.nextLine();


        System.out.println("�r�n�n Markas�n� se�iniz");
        for (Brand brand : Brand.brands) {
            System.out.print(brand.getName() + " ");
        }
        String brand = inp.nextLine();

        System.out.print("�r�n�n ramini giriniz: ");
        int ram = inp.nextInt();

        System.out.print("�r�n�n depolama alan�n� giriniz: ");
        int capacity = inp.nextInt();

        System.out.print("�r�n�n ekran boyutunu giriniz: ");
        double n = inp.nextDouble();

        notebookNumber = numbers;
        notebooklist.put(notebookNumber, new Notebook(numbers, price, stok, discountRate, productName, brand, ram, capacity, n));
    }

    private void control(int control) {
        while (notebookID.contains(control)) {
            System.out.print("Bu ID zaten kullan�lm��. L�tefen tekrar ID girin : ");
            control = inp.nextInt();
        }
        notebookID.add(control);
    }
}
