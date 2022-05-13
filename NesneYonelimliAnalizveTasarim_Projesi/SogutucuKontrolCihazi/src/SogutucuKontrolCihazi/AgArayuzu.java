package SogutucuKontrolCihazi;

import java.sql.*;
import java.util.Scanner;

public class AgArayuzu implements IObserver {
    private boolean cihazDurum;
    MerkezIslem merkezIslem = new MerkezIslem();

    public AgArayuzu() throws SQLException {

        System.out.println("\n cihaz Baslatildi");
        System.out.println("------------------------------------------------------------");
        VeritabaniPostgreSQL.KullaniciGiris(); 
        islem(); //Ýslem secme 
    }


    @Override
    public void beklemede() {

        System.out.println("\nCihaz Eylem bekliyor...");
        System.out.println("------------------------------------------------------------");
        cihazDurum = false;
    }

    @Override
    public void kontrol() {

        System.out.println("\nCihaz kontrol ediliyor...");
        System.out.println("------------------------------------------------------------");
        cihazDurum = true;
    }

    @Override
    public void islem() {

        Scanner islemSecim = new Scanner(System.in);

        while (true) {
            System.out.println("Eylem Seciniz");
            System.out.println("1-Sogutucu Ac");
            System.out.println("2-Sogutucu Kapat");
            System.out.println("3-Sýcaklýk Goruntule");
            System.out.println("4-Cihazi kapat");
            System.out.print("Seciminiz: ");
            int secim = islemSecim.nextInt();
            switch (secim) {
                case 1:
                    kontrol();
                    merkezIslem.sogutucuAcik(this);
                    beklemede();
                    break;
                case 2:
                    kontrol();
                    merkezIslem.sogutucuKapali(this);
                    beklemede();
                    break;
                case 3:
                    kontrol();
                    merkezIslem.sicaklikGoster(this);
                    beklemede();
                    break;
                case 4:

                    System.out.println("\n cihaz kapaniyor ...");
                    System.exit(0);
                    break;
                default:

                    System.out.println("\n Lütfen Dogru secim yapiniz!");
                    System.out.println("------------------------------------------------------------");
            }
        }

    }


}
