package Patikastore;

import java.util.Scanner;

public class Store {

    public Scanner inp = new Scanner(System.in);

    public void run() {
        int number = 3;
        while (number != 0) {
            System.out.println("Patika Ürün Yönetim Paneli !" + "\n" +
                    "1 - Notebook Ýþlemleri" + "\n" +
                    "2 - Cep telefonu Ýþlemleri" + "\n" +
                    "3 - Markalarý Listele" + "\n" +
                    "0 - Çýkýþ yap");
            number = inp.nextInt();
            switch (number) {
                case 1:
                    new Notebook().menu();

                    break;
                case 2:
                    new Phone().menu();
                    break;
                case 3:
                    new Brand().showBrands();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Yanlýþ deðerler girdiniz tekrar deneyin");
                    break;
            }
        }
    }
}
