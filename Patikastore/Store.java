package Patikastore;

import java.util.Scanner;

public class Store {

    public Scanner inp = new Scanner(System.in);

    public void run() {
        int number = 3;
        while (number != 0) {
            System.out.println("Patika �r�n Y�netim Paneli !" + "\n" +
                    "1 - Notebook ��lemleri" + "\n" +
                    "2 - Cep telefonu ��lemleri" + "\n" +
                    "3 - Markalar� Listele" + "\n" +
                    "0 - ��k�� yap");
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
                    System.out.println("Yanl�� de�erler girdiniz tekrar deneyin");
                    break;
            }
        }
    }
}
