package SogutucuKontrolCihazi;

import java.sql.*;
import java.util.Scanner;

public abstract class VeritabaniPostgreSQL {
    static boolean dogrulama = false;

    //Connection
    private static Connection baglan() {
        Connection baglanti = null;
        try {
            baglanti = DriverManager.getConnection("jdbc:postgresql://localhost:5432/NesneOdev",
                    "postgres", "mert2010");
            if (baglanti != null)
                System.out.println("Baglanti saglandi!");
            else
                System.out.println("Basarisiz baglanti denemesi!");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return baglanti;
    }

    public static void KullaniciGiris() throws SQLException {
        Connection dogrulamaBaglantisi = baglan();
        String vtKullaniciAdi = null, vtSifre = null, vtIsim;
        Statement stmt = dogrulamaBaglantisi.createStatement();
        String sorgu = "SELECT *  FROM \"kullanici\"";
        while (dogrulama == false) {
            ResultSet rs = stmt.executeQuery(sorgu);
            Scanner veriCek = new Scanner(System.in);
            System.out.print("Kullanici adi: ");
            String kAdi = veriCek.next();
            System.out.print("Sifre: ");
            String sifre = veriCek.next();
            System.out.println("\n");
            
            while (rs.next()) {
                vtKullaniciAdi = rs.getString("kullaniciadi");
                vtSifre = rs.getString("kullanicisifre");
                vtIsim = rs.getString("isim");
                if (kAdi.equals(vtKullaniciAdi) && sifre.equals(vtSifre)) {
                    System.out.println(String.format("Giris Basarili !\n  Merhaba %s\n", vtIsim));
                    dogrulama = true;
                    break;
                } else {
                    System.out.println("Kullanıcı adı şifre kombinasyonu yanlış !\n Tekrar giriniz.\n");
                    dogrulama = false;
                    break;
                }
            }
        }
        dogrulamaBaglantisi.close();
    }
}